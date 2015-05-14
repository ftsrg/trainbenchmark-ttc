package hu.bme.mit.trainbenchmark.ttc.railway.support

import fr.unice.i3s.sigma.emf.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.emf.support.EMFScalaSupport;

import hu.bme.mit.trainbenchmark.ttc.railway.Segment;
import hu.bme.mit.trainbenchmark.ttc.railway.TrackElement;

import org.eclipse.emf.common.util.EList;

trait SegmentScalaSupport extends EMFScalaSupport {
  type Segment = hu.bme.mit.trainbenchmark.ttc.railway.Segment
  
  protected implicit val _segmentProxyBuilder = new EMFProxyBuilder[Segment](Railway._railwayBuilder)
  
  object Segment {
    def apply(id: Int = 0, connectsTo: EList[TrackElement] = null, length: Int = 0): Segment = {
      val _instance = Railway._railwayBuilder.create[Segment]
      
      if (id != 0) _instance.setId(id)
      if (connectsTo != null) _instance.getConnectsTo.addAll(connectsTo)
      if (length != 0) _instance.setLength(length)
      
      _instance
    }
  }}
object SegmentScalaSupport extends SegmentScalaSupport
