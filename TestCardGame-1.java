/*
/    Authors:
/        Q. Foley
/        N. Elias
*/

import java.util.*;
import java.io.*;

public class TestCardGame{
   public static void main (String[] args){
      System.out.println(">>> Printed in Constructor");
      
      CardPlayer p0 = new CardPlayer("Player0", 0, new ArrayList<Card>());
      CardPlayer p1 = new CardPlayer("Player1", 0, new ArrayList<Card>());     
      CardPlayer p2 = new CardPlayer("Player2", 0, new ArrayList<Card>());     
      CardPlayer p3 = new CardPlayer("Player3", 0, new ArrayList<Card>());
      
      double p0score = 0;
      double p1score = 0;
      double p2score = 0;
      double p3score = 0;
      int total = 0;
      int numberOfGames = 2000;      
      
      System.out.println("Player " + p0.getName() + " is a Cardplayer");
      System.out.println("Player " + p1.getName() + " is a Cardplayer");
      System.out.println("Player " + p2.getName() + " is a Cardplayer");
      System.out.println("Player " + p3.getName() + " is a Cardplayer");
      
      System.out.println(">>> Printing game in TestCardGame");
      System.out.println("***Hearts***");
      System.out.println(p0);
      System.out.println(p1);
      System.out.println(p2);
      System.out.println(p3);
      
      String[] playerNames = new String[] {"Player0", "Player1", "Player2", "Player3"};
      ArrayList<CardPlayer> players = new ArrayList<CardPlayer>();
      players.add(p0);
      players.add(p1);
      players.add(p2);
      players.add(p3);
      
      CardGame game = new CardGame("game1", 4, playerNames, 0, players);
      System.out.println("deck -> " + game.getDeck());
      
      for(int i = 0; i < numberOfGames; i++){
         game.deal();
         game.playGame();
         
         System.out.print(">>> playGame() " + p0.getName()+ "(" +p0.getScore()+ ") ");
         System.out.print(p1.getName()+"("+p1.getScore()+") ");
         System.out.print(p2.getName()+"("+p2.getScore()+") ");
         System.out.println(p3.getName()+"("+p3.getScore()+") ");
      }

      p0score += p0.getScore();
      p1score += p1.getScore();
      p2score += p2.getScore();
      p3score += p3.getScore();
      
      total += p0score + p1score + p2score + p3score;
      System.out.println("Total Score = " + total);
      
      p0score = (p0score/total) * 100;
      p0score = Math.round(p0score * 100.0) / 100.0;
      p1score = (p1score/total) * 100;
      p1score = Math.round(p1score * 100.0) / 100.0;
      p2score = (p2score/total) * 100;
      p2score = Math.round(p2score * 100.0) / 100.0;
      p3score = (p3score/total) * 100;
      p3score = Math.round(p3score * 100.0) / 100.0;
      
      System.out.println(p0.getName() + " " + p0score + "%");
      System.out.println(p1.getName() + " " + p1score + "%");
      System.out.println(p2.getName() + " " + p2score + "%");
      System.out.println(p3.getName() + " " + p3score + "%");
   }
}