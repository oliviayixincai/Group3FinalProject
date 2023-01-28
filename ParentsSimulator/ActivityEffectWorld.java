import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Queue;
import java.util.LinkedList;

/**
 * It is a world to show the activities with fade effects.The activities will show on the screen follows the order that how player
 * dragged. The first dragged activity will show the first, the last dragged activity will show at the very end.
 * 
 * @author Yixin Cai
 * @version 2023-01-21
 */
public class ActivityEffectWorld extends AbstractWorld {
    // declare the variables and objects
    private Queue<Activity> activityQueue;
    private FadeEffect effect;
    private int[] pointsSum;
    private int randomChoiceIndex;
    private boolean inRandomChoice;
    private GreenfootImage background;

    /**
     * Constructor for objects of class ActivityWorld.
     * @param mainWorld It is a MainWorld
     * @param scheduleTable It is a ScheduleItem[][] used to store the activities.
     */
    public ActivityEffectWorld(MainWorld mainWorld, ScheduleItem[][] scheduleTable) {
        super(mainWorld);
        // initialize the variables and objects
        // Use the feature of Queue, which is "first in, first out"
        this.activityQueue = toActivityQueue(scheduleTable);
        this.pointsSum = new int[] {0,0,0,0};
        this.randomChoiceIndex = 0;
        
        background = new GreenfootImage("activityBG.png");
        setBackground(background);
    }
    
    /**
     * Act - do whatever the ActivityEffectWorld wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        // do nothing here if it is in random choice section
        if (this.inRandomChoice) {
            return;
        }

        // this condition can make sure the previous activity is done
        if (effect == null || effect.getWorld() == null) {
            int size = activityQueue.size();
            // this is to determine weather it should move on the the random choice section
            if (this.randomChoiceIndex < 2 && this.randomChoiceIndex * 4 == 8 - size) {
                startRandomChoice(this.randomChoiceIndex);
                this.randomChoiceIndex++;
            }
            else {
                playNextEffect();
            }
        }
    }
    
    /**
     * This is a method used to play the next activity effect
     */
    private void playNextEffect() {
        // first in, first out
        Activity activity = activityQueue.poll();
        if (activity == null) {
            finishWorld();
        }
        else {
            updatePoints(activity.getPoints());
            GreenfootImage activityEnlarged = new GreenfootImage("activity" + activity.getName() + "Icon.png");
            activityEnlarged.scale(420,360);
            effect = new FadeEffect(new GreenfootImage(activityEnlarged));
            addObject(effect, getWidth() / 2 + 30, getHeight() / 2 + 50);
        }
    }
    
    /**
     * This is a method used to start the random choice section.
     * @param questionNumber this is a int to indicate the index
     * of questions, answers and the results.
     */
    private void startRandomChoice(int questionNumber) {
        int stage = this.mainWorld.getStage();
        // the index used here to make sure the question, answers and result are matched.
        String question = Constants.randomChoiceQuestions[stage][questionNumber];
        String[] answers = Constants.randomChoiceAnswers[stage][questionNumber];
        int[][] results = Constants.randomChoiceResults[stage][questionNumber];
        
        GreenfootImage image = new GreenfootImage(1000, 700);
        image.setColor(new Color(253,234,232,254));
        image.fill();
        image.drawImage(new GreenfootImage("randomChoicesQuestion.png"), 0, 0);
        image.drawImage(new GreenfootImage(question, 30, Color.GRAY, new Color(0, 0, 0, 0)), 130, 130);
        setBackground(image);
        
        for (int i = 0; i < answers.length; i++) {
            addObject(new RandomChoice(answers[i], results[i]), 500, 300 + i * 100);
        }
        
        this.inRandomChoice = true;
    }
    
    /**
     * This is a method to end the randome choice section.
     * It can update the points, which is the results of the questions
     * , remove it self after and set background.
     * @param results It is an int[] used to store the points that need to be updated
     */
    public void finishRandomChoice(int[] results) {
        updatePoints(results);
        removeObjects(getObjects(RandomChoice.class));
        setBackground(this.background);
        this.inRandomChoice = false;
    }
    
    /**
     *  This is a method to update the points based on the result.
     *  @param points It is an int[] to store the points need to be updated
     */
    private void updatePoints(int[] points) {
        for (int i = 0; i < points.length; i++) {
            pointsSum[i] += points[i];
        }
    }
    
    /**
     * This is a method to store all of the activities that 
     * player choose into a Queue and return the Queue.
     * @param scheduleTable This is a ScheduleItem[][] that stores al of the activities
     * @return Queue<Activity> the Queue stored all the activities.
     */
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

    /**
     * This is a method to add the calculated points and go back to the main World
     */
    private void finishWorld() {
        this.mainWorld.addPoint("IQ", pointsSum[0]);
        this.mainWorld.addPoint("EQ", pointsSum[1]);
        this.mainWorld.addPoint("Memory", pointsSum[2]);
        this.mainWorld.addPoint("Creativity", pointsSum[3]);
        this.mainWorld.nextStage();
        Greenfoot.setWorld(this.mainWorld);
    }
}
