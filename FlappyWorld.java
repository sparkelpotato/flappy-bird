import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FlappyWorld here.
 * 
 * @author Ryan
 * @version finished
 */
public class FlappyWorld extends World
{
    private int counter = 0;
    private int points = 0;
    private int FIRST_POINT = 365;
    private int GAP_SIZE = 120;
    private Score score;
    private boolean isPaused = true;
    /**
     * Constructor for objects of class FlappyWorld.
     * 
     */
    public FlappyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false); 
        
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        //Create a Flappy Bird Oject
        FlappyBird flappy = new FlappyBird();
        //set paint order
        setPaintOrder(Start.class, Title.class, Score.class,GameOver.class, FlappyBird.class, Pipe.class);
        //Add flappy to our world - addObject(object, x, y)
        addObject(flappy, 100, getHeight()/2);
        score = new Score();
        score.setScore(points);
        addObject(score,getWidth()-50,50);

        Actor title = new Title();
        addObject(title, getWidth()/2, getHeight()/3);

        Actor ready = new GetReady();

        Actor start = new Start(title, ready);
        addObject(start, getWidth()/2, getHeight()*2/3);
    }
    
    public void act(){
        if(!isPaused){
            counter++;
            if(counter%100 == 0){
                Pipe tPipe = new TopPipe();
                Pipe bPipe = new BottomPipe();
                int random = Greenfoot.getRandomNumber(getHeight()/2)+getHeight()/4;
                int tOffset = random-tPipe.getImage().getHeight()/2;
                int bOffset = random+bPipe.getImage().getHeight()/2;
                addObject(tPipe, getWidth(), tOffset-GAP_SIZE/2);
                addObject(bPipe, getWidth(), bOffset+GAP_SIZE/2);
            }
            if(counter >= FIRST_POINT && (counter-FIRST_POINT)%100 == 0){
                points++;
                //System.out.println(points);
                score.setScore(points);
            }
        }
    }
    
    public boolean isPaused(){
        return isPaused;
    }
    
    public void setPaused(boolean isPaused){
        this.isPaused = isPaused;
    }
}
