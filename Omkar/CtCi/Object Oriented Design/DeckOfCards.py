# Author: Omkar Dixit
# Email: ond170030@utdallas.edu

# Deck of Cards

import random

class Cards:
    def __init__(self, value, suit):
        self.value = value
        self.suit = suit
    
    def show(self):
        print("{} of {}".format(self.value, self.suit))

    def getSuit(self):
        print("{}".format(self.suit))
    
    def getValue(self):
        print("{}".format(self.value))

class Deck:
    def __init__(self):
        self.cards = []
        self.__build()
    
    def __build(self):
        for suit in ["Spades", "Hearts", "Diamonds", "Clubs"]:
            for val in range(1, 14):
                self.cards.append(Cards(val, suit))

    def showFullDeck(self):
        for card in self.cards:
            card.show()
    
    def shuffle(self):
        random.shuffle(self.cards)
  
if __name__=="__main__":
    deck = Deck()
    deck.shuffle()
    deck.showFullDeck()