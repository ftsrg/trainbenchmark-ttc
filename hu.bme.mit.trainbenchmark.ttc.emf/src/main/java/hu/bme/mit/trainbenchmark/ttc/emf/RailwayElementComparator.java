package hu.bme.mit.trainbenchmark.ttc.emf;

import hu.bme.mit.trainbenchmark.ttc.railway.RailwayElement;

import java.util.Comparator;

public class RailwayElementComparator implements Comparator<RailwayElement> {

	@Override
	public int compare(final RailwayElement e1, final RailwayElement e2) {
		final int id1 = e1.getId();
		final int id2 = e2.getId();
		return Integer.compare(id1, id2);
	}

}
