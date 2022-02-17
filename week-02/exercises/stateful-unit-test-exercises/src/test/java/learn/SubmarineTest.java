package learn;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubmarineTest {

    Submarine submarine = new Submarine(100.0);
    // 1. Create one or more tests to confirm `dive` is working properly.
    // 2. Create a test to assert the submarine can't go deeper than the max depth.
    // (Be sure to use more than one max depth.)
    // 3. Create one or more tests to confirm `surface` is working properly.
    // 4. Create a test to assert the submarine can't go above sea level.
    // (Depth can never be negative.)
    // 5. Create one or more tests to confirm `getPressureInAtmospheres` is working properly.

    @Test
    void shouldHaveCorrectDepthAfter3Dives() {
        submarine.dive();
        submarine.dive();
        submarine.dive();
        assertEquals(9.0, submarine.getDepthInMeters(), 0.001);
    }

    @Test
    void shouldHaveMaxDepth() {
        double[] maxDepths = { 0.0, 2.0, 10.0, 100.0};

        for ( double d : maxDepths ) {
            submarine = new Submarine(d);
            for (int i = 0; i < d / 3 + 3; i++) {
                submarine.dive();
            }
            assertEquals( d, submarine.getDepthInMeters(), 0.001, String.format("at depth %s%n", d));
        }
    }

    @Test
    void shouldHaveCorrectPressureAfter3Dives() {
        submarine.dive();
        submarine.dive();
        submarine.dive();
        assertEquals(1.9, submarine.getPressureInAtmospheres(), 0.001);
    }


    @Test
    void shouldHaveMaxPressure() {
        double[] maxDepths = { 0.0, 2.0, 10.0, 100.0};

        for ( double d : maxDepths ) {
            submarine = new Submarine(d);
            for (int i = 0; i < d / 3 + 3; i++) {
                submarine.dive();
            }
            assertEquals( 1 + d/10, submarine.getPressureInAtmospheres(), 0.001, String.format("at depth %s%n", d));
        }
    }

    @Test
    void shouldHaveCorrectDepthAfter2Surfaces() {
        submarine.dive();
        submarine.dive();
        submarine.dive();
        submarine.surface();
        assertEquals(4.0, submarine.getDepthInMeters(), 0.001);
    }

    @Test
    void shouldHaveMinDepth() {
        double[] maxDepths = { 0.0, 2.0, 10.0, 100.0};

        for ( double d : maxDepths ) {
            submarine = new Submarine(d);
            for (int i = 0; i < d / 3 + 3; i++) {
                submarine.dive();
                submarine.surface();
            }
            assertEquals( 0.0, submarine.getDepthInMeters(), 0.001, String.format("at depth %s%n", d));
        }
    }

    @Test
    void shouldHaveCorrectPressureAfter2Surfaces() {
        submarine.dive();
        submarine.dive();
        submarine.dive();
        submarine.surface();
        assertEquals(1.4, submarine.getPressureInAtmospheres(), 0.001);
    }

    @Test
    void shouldHaveMinPressure() {
        double[] maxDepths = { 0.0, 2.0, 10.0, 100.0};

        for ( double d : maxDepths ) {
            submarine = new Submarine(d);
            for (int i = 0; i < d / 3 + 3; i++) {
                submarine.dive();
                submarine.surface();
                submarine.surface();
            }
            assertEquals( 1, submarine.getPressureInAtmospheres(), 0.001, String.format("at depth %s%n", d));
        }
    }


}