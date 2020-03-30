/*
/    Authors:
/        Q. Foley
/        N. Elias
*/
import java.util.*;

public class Deck{

   private ArrayList<Card> deck;

   public static final String[] NAMES = {"2","3","4","5","6","7","8","9","T","J","Q","K","A"};
   public static final String[] SUITS = {"clubs", "spades", "hearts", "diamonds"};
   public static final int[] VALUES = {2,3,4,5,6,7,8,9,10,11,12,13,14};
   
   public Deck(){
      initializeDeck();
   }
   
   public ArrayList<Card> getDeck(){
      return deck;
   }
   
   public void initializeDeck(){
      deck = new ArrayList<Card>();
      for(int s = 0; s < 4; s++) {
         for(int v = 0; v < 13; v++) {
            Card newCard = new Card();
            newCard.setName(NAMES[v]);
            newCard.setValue(VALUES[v]);
            newCard.setSuit(SUITS[s]);
            deck.add(newCard);
         }
      }
   }
   
   public Card getCard(int index){
      return deck.get(index);
   }
   
   public Card dealTopCard(){
      Card old = deck.get(0);
      deck.remove(deck.get(0));
      
      return old;
   }
   
   public void shuffle2(){
      for(int m = 0; m < 20; m++){
      
         int numCards = (int)(Math.random() * 9) + 2;
         ArrayList<Card> newArr = new ArrayList<Card>();
         
         for(int i = 0; i < numCards; i++){
            Card oldC = deck.get(i);
            deck.remove(deck.get(i));
            newArr.add(oldC);
         }
        int random = (int)(Math.random() * deck.size());
        deck.addAll(random, newArr);
      }
   }

   public void shuffle(){
      Collections.shuffle(deck);
   }
   
   public String toString(){
      return deck.toString();
   }
}
