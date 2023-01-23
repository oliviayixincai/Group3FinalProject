import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import greenfoot.GreenfootImage;

/**
 * Write a description of class ScheduleWorld here.
 * 
 * @author Yixin Cai
 * @version 2023-01-21
 */
public class ScheduleWorld extends AbstractWorld
{
    public static final int DEFAULT_ITEM_WIDTH = 120;
    public static final int DEFAULT_ITEM_HEIGHT = 90;
    
    private static final int LIST_ITEM_X0 = 142;
    private static final int LIST_ITEM_Y0 = 267;
    private static final int SCHEDULE_ITEM_X0 = 503;
    private static final int SCHEDULE_ITEM_Y0 = 335;
    
    private GreenfootImage scheduleText;
    private Label ageLabel;
    private Button finishButton;
    private Flashing_Text flashText;
    
    private ScheduleItem[][] scheduleTable;
    
    /**
     * Constructor for objects of class ScheduleWorld.
     * 
     */
    public ScheduleWorld(MainWorld mainWorld)
    {
        super(mainWorld);
        
        setBackground(new GreenfootImage("backgroundSchedule.png"));
        
        addObject(new Label(this.mainWorld.getStageText()), 500, 20);
        
        this.finishButton = new Button("buttonSchedule.png");
        
        scheduleText = new GreenfootImage("scheduleText.png");
        flashText = new Flashing_Text(scheduleText);
        addObject(flashText, 680, 220);
        
        this.scheduleTable = initScheduleTable();
        
        initSelection();
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(this.finishButton)) {
            ActivityEffectWorld aew = new ActivityEffectWorld(this.mainWorld, this.scheduleTable);
            Greenfoot.setWorld(aew);
        }
        
        initSelection();
        
        if (canFinish() && finishButton.getWorld() == null) {
            addObject(this.finishButton, 210, 620);
        }
    }
    
    public void trySetActivity(Activity activity) {
        for (int i = 0; i < scheduleTable.length; i++) {
            for (int j = 0; j < scheduleTable[i].length; j++) {
                ScheduleItem scheduleItem = scheduleTable[i][j];
                if (scheduleItem.canSetActivity(activity)) {
                    tryClearActivity(activity);
                    scheduleItem.setActivity(activity);
                    return;
                }
            }
        }
    }
    
    private void tryClearActivity(Activity activity) {
        for (int i = 0; i < scheduleTable.length; i++) {
            for (int j = 0; j < scheduleTable[i].length; j++) {
                ScheduleItem scheduleItem = scheduleTable[i][j];
                if (scheduleItem.getActivity() == activity) {
                    scheduleItem.clearActivity();
                    return;
                }
            }
        }
    }
    
    private void initSelection() {
        int borderX = 10;
        int borderY = 15;
        int stage = this.mainWorld.getStage();
        for (int i = 0; i < Constants.activityNames[stage].length; i++) {
            int offSetX = i % 2;
            int offSetY = i / 2;
            
            int x = LIST_ITEM_X0 + offSetX * (DEFAULT_ITEM_WIDTH + borderX);
            int y = LIST_ITEM_Y0 + offSetY * (DEFAULT_ITEM_HEIGHT + borderY);
            
            ArrayList<Activity> activities = (ArrayList<Activity>) getObjectsAt(x, y, Activity.class);
            
            String name = Constants.activityNames[stage][i];
            int[] points = Constants.activityPoints[stage][i];
            
            if (activities.size() == 0) {
                addObject(new Activity(name, points), x, y);
                addObject(new Activity(name, points), x, y);
            }
            else if (activities.size() == 1) {
                addObject(new Activity(name, points), x, y);
            }
        }
    }
    
    private ScheduleItem[][] initScheduleTable() {
        int borderX = -1;
        int borderY = 3;
        ScheduleItem[][] table = new ScheduleItem[4][3];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                table[i][j] = new ScheduleItem(SCHEDULE_ITEM_X0 + i * (DEFAULT_ITEM_WIDTH + borderX), SCHEDULE_ITEM_Y0 + j * (DEFAULT_ITEM_HEIGHT + borderY));
            }
        }
        return table;
    }
    
    private boolean canFinish() {
        for (int i = 0; i < scheduleTable.length; i++) {
            for (int j = 0; j < scheduleTable[i].length; j++) {
                ScheduleItem scheduleItem = scheduleTable[i][j];
                if (scheduleItem.getActivity() == null) {
                    return false;
                }
            }
        }
        return true;
    }

}
