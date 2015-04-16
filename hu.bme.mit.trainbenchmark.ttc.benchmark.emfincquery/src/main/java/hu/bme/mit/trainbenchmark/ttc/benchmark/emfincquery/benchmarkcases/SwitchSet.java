package hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.benchmarkcases;

import hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.SwitchSetMatch;
import hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.SwitchSetMatcher;
import hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.transformation.EMFIncQuerySwitchSetTransformation;

import java.util.Collection;
import java.util.HashSet;

import org.eclipse.incquery.runtime.api.IncQueryMatcher;
import org.eclipse.incquery.runtime.exception.IncQueryException;

public class SwitchSet extends EMFIncQueryBenchmarkCase<SwitchSetMatch> {

	@Override
	protected Collection<Object> getResultSet() throws IncQueryException {
		final Collection<Object> matches = new HashSet<>();
		for (final SwitchSetMatch match : SwitchSetMatcher.on(engine).getAllMatches()) {
			matches.add(match);
		}
		return matches;
	}
	
	@Override
	protected IncQueryMatcher<SwitchSetMatch> getMatcher() throws IncQueryException {
		return SwitchSetMatcher.on(engine);
	}	

	@Override
	protected void modify(final Collection<Object> matches, final long nElementsToModify) {
		final EMFIncQuerySwitchSetTransformation transformation = new EMFIncQuerySwitchSetTransformation();
		transformation.transform(matches, nElementsToModify);
	}

}