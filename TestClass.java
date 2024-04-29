


public class TestClass 
{

	public static void main(String[] args) 
	{
		PokerHand poker = new PokerHand();
		Card[] testCards= {new Card('D',"3",3),new Card('H',"6",6),new Card('S',"10",10),new Card('D',"J",11),new Card('D',"Q",12)};
		PokerHand poker2 = new PokerHand(testCards);
		//System.out.println(poker2);
		//System.out.println(poker2.getBestHand());
		System.out.println(poker2.toString());
		
		int[] newInt = {3,4};
		Card[] cardsToReplace = {new Card('S',"4",4),new Card('D',"A",14)};
		//System.out.println(poker2.discard(newInt,cardsToReplace));
		
		
		System.out.println();
		
		Deck deck = new Deck();
		System.out.println(deck);

	}

}
