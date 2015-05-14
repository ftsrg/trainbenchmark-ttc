package hu.bme.mit.trainbenchmark.ttc.railway.support

import fr.unice.i3s.sigma.emf.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.emf.support.EMFScalaSupport;

import hu.bme.mit.trainbenchmark.ttc.railway.RailwayContainer;
import hu.bme.mit.trainbenchmark.ttc.railway.RailwayElement;
import hu.bme.mit.trainbenchmark.ttc.railway.Route;
import hu.bme.mit.trainbenchmark.ttc.railway.Semaphore;

import org.eclipse.emf.common.util.EList;

trait RailwayContainerScalaSupport extends EMFScalaSupport {
  type RailwayContainer = hu.bme.mit.trainbenchmark.ttc.railway.RailwayContainer
  
  protected implicit val _railwaycontainerProxyBuilder = new EMFProxyBuilder[RailwayContainer](Railway._railwayBuilder)
  
  object RailwayContainer {
    def apply(invalids: EList[RailwayElement] = null, semaphores: EList[Semaphore] = null, routes: EList[Route] = null): RailwayContainer = {
      val _instance = Railway._railwayBuilder.create[RailwayContainer]
      
      if (invalids != null) _instance.getInvalids.addAll(invalids)
      if (semaphores != null) _instance.getSemaphores.addAll(semaphores)
      if (routes != null) _instance.getRoutes.addAll(routes)
      
      _instance
    }
  }}
object RailwayContainerScalaSupport extends RailwayContainerScalaSupport
