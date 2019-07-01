# Author: Omkar Dixit
# Email: ond170030@utdallas.edu

#  Rod Cutting

import sys

def rodCutting(n, prices):
    R = [0] * (n+1)
    for k in range(1, n+1):
        q = 0
        for i in range(k):
            q = max(q, prices[i]+R[k-i-1])
        R[k] = q
    return R[-1]


if __name__=="__main__":
    if len(sys.argv)==1:
        print("Input Not detected")
    else:
        prices = []
        for price in sys.argv[1:]:
            prices.append(int(price))
        # rate = [1.0, 2.5, 2.6, 2.5, 2.6, 2.8, 2.4, 2.5, 2.6, 2.6]
        print(rodCutting(len(prices), prices))