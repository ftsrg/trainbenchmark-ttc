package hu.bme.mit.trainbenchmark.ttc.railway.support

import fr.unice.i3s.sigma.emf.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.emf.support.EMFScalaSupport;

import hu.bme.mit.trainbenchmark.ttc.railway.Sensor;
import hu.bme.mit.trainbenchmark.ttc.railway.TrackElement;

import org.eclipse.emf.common.util.EList;

trait SensorScalaSupport extends EMFScalaSupport {
  type Sensor = hu.bme.mit.trainbenchmark.ttc.railway.Sensor
  
  protected implicit val _sensorProxyBuilder = new EMFProxyBuilder[Sensor](Railway._railwayBuilder)
  
  object Sensor {
    def apply(id: Int = 0, elements: EList[TrackElement] = null): Sensor = {
      val _instance = Railway._railwayBuilder.create[Sensor]
      
      if (id != 0) _instance.setId(id)
      if (elements != null) _instance.getElements.addAll(elements)
      
      _instance
    }
  }}
object SensorScalaSupport extends SensorScalaSupport
