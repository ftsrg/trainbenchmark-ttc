package hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.util;

import hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.SwitchSetMatch;
import hu.bme.mit.trainbenchmark.ttc.railway.SwitchPosition;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.switchSet pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class SwitchSetProcessor implements IMatchProcessor<SwitchSetMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pSwitchPosition the value of pattern parameter switchPosition in the currently processed match
   * 
   */
  public abstract void process(final SwitchPosition pSwitchPosition);
  
  @Override
  public void process(final SwitchSetMatch match) {
    process(match.getSwitchPosition());
  }
}
