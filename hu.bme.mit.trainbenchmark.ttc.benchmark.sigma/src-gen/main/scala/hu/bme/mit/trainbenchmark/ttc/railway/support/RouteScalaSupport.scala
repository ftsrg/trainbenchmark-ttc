package hu.bme.mit.trainbenchmark.ttc.railway.support

import fr.unice.i3s.sigma.emf.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.emf.support.EMFScalaSupport;

import hu.bme.mit.trainbenchmark.ttc.railway.Route;
import hu.bme.mit.trainbenchmark.ttc.railway.Semaphore;
import hu.bme.mit.trainbenchmark.ttc.railway.Sensor;
import hu.bme.mit.trainbenchmark.ttc.railway.SwitchPosition;

import org.eclipse.emf.common.util.EList;

trait RouteScalaSupport extends EMFScalaSupport {
  type Route = hu.bme.mit.trainbenchmark.ttc.railway.Route
  
  protected implicit val _routeProxyBuilder = new EMFProxyBuilder[Route](Railway._railwayBuilder)
  
  object Route {
    def apply(id: Int = 0, entry: Semaphore = null, follows: EList[SwitchPosition] = null, exit: Semaphore = null, definedBy: EList[Sensor] = null): Route = {
      val _instance = Railway._railwayBuilder.create[Route]
      
      if (id != 0) _instance.setId(id)
      if (entry != null) _instance.setEntry(entry)
      if (follows != null) _instance.getFollows.addAll(follows)
      if (exit != null) _instance.setExit(exit)
      if (definedBy != null) _instance.getDefinedBy.addAll(definedBy)
      
      _instance
    }
  }}
object RouteScalaSupport extends RouteScalaSupport
