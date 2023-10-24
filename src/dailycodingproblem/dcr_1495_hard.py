"""
This problem was asked by Netflix.

A Cartesian tree with sequence S is a binary tree defined by the following two properties:

It is heap-ordered, so that each parent value is strictly less than that of its children.
An in-order traversal of the tree produces nodes with values that correspond exactly to S.
For example, given the sequence [3, 2, 6, 1, 9], the resulting Cartesian tree would be:
"""


def main(lst):
    print(lst)

    node = Node(6)
    node.left = Node(5)
    node.right = Node(7)

    print(node.value)
    print(node.left.value)
    print(node.right.value)
      
class Node:
    left = None
    right= None

    def __init__(self, value):
       self.value = value

if __name__ == "__main__":
    main([3, 2, 6, 1, 9])
