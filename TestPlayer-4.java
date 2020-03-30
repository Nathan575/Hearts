/*
/    Authors:
/        Q. Foley
/        N. Elias
*/
public class TestPlayer {

   public static void main(String[] args) {
      
      Player Kara = new Player("Kara Jones", 0);
      System.out.println("Created Player -> " + Kara);
      
      Kara.updateScore(6);
      System.out.println("After scoring 6 points -> " + Kara);
           
      
      Player Bob = new Player("Bob Smith", 27);
      System.out.println("Created Player -> " + Bob);
      
      Bob.updateScore(65);
      System.out.println("After scoring 65 points -> " + Bob);
           
   
   }
 }