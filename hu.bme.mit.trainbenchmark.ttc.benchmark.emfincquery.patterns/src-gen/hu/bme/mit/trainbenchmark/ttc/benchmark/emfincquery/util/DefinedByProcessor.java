package hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.util;

import hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.DefinedByMatch;
import hu.bme.mit.trainbenchmark.ttc.railway.Route;
import hu.bme.mit.trainbenchmark.ttc.railway.Sensor;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.definedBy pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class DefinedByProcessor implements IMatchProcessor<DefinedByMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pRoute the value of pattern parameter route in the currently processed match
   * @param pSensor the value of pattern parameter sensor in the currently processed match
   * 
   */
  public abstract void process(final Route pRoute, final Sensor pSensor);
  
  @Override
  public void process(final DefinedByMatch match) {
    process(match.getRoute(), match.getSensor());
  }
}
