/**
 * Write a description of class StepRepository here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*; import java.util.List; import java.util.Arrays;

public class StepRepository implements IContainer
{
    
    //public String[] steps; 
    List<String> steps = new ArrayList<String>();
    // instance variables - replace the example below with your own
    private int x;

     @Override
   public IIterator getIIterator() {
      return new StepIterator();
   }
   
   public void addStep(String s)
   {
       this.steps.add(s);
    }

  
    
       
       private class StepIterator implements IIterator {
    
          int index;
    
          @Override
          public boolean hasNext() {
          
             if(index < steps.size()){
            return true;
         }
         return false;
      }

      @Override
      public Object next() {
      
         if(this.hasNext()){
//            return steps.[index++];
            return steps.get(index++);
         }
         return null;
      }		
   }
    
    
    /**
     * Constructor for objects of class StepRepository
     */
    public StepRepository()
    {
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    
}
