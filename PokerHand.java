
public class PokerHand 
{
	
	/*
	 * This field represents the cards in a player's hand
	 */
	private Card[] hand;
	
	
	
	/*
	 * TODO Create a constructor which takes no arguments and initializes
	 * the hand (our hand always has five cards) to an Ace of hearts, 
	 * King of hearts, Queen of hearts, Jack of hearts, and 10 of hearts.  
	 * This is a royal flush
	 *
	 */
	public PokerHand()
	{
		hand = new Card[5];
		Card card1 = new Card('H',"A",14);
		hand[0] = card1;
		Card card2 = new Card('H',"K",13);
		hand[1] = card2;
		Card card3 = new Card('H',"Q",12);
		hand[2] = card3;
		Card card4 = new Card('H',"J",11);
		hand[3] = card4;
		Card card5 = new Card('H',"10",10);
		hand[4] = card5;
		
		
		
	}
	
	/* 
	 * TODO Create a constructor which takes an array of 5 Cards 
	 * as an argument and initializes the hand to the five cards 
	 * passed.
	 * 
	 */
	public PokerHand(Card[] cards)
	{
		hand = cards;
	}
	
	
	/**
	 * This method sortHandByValue will put your cards in order
	 * from smallest to largest.  It is private and can only be
	 * called in this class.  It may prove useful for you.
	 */
	private void sortHandByValue()
	{
		for(int i = 0; i < hand.length; i++)
		{
			int index = i;
			int minVal = hand[i].getValue();
			for(int j = i+1; j < hand.length; j++)
			{
				if(hand[j].getValue()< minVal)
				{
					index = j;
					minVal = hand[j].getValue();
				}
			}
			Card temp = hand[i];
			hand[i] = hand[index];
			hand[index] = temp;
		}
	}
	
	
	/*
	 * TODO write a method called getBestHand (sorting will help)
	 * this method will take no arguments and will return a String 
	 * identifying the best hand which can be made.  The possible hands 
	 * and return values are as follows. These are in order of precedence
	 * (the ones at the top are the best hands).
	 * return "Royal Flush" if all cards in the hand are the same
	 * 	  suit and the card ranks are A, K, Q, J, 10
	 * DONE
	 * return "Straight Flush" if all cards are in the same suit
	 *    and the cards are all in consecutive order by value
	 *    ex.  7H, 8H, 9H, 10H, JH
	 *    DOne
	 * return "Four of a Kind" if there are four matching cards in hand
	 * 	  ex.  9D, 9H, 9S, 9C, 10D
	 * Done
	 * return "Flush" if all cards are the same suit.  Rank does
	 *    not matter.  Ex.  3S, 7S, 10S, KS, AS
	 *    Done
	 * return "Straight" if all cards are in consecutive order
	 *    by value, but not the same suit.  Ex. 4H, 5C, 6H, 7D, 8S
	 *    Done
	 * return "Full House" if there are a set of three matching
	 *    ranks and a separate set of two matching ranks.  
	 *    Ex. 4H, 4C, JD, JH, JS
	 *    Done
	 * return "Three of a Kind" if there are three cards with the same
	 *    rank.  Ex 5C, 9H, QC, QH, QD
	 *    DONE
	 * return "Two Pair" if there are two pairs of cards with matching ranks
	 *    Ex.  5H, 5D, 10H, 10C, KC
	 *    DONE
	 * return "Pair" if there are two matching ranks.  
	 *    Ex. 3D, 5D, 5H, KC, AH
	 *    
	 * return "High (rank of highest card)" if none of the others apply
	 * 	  Ex.  3D, 6H, 10S, JD, QD would return "High Q"
	 */
	public String getBestHand()
	{
		sortHandByValue();

		if (hand[0].getSuit()==hand[1].getSuit()&& hand[0].getSuit()==hand[2].getSuit()&&hand[0].getSuit()==hand[3].getSuit()
				&&hand[0].getSuit()==hand[4].getSuit() && hand[0].getRank().equals("10")&& hand[1].getRank().equals("J")
				&& hand[2].getRank().equals("Q")&& hand[3].getRank().equals("K")&& hand[4].getRank().equals("A"))
		{
			return "Royal Flush";
		}
		else if(hand[0].getSuit()==hand[1].getSuit()&& hand[1].getSuit()==hand[2].getSuit()&&hand[3].getSuit()==hand[4].getSuit()
				&&hand[0].getValue()==hand[1].getValue()-1&&hand[1].getValue()<hand[2].getValue()-1&&hand[2].getValue()<hand[3].getValue()-1
				&&hand[3].getValue()<hand[4].getValue()-1&&hand[4].getValue()==hand[3].getValue()+1)
		{
			return "Straight Flush";
		}
		else if(hand[0].getRank().equals(hand[1].getRank())&&hand[1].getRank().equals(hand[2].getRank())&&hand[2].getRank().equals(hand[3].getRank())
				||hand[1].getRank().equals(hand[2].getRank())&&hand[2].getRank().equals(hand[3].getRank())&&hand[3].getRank().equals(hand[4].getRank()))
				//&&hand[0].getRank().equals(hand[4].getRank())||hand)
		{
			return "Four of a kind";
		}
		else if(hand[0].getSuit()==hand[1].getSuit()&& hand[1].getSuit()==hand[2].getSuit()&&hand[2].getSuit()==hand[3].getSuit()
				&&hand[3].getSuit()==hand[4].getSuit())
		{
			return "Flush";
		}
		else if (hand[1].getValue()==hand[0].getValue()+1&&hand[2].getValue()==hand[1].getValue()+1&&hand[3].getValue()==hand[2].getValue()+1&&hand[4].getValue()==hand[3].getValue()+1)
		{
			return "Straight";
		}
		else if (hand[0].getRank().equals(hand[1].getRank())&&hand[1].getRank().equals(hand[2].getRank())&&hand[3].getRank().equals(hand[4].getRank())
				||hand[2].getRank().equals(hand[3].getRank())&&hand[3].getRank().equals(hand[4].getRank())&&hand[0].getRank().equals(hand[1].getRank()))
		{
			return "Full House";
		}
		else if (hand[0].getRank().equals(hand[1].getRank())&&hand[1].getRank().equals(hand[2].getRank())||hand[2].getRank().equals(hand[3].getRank())&&hand[3].getRank().equals(hand[4].getRank()))
		{
			return "3 of a kind";
		}
		else if (hand[0].getRank().equals(hand[1].getRank())&&hand[2].getRank().equals(hand[3].getRank())||hand[1].getRank().equals(hand[2].getRank())&&hand[3].getRank().equals(hand[4].getRank()))
		{
			return "Two Pair";
		}
		else if (hand[0].getRank().equals(hand[1].getRank())||hand[1].getRank().equals(hand[2].getRank())||hand[2].getRank().equals(hand[3].getRank())||hand[3].getRank().equals(hand[4].getRank()))
		{
			return "Pair";
		}
		else
		{
			return "High "+hand[4].getRank();
		}
						
		
	}
	
	/*
	 * TODO write a toString method which returns a string containing
	 * the rank and suit of every card in the hand, separated by a comma
	 * Ex.  3D, 4D, 4D, 8S, KH
	 */
	public String toString()
	{
		String outputStr = "";
		for (int i = 0;i < hand.length;i++)
		{
			String cardRank = hand[i].getRank();
			char cardSuit = hand[i].getSuit();
			outputStr += cardRank + cardSuit + ",";
		}
		return outputStr;
	}
	
	
	/*
	 * TODO Write a method called discard.  The goal of this method is 
	 * to choose cards to discard and replace with new cards.  The 
	 * method should take two arguments, 
	 * the first will be an int array which will store the indexes of 
	 * hand which are to be replaced, and the second is a Card array 
	 * which will contain the new cards to be placed into hand.
	 * Ex.  hand contains 4H,4D,4C,JS,KC  
	 * 		given int[] arr = {3,4};
	 * 		and Card[] cards = {4S,AD} //using shorthand to demonstrate
	 * 		after discard(arr,cards);
	 * 		hand would now contain 4H,4D,4C,4S,AD
	 * 
	 * 
	 */
	public void discard(int[] replaceInd,Card[] newCards)
	{
		
		for (int i = 0;i < replaceInd.length;i++)
		{
			hand[replaceInd[i]] = newCards[i];
		}
		
	}
}