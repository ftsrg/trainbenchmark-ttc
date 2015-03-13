package hu.bme.mit.trainbenchmark.ttc.benchmark.benchmarkcases.transformations;

import hu.bme.mit.trainbenchmark.ttc.benchmark.util.UniqueRandom;
import hu.bme.mit.trainbenchmark.ttc.constants.TrainBenchmarkConstants;

import java.util.ArrayList;
import java.util.List;

public class TransformationUtil {
	
	public static <T> List<T> pickRandom(long nElementsToModify, final List<T> elements) {
		final UniqueRandom random = new UniqueRandom(TrainBenchmarkConstants.RANDOM_SEED);
		
		final int size = elements.size();
		if (size < nElementsToModify) {
			nElementsToModify = size;
		}

		final List<T> elementsToModify = new ArrayList<>();
		for (int i = 0; i < nElementsToModify; i++) {
			final int rndTarget = random.nextInt(size);
			final T element = elements.get(rndTarget);
			elementsToModify.add(element);
		}
		return elementsToModify;
	}
	
}
