import requests
req = requests.get("https://query1.finance.yahoo.com/v7/finance/download/SPY?period1=728265600&period2=1702684800&interval=1d&events=history&includeAdjustedClose=true")
url_content = req.content
csv_file = open('file.csv', 'wb')
csv_file.write(url_content)
csv.file_close()