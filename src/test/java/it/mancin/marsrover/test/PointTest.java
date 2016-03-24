package it.mancin.marsrover.test;

import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

import it.mancin.marsrover.*;

/*
Point is a two-dimensional point on the grid that indicate one of the 2 coordinate and maximum of that coordinate
Methods forward/backward increase/decrease location.
If maximum location is reached, stay still.
*/
public class PointTest {

    Point point;
    private final int location = 2;
    private final int maxLocation = 5;

    @Before
    public void beforePointTest() {
        this.point = new Point(this.location, this.maxLocation);
    }

    @Test
    public void setLocationAndMaxLocationParams() {
        assertThat(this.point.getLocation()).isEqualTo(this.location);
        assertThat(this.point.getMaxLocation()).isEqualTo(this.maxLocation);
    }

    @Test
    public void getForwardLocationShouldIncreasePointValueByOne() {
        int expected = this.point.getLocation() + 1;
        assertThat(this.point.getForwardLocation()).isEqualTo(expected);
    }

    @Test
    public void getBackwardLocationShouldDecreasePointValueByOne() {
        int expected = this.point.getLocation() - 1;
        assertThat(this.point.getBackwardLocation()).isEqualTo(expected);
    }

}