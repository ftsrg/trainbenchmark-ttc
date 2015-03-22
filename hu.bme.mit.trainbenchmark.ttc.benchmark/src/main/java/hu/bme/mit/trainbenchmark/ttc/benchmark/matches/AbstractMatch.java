package hu.bme.mit.trainbenchmark.ttc.benchmark.matches;

import java.util.Arrays;


public abstract class AbstractMatch<T> {

	protected T[] match;

	public T[] getMatch() {
		return match;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(match);
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
		final AbstractMatch other = (AbstractMatch) obj;
		if (!Arrays.equals(match, other.match))
			return false;
		return true;
	}

}
