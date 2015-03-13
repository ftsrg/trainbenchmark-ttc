package hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.benchmarkcases;

import hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.SwitchSensorMatch;
import hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.SwitchSensorMatcher;
import hu.bme.mit.trainbenchmark.ttc.emf.transformation.SwitchSensorTransformation;
import hu.bme.mit.trainbenchmark.ttc.railway.Switch;

import java.util.Collection;
import java.util.Set;

import org.eclipse.incquery.runtime.api.IncQueryMatcher;
import org.eclipse.incquery.runtime.exception.IncQueryException;

public class SwitchSensor extends EMFIncQueryBenchmarkCase<Switch, SwitchSensorMatch> {

	@Override
	protected Set<Switch> getResultSet() throws IncQueryException {
		return SwitchSensorMatcher.on(engine).getAllValuesOfsw();
	}

	@Override
	protected IncQueryMatcher<SwitchSensorMatch> getMatcher() throws IncQueryException {
		return SwitchSensorMatcher.on(engine);
	}

	@Override
	protected Switch extract(final SwitchSensorMatch match) {
		return match.getSw();
	}

	@Override
	protected void modify(final Collection<Switch> vertices, final long nElementsToModify) {
		final SwitchSensorTransformation transformation = new SwitchSensorTransformation();
		transformation.transform(vertices, nElementsToModify);
	}
	
}
