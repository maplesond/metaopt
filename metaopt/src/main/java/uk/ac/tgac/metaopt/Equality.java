package uk.ac.tgac.metaopt;

/**
 * Created with IntelliJ IDEA.
 * User: maplesod
 * Date: 26/12/13
 * Time: 19:08
 * To change this template use File | Settings | File Templates.
 */
public class Equality {

    public static final double DEFAULT_TOLERANCE = 0.001;

    public static boolean approxEquals(double actual, double expected) {
        return approxEquals(actual, expected, DEFAULT_TOLERANCE);
    }

    public static boolean approxEquals(double actual, double expected, double tolerance) {
        double val = Math.abs(actual - expected);
        return val < tolerance;
    }

    public static boolean approxEquals(double[] actual, double[] expected) {
        return approxEquals(actual, expected, DEFAULT_TOLERANCE);
    }

    public static boolean approxEquals(double[] actual, double[] expected, double tolerance) {

        if (actual == null || expected == null || actual.length != expected.length)
            return false;

        for(int i = 0; i < actual.length; i++) {
            if (!approxEquals(actual[i], expected[i], tolerance))
                return false;
        }

        return true;
    }
}
