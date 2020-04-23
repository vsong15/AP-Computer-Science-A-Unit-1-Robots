   public abstract class Ghost extends Robot
   {
      private String originalImage; //remember our original image to turn back to after turning blue (when pacbot eats a power pellet)
      private int delay;				//to slow ghosts down
      
       //args: avenue location, street location, image file name, delay value
      public Ghost(int x, int y, String id, int d)
      {
         super(x, y, (int)(Math.random()*4), 0, id);
         originalImage = id;
         delay = d;
      }
      
   	//args: image file name
      public Ghost(String id)
      {
         super(id);
         originalImage = id;
         delay = 2;
      }
    
     //post: true if out image is our original color.  false if we are a blue ghost (because pacbot is superCharged)
      public boolean areWeOurOriginalColor()
      {
         return imageName().equals(originalImage);
      }
     
    //post: reset ghost image back to its original color (after pacbot superCharge wears off)
      public void resetOriginalImage()
      {
         setImageName(originalImage);
      }
    
      public int getDelay()
      {
         return delay;
      }
    
      public void setDelay(int d)
      {
         if(d >= 0)
            delay = d;
      }
    
      public void turnRight()
      {
         for(int i=0; i<3; i++)
            turnLeft();
      }  
   	
      public void turnAround()
      {
         turnLeft();
         turnLeft();
      }
   	
      public boolean rearIsClear()
      {
         boolean clear = false;
         turnAround();
         if(frontIsClear())
            clear = true;
         turnAround();
         return clear;
      }
   	
   	//post:  turn in a random direction, or don't turn at all
      public void randMove()
      {
         int randDir = (int)(Math.random()*4);	//0, 1, 2 or 3
         if(randDir==0)
            turnRight();
         else
            if(randDir==1)
               turnLeft();
            else
               if(randDir==2)
                  turnAround();
      }
   
   	//pre: avenue and street are location of pacbot player
      public void makeMove(int avenue, int street)
      {	 
         //slow ghost down
         for(int i=0; i<delay; i++)
         {
            turnAround();
            turnAround();
         }  
         
         makeNextMove(avenue, street);
      	
      }
      
       //given that avenue and street are pacbots current position, make your next move (or turn)
      public abstract void makeNextMove(int avenue, int street);
   }
