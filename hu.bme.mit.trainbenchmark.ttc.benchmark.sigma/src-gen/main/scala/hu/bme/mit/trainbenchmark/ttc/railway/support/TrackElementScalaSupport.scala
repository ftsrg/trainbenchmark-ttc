package hu.bme.mit.trainbenchmark.ttc.railway.support

import fr.unice.i3s.sigma.emf.support.EMFScalaSupport;

import hu.bme.mit.trainbenchmark.ttc.railway.TrackElement;

trait TrackElementScalaSupport extends EMFScalaSupport {
  type TrackElement = hu.bme.mit.trainbenchmark.ttc.railway.TrackElement
  
  object TrackElement {
  }}
object TrackElementScalaSupport extends TrackElementScalaSupport
