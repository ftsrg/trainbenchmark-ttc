package hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.benchmarkcases;

import hu.bme.mit.trainbenchmark.ttc.benchmark.emf.match.EMFSemaphoreNeighborMatch;
import hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.SemaphoreNeighborMatch;
import hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.SemaphoreNeighborMatcher;
import hu.bme.mit.trainbenchmark.ttc.emf.transformation.SemaphoreNeighborTransformation;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.incquery.runtime.api.IncQueryMatcher;
import org.eclipse.incquery.runtime.exception.IncQueryException;

public class SemaphoreNeighbor extends EMFIncQueryBenchmarkCase<EMFSemaphoreNeighborMatch, SemaphoreNeighborMatch> {

	@Override
	protected Set<EMFSemaphoreNeighborMatch> getResultSet() throws IncQueryException {
		final Set<EMFSemaphoreNeighborMatch> emfMatch = new HashSet<>();
		for (final SemaphoreNeighborMatch match : SemaphoreNeighborMatcher.on(engine).getAllMatches()) {
			emfMatch.add(convertMatch(match));
		}
		return emfMatch;
	}

	@Override
	protected IncQueryMatcher<SemaphoreNeighborMatch> getMatcher() throws IncQueryException {
		return SemaphoreNeighborMatcher.on(engine);
	}

	@Override
	protected EMFSemaphoreNeighborMatch convertMatch(final SemaphoreNeighborMatch match) {
		return new EMFSemaphoreNeighborMatch(match.getSemaphore(), match.getRoute1(), match.getRoute3(), match.getSensor1(),
				match.getSensor2(), match.getTe1(), match.getTe2());
	}

	@Override
	protected void modify(final Collection<EMFSemaphoreNeighborMatch> matches, final long nElementsToModify) {
		final SemaphoreNeighborTransformation transformation = new SemaphoreNeighborTransformation();
		transformation.transform(matches, nElementsToModify);
	}

}
