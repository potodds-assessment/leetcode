from typing import *
from ListNode import *

# https://leetcode.com/problems/two-sum/
def L1_Two_Sum(nums: List[int], target: int) -> List[int]:
    prevMap = {}
    for i, n in enumerate(nums):
        diff = target - n
        if diff in prevMap:
            return [prevMap[diff], i]
        prevMap[n] = i
    return

# https://leetcode.com/problems/valid-parentheses/?envType=list&envId=xi4ci4ig
def L20_Valid_Parentheses(s: str) -> bool:
    stack = []
    closeToOpen = { ")" : "(", "]" : "[", "}" : "{" }

    for c in s:
        if c in closeToOpen:
            if stack and stack[-1] == closeToOpen[c]:
                stack.pop()
            else:
                return False
        else:
            stack.append(c)

    return True if not stack else False

# https://leetcode.com/problems/best-time-to-buy-and-sell-stock/?envType=list&envId=xi4ci4ig
def L21_Best_Time_To_Buy_and_Sell_Stock(prices: List[int]) -> int:
    l, r = 0, 1
    maxP = 0

    while r < len(prices):
        if prices[l] < prices[r]:
            profit = prices[r] - prices[l]
            maxP = max(maxP, profit)
        else:
            l = r
        r += 1
    
    return maxP

# https://leetcode.com/problems/reverse-linked-list/?envType=list&envId=xi4ci4ig
def L206_Reverse_Linked_List(head: ListNode) -> ListNode:
    if not head:
        return None

    newHead = head
    if head.next:
        newHead = L206_Reverse_Linked_List(head.next)
        head.next.next = head
    head.next = None

    return newHead

# https://leetcode.com/problems/min-stack/?envType=list&envId=ong932e1
class L155_Min_Stack:
    def __init__(self):
        self.stack = []
        self.minStack = []

    def push(self, val: int) -> None:
        self.stack.append(val)
        val = min(val, self.minStack[-1] if self.minStack else val)
        self.minStack.append(val)

    def pop(self) -> None:
        self.stack.pop()
        self.minStack.pop()

    def top(self) -> int:
        return self.stack[-1]
    
    def getMin(self) -> int:
        return self.minStack[-1]

