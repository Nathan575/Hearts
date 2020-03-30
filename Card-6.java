/*
/    Authors:
/        Q. Foley
/        N. Elias
*/
public class Card implements Comparable<Object>{
      
      private String name;
      private String suit;
      private int value;
            
      public Card(){
         name = "";
         suit = "";
         value = 0;
      } 
      
      public Card(String myN, String myS, int v){
         name = myN;
         suit = myS;
         value = v;
      }
      
      public String getName(){
         return name;
      }
      
      public String getSuit(){
         return suit;
      }
      
      public int getValue(){
         return value;
      }
      
      public void setName(String n){
         name = n;
      }
      
      public void setSuit(String s){
         suit = s;
      }
      
      public void setValue(int v){
         value = v;
      }
      
      public boolean equals(Object obj){
         Card c = (Card) obj;
         
         String cName = c.getName();
         boolean nameEqual = this.name.equals(cName);
         
         String sName = c.getSuit();
         boolean suitEqual = this.suit.equals(sName);
         
         int vWorth = c.getValue();
         boolean valueEqual = (this.value == vWorth);
         
         return(nameEqual && suitEqual && valueEqual);
      }
      
      public int compareTo(Object obj) {
         Card c = (Card) obj;
         int realValue = c.getValue();
         String realSuit = c.getSuit();
         
         int realValueCheck = 0;
         int valueCheck = 0;
         
         if(realSuit.equals("clubs")){
            realValueCheck+=42;
         }
         if(realSuit.equals("spades")){
            realValueCheck+=28;
         }
         if(realSuit.equals("hearts")){
            realValueCheck+=14;
         }
         
         if(suit.equals("clubs")){
            valueCheck+=42;
         }
         if(suit.equals("spades")){
            valueCheck+=28;
         }
         if(suit.equals("hearts")){
            valueCheck+=14;
         }
         
         realValueCheck += realValue;
         valueCheck += value;
         
         if(realValueCheck == valueCheck){
            return 0;
         }
         else if(realValueCheck > valueCheck){
            return -1;
         }
         
         return 1;   
      }
      
      public String toString(){
         return ("" + suit.substring(0,1) + name + "(" + value + ")");
      }
      
}