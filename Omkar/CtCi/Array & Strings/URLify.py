# Author: Omkar Dixit
# Email: ond170030@utdallas.edu

# python URLify.py Mr John Smith

import sys

# Time Complexity O(n)

def URLify(str):
    return "%20".join(str)

if __name__=="__main__":
    if len(sys.argv)==1:
        print("String Not Detected")
    else:
        print(URLify(sys.argv[1:]))