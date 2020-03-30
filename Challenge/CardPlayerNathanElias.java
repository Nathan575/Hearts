/*
/    Authors:
/        N. Elias
*/
import java.util.*;
import java.io.*;

public class CardPlayerNathanElias extends CardPlayer{

   private int greatest;
   private ArrayList<Card> hand = super.getHand();

   public CardPlayerNathanElias(String name, int score, ArrayList<Card> hand) {
      super(name, score, hand);
   }
   
   public int getGreatest(){
      return greatest;
   }
   
   public Card chooseCard(ArrayList<Card> round, ArrayList<Card> game){
      Card c2 = new Card("2", "clubs", 2);
      Card sQ = new Card("Q", "spades", 12);
      ArrayList<Card> matchSuit = new ArrayList<Card>();
      ArrayList<Card> hearts = new ArrayList<Card>();
      String firstSuit;
      int greater = 0;
      
      if(game.size() == 0 && hand.contains(c2)){
      
         return playCard(hand.indexOf(c2));
      }
      
      else if((round.size() == 0)){
         return playCard((int)(Math.random()*hand.size()));
      }
      
      else {
         firstSuit = round.get(0).getSuit();
         
         //matchSuit
         for(int i=hand.size()-1; i>=0; i--) {
            if(hand.get(i).getSuit().equals(firstSuit)){
               matchSuit.add(hand.get(i));
            }
         }
         
         if(matchSuit.size() > 0) {
            Card playC = new Card();
            boolean defined = false;
            for(int i = 0; i < matchSuit.size(); i++){
               if (matchSuit.get(i).getValue() > greater){
                  playC = matchSuit.get(i);
                  defined = true;
               }
               if(defined){
                  return playCard(hand.indexOf(playC));
               }
            }
         }
         //hearts
         for(int i=hand.size()-1; i>=0; i--) {
            if(hand.get(i).getSuit().equals("hearts")){
               hearts.add(hand.get(i));
            }
         }
         if(hearts.size() > 0) {
            Card playC = hearts.get((int)(Math.random()*hearts.size()));
            return playCard(hand.indexOf(playC));
         
         }
      }
     
     if(hand.contains(sQ)){
      return playCard(hand.indexOf(sQ));
     }
     
     return playCard((int)(Math.random()*hand.size()));
   }  
}
