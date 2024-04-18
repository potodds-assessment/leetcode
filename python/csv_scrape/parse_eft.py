import csv
import urllib
import datetime
import requests                  # [handles the http interactions](http://docs.python-requests.org/en/master/) 
from bs4 import BeautifulSoup    # beautiful soup handles the html to text conversion and more
import re                        # regular expressions are necessary for finding the crumb (more on crumbs later)
from datetime import datetime    # string to datetime object conversion
from time import mktime          # mktime transforms datetime objects to unix timestamps

#CSV_URL = 'http://web.cs.wpi.edu/~cs1004/a16/Resources/SacramentoRealEstateTransactions.csv'
#CSV_URL='https://query1.finance.yahoo.com/v7/finance/quote?symbols=BTC-USD'
CSV_URL='https://query1.finance.yahoo.com/v6/finance/download/BTC-GBP'
#CSV_URL='https://query1.finance.yahoo.com/v6/finance/download/GFAI?period1=1671503966&period2=1703039966&interval=1d&events=history&includeAdjustedClose=true'
#CSV_URL = 'http://samplecsvs.s3.amazonaws.com/Sacramentorealestatetransactions.csv'
# headers = {
#     'User-Agent': 'Mozilla/5.0'
# }

# def lookup(symbol):
#     """Look up quote for symbol."""

#     # Prepare API request
#     symbol = symbol.upper()
#     end = datetime.datetime.now(pytz.timezone("US/Eastern"))
#     start = end - datetime.timedelta(days=7)

#     print(int(end.timestamp()))
#     print(int(start.timestamp()))

#     # Yahoo Finance API
#     url = (
#         f"https://query1.finance.yahoo.com/v7/finance/download/{urllib.parse.quote_plus(symbol)}"
#         f"?period1={int(start.timestamp())}"
#         f"&period2={int(end.timestamp())}"
#         f"&interval=1d&events=history&includeAdjustedClose=true"
#     )

#     # Header for response
#     """ header = {
#         'User-Agent'      : 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36',
#         'Accept'          : '*/*',
#         'Accept-Language' : 'en-US,en;q=0.5',
#         'DNT'             : '1', # Do Not Track Request Header
#         'Connection'      : 'close'
#     } """

#     # Query API
#     try:
#         """ response = requests.get(url, cookies={"session": str(uuid.uuid4())}, headers=header) """
#         response = requests.get(url, cookies={"session": str(uuid.uuid4())}, headers={"User-Agent": "python-requests", "Accept": "*/*"})
#         response.raise_for_status()

#         # CSV header: Date,Open,High,Low,Close,Adj Close,Volume
#         quotes = list(csv.DictReader(response.content.decode("utf-8").splitlines()))
#         quotes.reverse()
#         print(quotes)
#         price = round(float(quotes[0]["Adj Close"]), 2)
#         return {
#             "name": symbol,
#             "price": price,
#             "symbol": symbol
#         }
#     except (requests.RequestException, ValueError, KeyError, IndexError) as e:
#         print(f"An error occured: {e}")
#         return None

# def get_yahoo_cookie():
#     cookie = None

#     user_agent_key = "User-Agent"
#     user_agent_value = "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36"

#     headers = {user_agent_key: user_agent_value}
#     response = requests.get(
#         "https://fc.yahoo.com", headers=headers, allow_redirects=True
#     )

#     if not response.cookies:
#         raise Exception("Failed to obtain Yahoo auth cookie.")

#     cookie = list(response.cookies)[0]

#     return cookie


# def get_yahoo_crumb(cookie):
#     crumb = None

#     user_agent_key = "User-Agent"
#     user_agent_value = "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36"

#     headers = {user_agent_key: user_agent_value}

#     crumb_response = requests.get(
#         "https://query1.finance.yahoo.com/v1/test/getcrumb",
#         headers=headers,
#         cookies={cookie.name: cookie.value},
#         allow_redirects=True,
#     )
#     crumb = crumb_response.text

#     if crumb is None:
#         raise Exception("Failed to retrieve Yahoo crumb.")

#     return crumb

# # Usage
# #cookie = get_yahoo_cookie()
# #crumb = get_yahoo_crumb(cookie)



# with requests.Session() as s:
#     # CSV_URL=CSV_URL+'&crumb='+crumb
#     print(CSV_URL)
#     download = s.get(CSV_URL)

#     print(download.content)

#     decoded_content = download.content.decode("utf-8")
#     cr = csv.reader(decoded_content.splitlines(), delimiter=',')
#     my_list = list(cr)
#     for row in my_list:
#         print(row)


def _get_crumbs_and_cookies(stock):
    """
    get crumb and cookies for historical data csv download from yahoo finance
    
    parameters: stock - short-handle identifier of the company 
    
    returns a tuple of header, crumb and cookie
    """
    
    url = 'https://finance.yahoo.com/quote/{}/history'.format(stock)
    with requests.session():
        header = {'Connection': 'keep-alive',
                   'Expires': '-1',
                   'Upgrade-Insecure-Requests': '1',
                   'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; WOW64) \
                   AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36'
                   }
        
        website = requests.get(url, headers=header)
        soup = BeautifulSoup(website.text, 'lxml')
        crumb = re.findall('"CrumbStore":{"crumb":"(.+?)"}', str(soup))
        
        print(crumb)

        return (header, crumb, website.cookies)
    
def convert_to_unix(date):
    """
    converts date to unix timestamp
    
    parameters: date - in format (dd-mm-yyyy)
    
    returns integer unix timestamp
    """
    datum = datetime.strptime(date, '%d-%m-%Y')
    
    return int(mktime(datum.timetuple()))

def load_csv_data(stock, interval='1d', day_begin='01-12-2023', day_end='19-12-2023'):
    """
    queries yahoo finance api to receive historical data in csv file format
    
    parameters: 
        stock - short-handle identifier of the company
        
        interval - 1d, 1wk, 1mo - daily, weekly monthly data
        
        day_begin - starting date for the historical data (format: dd-mm-yyyy)
        
        day_end - final date of the data (format: dd-mm-yyyy)
    
    returns a list of comma seperated value lines
    """
    day_begin_unix = convert_to_unix(day_begin)
    day_end_unix = convert_to_unix(day_end)
    
    header, crumb, cookies = _get_crumbs_and_cookies(stock)
    print(header)
    print(crumb)
    print(cookies)
    
    with requests.session():
        url = 'https://query1.finance.yahoo.com/v7/finance/download/' \
              '{stock}?period1={day_begin}&period2={day_end}&interval={interval}&events=history&crumb={crumb}&includeAdjustedClose=true' \
              .format(stock=stock, day_begin=day_begin_unix, day_end=day_end_unix, interval=interval, crumb=crumb)
                
        print(url)
        website = requests.get(url, headers=header, cookies=cookies)
       
        return website.text.split('\n')[:-1]

dd = load_csv_data('TSLA')
print(dd)