import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Start here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Start extends Actor
{
    private Actor title;
    private Actor ready;
    /**
     * Act - do whatever the Start wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Start(Actor title, Actor ready){
        this.title = title;
        this.ready = ready;
    }
    
    public void act()
    {
        // Add your action code here.
        if(Greenfoot.mousePressed(this)){
            FlappyWorld world = (FlappyWorld)getWorld();
            world.removeObject(this);
            world.removeObject(title);
            world.addObject(ready, world.getWidth()/2, world.getHeight()/2);
        }
    }
}
