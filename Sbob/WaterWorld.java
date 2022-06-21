import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class waterworld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WaterWorld extends World
{
    /**
     * Constructor for objects of class waterworld.
     * 
     */
    public WaterWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        prepare();
    }
    public void dropGold(){
        PirateGold g = new PirateGold();
        addObject(g, Greenfoot.getRandomNumber(getWidth()), 10);
    }
    public void dropTrap(){
        CrabTrap t = new CrabTrap();
        addObject(t, 50 + Greenfoot.getRandomNumber(getWidth())-100, 10);
    }
    public void act(){
        if (Greenfoot.getRandomNumber(120)==5){
            dropGold();
        }
        if (Greenfoot.getRandomNumber(500)==20){
            dropTrap();
        }
    }
    private void prepare(){
        Sbob sbob = new Sbob();
        addObject(sbob, 328, 537);
        sbob.setLocation(399, 527);
    }
}











