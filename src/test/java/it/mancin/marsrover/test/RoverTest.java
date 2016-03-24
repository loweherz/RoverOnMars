package it.mancin.marsrover.test;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

import it.mancin.marsrover.*;

/*
 * Rover
 * */
public class RoverTest {

    private Rover rover;
    private Coordinates roverCoordinates;
    private final Direction direction = Direction.N;
    private Point x;
    private Point y;
   
    @Before
    public void beforeRoverTest() {
        this.x = new Point(1, 5);
        this.y = new Point(2, 5);
        this.roverCoordinates = new Coordinates(this.x, this.y, this.direction);
        this.rover = new Rover(this.roverCoordinates);
    }

    @Test
    public void setCoordinatesAndDirection() {
        assertThat(this.rover.getCoordinates()).isEqualToComparingFieldByField(this.roverCoordinates);
    }

    @Test
    public void moveForwardWhenCommandIsM() throws Exception {
        int expected = this.y.getLocation() + 1;
        this.rover.receiveSingleCommand('M');
        assertThat(this.rover.getCoordinates().getY().getLocation()).isEqualTo(expected);
    }

    @Test
    public void turnLeftWhenCommandIsL() throws Exception {
        this.rover.receiveSingleCommand('L');
        assertThat(this.rover.getCoordinates().getDirection()).isEqualTo(Direction.O);
    }

    @Test
    public void turnRightWhenCommandIsR() throws Exception {
        this.rover.receiveSingleCommand('R');
        assertThat(this.rover.getCoordinates().getDirection()).isEqualTo(Direction.E);
    }

    @Test(expected = Exception.class)
    public void throwExceptionWhenCommandIsUnknown() throws Exception {
        this.rover.receiveSingleCommand('X');
    }

    @Test
    public void receiveMultipleCommands() throws Exception {
        int expected = this.x.getLocation() + 1;
        this.rover.receiveCommands("RM");
        assertThat(this.rover.getCoordinates().getX().getLocation()).isEqualTo(expected);
        assertThat(this.rover.getCoordinates().getDirection()).isEqualTo(Direction.E);
    }

    @Test
    public void stopOneEdge() throws Exception {
        int expected = this.x.getMaxLocation();
        this.rover.receiveCommands("RMMMMMM");
        assertThat(this.rover.getCoordinates().getX().getLocation()).isEqualTo(expected);
    }

   
    @Test
    public void returnXYAndDirectionOnSpecificCommand() throws Exception {
        this.rover.receiveCommands("MMRMM");
        assertThat(this.rover.getPosition()).isEqualTo("3 4 E");
    }

}
