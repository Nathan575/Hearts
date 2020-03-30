/*
/    Authors:
/        Q. Foley
         N. Elias
*/
public class TestDeck {

   public static void main(String[] args) {
      
      Deck newDeck = new Deck();
      System.out.println("new deck " + newDeck);
      
      newDeck.shuffle();
      System.out.println("shuffled " + newDeck + "\n");
      
      for(int i=0; i<4; i++) {
         System.out.print("13 cards ");
         for(int m=0; m<13; m++) {
            System.out.print(newDeck.dealTopCard());
         }
         System.out.println("\nremaining " + newDeck);

      }
      
      Deck newerDeck = new Deck();
      int random = (int)(Math.random() * newerDeck.getDeck().size());
      
      Card theCard = newerDeck.getDeck().get(random);
      System.out.println("\nrandom card from new deck " + theCard + ".");
      int numL = 0;
      
      for(int i = 0; i < 52000; i++){
         newerDeck.shuffle();
         if((newerDeck.getDeck().get(random)).equals(theCard)){
            numL++;
         }
      }
      
      System.out.println("random location to check is " + random + ".");
      System.out.println("Found " + theCard + " at location " + random + " in the deck " + numL + " times.");
   }
}
