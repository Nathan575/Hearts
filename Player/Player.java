/*
/    Authors:
/        Q. Foley
/        N. Elias
*/
public class Player{
   
   private String name;
   private int score;
   
   public Player(String n, int s){
      name = n;
      score = s;
   }
   
   public String getName(){
      return name;
   }
   
   public int getScore(){
      return score;
   }
   
   public void setName(String na){
      name = na;
   }
   
   public void setScore(int sc){
      score = sc;
   }
   
   public void updateScore(int value){
      score += value;
   }
   
   public String toString(){
      return name + " " + score;
   }
  

}
