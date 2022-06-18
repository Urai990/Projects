import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FallingObjects here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FallingObjects extends Actor
{
    private int dropSpeed = 1;
    private boolean onBottom = false;
    /**
     * Act - do whatever the FallingObjects wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        fall();
    }
    private void fall() 
    {
        // Add your falling code here.
        setLocation(getX(), getY() + dropSpeed);
            if (! onBottom) {
       this.setLocation(getX(),getY()+dropSpeed);
       onBottom=checkBottom();
    }
    }    
    private boolean checkBottom()
    {
        // Add your checkBottom code here.
        if (getY()>570){
            return true;
        }
        else {
           return false;
       }
    } 
}    
