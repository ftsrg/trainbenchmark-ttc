package hu.bme.mit.trainbenchmark.ttc.benchmark.test;

import static org.junit.Assert.assertEquals;
import hu.bme.mit.trainbenchmark.ttc.benchmark.config.BenchmarkConfig;
import hu.bme.mit.trainbenchmark.ttc.benchmark.config.ChangeSet;
import hu.bme.mit.trainbenchmark.ttc.benchmark.scenarios.AbstractBenchmarkLogic;
import hu.bme.mit.trainbenchmark.ttc.benchmark.util.BenchmarkResult;
import hu.bme.mit.trainbenchmark.ttc.constants.QueryConstants;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

public abstract class TrainBenchmarkTest {
	
	public void testTransformation(final String query, final int expectedResultSize1, final int expextedResultSize2) throws IOException {
		final BenchmarkConfig bc = initialize(query, "");
		
		final AbstractBenchmarkLogic bl = getBenchmarkLogic(bc);
		final BenchmarkResult bmr = bl.runBenchmark();
		final List<Integer> resultSizes = bmr.getResultSizes();
		final int actualResultSize1 = resultSizes.get(0);
		final int actualResultSize2 = resultSizes.get(1);
		assertEquals(expectedResultSize1, actualResultSize1);
		assertEquals(expextedResultSize2, actualResultSize2);
	}

	public BenchmarkConfig initialize(final String query, final String tool) throws IOException {
		return new BenchmarkConfig(tool, 1, 1, query, 1, ChangeSet.FIXED, 1);
	}
	
	@Test
	public void posLength() throws IOException {
		testTransformation(QueryConstants.POSLENGTH, 43, 42);
	}

	@Test
	public void routeSensor() throws IOException {
		testTransformation(QueryConstants.ROUTESENSOR, 7, 6);
	}

	@Test
	public void semaphoreNeighbor() throws IOException {
		testTransformation(QueryConstants.SEMAPHORENEIGHBOR, 1, 0);
	}

	@Test
	public void switchSensor() throws IOException {
		testTransformation(QueryConstants.SWITCHSENSOR, 2, 1);
	}

	@Test
	public void switchSet() throws IOException {
		testTransformation(QueryConstants.SWITCHSET, 3, 2);
	}
	
	protected abstract AbstractBenchmarkLogic getBenchmarkLogic(BenchmarkConfig bc);
	
}
