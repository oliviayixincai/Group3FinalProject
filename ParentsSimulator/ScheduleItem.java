/**
 * This is a wrapper class for a schedule item from the schedule table. It contains the coordinate of the item, 
 * height and width of the item in the schedule table displayed on the world.
 * 
 * @author Yixin Cai
 * @version 2023-01-21
 */
public class ScheduleItem  
{
    // instance variables - replace the example below with your own
    private int x;
    private int y;
    private int width;
    private int height;
    
    private Activity activity;

    /**
     * Constructor for objects of class ScheduleItem
     * @param x This is an int to show the x location
     * @param y This is an int to show the y location
     */
    public ScheduleItem(int x, int y) {
        this(x, y, ScheduleWorld.DEFAULT_ITEM_WIDTH, ScheduleWorld.DEFAULT_ITEM_HEIGHT);
    }
    
    /**
     * Constructor for objects of class ScheduleItem
     * @param x This is an int to show the x location
     * @param y This is an int to show the y location
     * @param y This is an int to show the width
     * @param y This is an int to show the height
     */
    public ScheduleItem(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    /**
     * This is a method to determine weather can set an activity
     * @param activity The activity theat player choose
     * @return boolean true if can set the activity, false otherwise
     */
    public boolean canSetActivity(Activity activity) {
        // cannot set activity is there's already has one
        if (this.activity != null) {
            return false;
        }
        
        int aX = activity.getX();
        int aY = activity.getY();
        
        // determine weathr the location of the activity is close enough to the central part
        if (aX > x + width / 4 || aX < x - width / 4) {
            return false;
        }
        else if (aY > y + height / 4 || aY < y - height / 4) {
            return false;
        }
        
        return true;
    }
    
    /**
     * This is a method to set the activity
     * @param activity The activity the player wants to set
     */
    public void setActivity(Activity activity) {
        activity.setActivity(this.x, this.y);
        this.activity = activity;
    }
    
    /**
     * This is a method to return the activity
     * @return Activiy an activity that player choose
     */
    public Activity getActivity() {
        return this.activity;
    }
    
    /**
     * This is a method to remove the activity
     */
    public void clearActivity() {
        this.activity = null;
    }
}
