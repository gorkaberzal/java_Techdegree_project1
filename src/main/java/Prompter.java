import java.util.InputMismatchException;
import java.util.Scanner;

class Prompter {
 

  Scanner scanner = new Scanner(System.in);
  private int maxAmount = 0;
  private int guessedNum = 0;
  private int randomNum = 0;
  private String item = "";
  
  Jar jar = new Jar(promptForItem(), promptForMaxAmount());
  
  public String promptForItem() { 
    boolean accepted = false;
    System.out.printf("////////////////////  ADMINISTRATOR  /////////// %n\n");
    do {
      System.out.printf("What type of item?  \n");    
      try {
        item = scanner.nextLine();
        if(!item.isEmpty()){
          if((Integer.parseInt(item)) != 0){
            System.out.printf("A String is required, numbers are not allowed but words! %n");
            accepted = false;
          } 
        } else {
          System.out.printf("The input is too small %n");
          accepted = false;
        }
      }catch(NumberFormatException e) {
         accepted = true;
      }catch(NullPointerException e) {
        System.out.printf("A String is required! %n");
        accepted = false;
      }   
    } while (!accepted);
    return item;
  }
  
  public int promptForMaxAmount(){
    boolean accepted = false;
    while(!accepted) {
      try {
        System.out.printf("%nWhat is the maximum amount of %s?  %n", item);
        maxAmount = scanner.nextInt();
        if((maxAmount == (int)maxAmount) && maxAmount > 0){
          accepted = true;
        }else {
           System.out.printf("maxAmount is not a number or it is negative. Please enter a positive number. \n");
           accepted = false; 
        }
        scanner.nextLine();
      } catch(InputMismatchException e) {
        scanner.nextLine();
        System.out.printf("%nPlease try again. A number is required.");
      }
    }
    return maxAmount;
  }
  
  public int promptForRandom(){
    System.out.printf("%n////////////////////  PLAYER   ///////////////// \n\n");  
    System.out.printf("How many %s are in the jar? ", item); 
    randomNum = jar.fill(maxAmount);
    return randomNum;
  }
  
  public void guessGame(){ 
    int count = 0;
    while(jar.guessIsEqual(guessedNum, randomNum) != true){
      System.out.printf("Pick a number between 1 and %d  %n", maxAmount);
      try {
        guessedNum = scanner.nextInt();
        if(jar.guessIsGreaterMax(guessedNum, maxAmount)){
          System.out.printf("Your guess must be less than %d \n  ", maxAmount + 1);
        } else {
          if(jar.guessIsSmaller(guessedNum, randomNum)){
            System.out.printf("%nYour guess is too low \n");          
          }
          if(jar.guessIsGreater(guessedNum, randomNum, maxAmount)){
            System.out.printf("%nYour guess is too high \n");           
          }  
          count ++;
          }
      } catch(InputMismatchException e) {
        scanner.nextLine();
        System.out.printf("%nPlease try again. A number is required.%n");
      } 
    }
    System.out.printf("You got it in %d attempts \n", count);
  }

}