package hu.bme.mit.trainbenchmark.ttc.railway.support

import fr.unice.i3s.sigma.emf.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.emf.support.EMFScalaSupport;

import hu.bme.mit.trainbenchmark.ttc.railway.Semaphore;
import hu.bme.mit.trainbenchmark.ttc.railway.Signal;

trait SemaphoreScalaSupport extends EMFScalaSupport {
  type Semaphore = hu.bme.mit.trainbenchmark.ttc.railway.Semaphore
  
  protected implicit val _semaphoreProxyBuilder = new EMFProxyBuilder[Semaphore](Railway._railwayBuilder)
  
  object Semaphore {
    def apply(id: Int = 0, signal: Signal = Signal.FAILURE): Semaphore = {
      val _instance = Railway._railwayBuilder.create[Semaphore]
      
      if (id != 0) _instance.setId(id)
      if (signal != Signal.FAILURE) _instance.setSignal(signal)
      
      _instance
    }
  }}
object SemaphoreScalaSupport extends SemaphoreScalaSupport
