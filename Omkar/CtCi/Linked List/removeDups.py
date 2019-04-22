# Author: Omkar Dixit
# Email: ond170030@utdallas.edu

import sys

class Node:
    def __init__(self, val):
        self.val = val
        self.next = None
    
def removeDups(head):
    mySet = set()
    curr = head
    prev = Node(None)
    while curr:
        if curr.val in mySet:
            prev.next = curr.next
        else:
            prev = curr
            mySet.add(curr.val)
        curr = curr.next
    return head

if __name__=="__main__":
    if len(sys.argv)==1:
        print("List not detected")
    else:
        head = Node(sys.argv[1])
        if len(sys.argv)==2:
            print(head.val)
        else:
            curr = head
            for i in sys.argv[2:]:
                node = Node(i)
                curr.next = node
                curr = node
            head = removeDups(head)
            while(head):
                print(head.val, end=" ")
                head = head.next