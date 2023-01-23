/**
 * Write a description of class Constants here.
 * 
 * @author Yixin Cai
 * @version 2023-01-21
 */
public class Constants  
{
    public static String[][] activityNames = {
        { "Alphabet", "Speak", "Walk" },
        { "Art", "Math", "Music", "PE", "Science" },
        { "AdvFunc", "Band", "CS", "English", "Business" }
    };
    
    public static int[][][] activityPoints = {
        { {1,0,1,0}, {0,2,0,0}, {1,0,0,1} },
        { {0,0,1,2}, {3,0,0,0}, {0,2,0,1}, {0,2,0,1}, {1,0,2,0} },
        { {4,0,0,0}, {0,0,2,2}, {1,0,1,2}, {0,2,2,0}, {0,3,0,1} }
    };
    
    /**
    public static final GreenfootImage[][] effectImages = {
        {
            new GreenfootImage("activityAlphabet.png"),
            new GreenfootImage("activitySpeak.png"),
            new GreenfootImage("activityWalk.png")
        },
        {
            new GreenfootImage("activityAlphabet.png"),
            new GreenfootImage("activitySpeak.png"),
            new GreenfootImage("activityWalk.png"),
            new GreenfootImage("activitySpeak.png"),
            new GreenfootImage("activityWalk.png")
        },
        {
            new GreenfootImage("activityAlphabet.png"),
            new GreenfootImage("activitySpeak.png"),
            new GreenfootImage("activityWalk.png"),
            new GreenfootImage("activitySpeak.png"),
            new GreenfootImage("activityWalk.png")
        }
    };
    */
    
    public static String[][] randomChoiceQuestions = {
        { "Stage 0 - Question 1", "Stage 0 - Question 2"},
        { "Stage 1 - Question 1", "Stage 1 - Question 2"},
        { "Stage 2 - Question 1", "Stage 2 - Question 2"}
    };
    
    public static String[][][] randomChoiceAnswers = {
        {
            { "Stage 0 - Question 1 - Answers 1", "Stage 0 - Question 1 - Answers 2", "Stage 0 - Question 1 - Answers 3"},
            { "Stage 0 - Question 2 - Answers 1", "Stage 0 - Question 2 - Answers 2", "Stage 0 - Question 2 - Answers 3"}
        },
        {
            { "Stage 1 - Question 1 - Answers 1", "Stage 1 - Question 1 - Answers 2", "Stage 1 - Question 1 - Answers 3"},
            { "Stage 1 - Question 2 - Answers 1", "Stage 1 - Question 2 - Answers 2", "Stage 1 - Question 2 - Answers 3"}
        },
        {
            { "Stage 2 - Question 1 - Answers 1", "Stage 2 - Question 1 - Answers 2", "Stage 2 - Question 1 - Answers 3"},
            { "Stage 2 - Question 2 - Answers 1", "Stage 2 - Question 2 - Answers 2", "Stage 2 - Question 2 - Answers 3"}
        }
    };
    
    public static int[][][][] randomChoiceResults = {
        { { {1,0,1,0}, {0,1,0,1}, {-1,0,-1,0} }, { {0,1,0,1}, {1,0,1,0}, {0,-1,0,-1} } },
        { { {2,0,2,0}, {0,2,0,2}, {-2,0,-2,0} }, { {0,2,0,2}, {2,0,2,0}, {0,-2,0,-2} } },
        { { {3,0,3,0}, {0,3,0,3}, {-3,0,-3,0} }, { {0,3,0,3}, {3,0,3,0}, {0,-3,0,-3} } },
    };

}
