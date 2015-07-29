package hu.bme.mit.trainbenchmark.ttc.railway.support

import fr.unice.i3s.sigma.emf.support.EMFScalaSupport;

import hu.bme.mit.trainbenchmark.ttc.railway.RailwayElement;

trait RailwayElementScalaSupport extends EMFScalaSupport {
  type RailwayElement = hu.bme.mit.trainbenchmark.ttc.railway.RailwayElement
  
  object RailwayElement {
  }}
object RailwayElementScalaSupport extends RailwayElementScalaSupport
