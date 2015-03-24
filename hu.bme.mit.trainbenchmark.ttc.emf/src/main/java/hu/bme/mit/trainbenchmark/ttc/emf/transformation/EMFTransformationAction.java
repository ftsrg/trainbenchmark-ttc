package hu.bme.mit.trainbenchmark.ttc.emf.transformation;

import hu.bme.mit.trainbenchmark.ttc.benchmark.matches.AbstractMatch;

import java.util.Collection;

public abstract class EMFTransformationAction<T extends AbstractMatch> {

	public abstract void transform(Collection<T> matches, final long nElementsToModify);
	
}
