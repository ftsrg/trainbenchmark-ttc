package hu.bme.mit.trainbenchmark.ttc.benchmark.java.transformation;

import java.util.Collection;

public abstract class JavaTransformationAction {

	public abstract void transform(Collection<Object> matches, final long nElementsToModify);
	
}
