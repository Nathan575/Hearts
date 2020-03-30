/*
/    Authors:
/        Q. Foley
         N. Elias
*/
import java.util.*;
import java.io.*;

public class TestCardPlayer {

   public static void main(String[] args) {
      
      ArrayList<Card> k = new ArrayList<Card>();
      CardPlayer Kara = new CardPlayer("Kara", k, 0);
      System.out.println("Created Player -> " + Kara);
      
      Kara.addCard(new Card("3", "diamonds", 3));
      Kara.addCard(new Card("A", "hearts", 14));
      Kara.addCard(new Card("6", "spades", 6));
      Kara.addCard(new Card("7", "spades", 7));
      Kara.addCard(new Card("2", "clubs", 2));
      Kara.addCard(new Card("3", "clubs", 3));
               
      System.out.println("After adding 6 specific cards. Player -> " + Kara);
      Kara.updateScore(27);
      
      System.out.println("Played " + Kara.playCard(5) + " at index 5 and updated score to 27 points. Player -> " + Kara);
      
      ArrayList<Card> round = new ArrayList<Card>();
      ArrayList<Card> game = new ArrayList<Card>();
      
      System.out.println("Cards played in round -> " + round);
      System.out.println("Cards played in game -> " + game);
      
      Card theCard = Kara.chooseCard(round, game);
      round.add(theCard);
      System.out.println("Chose 2 of clubs -> " + theCard + " Player -> " + Kara);
      
      round.set(0, new Card("10", "spades", 10));
      System.out.println("Cards played in round -> " + round);
      
      boolean done = false;
      
      while(!done){
         int random = (int)(Math.random() * Kara.getHand().size());
         
         if(Kara.getHand().get(random).getSuit().equals("spades")){
            theCard = Kara.playCard(random);
            done = true;
         }         
         
      }
      System.out.println("RANDOMLY chosen spade -> " + theCard + " Player -> " + Kara);
      round.set(0, new Card("9", "clubs", 9));
      
      System.out.println("Cards played in round -> " + round);
      theCard = Kara.chooseCard(round, game);
      
      System.out.println("heart chosen -> " + theCard + " Player -> " + Kara);
      round.clear();
      
      System.out.println("Cards played in round -> " + round);
      theCard = Kara.chooseCard(round, game);
      
      System.out.println("RANDOMLY chosen card -> " + theCard + " Player -> " + Kara);
   }
 }
