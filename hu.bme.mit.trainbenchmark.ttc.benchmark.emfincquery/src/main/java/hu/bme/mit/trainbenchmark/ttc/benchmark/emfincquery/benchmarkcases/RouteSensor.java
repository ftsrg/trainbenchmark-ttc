package hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.benchmarkcases;

import hu.bme.mit.trainbenchmark.ttc.benchmark.emf.match.EMFRouteSensorMatch;
import hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.RouteSensorMatch;
import hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.RouteSensorMatcher;
import hu.bme.mit.trainbenchmark.ttc.emf.transformation.RouteSensorTransformation;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.incquery.runtime.api.IncQueryMatcher;
import org.eclipse.incquery.runtime.exception.IncQueryException;

public class RouteSensor extends EMFIncQueryBenchmarkCase<EMFRouteSensorMatch, RouteSensorMatch> {

	@Override
	protected Set<EMFRouteSensorMatch> getResultSet() throws IncQueryException {
		final Set<EMFRouteSensorMatch> emfMatch = new HashSet<>();
		for (final RouteSensorMatch match : RouteSensorMatcher.on(engine).getAllMatches()) {
			emfMatch.add(convertMatch(match));
		}
		return emfMatch;
	}

	@Override
	protected IncQueryMatcher<RouteSensorMatch> getMatcher() throws IncQueryException {
		return RouteSensorMatcher.on(engine);
	}

	@Override
	protected EMFRouteSensorMatch convertMatch(final RouteSensorMatch match) {
		return new EMFRouteSensorMatch(match.getRoute(), match.getSensor(), match.getSwitchPosition(), match.getSw());
	}

	@Override
	protected void modify(final Collection<EMFRouteSensorMatch> matches, final long nElementsToModify) {
		final RouteSensorTransformation transformation = new RouteSensorTransformation();
		transformation.transform(matches, nElementsToModify);
	}

}
