import java.util.*;
import java.util.Random; 

public class guessNumber
{  
	static int round=0;  
    static int totalScore=0; 
	static int[] score=new int[10]; 
    
	
	static boolean checkLimit(int attempts)
	{   
        if (attempts>=15)
        {
			return true;
        }
		return false;
	}
    
	
	static void calScore(int attempts,int round)
	{ 
		if(attempts<=5)
			score[round]=5;
	  else if(attempts>5&&attempts<=9)
		    score[round]=4;
	  else if(attempts>9&&attempts<=12)
		    score[round]=3;
	  else if (attempts>12&&attempts<=14)
	        score[round]=2;
	  else if(attempts>14&&attempts<=15)
	     	score[round]=1;
      else 
		   return ;
	   
	}
	

	static int startGame(int minimumValue,int maximumValue)
	{  
		Scanner sc=new Scanner(System.in);
        
		
		Random random= new Random();


		
        int randomNumber= minimumValue+random.nextInt(maximumValue-minimumValue);

		int attempts=0;

         round++;
       while(true)
		{
		   
		   System.out.println("\nEnter your guess between ("+minimumValue+"-"+maximumValue+") : ");
		   int playerGuess=sc.nextInt();

           attempts++; 
		   
		   if(playerGuess==randomNumber)
			{  
			   
			  calScore(attempts,round); 
		    
			 System.out.println("Your Guess is Correct!!");
			 System.out.println("\nYour total attempts are :"+attempts);
			 System.out.println("Do You Want to play another round(y/n)?");
             String choice= sc.next();
			 if(choice.equals("y"))
             startGame(minimumValue,maximumValue); 
			 break;
			}

		   else if (playerGuess<randomNumber)
			   System.out.println("\nNumber is lower...Guess again");

           else 
		       System.out.println("\nNumber is higher...Guess again");
           
		    
		   if(checkLimit(attempts))
			{  
			   System.out.println("You have exceed attempt limit you loose this round");

		       System.out.println("Do You Want to play another round(y/n)?");
               String choice= sc.next();
			   if(choice.equals("y"))
               startGame(minimumValue,maximumValue); 
			   break;
			}
		   
		}
     
      return round;    
	}
   
	public static void main(String[] args)
	{ 
	   
		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome to Number Guessing Game\n");
		System.out.println("You have to guess number in 15 attempts");
         
		//input range
		System.out.println("Enter the range in which you want to guess numbers");
		System.out.print("From : ");
		int minimumValue=sc.nextInt();
		System.out.print("To : ");
		int maximumValue=sc.nextInt();
        
		
		int round=startGame(minimumValue,maximumValue);

		
		System.out.println("You have played Total "+round+" rounds");
		System.out.println("Your round wise score out of 5 is: ");
		
		for (int i=1;i<=round ;i++ )
		{
			System.out.printf("Round[%d]= %d\n",i,score[i]);
			totalScore+=score[i];
		}
		System.out.println("Your total score is "+totalScore);
   
      }

}
