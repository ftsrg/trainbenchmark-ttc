package hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.transformation;

import java.util.Collection;

public abstract class EMFIncQueryTransformationAction {

	public abstract void transform(Collection<Object> matches, final long nElementsToModify);
	
}
