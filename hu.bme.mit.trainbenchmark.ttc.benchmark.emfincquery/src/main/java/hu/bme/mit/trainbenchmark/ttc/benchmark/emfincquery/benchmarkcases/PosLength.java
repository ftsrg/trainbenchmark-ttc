package hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.benchmarkcases;

import hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.PosLengthMatch;
import hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.PosLengthMatcher;
import hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.transformation.EMFIncQueryPosLengthTransformation;

import java.util.Collection;
import java.util.HashSet;

import org.eclipse.incquery.runtime.exception.IncQueryException;

public class PosLength extends EMFIncQueryBenchmarkCase<PosLengthMatch> {

	@Override
	protected Collection<Object> getResultSet() throws IncQueryException {
		final Collection<Object> matches = new HashSet<>();
		for (final PosLengthMatch match : PosLengthMatcher.on(engine).getAllMatches()) {
			matches.add(match);
		}
		return matches;
	}
	
	@Override
	protected PosLengthMatcher getMatcher() throws IncQueryException {
		return PosLengthMatcher.on(engine);
	}

	@Override
	protected void modify(final Collection<Object> matches, final long nElementsToModify) {
		final EMFIncQueryPosLengthTransformation transformation = new EMFIncQueryPosLengthTransformation();
		transformation.transform(matches, nElementsToModify);
	}
	
}
