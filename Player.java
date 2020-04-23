   public class Player extends Robot
   {
      private int beepersEaten;	//count # beepers eaten to see when level needs to be reset if all world beepers eaten
      private int superCharge;	//time left in which Player can eat a ghost
      private int numLives;		//game ends when we run out of lives
      private int score;			//player score
      
   	//args: avenue, street, direction, #beepers
      public Player(int x, int y, int d, int b)
      {
         super(x, y, d, b, "pics/pacbot/pacbot");
         beepersEaten=0;
         superCharge=0;
         numLives=3;
         score=0;
      }
      
      public Player()
      {
         super("pics/pacbot/pacbot");	
         beepersEaten=0;
         superCharge=0;
         numLives=3;
         score=0;
      }
   	
   	//post: picks up all beepers standing on and returns # picked up
      public int countBeepers()
      {
         int count=0;
         while(onABeeper())
         {
            pickBeeper();
            count++;
         }
         if(count>0)
            beepersEaten++;
         return count;
      }
   	
   	//post:  advances eating animantion, eats a pellet if on one 
   	//       and supercharges pacbot if we eat a power pellet (more than 1 beeper in a pile)
      public void eatPellet()
      {
         advanceAnim();
         if(onABeeper())
         {
            score += 10;			//10 points for eating normal pellet
            int num = countBeepers();
            if(num > 1)				//we ate a power pellet
            {
               superCharge = 20;	//add time the power pellet lasts (20 moves)
               score += 40; 		//50 points for eating power pellet (10+40)  
            }
         }
      }
   	
   	//post: toggle picture used for pacbot (open mouth, closed mouth)
      public void advanceAnim()
      {
         if(imageName().equals("pics/pacbot/pacbot2"))
            setImageName("pics/pacbot/pacbot");	//open mouth
         else
            setImageName("pics/pacbot/pacbot2");	//closed mouth
      }
   	
      public void moveUp()
      {
         eatPellet();
         while(!facingNorth())
            turnLeft();
         if(frontIsClear())
            move();
         if(superCharge > 0)
            superCharge--;   
      }
   	
      public void moveDown()
      {
         eatPellet();
         while(!facingSouth())
            turnLeft();
         if(frontIsClear())
            move();
         if(superCharge > 0)
            superCharge--;   
      }
   
      public void moveRight()
      {
         eatPellet();
         while(!facingEast())
            turnLeft();
         if(frontIsClear())
            move();
         if(superCharge > 0)
            superCharge--;   
      }
   
      public void moveLeft()
      {
         eatPellet();
         while(!facingWest())
            turnLeft();
         if(frontIsClear())
            move();
         if(superCharge > 0)
            superCharge--;   
      }
   
    
      public int getBeepersEaten()
      {
         return beepersEaten;
      }
      
   	//post: resets player to inital spawn values for level reset
      public void resetPlayer()
      {
         beepersEaten=0;
         superCharge=0;
         restoreInitialState();
      }
   
      
      public int getSuperCharge()
      {
         return superCharge;
      }
   
      public int getNumLives()
      {
         return numLives;
      }
      
      public int getScore()
      {
         return score;
      }
      
      public void addScore(int add)
      {
         score += add;
      }
   
   //post: resets player to inital spawn values when eaten by a ghost
      public void eaten()
      {
         numLives--;
         superCharge = 0;
         restoreInitialState();
      }
   }
