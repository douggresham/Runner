import greenfoot.*;
import java.util.ArrayList;
public class Runner extends Actor
{
    private boolean gameStarted=false;
    private boolean isInAir=false;
    private int count=-8;
    private BaseFloor bF = new BaseFloor();
    private ArrayList<Box> boxes = new ArrayList<Box>();
    private ArrayList<Boolean> pointAdded = new ArrayList<Boolean>();
    private int boxGeneration=-1;
    private Timer boxStaggerTimer = new Timer();
    private boolean gameOver=false;
    private int lifeCount=3;
    private Life l1 = new Life();
    private Life l2 = new Life();
    private Life l3 = new Life();
    private Score1 s1 = new Score1();
    private Score10 s10 = new Score10();
    private Score100 s100 = new Score100();
    private Score1 h1 = new Score1();
    private Score10 h10 = new Score10();
    private Score100 h100 = new Score100();
    private int score = 0;
    private static int highScore;
    private Goal g = new Goal();
    private int runnerImage=0;
    private GameOverScreen gOS = new GameOverScreen();
    private boolean gameOverSound=false;
    public void act() 
    {
        if(!gameStarted)
        {
          if(Greenfoot.isKeyDown("1"))
          {
               gameStarted=true;
               Greenfoot.setSpeed(40);
               Greenfoot.playSound("Jump.wav");
          }
          if(Greenfoot.isKeyDown("2"))
          {
              gameStarted=true;
              Greenfoot.setSpeed(45);
              Greenfoot.playSound("Jump.wav");
          }
          if(Greenfoot.isKeyDown("3"))
          {
           gameStarted=true;   
           Greenfoot.setSpeed(50);
           Greenfoot.playSound("Jump.wav");
          }
       }
       setLifeCounter();
       setHighScore(highScore);
        if(!gameOver&&gameStarted)
        {
         if(runnerImage<5)
         {
           setImage("runner1.JPG");
         }
         if(runnerImage<10&&runnerImage>=5)
         {
           setImage("runner2.JPG");
         }
         if(runnerImage<15&&runnerImage>=10)
         {
           setImage("runner3.JPG");
         }
         if(runnerImage<20&&runnerImage>=15)
         {
           setImage("runner4.JPG");
         }
         if(runnerImage<25&&runnerImage>=20)
         {
           setImage("runner5.JPG");
         }
         if(runnerImage==25)
         {
           runnerImage=0;               
         }
         runnerImage++;
         if(isTouching(Box.class))
         {
           lifeCount--;
           getWorld().removeObjects(getIntersectingObjects(Box.class));
           Greenfoot.playSound("Hit.wav");
         }
         for(int i=0;i<boxes.size();i++)
         {
           if(boxes.get(i).getGoalTouch()==true&&pointAdded.get(i)==false)
           {
             score++;
             setScore(score);
             pointAdded.set(i,true);
           }
         }
         boxGeneration=(int)(Math.random()*30);
         if(boxGeneration==0&&boxStaggerTimer.getTime()==0)
         {
            boxStaggerTimer.startTimer();
            Box b = new Box();
            boxes.add(b);
            pointAdded.add(false);
            getWorld().addObject(b,850,300);
         }
         if(isTouching(BaseFloor.class)&&getX()>100)
         {
            move(-10);
         } 
         if(boxStaggerTimer.getTime()==1500)
         {
            boxStaggerTimer.stopTimer();
         }
         if(count==9)
         {
            count=-8;
            isInAir=false;
         }
         if(!isInAir&&Greenfoot.isKeyDown("SPACE"))
         {
            Greenfoot.playSound("Jump.wav");
            isInAir=true;
         }
         if(isInAir)
         {
          turn(360);
          if(count<=0)
          setLocation(getX()+1,getY()-count*count);
          else if(count>0)
          setLocation(getX()+1,getY()+count*count);
          count++;
         } 
       }
       if(gameOver)
       {
        if(score>highScore)
        {
           highScore=score;
           setHighScore(highScore);
        }
        getWorld().addObject(gOS,243,261);
        if(!gameOverSound)
        {
           Greenfoot.playSound("Death.wav");
           gameOverSound=true;
        }
        }
    }  
    public void setLifeCounter()
    {
        if(lifeCount==2)
        {
            getWorld().removeObject(l1);
        }
        else  if(lifeCount==1)
        {
            getWorld().removeObject(l1);
            getWorld().removeObject(l2);
        }
        else if(lifeCount==0)
        {
            getWorld().removeObject(l1);
            getWorld().removeObject(l2);
            getWorld().removeObject(l3);
            gameOver=true;
        }
    }
    public void setScore(int count)
    {
        if(count<10)
        {
            s1.setImage(count+".JPG");
        }
        if(count>10&&count<100)
        {
            s1.setImage(count%10+".JPG");
            s10.setImage(count/10+".JPG");
        }
        if(count>100&&count<1000)
        {
            s1.setImage(count%10+".JPG");
            s10.setImage((count%100)/10+".JPG");
            s100.setImage(count/100+".JPG");
        }
    }
    public void setHighScore(int count)
    {
        if(count<10)
        {
            h1.setImage(count+".JPG");
        }
        if(count>10&&count<100)
        {
            h1.setImage(count%10+".JPG");
            h10.setImage(count/10+".JPG");
        }
        if(count>100&&count<1000)
        {
            h1.setImage(count%10+".JPG");
            h10.setImage((count%100)/10+".JPG");
            h100.setImage(count/100+".JPG");
        }
    }
    public BaseFloor getBaseFloor()
    {
        return bF;
    }
    public Life getLife1()
    {
        return l1;
    }
    public Life getLife2()
    {
       return l2; 
    }
    public Life getLife3()
    {
        return l3;
    }
    public Score1 getScore1()
    {
        return s1;
    }
    public Score10 getScore10()
    {
        return s10;
    }
    public Score100 getScore100()
    {
        return s100;
    }
    public Score1 getHighScore1()
    {
        return h1;
    }
    public Score10 getHighScore10()
    {
        return h10;
    }
    public Score100 getHighScore100()
    {
        return h100;
    }
    public boolean getGameOver()
    {
        return gameOver;
    }
    public Goal getGoal()
    {
        return g;
    }
    public boolean getGameStarted()
    {
        return gameStarted;
    }
}

