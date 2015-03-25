package hu.bme.mit.trainbenchmark.ttc.benchmark.java.matches;

import hu.bme.mit.trainbenchmark.ttc.railway.RailwayElement;

import java.util.Arrays;


public abstract class JavaMatch {

	protected RailwayElement[] match;

	public RailwayElement[] getMatch() {
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
		final JavaMatch other = (JavaMatch) obj;
		if (!Arrays.equals(match, other.match))
			return false;
		return true;
	}

}
