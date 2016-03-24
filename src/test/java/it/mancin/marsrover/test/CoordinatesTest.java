package it.mancin.marsrover.test;

import org.junit.Before;
import org.junit.Test;

import it.mancin.marsrover.*;

import static org.assertj.core.api.Assertions.*;

/*
 * Coordinate are set of two point and direction
 * */
public class CoordinatesTest {

    private Coordinates coordinates;
    private Point x;
    private Point y;
    private final Direction direction = Direction.N;

    @Before
    public void beforeCoordinatesTest() {
        this.x = new Point(4, 12);
        this.y = new Point(5, 12);
        this.coordinates = new Coordinates(this.x, this.y, this.direction);
    }

    @Test
    public void setXAndYParamsAndDirection() {
        assertThat(this.coordinates.getX()).isEqualToComparingFieldByField(this.x);
        assertThat(this.coordinates.getY()).isEqualToComparingFieldByField(this.y);
        
        assertThat(this.coordinates.getDirection()).isEqualTo(this.direction);
    }

    @Test
    public void moveForwardShouldIncreaseYWhenDirectionIsN() {
        Point expected = new Point(this.y.getLocation() + 1, this.y.getMaxLocation());
        this.coordinates.setDirection(Direction.N);
        this.coordinates.moveForward();
        assertThat(this.coordinates.getY()).isEqualToComparingFieldByField(expected);
    }

    @Test
    public void moveBackwardShouldIncreaseYWhenDirectionIsS() {
        Point expected = new Point(this.y.getLocation() + 1, this.y.getMaxLocation());
        this.coordinates.setDirection(Direction.S);
        this.coordinates.moveBackward();
        assertThat(this.coordinates.getY()).isEqualToComparingFieldByField(expected);
    }
    
    @Test
    public void moveForwardShouldDecreaseXWhenDirectionIsO() {
        Point expected = new Point(this.x.getLocation() - 1, this.x.getMaxLocation());
        this.coordinates.setDirection(Direction.O);
        this.coordinates.moveForward();
        assertThat(this.coordinates.getX()).isEqualToComparingFieldByField(expected);
    }

    @Test
    public void moveBackwardShouldDecreaseXWhenDirectionIsE() {
        Point expected = new Point(this.x.getLocation() - 1, this.x.getMaxLocation());
        this.coordinates.setDirection(Direction.E);
        this.coordinates.moveBackward();
        assertThat(this.coordinates.getX()).isEqualToComparingFieldByField(expected);
    }

    @Test
    public void toStringShouldReturnPosition() {
        String expected = this.x.getLocation() + " " + this.y.getLocation() + " " + this.direction.getShortName();
        assertThat(this.coordinates.toString()).isEqualTo(expected);
    }

}
