import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Queue;
import java.util.LinkedList;

/**
 * Write a description of class ActivityWorld here.
 * 
 * @author Yixin Cai
 * @version 2023-01-21
 */
public class ActivityEffectWorld extends AbstractWorld {
    private Queue<Activity> activityQueue;
    private FadeEffect effect;
    private int[] pointsSum;
    private int randomChoiceIndex;
    private boolean inRandomChoice;
    private GreenfootImage background;

    /**
     * Constructor for objects of class ActivityWorld.
     * 
     */
    public ActivityEffectWorld(MainWorld mainWorld, ScheduleItem[][] scheduleTable) {
        super(mainWorld);
        
        this.activityQueue = toActivityQueue(scheduleTable);
        this.pointsSum = new int[] {0,0,0,0};
        this.randomChoiceIndex = 0;
        
        background = new GreenfootImage("activityBG.png");
        setBackground(background);
    }
    
    public void act() {
        if (this.inRandomChoice) {
            return;
        }

        if (effect == null || effect.getWorld() == null) {
            int size = activityQueue.size();
            if (this.randomChoiceIndex < 2 && this.randomChoiceIndex * 4 == 8 - size) {
                startRandomChoice(this.randomChoiceIndex);
                this.randomChoiceIndex++;
            }
            else {
                playNextEffect();
            }
        }
    }
    
    private void playNextEffect() {
        Activity activity = activityQueue.poll();
        if (activity == null) {
            finishWorld();
        }
        else {
            updatePoints(activity.getPoints());
            // Yixin, I changed this part to enlarge the activity images.
            GreenfootImage activityEnlarged = new GreenfootImage("activity" + activity.getName() + "Icon.png");
            activityEnlarged.scale(420,360);
            
            effect = new FadeEffect(new GreenfootImage(activityEnlarged));
            //effect = new FadeEffect(new GreenfootImage("activity" + activity.getName() + "Icon.png"))
            addObject(effect, getWidth() / 2 + 30, getHeight() / 2 + 50);
        }
    }
    
    private void startRandomChoice(int questionNumber) {
        int stage = this.mainWorld.getStage();
        String question = Constants.randomChoiceQuestions[stage][questionNumber];
        String[] answers = Constants.randomChoiceAnswers[stage][questionNumber];
        int[][] results = Constants.randomChoiceResults[stage][questionNumber];
        
        GreenfootImage image = new GreenfootImage("randomChoiceBG.png");
        image.drawImage(new GreenfootImage("randomChoicesQuestion.png"), 0, 0);
        image.drawImage(new GreenfootImage(question, 50, Color.GRAY, new Color(0, 0, 0, 0)), 130, 130);
        
        setBackground(image);
        
        for (int i = 0; i < answers.length; i++) {
            addObject(new RandomChoice(answers[i], results[i]), 500, 300 + i * 100);
        }
        
        this.inRandomChoice = true;
    }
    
    public void finishRandomChoice(int[] results) {
        updatePoints(results);
        removeObjects(getObjects(RandomChoice.class));
        setBackground(this.background);
        this.inRandomChoice = false;
    }
    
    private void updatePoints(int[] points) {
        for (int i = 0; i < points.length; i++) {
            pointsSum[i] += points[i];
        }
    }
    
    private Queue<Activity> toActivityQueue(ScheduleItem[][] scheduleTable) {
        Queue<Activity> queue = new LinkedList<Activity>();
        
        for (int i = 0; i < scheduleTable.length; i++) {
            for (int j = 0; j < scheduleTable[i].length; j++) {
                Activity activity = scheduleTable[i][j].getActivity();
                if (activity != null) {
                    queue.add(activity);
                }
            }
        }

        return queue;
    }

    private void finishWorld() {
        this.mainWorld.addPoint("IQ", pointsSum[0]);
        this.mainWorld.addPoint("EQ", pointsSum[1]);
        this.mainWorld.addPoint("Memory", pointsSum[2]);
        this.mainWorld.addPoint("Creativity", pointsSum[3]);
        this.mainWorld.nextStage();
        Greenfoot.setWorld(this.mainWorld);
    }
}
