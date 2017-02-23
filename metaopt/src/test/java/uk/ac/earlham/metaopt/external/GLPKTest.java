package uk.ac.earlham.metaopt.external;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import uk.ac.earlham.metaopt.Problem;
import uk.ac.earlham.metaopt.Solution;
import uk.ac.earlham.metaopt.test.Problems;
import uk.ac.earlham.metaopt.Optimiser;
import uk.ac.earlham.metaopt.OptimiserException;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeTrue;

/**
 * Created with IntelliJ IDEA.
 * User: dan
 * Date: 22/09/13
 * Time: 21:31
 * To change this template use File | Settings | File Templates.
 */
public class GLPKTest {

    private Optimiser glpk = null;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();


    @Before
    public void setUpStreams() {

        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }


    @Before
    public void setup() {

        boolean success = true;
        try {
            glpk = new GLPK();
        }
        catch (OptimiserException oe) {
            success = false;
        }

        if (!glpk.isOperational()) {
            success = false;
        }

        if (!success) {
            //System.err.println("GLPK not configured for you system... skipping GLPK tests");
        }

        assumeTrue(success);
    }

    @Test
    public void testAcceptsIdentifier() throws OptimiserException {

        assumeTrue(glpk != null);

        assertTrue(glpk.acceptsIdentifier("glpk"));
        assertTrue(glpk.acceptsIdentifier("Glpk"));
        assertTrue(glpk.acceptsIdentifier("GLPK"));
        assertTrue(glpk.acceptsIdentifier("GLPK"));
    }



    @Test(expected=OptimiserException.class)
    public void testSimple() throws OptimiserException {

        assumeTrue(glpk != null);

        Problem problem = Problems.empty();

        Solution solution = glpk.optimise(problem);

        assertTrue(solution.getSolution() == 0.0);
        assertTrue(solution.getVariableValues().length == 0);
    }

    /**
     * This example formulates and solves the following empty MIP model:
     *  maximize    x +   y + 2 z
     *  subject to  x + 2 y + 3 z <= 4
     *  x + y       >= 1
     *  x, y, z binary
     * @throws OptimiserException
     */
    @Test
    public void testMip1() throws OptimiserException {

        assumeTrue(glpk != null);

        // Create the MIP1 Problem
        Problem problem = Problems.mixedIntegerLinear1();

        // Solve
        Solution solution = glpk.optimise(problem);

        // Check result
        double[] vals = solution.getVariableValues();

        /*assertTrue(vals[0] == 1.0);
        assertTrue(vals[1] == 0.0);
        assertTrue(vals[2] == 1.0);

        assertTrue(solution.getSolution() == 3.0)*/
    }

    /**
     * This example formulates and solves a simple linear problem
     *
     * @throws OptimiserException
     */
    @Test
    public void testSimpleLinear() throws OptimiserException {

        assumeTrue(glpk != null);

        // Create the simple linear Problem
        Problem problem = Problems.simpleLinear();

        // Solve
        Solution solution = glpk.optimise(problem);

        // Check result
        double[] vals = solution.getVariableValues();
        /*assertTrue(Equality.approxEquals(vals[0], 1.5));
        assertTrue(Equality.approxEquals(vals[1], 0.0));*/
    }
}
