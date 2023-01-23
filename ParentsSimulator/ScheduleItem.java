/**
 * Write a description of class ScheduleItem here.
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
     */
    public ScheduleItem(int x, int y) {
        this(x, y, ScheduleWorld.DEFAULT_ITEM_WIDTH, ScheduleWorld.DEFAULT_ITEM_HEIGHT);
    }
    
    public ScheduleItem(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    public boolean canSetActivity(Activity activity) {
        if (this.activity != null) {
            return false;
        }
        
        int aX = activity.getX();
        int aY = activity.getY();
        
        if (aX > x + width / 4 || aX < x - width / 4) {
            return false;
        }
        else if (aY > y + height / 4 || aY < y - height / 4) {
            return false;
        }
        
        return true;
    }
    
    public void setActivity(Activity activity) {
        activity.setActivity(this.x, this.y);
        this.activity = activity;
    }
    
    public Activity getActivity() {
        return this.activity;
    }
    
    public void clearActivity() {
        this.activity = null;
    }
}
