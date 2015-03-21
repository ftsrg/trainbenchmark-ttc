package hu.bme.mit.trainbenchmark.ttc.benchmark.benchmarkcases;

public abstract class AbstractPosLengthMatch<Segment> extends AbstractMatch {

	protected Segment segment;
	
	public AbstractPosLengthMatch(final Segment segment) {
		super();
		this.segment = segment;
	}

	public Segment getSegment() {
		return segment;
	}
	
	@Override
	public String toString() {
		return "PosLengthMatch [segment=" + segment + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((segment == null) ? 0 : segment.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final AbstractPosLengthMatch other = (AbstractPosLengthMatch) obj;
		if (segment == null) {
			if (other.segment != null)
				return false;
		} else if (!segment.equals(other.segment))
			return false;
		return true;
	}
	
}
