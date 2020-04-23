   //LAB:  PACBOT!
   //you control the pacbot, and must eat all the beepers in the maze
	//you are chased by 4 ghosts, and have 3 lives
	//if you eat a power-beeper, you get supercharged for 20 moves and can eat the ghosts
	//use the arrow keys to move, and ESC to quit
	
	//the assignment:  define 3 subclasses of the abstract Ghost object
	//the RandomMover (given) will move randomly across the map.
	//you must create the AFollower, which follows the pacbot across avenues, but selects a random street at an intersection
	//create the SFollower, which follows the pacbot across streets, but selects a random avenue at an intersection
	//lastly, create the ASFollower, which follows the pacbot across both streets and avenues
	   
   import javax.swing.*;
   import java.awt.event.*;
   public class PacbotDriver
   {
      public static Player pacbot = new Player(8,9,World.EAST,0);
      public static int ghostDelay = 2;
      public static Ghost[] ghosts = new Ghost[4];    	  
      public static int beepersEaten = 0;
      public static int worldBeepers = 0;
      
   	//post:	change ghost color depending on if pacbot is superCharged 	
   	//			see if ghosts collide with pacbot - he eats us if pacbot has superCharge.  
   	//			Ghost eats pacbot if pacbot is not superCharged.
      public static void checkCollisions()
      {
         for(int i=0; i<ghosts.length; i++)
         {		
         			//ghosts are scared (pacbot is supercharged): change to blue ghost if it hasn't already
            if(pacbot.getSuperCharge() > 0 && ghosts[i].areWeOurOriginalColor())
               ghosts[i].setImageName("pics/pacbot/ghost5");
            else	//pacbot's superCharge has worn off: change back to original color if it hasn't already
               if(pacbot.getSuperCharge() == 0 && !ghosts[i].areWeOurOriginalColor())
                  ghosts[i].resetOriginalImage();
            if(ghosts[i].onARobot())
            {
               Robot temp = ghosts[i].getARobot();
               if(temp != null && (temp instanceof Player))
               {
                  if(pacbot.getSuperCharge() > 0)
                  {
                     pacbot.addScore(200);
                     ghosts[i].restoreInitialState();
                  }
                  else
                  {
                     pacbot.eaten();
                     for(int j=0; j<ghosts.length; j++)
                        ghosts[j].restoreInitialState();
                     return;
                  }	
               }
            }
         }
      }
   	
      public static void main(String[] args) 
      {
         World.readWorld("pacbot3");
         World.setSize(16, 19);
         World.setSpeed(20);
         World.setTrace(false);  								//don't report locations to debugger window
         worldBeepers = World.numBeepers();
         (World.getView()).addKeyListener(new listen());	//add keyboard listener to register single-key input
       
         ghosts[0] = new ASFollower(7,10, "pics/pacbot/ghost1", ghostDelay);	//follows pacbot across avenues and streets 
         ghosts[1] = new AFollower(8,10, "pics/pacbot/ghost2", ghostDelay); 	//follows pacbot across avenues
         ghosts[2] = new SFollower(9,10, "pics/pacbot/ghost3", ghostDelay); 	//follows pacbot across streets
         ghosts[3]= new RandomMover(8,11, "pics/pacbot/ghost4", ghostDelay);  //moves randomly
         //pacbot starts with 3 lives - continue the game while you have lives left    
         while(pacbot.getNumLives() > 0)
         {
            //move the ghosts - check for collisions with pacbot
            for(int i=0; i<ghosts.length; i++)
            {
               checkCollisions();
               if(pacbot.getSuperCharge() > 0)	//don't persue pacbot if he is superCharged
                  ghosts[i].randMove();
               else										//persue pacbot in your own polymorphic way
                  ghosts[i].makeMove(pacbot.avenue(), pacbot.street());
               checkCollisions();
            }
            //if we eat all the pellets in the world, reset player and ghosts and reload the world.  Make ghosts faster.
            if(pacbot.getBeepersEaten() == worldBeepers)
            {
               World.readWorld("pacbot3");
               worldBeepers = World.numBeepers();
               pacbot.resetPlayer();
               if(ghostDelay > 0)
                  ghostDelay--;
               for(int j=0; j<ghosts.length; j++)
               {
                  ghosts[j].restoreInitialState();
                  ghosts[j].setDelay(ghostDelay);
               }
            }
         } 
         System.out.println("Game over");
         System.out.println("SCORE:" + pacbot.getScore());
         System.exit(1);
      }
      
      public static class listen implements KeyListener 
      {
      
         public void keyTyped(KeyEvent e)
         {
         
         }
         
         public void keyReleased(KeyEvent e)
         {
         
         }
      
         public void keyPressed(KeyEvent e)
         {
            int k=e.getKeyCode();
            if(pacbot.getSuperCharge() > 0)
            {	
               System.out.print(pacbot.getSuperCharge()+" ");	//count down superCharge time left
               if(pacbot.getSuperCharge()==1)
                  System.out.println();
            }
            //move player to other side of portal
            if(pacbot.areYouHere(10, 1) && pacbot.facingWest())
               pacbot.teleport(10,15);
            else
               if(pacbot.areYouHere(10, 15) && pacbot.facingEast())
                  pacbot.teleport(10,1);
               else
                  if(k==KeyEvent.VK_UP)							//Move up	
                     pacbot.moveUp();
                  else
                     if(k==KeyEvent.VK_DOWN)						//Move down
                        pacbot.moveDown();
                     else
                        if(k==KeyEvent.VK_RIGHT)				//Move right
                           pacbot.moveRight();
                        else
                           if(k==KeyEvent.VK_LEFT)				//Move left
                              pacbot.moveLeft();
                           else
                              if(k==KeyEvent.VK_ESCAPE)		//End the program	
                              {
                                 System.out.println("Thanks for playing");
                                 System.out.println("SCORE:" + pacbot.getScore());
                                 System.exit(1);
                              }
         }
      }
   }