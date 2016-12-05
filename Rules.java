import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This Page will display game rules.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rules extends Actor
{
    private ConcreteCommand command;
    /**
     * Act - do whatever the About wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Rules()
    {
        GreenfootImage image = new GreenfootImage("rules.png");
        image.scale(40,40);
        setImage(image);
    }
    
    public void act() 
    {
        MouseInfo mouseInfo = Greenfoot.getMouseInfo();
      if(Greenfoot.mouseClicked(this))
      {
          command = new ConcreteCommand();
          command.setReceiver(new RuleButtonReceiver());
          InvokerImpl i = new InvokerImpl();
          i.setCommand(command);
          i.invoke(); 
        }
        /*
        // Add your action code here.
      MouseInfo mouseInfo = Greenfoot.getMouseInfo();
      if(Greenfoot.mouseClicked(this)){
          Greenfoot.playSound("button_click.mp3");
          Greenfoot.setWorld(new GameRules());
         */ 
       
}
}
