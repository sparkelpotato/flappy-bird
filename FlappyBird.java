import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FlappyBird here.
 * 
 * @author Ryan 
 * @version finished
 */
public class FlappyBird extends Actor
{
    double dy = 0;
    double g = .3; //.5
    double JUMP_SPEED = -4; //-7
    double ROTATION_MULTIPLIER = 5; //3
    int ANIM_RATE = 3;
    int animFrame = 0;
    int counter = 0;
    GreenfootImage fb1 = new GreenfootImage("flappybird1.png");
    GreenfootImage fb2 = new GreenfootImage("flappybird2.png");
    GreenfootImage fb3 = new GreenfootImage("flappybird3.png");
    /**
     * Act - This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        FlappyWorld world = (FlappyWorld)getWorld();
        if(!world.isPaused()){
            //jump if user presses up
            if(isJumping()){
                dy = JUMP_SPEED;
            }
            //game over when bird drops out of the world
            if(getY() > getWorld().getHeight() || getOneIntersectingObject(Pipe.class) != null){
                Actor lose = new GameOver();
                world.addObject(lose, world.getWidth()/2, world.getHeight()/2);
                Greenfoot.stop();
            }
            setLocation(getX(), getY()+(int)Math.round(dy));
            if(getY() < 0){
                setLocation(getX(), 0);
            }
            dy += g;
            counter++;
            animation();
        }
    }
    
    private void animation(){
        setRotation((int)(dy*ROTATION_MULTIPLIER));
        if(counter % ANIM_RATE == 0){
            switch(animFrame){
                case 0:
                    setImage(fb1);
                    break;
                case 1:
                    setImage(fb2);
                    break;
                case 2:
                    setImage(fb3);
                    break;
                case 3:
                    setImage(fb2);
                    animFrame = 0;
                    return;
                default:
                    setImage(fb1);
            }
            animFrame++;
        }
    }
    
    public static boolean isJumping(){
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse == null){
            return Greenfoot.isKeyDown("up");
        }
        return Greenfoot.isKeyDown("up") || (mouse.getButton() == 1 && !(mouse.getClickCount() > 0));
    }
}
