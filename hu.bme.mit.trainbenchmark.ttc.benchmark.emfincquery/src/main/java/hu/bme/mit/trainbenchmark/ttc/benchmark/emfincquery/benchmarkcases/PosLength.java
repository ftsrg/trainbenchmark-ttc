package hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.benchmarkcases;

import hu.bme.mit.trainbenchmark.ttc.benchmark.emf.EMFPosLengthMatch;
import hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.PosLengthMatch;
import hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.PosLengthMatcher;
import hu.bme.mit.trainbenchmark.ttc.emf.transformation.PosLengthTransformation;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.incquery.runtime.exception.IncQueryException;

public class PosLength extends EMFIncQueryBenchmarkCase<EMFPosLengthMatch, PosLengthMatch> {

	@Override
	protected Set<EMFPosLengthMatch> getResultSet() throws IncQueryException {
		final Set<EMFPosLengthMatch> emfMatch = new HashSet<>();
		for (final PosLengthMatch match : PosLengthMatcher.on(engine).getAllMatches()) {
			emfMatch.add(convertMatch(match));
		}
		return emfMatch;
	}
	
	@Override
	protected PosLengthMatcher getMatcher() throws IncQueryException {
		return PosLengthMatcher.on(engine);
	}

	@Override
	protected EMFPosLengthMatch convertMatch(final PosLengthMatch match) {
		return new EMFPosLengthMatch(match.getSegment());
	}
	
	@Override
	protected void modify(final Collection<EMFPosLengthMatch> matches, final long nElementsToModify) {
		final PosLengthTransformation transformation = new PosLengthTransformation();
		transformation.transform(matches, nElementsToModify);
	}
	
}
