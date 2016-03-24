package it.mancin.marsrover;

public enum Direction {

    N(0, 'N'),
    E(1, 'E'),
    S(2, 'S'),
    O(3, 'O');

    private int value;
    private char shortName;
   
    private Direction(int newValue, char shortNameValue) {
        this.value = newValue;
        this.shortName = shortNameValue;
    }

    public Direction getBackwardDirection() {
        return values()[(this.getValue() + 2) % 4];
    }

    public int getValue() {
        return this.value;
    }

    public char getShortName() { 
    	return this.shortName; 
    }
    
}