package hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.benchmarkcases;

import hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.PosLengthMatch;
import hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.PosLengthMatcher;
import hu.bme.mit.trainbenchmark.ttc.emf.transformation.PosLengthTransformation;
import hu.bme.mit.trainbenchmark.ttc.railway.Segment;

import java.util.Collection;
import java.util.Set;

import org.eclipse.incquery.runtime.exception.IncQueryException;

public class PosLength extends EMFIncQueryBenchmarkCase<Segment, PosLengthMatch> {

	@Override
	protected Set<Segment> getResultSet() throws IncQueryException {
		return getMatcher().getAllValuesOfsegment();
	}
	
	@Override
	protected PosLengthMatcher getMatcher() throws IncQueryException {
		return PosLengthMatcher.on(engine);
	}

	@Override
	protected Segment extract(final PosLengthMatch match) {
		return match.getSegment();
	}
	
	@Override
	protected void modify(final Collection<Segment> vertices, final long nElementsToModify) {
		final PosLengthTransformation transformation = new PosLengthTransformation();
		transformation.transform(vertices, nElementsToModify);
	}
	
}
