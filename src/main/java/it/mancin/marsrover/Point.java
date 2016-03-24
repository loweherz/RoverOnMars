package it.mancin.marsrover;

public class Point {

    private int location;
    private int maxLocation = Integer.MAX_VALUE;
    
    public Point(int locationValue, int maxLocationValue) {
        setLocation(locationValue);
        setMaxLocation(maxLocationValue);
    }

    public int getForwardLocation() {
    	return getLocation()<getMaxLocation() ? getLocation()+1 : getLocation();
    }

    public int getBackwardLocation() {
    	return getLocation()>0 ? getLocation()-1 : getLocation();
	}
    
    
    /*
     * Getter/Setter
     * */
    public void setLocation(int value) { 
    	if(value<=getMaxLocation() && value>=0) //Check for to stop when set position outter the edge
    		this.location = value; 
    }
    public int getLocation() { 
    	return this.location; 
    }

    public void setMaxLocation(int value) { 
    	this.maxLocation = value; 
    }
    public int getMaxLocation() { 
    	return this.maxLocation; 
    }

}