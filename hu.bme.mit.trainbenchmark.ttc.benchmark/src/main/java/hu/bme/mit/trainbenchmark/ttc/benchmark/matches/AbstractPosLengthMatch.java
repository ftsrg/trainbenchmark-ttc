package hu.bme.mit.trainbenchmark.ttc.benchmark.matches;

@SuppressWarnings("unchecked")
public abstract class AbstractPosLengthMatch<T, Segment extends T> extends AbstractMatch<T> {

	public AbstractPosLengthMatch(final Segment segment) {
		super();
		match = (T[]) new Object[] { segment };
	}

	public Segment getSegment() {
		return (Segment) match[0];
	}

}
