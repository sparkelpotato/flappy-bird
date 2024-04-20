import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pipe here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pipe extends Actor
{
    private int PIPE_SPEED = 2;
    /**
     * Act - do whatever the Pipe wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        FlappyWorld world = (FlappyWorld)getWorld();
        if(!world.isPaused()){
            setLocation(getX()-PIPE_SPEED, getY());
            if(getX() < -getImage().getWidth()/2){
                getWorld().removeObject(this);
            }
        }
    }
}
