package hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.benchmarkcases;

import hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.SwitchSetMatch;
import hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.SwitchSetMatcher;
import hu.bme.mit.trainbenchmark.ttc.emf.transformation.SwitchSetTransformation;
import hu.bme.mit.trainbenchmark.ttc.railway.SwitchPosition;

import java.util.Collection;
import java.util.Set;

import org.eclipse.incquery.runtime.exception.IncQueryException;

public class SwitchSet extends EMFIncQueryBenchmarkCase<SwitchPosition, SwitchSetMatch> {

	@Override
	protected Set<SwitchPosition> getResultSet() throws IncQueryException {
		return getMatcher().getAllValuesOfswitchPosition();
	}
	
	@Override
	protected SwitchSetMatcher getMatcher() throws IncQueryException {
		return SwitchSetMatcher.on(engine);
	}

	@Override
	protected SwitchPosition extract(final SwitchSetMatch match) {
		return match.getSwitchPosition();
	}
	
	@Override
	protected void modify(final Collection<SwitchPosition> vertices, final long nElementsToModify) {
		final SwitchSetTransformation transformation = new SwitchSetTransformation();
		transformation.transform(vertices, nElementsToModify);
	}
	
}
