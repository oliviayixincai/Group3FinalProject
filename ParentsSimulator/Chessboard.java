import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Write a description of class Chessboard here.
 * 
 * @Fiona Ho 
 * @version (a version number or a date)
 */
public class Chessboard extends World {
    private GreenfootImage backboard, statsboard;
    private int squareSize, xOffset, yOffset;
    private Square s;
    private Piece[][] chess;
    private Player player;
    private ArrayList<GreenfootImage> images;
    private ArrayList<Piece> pieces;
    private int points;
    private Timer timer;
    private Score score;
    private MainWorld main;
    
    public Chessboard(MainWorld mainWorld) {
        super(1000, 700, 1);
        //GreenfootImage bg = new GreenfootImage(getWidth(), getHeight());
        //bg.setColor(new Color(130, 89, 17));
        //bg.fillRect(0, 0, getWidth(), getHeight());
        setBackground("wood.png");
        // bg from https://www.vecteezy.com/free-vector/cartoon-wood (edited)
        
        main = mainWorld;
        squareSize = 75;
        
        xOffset = 375;
        yOffset = 90;
        player = new Player();
        
        setBoard();
        respawn();
        
        backboard = new GreenfootImage("board.png");
        getBackground().drawImage(backboard, 312, 27);
        statsboard = new GreenfootImage("stats.png");
        getBackground().drawImage(statsboard, 40, 225);
        timer = new Timer(60);
        score = new Score(0);
        addObject(timer, 171, 290);
        addObject(score, 171, 400);
        
        startTimer();
        points = 24;
    }
    
    public void act() {
        points = checkPoints();
        score.setDisplayer(points);
        if(60-getTimeInSeconds()>0){
            endTimer();
            timer.setDisplayer(60-getTimeInSeconds());
        }
        if(getTimeInSeconds()>=60) {
            Greenfoot.setWorld(new WinScreen(points, getTimeInSeconds(), false, main));
        }
    }
    
    public int checkPoints() {
        return (60 - getTimeInSeconds()) /5 *2 + 2;
    }
    
    public void setBoard() {
        Square[][] board = new Square[8][8];
        for(int row = 0; row < 8; row++) {
            for(int col = 0; col < 8; col++) {
                if((row+col) % 2 == 0) {
                    s = new Square("W");
                } else {
                    s = new Square("B");
                }
                board[row][col] = s;
            }
        }
        for(int row = 0; row < 8; row++) {
            for(int col = 0; col < 8; col++) {
                addObject(board[row][col], col*squareSize+xOffset, row*squareSize+yOffset);
            }
        }
        
        chess = new Piece[8][8];
        images = new ArrayList<GreenfootImage>();
        pieces = new ArrayList<Piece>();
        addImages();
        for(int row = 0; row < 8; row++) {
            for(int col = 0; col < 8; col++) {
                chess[row][col] = new Piece();
            }
        }
        Random random = new Random();
        int rand = random.nextInt(4);
        if(rand == 0) {
            buildMaze1();
        } else if (rand == 1) {
            buildMaze2();
        } else if (rand == 2) {
            buildMaze3();
        } else if (rand == 3) {
            buildMaze4();
        }
        for(int row = 0; row < 8; row++) {
            for(int col = 0; col < 8; col++) {
                addObject(chess[row][col], col*squareSize+xOffset, row*squareSize+yOffset);
            }
        }
        Collections.shuffle(images);
        for (int i = 0; i < pieces.size(); i++) {
            pieces.get(i).setImage(images.get(i % images.size()));
        }
    }
    
    public void respawn() {
        addObject(player, xOffset, yOffset);
    }
    
    public void buildMaze1() {
        chess[7][7] = new Exit(main);
        for(int i = 0; i < 3; i++) {
            chess[2][i+3] = new Wall();
            addPieces(2,i+3);
            chess[4][i+3] = new Wall();
            addPieces(4,i+3);
        }
        for(int i = 0; i < 7; i++) {
            chess[6][i+1] = new Wall();
            addPieces(6,i+1);
        }
        for(int i = 0; i < 2; i++) {
            chess[1][i] = new Wall();
            addPieces(1,i);
            chess[i+1][2] = new Wall();
            addPieces(i+1,2);
            chess[i+4][1] = new Wall();
            addPieces(i+4,1);
        }
        chess[0][4] = new Wall();
        addPieces(0,4);
        for(int i = 0; i < 4; i++) {
            chess[i+1][6] = new Wall();
            addPieces(i+1,6);
        }
    }
    
    public void buildMaze2() {
        chess[7][4] = new Exit(main);
        for(int i = 0; i < 3; i++) {
            chess[6][i+4] = new Wall();
            addPieces(6,i+4);
        }
        for(int i = 0; i < 2; i++) {
            chess[i+6][3] = new Wall();
            addPieces(i+6,3);
            chess[i+5][1] = new Wall();
            addPieces(i+5,1);
        }
        for(int i = 0; i < 7; i++) {
            chess[4][i+1] = new Wall();
            addPieces(4,i+1);
            chess[2][i] = new Wall();
            addPieces(2,i);
        }
        chess[1][6] = new Wall();
        addPieces(1,6);
        for(int i = 0; i < 4; i++) {
            chess[0][i+1] = new Wall();
            addPieces(0,i+1);
        }
    }
    
    public void buildMaze3() {
        chess[7][0] = new Exit(main);
        for(int i = 0; i < 6; i++) {
            chess[i+1][0] = new Wall();
            addPieces(i+1,0);
            chess[6][i+1] = new Wall();
            addPieces(6,i+1);
            chess[1][i+1] = new Wall();
            addPieces(1,i+1);
            chess[3][i+2] = new Wall();
            addPieces(3,i+2);
        }
        for(int i = 0; i < 5; i++) {
            chess[3][i+3] = new Wall();
            addPieces(3,i+3);
        }
        chess[4][2] = new Wall();
        addPieces(4,2);
        chess[4][6] = new Wall();
        addPieces(4,6);
        chess[5][4] = new Wall();
        addPieces(5,4);
    }
    
    public void buildMaze4() {
        chess[4][7] = new Exit(main);
        for(int i = 0; i < 8; i++) {
            chess[i][1] = new Wall();
            addPieces(i,1);
            chess[i][3] = new Wall();
            addPieces(i,3);
        }
        for(int i = 0; i < 3; i++) {
            chess[1][i+4] = new Wall();
            addPieces(1,i+4);
            chess[3][i+5] = new Wall();
            addPieces(3,i+5);
            chess[i+4][5] = new Wall();
            addPieces(i+4,5);
            chess[i+5][7] = new Wall();
            addPieces(i+5,7);
        }
        chess[6][1] = new Piece();
        chess[0][3] = new Piece();
    }
    
    public void addPieces(int row, int col) {
        pieces.add(chess[row][col]);
    }
    
    public void addImages() {
        // images from https://commons.wikimedia.org/wiki/Category:SVG_chess_pieces
        images.add(new GreenfootImage("wQueen.png"));
        //images.add(new GreenfootImage("wKing.png"));
        images.add(new GreenfootImage("wBishop.png"));
        images.add(new GreenfootImage("wKnight.png"));
        images.add(new GreenfootImage("wRook.png"));
        for(int i = 0; i < 4; i++) {
            images.add(new GreenfootImage("wPawn.png"));
            images.add(new GreenfootImage("bPawn.png"));
        }
        images.add(new GreenfootImage("bQueen.png"));
        //images.add(new GreenfootImage("bKing.png"));
        images.add(new GreenfootImage("bBishop.png"));
        images.add(new GreenfootImage("bKnight.png"));
        images.add(new GreenfootImage("bRook.png"));
    }
    
    public int getSquareSize() {
        return squareSize;
    }
    
    public int getxOffset() {
        return xOffset;
    }
    
    public int getyOffset() {
        return yOffset;
    }

    public int getPoints() {
        return points;
    }
    
    // mr cohen's timer class
    /**
     * A very simply Timer class that functions as a virtual stopwatch.
     * 
     * This can be used as a semi-accurate method of measuring the elapsed time
     * while some code is running. It can be used as a timer in a game, or to
     * track the efficiency of some procedure. Methods for stop, start and reset
     * allow easy control of Timer objects. Methods are included that return 
     * seconds (as an int), milliseconds (as a float) or a formatted String.
     * 
     * @author Jordan Cohen
     * @version v1.0.2
     */
    private long startTime;
    private long endTime;

    /**
     * Start the Timer
     */
    public void startTimer()
    {
        startTime = System.nanoTime();
    }

    /**
     * Stop the Timer
     */
    public void endTimer ()
    {
        endTime = System.nanoTime();
    }

    /**
     * Reset the Timer
     */
    public void resetTimer ()
    {
        startTime = 0;
        endTime = 0;
    }

    /**
     * Returns elapsed time as a neatly formatted String. Most practical for
     * applications where output (rather than calculation) is the goal. The
     * exact format will depend on the time elapsed - either ms, sec, or min:sec.
     * 
     * @return String   neatly formatted display of time elapsed
     */
    public String getTimeString ()
    {
        if ((endTime - startTime) < 1000000)
        {
            return (endTime - startTime) + "ns";
        }
        // Less than 1 second
        if ((endTime - startTime)/1000000000 < 1)
        {
            return getTimeInMilliseconds() + " ms";
        }
        else if ((endTime - startTime)/1000000000 < 60)
        {
            return getTimeInPreciseSeconds() + " sec";
        }
        
        int minutes = getTimeInSeconds() / 60;
        float seconds = getTimeInPreciseSeconds() - ((float)minutes * 60);
        return minutes + " min " + seconds + " sec";
    }
    
    /**
     * Return the elapsed time in seconds. This assumes that the timer has already
     * been started and stopped (but not reset). For very short durations, this will
     * return zero even though some time has elapsed.
     * 
     * @return int  The number of seconds elapsed, as an int.
     */
    public int getTimeInSeconds ()
    {
        return (int)((double)(endTime - startTime) / 1000000000.0);
    }
    
    /**
     * Return the elapsed time in seconds. This assumes that the timer has already
     * been started and stopped (but not reset). For very short durations, this will
     * return zero even though some time has elapsed.
     * 
     * @return float  The number of seconds elapsed, as an int.
     */
    public float getTimeInPreciseSeconds ()
    {
        return (float)((double)(endTime - startTime) / 1000000000.0);
    }

    /**
     * Return the elapsed time in seconds. This assumes that the timer has already
     * been started and stopped (but not reset). This will return the value as a 
     * float and is most useful for shorter durations where second is not accurate
     * enough.
     * 
     * @return float  The number of milliseconds elapsed, as a float.
     */
    public float getTimeInMilliseconds ()
    {
        return (float)((double)(endTime - startTime) / 1000000.0);
    }
    
    /**
     * This method is called by the Greenfoot system when the execution has started.
     * Play background sound in loop once the execution has started.
     */
    public void started() {
        Constants.chessSound.playLoop();
    }
    
    /**
     * This method is called by the Greenfoot system when the execution has stopped.
     * Pause background sound once the execution has stopped so that when it
     * started again, the sound will play coherently.
     */
    public void stopped() {
        Constants.chessSound.pause();
    }
}