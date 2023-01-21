import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class ScheduleWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScheduleWorld extends World
{
    private MainWorld mainWorld;
    
    private Button finishButton;
    
    private ScheduleItem[][] array;
    
    /**
     * Constructor for objects of class ScheduleWorld.
     * 
     */
    public ScheduleWorld(MainWorld mainWorld)
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1);
        drawGrid();
        this.mainWorld = mainWorld;
        this.finishButton = new Button("scheduleButton.png");
        //setBackground(new GreenfootImage("scheduleBackground.png"));
        addObject(this.finishButton, 800, 600);
        
        initSelectionList(2);
        initScheduleItem();
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(this.finishButton)) {
            Stats_Board stats=this.mainWorld.returnStats();
            stats.addPoints("IQ", 1);
            stats.addPoints("EQ", 2);
            Greenfoot.setWorld(this.mainWorld);
            
        }
        initSelectionList(2);
    }
    
    public void drawGrid() {
        addObject(new Grid(), 500, 350);
        //addObject(new ListGrid(Math.min(this.mainWorld.getRound() + 1, 6)), 200, 350);
    }
    
    public void trySetActivity(Activity activity) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                ScheduleItem scheduleItem = array[i][j];
                if (scheduleItem.canSetActivity(activity)) {
                    tryClearActivity(activity);
                    scheduleItem.setActivity(activity);
                    return;
                }
            }
        }
    }
    
    private void tryClearActivity(Activity activity) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                ScheduleItem scheduleItem = array[i][j];
                if (scheduleItem.getActivity() == activity) {
                    scheduleItem.clearActivity();
                    return;
                }
            }
        }
    }
    
    private void initSelectionList(int count) {
        int x0 = 200;
        int y0 = 170;
        int border = 0;
        for (int i = 0; i < count; i++) {
            int x = x0;
            int y = y0 + i * 90 + border;
            ArrayList<Activity> activities = (ArrayList<Activity>) getObjectsAt(x, y, Activity.class);
            if (activities.size() == 0) {
                addObject(new Activity(), x, y);
                addObject(new Activity(), x, y);
            }
            else if (activities.size() == 1) {
                addObject(new Activity(), x, y);
            }
        }
    }
    
    private void initScheduleItem() {
        array = new ScheduleItem[4][3];
        int x = 470;
        int y = 260;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = new ScheduleItem(x + i * 120, y + j * 90);
            }
        }
    }
}
