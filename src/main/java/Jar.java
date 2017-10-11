import java.util.Random;

public class Jar {
  private int maxNumItems =  0;
  private String item = "";
  private int someNumber = 0;

  public Jar(String item, int maxNumItems) {
  this.maxNumItems = maxNumItems;
  this.item = item;
  }
  
  public int fill(int maxAmount) {
    Random random = new Random();
    someNumber = random.nextInt(maxAmount) + 1;
    // Some number will be between 1 and maxAmount
    return someNumber;
  }
  
  public boolean guessIsEqual(int guessedNum, int randomNum){
    boolean guessed = false;    
    if(guessedNum == randomNum){
       guessed = true;
    }
    return guessed;
  }
  
  public boolean guessIsGreaterMax(int guessedNum, int maxAmount){
    boolean isGreater = false;
    if(guessedNum > maxAmount){
      isGreater = true;
    }
    return isGreater;
  }
  
  public boolean guessIsSmaller(int guessedNum, int randomNum){
    boolean isSmaller = false;
    if(guessedNum < randomNum) {
      isSmaller = true; 
    }
    return isSmaller;
  }
  
  public boolean guessIsGreater(int guessedNum, int randomNum, int maxAmount){
    boolean isGreater = false;
    if((guessedNum > randomNum) && (guessedNum < maxAmount +1)){
      isGreater = true;
    }
    return isGreater;
  }
  
}