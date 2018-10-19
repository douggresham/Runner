import greenfoot.*;
import java.util.ArrayList;
public class Box extends Actor
{
   private boolean goalTouch=false;
   public void act() 
   {
        move(-8);
        if(isAtEdge())
        getWorld().removeObject(this);
        if(goalTouch==false&&getOneIntersectingObject(Goal.class)!=null)
        goalTouch=true;
    }   
   public boolean getGoalTouch()
   {
       return goalTouch;
   }
}
