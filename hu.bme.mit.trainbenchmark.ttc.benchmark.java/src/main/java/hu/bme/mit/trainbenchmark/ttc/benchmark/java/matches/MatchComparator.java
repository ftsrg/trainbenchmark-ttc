//package hu.bme.mit.trainbenchmark.ttc.benchmark.java.matches;
//
//import java.util.Comparator;
//
//public class MatchComparator implements Comparator<Object> {
//
//	protected Comparator<T> modelElementComparator;
//	
//	public MatchComparator(final Comparator<T> modelElementComparator) {
//		this.modelElementComparator = modelElementComparator;
//	}
//	
//	@Override
//	public int compare(final M o1, final M o2) {
//		final T[] m1 = o1.match;
//		final T[] m2 = o2.match;
//		for (int i = 0; i < m1.length; i++) {		
//			final T t1 = m1[i];
//			final T t2 = m2[i];
//
//			final int comparison = modelElementComparator.compare(t1, t2);
//			if (comparison != 0) {
//				return comparison;
//			}
//		}
//
//		return 0;
//	}
//
//}
