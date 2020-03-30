/*
/    Authors:
/        Q. Foley
/        N. Elias
*/
import java.util.*;
import java.io.*;

public class CardPlayer extends Player{
   
   private ArrayList<Card> hand;
   private ArrayList<Card> takenCards;
   
   public CardPlayer(String n, int s, ArrayList<Card> h){
      super(n, s);
      hand = h;
      takenCards = new ArrayList<Card>();
   }
   
   public int getScore() {
      return super.getScore();
   }
   
   public String getName() {
      return super.getName();
   }
   
   public ArrayList<Card> getHand() {
      return hand;
   }
   
   public ArrayList<Card> getTakenCards() {
      return takenCards;
   }
   
   public void setScore(int s) {
      super.setScore(s);
   }
   
   public void setName(String n) {
      super.setName(n);
   }
   
   public void setHand(ArrayList<Card> h) {
      hand = h;
   }
   
   public void setTakenCards(ArrayList<Card> t) {
      takenCards.addAll(t);
   }
   
   public void addCard(Card theCard){
      hand.add(theCard);
   }
   
   public Card playCard(int index){
   
      Card oldCard = hand.get(index);
      hand.remove(hand.get(index));
      
      return oldCard;
   }
   
   public Card chooseCard(ArrayList<Card> round, ArrayList<Card> game){
      Card c2 = new Card("2", "clubs", 2);
      ArrayList<Card> matchSuit = new ArrayList<Card>();
      ArrayList<Card> hearts = new ArrayList<Card>();
      String firstSuit;
      
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
            Card playC = matchSuit.get((int)(Math.random()*matchSuit.size()));
            return playCard(hand.indexOf(playC));
         
         }
         //hearts
         for(int i=hand.size()-1; i>=0; i--) {
            if(hand.get(i).getSuit().equals("hearts")){
               hearts.add(hand.get(i));
            }
         }
         if(hearts.size() > 0) {

            Card playC = hearts.get((int)(Math.random()*hearts.size()));            return playCard(hand.indexOf(playC));
         
         }
      }
      Card playC = hand.get((int)(Math.random()*hand.size()));
      return playCard(hand.indexOf(playC));
   }
   
   public String toString() {
   
      Collections.sort(hand);
      
      return (super.getName() + " (" + super.getScore() + ") " + hand); 
   }
}
