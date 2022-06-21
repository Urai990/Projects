import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sbob here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sbob extends Actor
{
    /**
     * Act - do whatever the Sbob wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int gold = 0;
    private int crabTrap = 0;
    public void act(){
        // Add your action code here.
        getWorld().showText("Number of points: "+ Integer.toString(gold),400,550);
        if (Greenfoot.isKeyDown("right")){
            setLocation(getX()+1, getY());
        }
        if (Greenfoot.isKeyDown("left")){
            setLocation(getX()-1, getY());
        }
        if(canCatchGold()){
            CatchGold();
            gold = gold + 1;
            getWorld().showText("Number of points: "+ Integer.toString(gold),400,550);
                
        }
        if (canCrabTrapped()){
            CrabTrap();
        }
    
    }
    private boolean canCatchGold(){
        Actor gold = getOneObjectAtOffset(0,0,PirateGold.class);
        if (gold != null){
            return true;
        }
        else{
            return false;
        }
    }
    private void CatchGold(){
        Actor gold = getOneObjectAtOffset(0,0,PirateGold.class);
        if (gold != null){
            Greenfoot.playSound("cha_ching.wav");
            getWorld().removeObject(gold);
    
        }
    }
    private boolean canCrabTrapped(){
        Actor crabTrap = getOneObjectAtOffset(0,0,CrabTrap.class);
        if(crabTrap != null){
            return true;
        }
        else{
            return false;
        }
    }
    private void CrabTrap(){
       Actor crabTrap = getOneObjectAtOffset(0,0,CrabTrap.class);
        if (crabTrap != null){
            Greenfoot.playSound("bonk.wav");
            getWorld().removeObject(crabTrap);
            getWorld().showText("GAME OVER",400,300);
            Greenfoot.stop();
        }
    }
}













