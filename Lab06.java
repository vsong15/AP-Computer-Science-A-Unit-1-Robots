//Name______________________________ Date_____________
import java.io.*;				//lets us prepare for an IOException from getting input from the keyboard
import java.util.*;

public class Lab06
{
   public static void main(String[] args) 
   {
      Scanner input = new Scanner(System.in);								//this object allows us to get input from the keyboard
   
      System.out.println("What robot world would you like to load?");//this writes text to the debugger window
      String filename = input.nextLine();										//this waits for us to type in the name of our world to load
      World.readWorld(filename);													//filename stores the value of whatever we typed in above
      World.setSize(10, 10);														//worlds include tasks1, tasks2 and tasks3
      World.setSpeed(10);
   
      followBeeperRoad_1();		//go to the end of the row of beepers
      findTheBeeper();				//go to the beeper
      findTheWall(); 				//go to the wall
      findTheWallAndClean_1(); 	//go to the wall, pick up all the beepers (max one per pile)
      findTheWallAndClean_2(); 	//go to the wall, pick up all the beepers
      followBeeperRoad_2();		//go to the end of the row of beepers, there is one gap
   }
   
	//**************COMPLETE THE METHODS BELOW**************************************************
   public static void followBeeperRoad_1()	
   { //go to the end of the row of beepers
      Robot temp = new Robot(1, 1, World.EAST, 0, "pics/spider/karel");
      while(temp.onABeeper())
         temp.move();
   }
   
   public static void findTheBeeper()	
   { //go to the beeper
      Robot temp = new Robot(1, 2, World.EAST, 0, "pics/gorilla/karel");
      while(!temp.onABeeper())
         temp.move();
   }
   
   public static void findTheWall()	
   { //go to the wall
      Robot temp = new Robot(1, 3, World.EAST, 0, "pics/r2_d2/karel");
      while(temp.frontIsClear())
         temp.move();
   }
   
   public static void findTheWallAndClean_1()	
   { //go to the wall, pick up all the beepers (max one per pile)
      Robot temp = new Robot(1, 4, World.EAST, 0, "pics/shark/karel");
      if(temp.onABeeper())
         temp.pickBeeper();
      while(temp.frontIsClear())
      {
         temp.move();
         if(temp.onABeeper())
            temp.pickBeeper();
      }
      
   }
   
   public static void findTheWallAndClean_2()	
   { //go to the wall, pick up all the beepers
      Robot temp = new Robot(1, 5, World.EAST, 0, "pics/wolf/karel");
      while(temp.onABeeper())
         temp.pickBeeper();
      while(temp.frontIsClear())
      {
         temp.move();
         while(temp.onABeeper())
            temp.pickBeeper();
      }
   }
   
   public static void followBeeperRoad_2()
   { //go to the end of the row of beepers, there is one gap
      Robot temp = new Robot(1, 6, World.EAST, 0, "pics/yoda/karel");
      while(temp.onABeeper())
         temp.move();
      temp.move();
      while(temp.onABeeper())
         temp.move();
      
   }
}