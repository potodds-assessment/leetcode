#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'kangaroo' function below.
#
# The function is expected to return a STRING.
# The function accepts following parameters:
#  1. INTEGER x1
#  2. INTEGER v1
#  3. INTEGER x2
#  4. INTEGER v2
#

##########################
## Solution Explanation:
## Save prior difference between x1 current value and x2 current value ie priorRate
## compare next difference with priorRate, if it's increasing then stop with failure
## also keep list of either x1 values or x2 values and for each x1 or x2 value check if it is in the list, if it is return success
##########################

def kangaroo(x1, v1, x2, v2):
    decreasingRate = True
    priorRate = 0
    x1Rate = x1
    x2Rate = x2
    
    x1List = []
    x1List.append(x1)
    if x2 in x1List:
        return "YES"
    
    if x1 <= x2:
        priorRate = x1Rate-x2Rate
    else:
        priorRate = x2Rate-x1Rate

    while decreasingRate:
        x1Rate = x1Rate + v1
        x1List.append(x1Rate)
        x2Rate = x2Rate + v2
        if x2Rate in x1List:
            return "YES"
        
        if x1 <= x2:
            if (x1Rate-x2Rate) > priorRate:
                return "NO"
            else:
                priorRate = x1Rate-x2Rate
        else:
            if (x2Rate-x1Rate) > priorRate:
                return "NO"
            else:
                priorRate = x2Rate-x1Rate

    return "YES"
    
if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    first_multiple_input = input().rstrip().split()

    x1 = int(first_multiple_input[0])

    v1 = int(first_multiple_input[1])

    x2 = int(first_multiple_input[2])

    v2 = int(first_multiple_input[3])

    result = kangaroo(x1, v1, x2, v2)

    fptr.write(result + '\n')

    fptr.close()
