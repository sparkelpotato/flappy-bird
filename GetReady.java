import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GetReady here.
 * 
 * @author ryan 
 * @version finished
 */
public class GetReady extends Actor
{
    /**
     * Act - do whatever the GetReady wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        if(FlappyBird.isJumping()){
            FlappyWorld world = (FlappyWorld)getWorld();
            world.removeObject(this);
            world.setPaused(false);
        }
    }
}
