package uk.ac.earlham.metaopt;

/**
 * Created with IntelliJ IDEA.
 * User: maplesod
 * Date: 26/12/13
 * Time: 19:08
 * To change this template use File | Settings | File Templates.
 */
public class Equality {

    public static boolean approxEquals(double actual, double expected) {
        return approxEquals(actual, expected, 0.001);
    }

    public static boolean approxEquals(double actual, double expected, double tolerance) {
        double val = Math.abs(actual - expected);
        return val < tolerance;
    }
}
