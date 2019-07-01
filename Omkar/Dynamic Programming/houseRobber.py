# Author: Omkar Dixit
# Email: ond170030@utdallas.edu

# House Robber

import sys

def houseRobber(W, val, wt, n):
    K = [[0 for i in range(W+1)]for i in range(n+1)]
    for i in range(n+1):
        for w in range(W+1):
            if n==0 or w==0:
                K[i][w]=0
            elif wt[i-1] <= w:
                K[i][w] = max(val[i-1]+K[i-1][w-wt[i-1]], K[i-1][w])
            else:
                K[i][w] = K[i-1][w]
    return K[n][W]

if __name__=="__main__":
    value = [60, 100, 120]
    wt = [10, 20, 30]
    W =  50
    n = len(value)
    print(houseRobber(W, value, wt, n))

