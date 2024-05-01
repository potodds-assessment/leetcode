#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'dynamicArray' function below.
#
# The function is expected to return an INTEGER_ARRAY.
# The function accepts following parameters:
#  1. INTEGER n
#  2. 2D_INTEGER_ARRAY queries
#

def dynamicArray(n, queries):
    ans = [[0]*0 for i in range(n)]
    lastAnswer = 0
    finalAns = []
    startPrinting = False
    
    for query in queries:        
        idx = (query[1] ^ lastAnswer) % n
        if query[0] == 1:
            if startPrinting:
                print("query=",query,",idx=",idx,",lastAnswer=",lastAnswer,",ans[idx]=", ans[idx])
            ans[idx].append(query[2])
        else:
            if query[1] == 561031511:
                startPrinting = True
            if startPrinting:                
                print("query=",query,",idx=",idx,",lastAnswer=",lastAnswer,",y=", query[2],",len(ans[idx])=", len(ans[idx]),",ans[idx]=", ans[idx])
            if len(ans[idx]) == 0:
                lastAnswer = 0
            else:
                lastAnswer = ans[idx][query[2] % len(ans[idx])]
            finalAns.append(lastAnswer)
            ans[idx].append((query[1] ^ lastAnswer) % n)
            
#    print(finalAns)
    return finalAns
    # Write your code here

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    first_multiple_input = input().rstrip().split()

    n = int(first_multiple_input[0])

    q = int(first_multiple_input[1])

    queries = []

    for _ in range(q):
        queries.append(list(map(int, input().rstrip().split())))

    result = dynamicArray(n, queries)

    fptr.write('\n'.join(map(str, result)))
    fptr.write('\n')

    fptr.close()
