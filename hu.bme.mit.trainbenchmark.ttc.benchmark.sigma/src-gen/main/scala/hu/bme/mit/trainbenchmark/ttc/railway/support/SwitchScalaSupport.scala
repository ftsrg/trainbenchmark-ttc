package hu.bme.mit.trainbenchmark.ttc.railway.support

import fr.unice.i3s.sigma.emf.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.emf.support.EMFScalaSupport;

import hu.bme.mit.trainbenchmark.ttc.railway.Position;
import hu.bme.mit.trainbenchmark.ttc.railway.Switch;
import hu.bme.mit.trainbenchmark.ttc.railway.SwitchPosition;
import hu.bme.mit.trainbenchmark.ttc.railway.TrackElement;

import org.eclipse.emf.common.util.EList;

trait SwitchScalaSupport extends EMFScalaSupport {
  type Switch = hu.bme.mit.trainbenchmark.ttc.railway.Switch
  
  protected implicit val _switchProxyBuilder = new EMFProxyBuilder[Switch](Railway._railwayBuilder)
  
  object Switch {
    def apply(id: Int = 0, connectsTo: EList[TrackElement] = null, currentPosition: Position = Position.FAILURE, positions: EList[SwitchPosition] = null): Switch = {
      val _instance = Railway._railwayBuilder.create[Switch]
      
      if (id != 0) _instance.setId(id)
      if (connectsTo != null) _instance.getConnectsTo.addAll(connectsTo)
      if (currentPosition != Position.FAILURE) _instance.setCurrentPosition(currentPosition)
      if (positions != null) _instance.getPositions.addAll(positions)
      
      _instance
    }
  }}
object SwitchScalaSupport extends SwitchScalaSupport
