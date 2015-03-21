package hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.benchmarkcases;

import hu.bme.mit.trainbenchmark.ttc.benchmark.emf.EMFSwitchSensorMatch;
import hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.SwitchSensorMatch;
import hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.SwitchSensorMatcher;
import hu.bme.mit.trainbenchmark.ttc.emf.transformation.SwitchSensorTransformation;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.incquery.runtime.api.IncQueryMatcher;
import org.eclipse.incquery.runtime.exception.IncQueryException;

public class SwitchSensor extends EMFIncQueryBenchmarkCase<EMFSwitchSensorMatch, SwitchSensorMatch> {

	@Override
	protected Set<EMFSwitchSensorMatch> getResultSet() throws IncQueryException {
		final Set<EMFSwitchSensorMatch> emfMatch = new HashSet<>();
		for (final SwitchSensorMatch match : SwitchSensorMatcher.on(engine).getAllMatches()) {
			emfMatch.add(convertMatch(match));
		}
		return emfMatch;
	}

	@Override
	protected IncQueryMatcher<SwitchSensorMatch> getMatcher() throws IncQueryException {
		return SwitchSensorMatcher.on(engine);
	}

	@Override
	protected EMFSwitchSensorMatch convertMatch(final SwitchSensorMatch match) {
		return new EMFSwitchSensorMatch(match.getSw());
	}

	@Override
	protected void modify(final Collection<EMFSwitchSensorMatch> matches, final long nElementsToModify) {
		final SwitchSensorTransformation transformation = new SwitchSensorTransformation();
		transformation.transform(matches, nElementsToModify);
	}
	
}
