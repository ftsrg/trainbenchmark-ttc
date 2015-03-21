package hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.benchmarkcases;

import hu.bme.mit.trainbenchmark.ttc.benchmark.emf.EMFSwitchSetMatch;
import hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.SwitchSetMatch;
import hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.SwitchSetMatcher;
import hu.bme.mit.trainbenchmark.ttc.emf.transformation.SwitchSetTransformation;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.incquery.runtime.exception.IncQueryException;

public class SwitchSet extends EMFIncQueryBenchmarkCase<EMFSwitchSetMatch, SwitchSetMatch> {

	@Override
	protected Set<EMFSwitchSetMatch> getResultSet() throws IncQueryException {
		final Set<EMFSwitchSetMatch> emfMatch = new HashSet<>();
		for (final SwitchSetMatch match : SwitchSetMatcher.on(engine).getAllMatches()) {
			emfMatch.add(convertMatch(match));
		}
		return emfMatch;
	}
	
	@Override
	protected SwitchSetMatcher getMatcher() throws IncQueryException {
		return SwitchSetMatcher.on(engine);
	}

	@Override
	protected EMFSwitchSetMatch convertMatch(final SwitchSetMatch match) {
		return new EMFSwitchSetMatch(match.getSemaphore(), match.getRoute(), match.getSwitchPosition(), match.getSw());
	}
	
	@Override
	protected void modify(final Collection<EMFSwitchSetMatch> matches, final long nElementsToModify) {
		final SwitchSetTransformation transformation = new SwitchSetTransformation();
		transformation.transform(matches, nElementsToModify);
	}
	
}
