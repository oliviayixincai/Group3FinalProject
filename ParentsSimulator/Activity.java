import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Activity here.
 * 
 * @author Yixin Cai
 * @version 2023-01-21
 */
public class Activity extends Actor
{
    public static final int SPEED = 20;

    // declare the variables
    private String name;
    private int originalX;
    private int originalY;
    private boolean isMouseDown;
    private int[] points;

    /**
     * The constructor of the Activity.
     * @param name the name of the activity
     * @param points the points that the activity can add to the child
     */
    public Activity(String name, int[] points) {
        this.name = name;
        this.points = points;
        
        String imageFileName = "activity" + this.name + "Icon.png";
        setImage(new GreenfootImage(imageFileName));
    }
    
    /**
     * This method is called by the Greenfoot system when this actor has been inserted into the world.
     * @param w The world the object was added to.
     */
    public void addedToWorld(World w) {
        originalX = getX();
        originalY = getY();
    }

    /**
     * Act - do whatever the Activity wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.mouseDragged(this)) {
            setLocation(Greenfoot.getMouseInfo().getX(),Greenfoot.getMouseInfo().getY());
            this.isMouseDown = true;
        }
        else if (Greenfoot.mouseDragEnded(this)) {
            ArrayList<Activity> activities = (ArrayList<Activity>) getObjectsAtOffset(0, 0, Activity.class);
            if (activities.size() == 1) {
                ScheduleWorld sw = (ScheduleWorld) getWorld();
                sw.trySetActivity(this);
            }
            this.isMouseDown = false;
        }
        
        if (!this.isMouseDown) {
            checkMove();
        }
    }
    
    /**
     * Move the activity towards original location. It moves the activity one step at a time.
     * The distance of each time is based on the SPEED constant value in this class.
     */
    private void checkMove() {
        int x = getX();
        int y = getY();
        if (x != originalX || y != originalY) {
            double dx = Math.abs(originalX - x);
            double dy = Math.abs(originalY - y);
            double degree = Math.atan(dy / dx);
            double mx = Math.cos(degree) * SPEED;
            double my = Math.sin(degree) * SPEED;
            if (dx < mx || dy < my) {
                setLocation(originalX, originalY);
            }
            else {
                int xDirection = originalX > x ? 1 : -1;
                int yDirection = originalY > y ? 1 : -1;
                setLocation((int) (x + mx * xDirection), (int) (y + my * yDirection));
            }
        }
    }
    
    /**
     * Set the activity to the given coordinate.
     * @param x x coordinate to be set
     * @param y y coordinate to be set
     */
    public void setActivity(int x, int y) {
        setLocation(x, y);
        this.originalX = x;
        this.originalY = y;
    }
    
    /**
     * Get the name of the activity
     * @return String name of the activity
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Get the points of the activity
     * @return int[] points of the activity
     */
    public int[] getPoints() {
        return this.points;
    }
    
}
