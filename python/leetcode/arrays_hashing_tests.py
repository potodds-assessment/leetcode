from arrays_hashing import *
from ListNode import *

def runTest(func, ans, *args):
    if func(*args) == ans:
        print("{} passed".format(func.__name__)) 
    else:
        print("{} failed".format(func.__name__))

# runTest(L1_Two_Sum, [2,3], [2,7,11,15], 26)
# runTest(L20_Valid_Parentheses, True, "()[]{}")
# runTest(L21_Best_Time_To_Buy_and_Sell_Stock, 5, [7,1,5,3,6,4])

######################### L206_Reverse_Linked_List ##########################################
# n = L206_Reverse_Linked_List(head = ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5))))))
# while n:
#     print(n.val)
#     n = n.next
######################### L155_Min_Stack ####################################################
c = L155_Min_Stack()
c.push(-2)
c.push(0)
c.push(-3)
print(c.getMin() == -3)
c.pop()
print(c.getMin() == -2)
c.pop()
print(c.getMin() == -2)
######################### L155_Min_Stack ####################################################
