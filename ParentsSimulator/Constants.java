import greenfoot.GreenfootSound;

/**
 * This class is a place to store the static or final object and variables, which 
 * can make sure the switch between worlds can be smooth and to protect some values.
 * 
 * backgroundMusic
 * Music by <a href="https://pixabay.com/users/23117649-23117649/?utm_source=link-attributi
 * on&amp;utm_medium=referral&amp;utm_campaign=music&amp;utm_content=7741">23117649</a> from
 * <a href="https://pixabay.com//?utm_source=link-attribution&amp;utm_medium=referral&amp;utm_c
 * ampaign=music&amp;utm_content=7741">Pixabay</a>
 * 
 * @author Yixin Cai
 * @version 2023-01-23
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
    
    
    // I know the most recommended format is wav, but its size is too big about 38MB.
    // Therfore, I use mp3 format to reduce the size to 6 MB.
    public static final GreenfootSound backgroundSound = new GreenfootSound("main.mp3");
    public static final GreenfootSound pixelSound = new GreenfootSound("pixel.mp3");
    public static final GreenfootSound chessSound = new GreenfootSound("chess.mp3");
    public static final GreenfootSound memorySound = new GreenfootSound("memory.mp3");
    public static final GreenfootSound successSound = new GreenfootSound("success.wav");
    public static final GreenfootSound failSound = new GreenfootSound("fail.wav");
}
