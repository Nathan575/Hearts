/*
/    Authors:
/        Q. Foley
/        N. Elias
*/

import java.util.*;
import java.io.*;

public class CardGame{

   private Deck deckOfCards;
   private String nameOfGame;
   private ArrayList<CardPlayer> players;
   private int numberOfPlayers;
   private int currentPlayer;
   private ArrayList<Card> game;
   private ArrayList<Card> round;
   
   public CardGame(String n, int p, String[] playerNames, int c, ArrayList<CardPlayer> play) {
   
      deckOfCards = new Deck();
      nameOfGame = n;
      numberOfPlayers = p;
      players = new ArrayList<CardPlayer>();
      currentPlayer = c;
      this.players = play;
      
      game = new ArrayList<Card>();
      round = new ArrayList<Card>();
   }
   
   public ArrayList<Card> getGame() {
      return game;
   }
   
   public ArrayList<Card> getRound() {
      return game;
   }
   public Deck getDeck() {
      return deckOfCards;
   }
   
   public void deal(){
      deckOfCards = new Deck();
      deckOfCards.shuffle();
      for(int i = 0; i < numberOfPlayers; i++){
         CardPlayer player = players.get(i);
         
         for(int x = 0; x < 13; x++){
            player.addCard(deckOfCards.dealTopCard());
         }
         
      }
   }

   public void playGame() {
      
      round = new ArrayList<Card>();
      game = new ArrayList<Card>();
      int winner;
      
      findFirstPlayer();
      
      for(int rnd = 13; rnd >= 0;rnd--) {
         //go through each player starting at currentplayer
         int playerOn = currentPlayer;
         boolean firstIter = true;
         while(!((currentPlayer == playerOn-1)||((playerOn==0)&&(currentPlayer==numberOfPlayers-1)))) {
            
            if(firstIter==false) {
               if(currentPlayer!=numberOfPlayers-1) currentPlayer++;
               else currentPlayer = 0;
               
            }
            firstIter=false;
            
            if(players.get(currentPlayer).getHand().size() != 0){
               Card playCard = players.get(currentPlayer).chooseCard(round, game);
               round.add(playCard);              
            }
        }
        winner = winsRound(round);
        winner = winner % numberOfPlayers;
        
        players.get(winner).setTakenCards(round);
        getPlayerScore(winner, round);
         
        game.addAll(round);
        
        currentPlayer = winner;
        
        if(round.size() > 0){
         checkRound(round, playerOn);
         //System.out.println(players.get(currentPlayer).getHand());
        }
        
        round.clear();        
      }
   }

   public void getPlayerScore(int index, ArrayList<Card> taken){
      
      int score = 0;
      Card qSpades = new Card("Q", "spades", 12);
      
      
      for(int i = 0; i < taken.size(); i++){
         if(taken.get(i).getSuit().equals("hearts")){
            score++;
         }
         else if(taken.get(i).equals(qSpades)) {
            score += 13;
         }
      }
      players.get(index).updateScore(score);
   }
   
   public int winsRound(ArrayList<Card> cards){
      //finds person who wins
      int greatest = 0;
      ArrayList<Integer> demCards = new ArrayList<Integer>();
      
      for(int i=0; i < cards.size(); i++) {
            if(cards.get(i).getSuit().equals(cards.get(0).getSuit())){
               demCards.add(i);
           }
      }
      for(int x = 0; x < demCards.size(); x++){
         Card theCard = cards.get(demCards.get(x));
         if(theCard.getValue() > greatest){
            greatest = x;
         }
      }
             
       return greatest;
   }
   
   public void checkRound(ArrayList<Card> round, int startingPlayer) {
   System.out.print(startingPlayer + " ");
   // Establish what the suit to match is
   String roundSuit = round.get(0).getSuit(); 
   // For all other players
   for (int i = 1; i < round.size(); i++) { 
      // If their card doesn't match suit, check to see if they're incorrect
      if (!round.get(i).getSuit().equals(roundSuit)) { 
         CardPlayer player = players.get((i + startingPlayer) % round.size());
         // Go through their cards
         for (Card c : player.getHand()) { 
            // If incorrect, print out offending card and that they're incorrect
            if (c.getSuit().equals(roundSuit)) { 
               System.out.println("*** INCORRECT ***" + player.getName() + " playing " + round.get(i) + " in " + round + " while having " + player.getHand());
               break;
            }
         }
      }
   }
}

   
   
   public int findFirstPlayer(){
      //find first player with 2 clubs
      for(int i = 0; i < numberOfPlayers; i++) {
         if(players.get(i).getHand().contains(new Card("2", "clubs", 2))) {
            this.currentPlayer = i;
         }
      }
     return currentPlayer;   
   }
   
   public Card findHighest(ArrayList<Card> c) {
      Card highest = new Card();
      for(int i=0; i<c.size(); i++) {
         if(c.get(i).getValue() > highest.getValue()){ 
            highest = c.get(i);
         } 
      }
     return highest;
   }
   
   public String toString() {
      return "" + nameOfGame + " " + players + " " + deckOfCards;
   }
   
}
