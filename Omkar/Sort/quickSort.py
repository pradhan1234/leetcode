# Author: Omkar Dixit
# Email: ond170030@utdallas.edu

import time
import sys
from random import shuffle

# Time Complexity: O(n^2)
# Space Complexity O(logn)
def quickSort(arr, l, r):
    if l < r:
        pivot = partition(arr, l, r)
        quickSort(arr, l, pivot)
        quickSort(arr, pivot+1, r)

def partition(arr, l, r):
    pivot = arr[l]
    leftwall = l
    for i in range(l+1, r+1):
        if arr[i] < pivot:
            arr[i], arr[leftwall] = arr[leftwall], arr[i]
            leftwall+=1
    pivot, arr[leftwall] = arr[leftwall], pivot
    return leftwall

if __name__=="__main__":
    n =  int(sys.argv[1])
    arr = []
    for i in range(n):
        arr.append(i)
    shuffle(arr)
    start = time.time()
    quickSort(arr, 0, len(arr)-1)
    end = time.time()
    print("Quick sort")
    print("Time Taken "+str(end-start)+" Seconds")
    # print(arr)