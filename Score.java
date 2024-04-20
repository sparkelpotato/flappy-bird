import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends Actor
{
    int FONTSIZE = 32;
    
    public Score(){
        GreenfootImage image = new GreenfootImage(100, 50);
        setImage(image);
    }
    
    public void setScore(int score){
        GreenfootImage image = getImage();
        image.clear();
        
        Font f = new Font("Comic Sans MS", FONTSIZE);
        image.setFont(f);
        image.setColor(Color.MAGENTA);
        image.drawString("" + score, image.getWidth()/2, image.getHeight()/2);
        setImage(image);
    }
}
