import greenfoot.*;
public class RunnerWorld extends World
{
    private Runner r = new Runner();
    private HighScoreImage hSI = new HighScoreImage();
    private ScoreImage sI1 = new ScoreImage();
    private ScoreImage sI2 = new ScoreImage();
    private Logo l = new Logo();
    private EasyScreen eS = new EasyScreen();
    private MediumScreen mS = new MediumScreen();
    private HardScreen hS = new HardScreen();
    private boolean musicStarted=false;
    public RunnerWorld()
    {   
        super(900, 600, 1); 
        addObject(r, 100,295);
        r.getImage().setTransparency(0);
        addObject(eS,431,223);
        addObject(mS,492,300);
        addObject(hS,439,387);
        addObject(l, 73,15);
    }
    public void act()
    {
        if(r.getGameOver()==false&&r.getGameStarted()==true)
       {
         if(!musicStarted)
         {
         Greenfoot.playSound("Main.mp3");
         musicStarted=true;
        }
         removeObject(eS);
         removeObject(mS);
         removeObject(hS);
         r.getImage().setTransparency(255);
         addObject(r.getBaseFloor(), 371,485);
         addObject(r.getLife1(),91,63);
         addObject(r.getLife2(),52,63);
         addObject(r.getLife3(),17,63);
         addObject(r.getScore1(),819,22);
         addObject(r.getScore10(),801,22);
         addObject(r.getScore100(),782,22);
         addObject(r.getHighScore1(),523,22);
         addObject(r.getHighScore10(),502,22);
         addObject(r.getHighScore100(),482,22);
         addObject(r.getGoal(),10,303);
         r.getGoal().getImage().setTransparency(0);
         addObject(hSI,311,13);
         addObject(sI1,407,13);
         addObject(sI2,708,14);
       }
    }
}

