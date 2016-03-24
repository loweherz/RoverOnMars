package it.mancin.marsrover;


public class Coordinates {

    private Point x, y;
    private Direction direction;

    public Coordinates(Point xValue,Point yValue,Direction directionValue) {
        setX(xValue);
        setY(yValue);
        setDirection(directionValue);
    }

    /**
     * Method that permit to move rover
     * @input directionValue set direction
     * */
    public void move(Direction directionValue) {
        int xLocation = this.x.getLocation();
        int yLocation = this.y.getLocation();
        switch (directionValue) {
            case N:
                yLocation = this.y.getForwardLocation();
                break;
            case E:
                xLocation = this.x.getForwardLocation();
                break;
            case S:
                yLocation = this.y.getBackwardLocation();
                break;
            case O:
                xLocation = this.x.getBackwardLocation();
                break;
			default:
				break;
        }
            
	   	this.x.setLocation(xLocation);
        this.y.setLocation(yLocation);
    }


    public void moveForward() {
        move(this.direction);
    }

    public void moveBackward() {
        move(this.direction.getBackwardDirection());
    }

    private void changeDirection(Direction directionValue, int directionStep) {
        int directions = Direction.values().length;
        int index = (directions + directionValue.getValue() + directionStep) % directions;
        this.direction = Direction.values()[index];
    }

    public void changeDirectionLeft() {
        changeDirection(this.direction, -1);
    }

    public void changeDirectionRight() {
        changeDirection(this.direction, 1);
    }

    @Override
    public String toString() {
        String status = "";
        return getX().getLocation() + " " + getY().getLocation() + " " + getDirection().getShortName() + status;
    }
    
    
    /*
     * Getter/Setter
     * */
    public void setX(Point value) { 
    	this.x = value; 
    }
    public Point getX() { 
    	return this.x; 
    }

    public void setY(Point value) { 
    	this.y = value; 
    }
    public Point getY() { 
    	return this.y; 
    }

    public void setDirection(Direction value) {
        this.direction = value;
    }
    public Direction getDirection() {
        return this.direction;
    }



}
