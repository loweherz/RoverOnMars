package it.mancin.marsrover;

public class Rover {

	private Coordinates coordinates;
    
	public Rover(Coordinates coordinatesValue) {
        setCoordinates(coordinatesValue);
    }
	
    public void receiveCommands(String commands) throws Exception {
        for (char command : commands.toCharArray()) {
            receiveSingleCommand(command);
        }
    }

    public void receiveSingleCommand(char command) throws Exception {
        switch(Character.toUpperCase(command)) {
            case 'M':
                getCoordinates().moveForward();
                break;
            case 'L':
                getCoordinates().changeDirectionLeft();
                break;
            case 'R':
                getCoordinates().changeDirectionRight();
                break;
            default:
                throw new Exception("Command " + command + " is unknown.");
        }
    }

    public String getPosition() {
        return getCoordinates().toString();
    }


    /*
     * Getter/Setter
     * */
    public void setCoordinates(Coordinates value) {
        this.coordinates = value;
    }
    public Coordinates getCoordinates() {
        return this.coordinates;
    }

}