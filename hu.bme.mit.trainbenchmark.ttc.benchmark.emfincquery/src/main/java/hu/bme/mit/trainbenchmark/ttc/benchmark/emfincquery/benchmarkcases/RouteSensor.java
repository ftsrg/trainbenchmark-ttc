package hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.benchmarkcases;

import hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.RouteSensorMatch;
import hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.RouteSensorMatcher;
import hu.bme.mit.trainbenchmark.ttc.emf.transformation.RouteSensorTransformation;
import hu.bme.mit.trainbenchmark.ttc.railway.Sensor;

import java.util.Collection;
import java.util.Set;

import org.eclipse.incquery.runtime.api.IncQueryMatcher;
import org.eclipse.incquery.runtime.exception.IncQueryException;

public class RouteSensor extends EMFIncQueryBenchmarkCase<Sensor, RouteSensorMatch> {

	@Override
	protected Set<Sensor> getResultSet() throws IncQueryException {
		return RouteSensorMatcher.on(engine).getAllValuesOfsensor();
	}

	@Override
	protected IncQueryMatcher<RouteSensorMatch> getMatcher() throws IncQueryException {
		return RouteSensorMatcher.on(engine);
	}

	@Override
	protected Sensor extract(final RouteSensorMatch match) {
		return match.getSensor();
	}

	@Override
	protected void modify(final Collection<Sensor> vertices, final long nElementsToModify) {
		final RouteSensorTransformation transformation = new RouteSensorTransformation();
		transformation.transform(vertices, nElementsToModify);	
	}
	
}
