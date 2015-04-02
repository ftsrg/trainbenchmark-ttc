package hu.bme.mit.trainbenchmark.ttc.benchmark.java.matches;

import hu.bme.mit.trainbenchmark.ttc.railway.RailwayElement;

import java.util.Comparator;

public class JavaMatchComparator implements Comparator<Object> {
	
	@Override
	public int compare(final Object o1, final Object o2) {	
		final RailwayElement[] m1 = ((JavaMatch) o1).match;
		final RailwayElement[] m2 = ((JavaMatch) o2).match;
		for (int i = 0; i < m1.length; i++) {		
			final RailwayElement t1 = m1[i];
			final RailwayElement t2 = m2[i];

			final int comparison = t1.getId() - t2.getId();
			if (comparison != 0) {
				return comparison;
			}
		}

		return 0;
	}

}
