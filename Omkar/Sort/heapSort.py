# Author: Omkar Dixit
# Email: ond170030@utdallas.edu

def heapify(arr, i, size):
    largest = i
    left = (2*i) + 1
    right = (2*i) + 2
    if left < size and arr[i] < arr[left]:
        largest = left
    if right < size and arr[largest] < arr[right]:
        largest = right
    if largest != i:
        arr[i], arr[largest] = arr[largest], arr[i]
        heapify(arr, largest, size)

def heapSort(arr):
    n = len(arr)
    for i in range(n, -1, -1):
        heapify(arr, i, n)
    for i in range(n-1, 0, -1):
        arr[i], arr[0] = arr[0], arr[i]
        heapify(arr, 0, i)

if __name__=="__main__":
    arr = [12, 11, 13, 5, 6, 7]
    heapSort(arr)
    print(arr)
    
