package hu.bme.mit.trainbenchmark.ttc.benchmark.viatra.matches;

import java.util.Comparator;

import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.evm.api.Activation;

import hu.bme.mit.trainbenchmark.ttc.railway.RailwayElement;

public class VIATRAMatchComparator implements Comparator<Object> {

	@Override
	public int compare(final Object o1, final Object o2) {
		Activation<BasePatternMatch> a1 = (Activation<BasePatternMatch>) o1;
		Activation<BasePatternMatch> a2 = (Activation<BasePatternMatch>) o2;
		final Object[] m1 = a1.getAtom().toArray();
		final Object[] m2 = a2.getAtom().toArray();

		for (int i = 0; i < m1.length; i++) {
			final RailwayElement t1 = (RailwayElement) m1[i];
			final RailwayElement t2 = (RailwayElement) m2[i];

			final int comparison = t1.getId() - t2.getId();
			if (comparison != 0) {
				return comparison;
			}
		}

		return 0;

	}

}
