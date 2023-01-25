import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Piece here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Piece
{
    private GreenfootImage pic;
    private Chessboard w;
    private Piece[][] c;
    private boolean blocked;
    private int ss, xOff, yOff;
    private int dY, dX;
    private Wall wall;
    private int count;
    private int half;
    
    public Player() {
        /*
        pic = new GreenfootImage(50, 50);
        pic.setColor(Color.BLUE);
        pic.fillRect(0, 0, 75, 75);
        */
        pic = new GreenfootImage("wKing.png");
        setImage(pic);
    }
    
    public void addedToWorld(World w){
        this.w = (Chessboard)w;
        getValues();
    }
    
    public void getValues() {
        ss = w.getSquareSize();
        xOff = w.getxOffset();
        yOff = w.getyOffset();
    }

    public void act()
    {
        checkDir();
        if(canMove()) {
            move();
        }
    }
    
    public void checkDir() {
        int speed = 1;
        if(Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("w")) {
            dY = -speed;
        }
        if(Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("s")) {
            dY = speed;
        }
        if(Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a")) {
            dX = -speed;
        }
        if(Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d")) {
            dX = speed;
        }
    }
    
    public boolean canMove() {
        int x = getX();
        int y = getY();
        /*
        half = pic.getWidth()/4;
        if(x < xOff-20) {
            x += half;
            dX = 0;
            dY = 0;
        }
        if(x >= 7*ss+xOff+20) {
            x -= half;
            dX = 0;
            dY = 0;
        }
        if(y < yOff-20) {
            y += half;
            dX = 0;
            dY = 0;
        }
        if(y >= 7*ss+yOff+20) {
            y -= half;
            dX = 0;
            dY = 0;
        }
        setLocation(x,y);
        */
        if(x < xOff-20 || x >= 7*ss+xOff+20 || y < yOff-20 || y >= 7*ss+yOff+20) {
            //System.out.println("Blocked by edge");
            //return false;
            w.removeObject(this);
            dX = 0;
            dY = 0;
            w.respawn();
        }
        return true;
    }
    
    public void move() {
        half = pic.getWidth()/2;
        
        // move right
        if(dX > 0) {
            wall = (Wall)getOneObjectAtOffset((half+dX)+1, -half+1, Wall.class);
            if(wall == null) {
                wall = (Wall)getOneObjectAtOffset((half+dX)+1, half-1, Wall.class);
                //System.out.println("got wall");
            }
            if(wall != null) {
                setLocation(getX() -(half + 0), getY());
                dX = 0;
            }
        }
        
        // move left
        if(dX < 0) {
            wall = (Wall)getOneObjectAtOffset((-half+dX)-1, -half+1, Wall.class);
            if(wall == null) {
                wall = (Wall)getOneObjectAtOffset((-half+dX)-1, half-1, Wall.class);
            }
            if(wall != null) {
                setLocation(getX() +(half + 0), getY());
                dX = 0;
            }
        }
        
        // apply h move
        setLocation(getX() + dX, getY());
        
        // move down
        if(dY > 0) {
            wall = (Wall)getOneObjectAtOffset(half-1, (half+dY)-1, Wall.class);
            if(wall == null) {
                wall = (Wall)getOneObjectAtOffset(-half+1, (half+dY)-1, Wall.class);
            }
            if(wall != null) {
                setLocation(getX(), getY() -(half + 0));
                dY = 0;
            }
        }
        
        // move up
        if(dY < 0) {
            wall = (Wall)getOneObjectAtOffset(half-1, (-half+dY)+1, Wall.class);
            if(wall == null) {
                wall = (Wall)getOneObjectAtOffset(half-1, (-half+dY)+1, Wall.class);
            }
            if(wall != null) {
                setLocation(getX(), getY() +(half + 0));
                dY = 0;
            }
        }
        
        // apply v move
        setLocation(getX(), getY() + dY);
    }
}