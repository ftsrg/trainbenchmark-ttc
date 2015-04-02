package hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.matches;

import hu.bme.mit.trainbenchmark.ttc.railway.RailwayElement;

import java.util.Comparator;

import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;

public class EMFIncQueryBenchmarkComparator implements Comparator<Object> {

	@Override
	public int compare(final Object o1, final Object o2) {
		final Object[] m1 = ((BasePatternMatch) o1).toArray();
		final Object[] m2 = ((BasePatternMatch) o2).toArray();
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
