import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;

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
          {
                GuessItWorld w=new GuessItWorld();
                w.started();
                Greenfoot.setWorld(w);
           }
          else if(world instanceof GameAbout)
          {
                GuessItWorld w=new GuessItWorld();
                w.started();
                Greenfoot.setWorld(w);
           }
          else if(world instanceof GamePlayWorld)
            {
                
              String message= "You will lose your progress.Do you really want to go back?";
              String title= "CONFIRMATION !!!";
              int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
              if (reply == JOptionPane.YES_OPTION)
                {
                    
                if(getWorldOfType(GamePlayWorld.class).backgroundMusic!=null)
                {
                getWorldOfType(GamePlayWorld.class).backgroundMusic.stop();
                }
                
                //clearing the hashmap
                //for(Map.Entry<String,Boolean> entrySet :getWorldOfType(GamePlayWorld.class).previousQueryResultMap.entrySet())
                QueryResultBox resultBox = getWorldOfType(GamePlayWorld.class).getObjects(QueryResultBox.class).get(0);
                StringBuilder queryTest = new StringBuilder(); 
                for(Iterator<Map.Entry<String,Boolean>> it =getWorldOfType(GamePlayWorld.class).previousQueryResultMap.entrySet().iterator();it.hasNext();)
                 {
                     Map.Entry<String,Boolean> entry = it.next();
                     it.remove();
                     System.out.println("a key removed");
                    }
                 resultBox.updateImage(queryTest.toString());
                 
                 /*sample
                 Map<String, String> map = new HashMap<String, String>() {
      {
        put("test", "test123");
        put("test2", "test456");
      }
    };

    for(Iterator<Map.Entry<String, String>> it = map.entrySet().iterator(); it.hasNext(); ) {
      Map.Entry<String, String> entry = it.next();
      if(entry.getKey().equals("test")) {
        it.remove();
      }
    }
                */
                String name = getWorldOfType(GamePlayWorld.class).playerName;
                System.out.print(name);
                Greenfoot.setWorld(new GameTypeSelect(name));
                
                
                
            }
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
                GuessItWorld w=new GuessItWorld();
                w.started();
                Greenfoot.setWorld(w);
            }
          
          else if(world instanceof GameAbout)
          {
          GuessItWorld w=new GuessItWorld();
          w.started();
          Greenfoot.setWorld(w);
          }
                          
              
    } 
    
    }
}

