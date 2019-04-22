# Author: Omkar Dixit
# Email: ond170030@utdallas.edu

# python isUnique.py string

from collections import Counter
import sys

"""
Time Complexity: O(n), since Counter() construction will take O(n) time, 
then most_common(k) takes O(nlogk) since k is 1 here it will be just O(n)
"""
def isUnique(str):
    if Counter(str).most_common(1)[0][1] > 1:
        return False
    return True

if __name__=="__main__":
    # print(sys.argv)
    if len(sys.argv)==1:
        print("No String Detected")
    else:
        print(isUnique(sys.argv[1].strip()))
    