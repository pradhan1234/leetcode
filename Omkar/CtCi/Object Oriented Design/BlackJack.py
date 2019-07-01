# Author: Omkar Dixit
# Email: ond170030@utdallas.edu

#  Black Jack

import random

class BlackJackCard:
    def __init__(self, value, suit):
        self.value = value
        self.suit = suit
        self.available = True
    
    def markAvailable(self):
        self.available = True
        return
    
    def markUnavailable(self):
        self.available = False
        return 
    
    def isAvailable(self):
        return self.available
    
    def getSuit(self):
        return self.suit
    
    def getValue(self):
        if self.isAce():
            return 1
        elif self.value >= 11 and self.value <= 13:
            return 10
        else:
            return self.value
        
    def isAce(self):
        return self.value == 1
    
    def getMinValue(self):
        if self.isAce():
            return 1
        else:
            return self.getValue()
    
    def getMaxValue(self):
        if self.isAce():
            return 11
        else:
            return self.getValue()

class BlackJackHand:
    def __init__(self):
        self.cards = []
    
    def addCard(card):
        self.card.append(card)
        
