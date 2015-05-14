package hu.bme.mit.trainbenchmark.ttc.railway.support

import fr.unice.i3s.sigma.emf.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.emf.support.EMFScalaSupport;

import hu.bme.mit.trainbenchmark.ttc.railway.Position;
import hu.bme.mit.trainbenchmark.ttc.railway.Switch;
import hu.bme.mit.trainbenchmark.ttc.railway.SwitchPosition;

trait SwitchPositionScalaSupport extends EMFScalaSupport {
  type SwitchPosition = hu.bme.mit.trainbenchmark.ttc.railway.SwitchPosition
  
  protected implicit val _switchpositionProxyBuilder = new EMFProxyBuilder[SwitchPosition](Railway._railwayBuilder)
  
  object SwitchPosition {
    def apply(id: Int = 0, switch: Switch = null, position: Position = Position.FAILURE): SwitchPosition = {
      val _instance = Railway._railwayBuilder.create[SwitchPosition]
      
      if (id != 0) _instance.setId(id)
      if (switch != null) _instance.setSwitch(switch)
      if (position != Position.FAILURE) _instance.setPosition(position)
      
      _instance
    }
  }}
object SwitchPositionScalaSupport extends SwitchPositionScalaSupport
