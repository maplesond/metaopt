package uk.ac.earlham.metaopt.external;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggingEvent;
import org.junit.Before;
import org.junit.Test;
import uk.ac.earlham.metaopt.*;
import uk.ac.earlham.metaopt.test.Problems;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeTrue;

/**
 * Created with IntelliJ IDEA.
 * User: maplesod
 * Date: 23/10/13
 * Time: 16:31
 * To change this template use File | Settings | File Templates.
 */
public class JOptimizerTest {

    private Optimiser jOptimizer = null;

    private static class TestAppender extends AppenderSkeleton{

        final List<LoggingEvent> log = new ArrayList<>();

        @Override
        protected void append(LoggingEvent loggingEvent) {
            log.add(loggingEvent);
        }

        @Override
        public boolean requiresLayout() {
            return false;
        }

        @Override
        public void close() {

        }

        public List<LoggingEvent> getLog() {
            return new ArrayList<>(log);
        }
    }

    @Before
    public void setup() {

        Logger.getRootLogger().addAppender(new TestAppender());
        boolean success = true;
        try {
            jOptimizer = new JOptimizer();
        }
        catch (OptimiserException oe) {
            success = false;
            System.err.println("JOptimizer not configured for you system... skipping JOptimizer tests");
        }

        assumeTrue(success);
    }

    @Test
    public void testAcceptsIdentifier() throws OptimiserException {

        assumeTrue(jOptimizer != null);

        assertTrue(jOptimizer.acceptsIdentifier("joptimizer"));
        assertTrue(jOptimizer.acceptsIdentifier("Joptimizer"));
        assertTrue(jOptimizer.acceptsIdentifier("JOPTIMIZER"));
        assertTrue(jOptimizer.acceptsIdentifier("JOptimizer"));
    }


    @Test(expected=OptimiserException.class)
    public void testEmptyProblem() throws OptimiserException {

        assumeTrue(jOptimizer != null);

        Problem problem = Problems.empty();

        Solution solution = new JOptimizer().optimise(problem);

        assertTrue(solution.getSolution() == 0.0);
        assertTrue(solution.getVariableValues().length == 0);
    }


    /**
     * This example formulates and solves a simple linear problem
     *
     * @throws OptimiserException
     */
    @Test
    public void testSimpleLinear() throws OptimiserException {

        assumeTrue(jOptimizer != null);

        // Create the Problem
        Problem problem = Problems.simpleLinear();

        // Solve
        Solution solution = jOptimizer.optimise(problem);

        // Check result
        double[] vals = solution.getVariableValues();
        assertTrue(Equality.approxEquals(vals[0], 1.5));
        assertTrue(Equality.approxEquals(vals[1], 0.0));
    }


    /**
     * This example formulates and solves a simple quadratic problem
     *
     * @throws OptimiserException
     */
    @Test
    public void testSimpleQuadratic() throws OptimiserException {

        assumeTrue(jOptimizer != null);

        // Create the Problem
        Problem problem = Problems.simpleQuadratic();

        // Solve
        Solution solution = new JOptimizer().optimise(problem);

        // Check result
        double[] vals = solution.getVariableValues();
        assertTrue(Equality.approxEquals(vals[0], 0.5));
        assertTrue(Equality.approxEquals(vals[1], 0.5));
    }


    /**
     * This example formulates and solves a simple quadratic problem
     *
     * @throws OptimiserException
     */
    @Test
    public void testSimpleQuadratic2() throws OptimiserException {

        assumeTrue(jOptimizer != null);

        // Create the Problem
        Problem problem = Problems.simpleQuadratic2();

        // Solve
        Solution solution = new JOptimizer().optimise(problem);

        // Check result
        double[] vals = solution.getVariableValues();
        assertTrue(Equality.approxEquals(vals[0], 0.0));
        assertTrue(Equality.approxEquals(vals[1], 1.0));
        assertTrue(Equality.approxEquals(vals[2], 2.0/3.0));
    }
}
