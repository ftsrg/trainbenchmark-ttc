package hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery;

import hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.util.PosLengthQuerySpecification;
import hu.bme.mit.trainbenchmark.ttc.railway.Segment;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.PosLength pattern,
 * to be used in conjunction with {@link PosLengthMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see PosLengthMatcher
 * @see PosLengthProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class PosLengthMatch extends BasePatternMatch {
  private Segment fSegment;
  
  private Integer fLength;
  
  private static List<String> parameterNames = makeImmutableList("segment", "length");
  
  private PosLengthMatch(final Segment pSegment, final Integer pLength) {
    this.fSegment = pSegment;
    this.fLength = pLength;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("segment".equals(parameterName)) return this.fSegment;
    if ("length".equals(parameterName)) return this.fLength;
    return null;
  }
  
  public Segment getSegment() {
    return this.fSegment;
  }
  
  public Integer getLength() {
    return this.fLength;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("segment".equals(parameterName) ) {
    	this.fSegment = (hu.bme.mit.trainbenchmark.ttc.railway.Segment) newValue;
    	return true;
    }
    if ("length".equals(parameterName) ) {
    	this.fLength = (java.lang.Integer) newValue;
    	return true;
    }
    return false;
  }
  
  public void setSegment(final Segment pSegment) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSegment = pSegment;
  }
  
  public void setLength(final Integer pLength) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fLength = pLength;
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.PosLength";
  }
  
  @Override
  public List<String> parameterNames() {
    return PosLengthMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fSegment, fLength};
  }
  
  @Override
  public PosLengthMatch toImmutable() {
    return isMutable() ? newMatch(fSegment, fLength) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"segment\"=" + prettyPrintValue(fSegment) + ", ");
    
    result.append("\"length\"=" + prettyPrintValue(fLength)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fSegment == null) ? 0 : fSegment.hashCode());
    result = prime * result + ((fLength == null) ? 0 : fLength.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof PosLengthMatch)) { // this should be infrequent
    	if (obj == null) {
    		return false;
    	}
    	if (!(obj instanceof IPatternMatch)) {
    		return false;
    	}
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    PosLengthMatch other = (PosLengthMatch) obj;
    if (fSegment == null) {if (other.fSegment != null) return false;}
    else if (!fSegment.equals(other.fSegment)) return false;
    if (fLength == null) {if (other.fLength != null) return false;}
    else if (!fLength.equals(other.fLength)) return false;
    return true;
  }
  
  @Override
  public PosLengthQuerySpecification specification() {
    try {
    	return PosLengthQuerySpecification.instance();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the query specification exists
     	throw new IllegalStateException (ex);
    }
  }
  
  /**
   * Returns an empty, mutable match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @return the empty match.
   * 
   */
  public static PosLengthMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pSegment the fixed value of pattern parameter segment, or null if not bound.
   * @param pLength the fixed value of pattern parameter length, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static PosLengthMatch newMutableMatch(final Segment pSegment, final Integer pLength) {
    return new Mutable(pSegment, pLength);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSegment the fixed value of pattern parameter segment, or null if not bound.
   * @param pLength the fixed value of pattern parameter length, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static PosLengthMatch newMatch(final Segment pSegment, final Integer pLength) {
    return new Immutable(pSegment, pLength);
  }
  
  private static final class Mutable extends PosLengthMatch {
    Mutable(final Segment pSegment, final Integer pLength) {
      super(pSegment, pLength);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends PosLengthMatch {
    Immutable(final Segment pSegment, final Integer pLength) {
      super(pSegment, pLength);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
