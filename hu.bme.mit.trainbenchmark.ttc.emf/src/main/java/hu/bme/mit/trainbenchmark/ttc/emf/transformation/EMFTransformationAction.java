package hu.bme.mit.trainbenchmark.ttc.emf.transformation;

import hu.bme.mit.trainbenchmark.ttc.railway.RailwayElement;

import java.util.Collection;

public abstract class EMFTransformationAction<T extends RailwayElement> {

	public abstract void transform(Collection<T> invalids, final long nElementsToModify);
	
}
