package hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.util;

import com.google.common.collect.Sets;
import hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.DefinedByMatch;
import hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.DefinedByMatcher;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeBinary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;

/**
 * A pattern-specific query specification that can instantiate DefinedByMatcher in a type-safe way.
 * 
 * @see DefinedByMatcher
 * @see DefinedByMatch
 * 
 */
@SuppressWarnings("all")
public final class DefinedByQuerySpecification extends BaseGeneratedEMFQuerySpecification<DefinedByMatcher> {
  private DefinedByQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static DefinedByQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected DefinedByMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return DefinedByMatcher.on(engine);
  }
  
  @Override
  public DefinedByMatch newEmptyMatch() {
    return DefinedByMatch.newEmptyMatch();
  }
  
  @Override
  public DefinedByMatch newMatch(final Object... parameters) {
    return DefinedByMatch.newMatch((hu.bme.mit.trainbenchmark.ttc.railway.Route) parameters[0], (hu.bme.mit.trainbenchmark.ttc.railway.Sensor) parameters[1]);
  }
  
  private static class LazyHolder {
    private final static DefinedByQuerySpecification INSTANCE = make();
    
    public static DefinedByQuerySpecification make() {
      return new DefinedByQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static DefinedByQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.definedBy";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("route","sensor");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("route", "hu.bme.mit.trainbenchmark.ttc.railway.Route"),new PParameter("sensor", "hu.bme.mit.trainbenchmark.ttc.railway.Sensor"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_route = body.getOrCreateVariableByName("route");
      	PVariable var_sensor = body.getOrCreateVariableByName("sensor");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_route, "route"),
      				
      		new ExportedParameter(body, var_sensor, "sensor")
      	));
      	new TypeBinary(body, CONTEXT, var_route, var_sensor, getFeatureLiteral("http://www.semanticweb.org/ontologies/2015/ttc/trainbenchmark", "Route", "definedBy"), "http://www.semanticweb.org/ontologies/2015/ttc/trainbenchmark/Route.definedBy");
      	bodies.add(body);
      }
      	// to silence compiler error
      	if (false) throw new IncQueryException("Never", "happens");
      } catch (IncQueryException ex) {
      	throw processDependencyException(ex);
      }
      return bodies;
    }
  }
}
