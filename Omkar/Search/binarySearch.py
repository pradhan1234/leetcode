# Author: Omkar Dixit
# Email: ond170030@utdallas.edu
import sys

def binarySearch(arr, left, right, x):
    if left > right:
        return False
    mid = int(left + (right - left)/2)
    if x == arr[mid]:
        return True
    elif x < arr[mid]:
        binarySearch(arr, left, mid-1, x)
    else:
        binarySearch(arr, mid+1, right, x)

if __name__=="__main__":
    toSearch = int(sys.argv[1])
    arr = []
    for i in range(2, len(sys.argv)):
        arr.append(int(sys.argv[i]))
    print(binarySearch(arr, 0, len(arr)-1, toSearch))
