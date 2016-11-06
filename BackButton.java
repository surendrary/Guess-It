import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BackButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BackButton extends Actor
{
    /**
     * Act - do whatever the BackButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public BackButton(){
        GreenfootImage image = new GreenfootImage("back_button.png");
        image.scale(60,60);
        setImage(image);
    }
    
    public void act() 
    {
        // Add your action code here.
      MouseInfo mouseInfo = Greenfoot.getMouseInfo();
      if(Greenfoot.mouseClicked(this)){
          Greenfoot.playSound("button_click.mp3");
          World world = getWorld();
          if(world instanceof GameRules)
                Greenfoot.setWorld(new GuessItWorld());
          else if(world instanceof GameAbout)
                Greenfoot.setWorld(new GuessItWorld());
          else if(world instanceof GamePlayWorld)
            {
                String name = getWorldOfType(GamePlayWorld.class).playerName;
                System.out.print(name);
                Greenfoot.setWorld(new GameTypeSelect(name));
            }
          else if(world instanceof MultiplayerHome)
            {
                String name = getWorldOfType(MultiplayerHome.class).userName;
                System.out.print(name);
                Greenfoot.setWorld(new GameTypeSelect(name));
            }
            
          else if(world instanceof GameLevelSelection)
            {
                String name = getWorldOfType(GameLevelSelection.class).playerName;
                System.out.print(name);
                Greenfoot.setWorld(new GameTypeSelect(name));
            }
            
          else if(world instanceof GameTypeSelect)
            {
                String name = getWorldOfType(GameTypeSelect.class).playerName;
                System.out.print(name);
                Greenfoot.setWorld(new GuessItWorld());
            }
          
          else if(world instanceof GameAbout)
          Greenfoot.setWorld(new GuessItWorld());
                          
              
    } 
    
    }
}
