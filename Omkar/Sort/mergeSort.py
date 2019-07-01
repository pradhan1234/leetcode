# Author: Omkar Dixit
# Email: ond170030@utdallas.edu

import time
import random
import sys

# Time Complexity O(nlogn)
# Space Complexity O(n)
def mergeSort1(arr, l, r):
    if l < r:
        m = int((l+r)/2)
        mergeSort1(arr, l, m)
        mergeSort1(arr, m+1, r)
        merge1(arr, l, m, r)

def merge1(arr, l, m, r):
    L = arr[l:m+1]
    R = arr[m+1:r+1]
    i, j = 0, 0
    for k in range(l, r+1):
        if j>=len(R) or (i < len(L) and L[i] <= R[j]):
            arr[k] = L[i]
            i+=1
        else:
            arr[k] = R[j]
            j+=1

'''
Here in the take 1 we are allocating unecessary arrays L and R, and also we can stop the recursion below certain threshold
'''

def insertionSort(arr, l, r):
    for i in range(l, r+1):
        temp = arr[i]
        j = i-1
        while j >= l and temp < arr[j]:
            arr[j+1] = arr[j]
            j-=1
        arr[j+1] = temp

def mergeSort2(arr, B, l, r):
    if r - l + 1 < 17:
        insertionSort(arr, l, r)
    else:
        m = int((r+l)/2)
        mergeSort2(arr, B, l, m)
        mergeSort2(arr, B, m+1, r)
        merge2(arr, B, l, m, r)  

def merge2(arr, B, l, m, r):
    B = arr[l:r-l+1]
    i, j = l, m+1
    for k in range(l, r+1):
        if j>r or (i<=m and B[i] <= B[j]):
            arr[k] = B[i]
            i+=1
        else:
            arr[k] = B[j]
            j+=1

if __name__=="__main__":
    n = int(sys.argv[1])
    choice = int(sys.argv[2])
    arr = []
    for i in range(n):
        arr.append(i)
    if choice == 0:
        random.shuffle(arr)
        start = time.time()
        insertionSort(arr, 0, len(arr)-1)
        end = time.time()
        print("Insertion Sort")
        print(arr)
        print("Time Taken "+str(end-start)+" Seconds")
    elif choice == 1:
        random.shuffle(arr)
        start = time.time()
        mergeSort1(arr, 0, len(arr)-1)
        end = time.time()
        print("Merge Sort 1")
        print(arr)
        print("Time Taken " + str(end - start) + " Seconds") 
    elif choice ==2:
        random.shuffle(arr)
        B = [-1] * len(arr)
        start = time.time()
        mergeSort2(arr, B, 0, len(arr)-1)
        end = time.time()
        print("Merge Sort 2")
        print(arr)
        print("Time Taken " + str(end - start) + " Seconds")