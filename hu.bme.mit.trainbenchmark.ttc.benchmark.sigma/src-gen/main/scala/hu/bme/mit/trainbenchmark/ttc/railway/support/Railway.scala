package hu.bme.mit.trainbenchmark.ttc.railway.support

import fr.unice.i3s.sigma.emf.support.EMFBuilder;
import fr.unice.i3s.sigma.emf.support.EMFScalaSupport;
import fr.unice.i3s.sigma.emf.support.SigmaEcorePackage;

import hu.bme.mit.trainbenchmark.ttc.railway.Position;
import hu.bme.mit.trainbenchmark.ttc.railway.RailwayContainer;
import hu.bme.mit.trainbenchmark.ttc.railway.RailwayElement;
import hu.bme.mit.trainbenchmark.ttc.railway.RailwayPackage;
import hu.bme.mit.trainbenchmark.ttc.railway.Route;
import hu.bme.mit.trainbenchmark.ttc.railway.Segment;
import hu.bme.mit.trainbenchmark.ttc.railway.Semaphore;
import hu.bme.mit.trainbenchmark.ttc.railway.Sensor;
import hu.bme.mit.trainbenchmark.ttc.railway.Signal;
import hu.bme.mit.trainbenchmark.ttc.railway.Switch;
import hu.bme.mit.trainbenchmark.ttc.railway.SwitchPosition;
import hu.bme.mit.trainbenchmark.ttc.railway.TrackElement;

import org.eclipse.emf.common.util.EList;

import scala.Option;


trait Railway
  extends EMFScalaSupport {
    
    implicit class Segment2Sigma(that: Segment) {
      def length: Int = that.getLength
      def length_=(value: Int): Unit = that.setLength(value)
    }
    implicit class TrackElement2Sigma(that: TrackElement) {
      def sensor: Option[Sensor] = Option(that.getSensor)
      def sensor_=(value: Sensor): Unit = that.setSensor(value)
      def sensor_=(value: ⇒ Option[Sensor]): Unit =
        that.setSensor(Railway._railwayBuilder.ref(value))
      def connectsTo: EList[TrackElement] = that.getConnectsTo
    }
    implicit class Switch2Sigma(that: Switch) {
      def currentPosition: Position = that.getCurrentPosition
      def currentPosition_=(value: Position): Unit = that.setCurrentPosition(value)
      def positions: EList[SwitchPosition] = that.getPositions
    }
    implicit class Route2Sigma(that: Route) {
      def entry: Semaphore = that.getEntry
      def entry_=(value: Semaphore): Unit = that.setEntry(value)
      def entry_=(value: ⇒ Option[Semaphore]): Unit =
        that.setEntry(Railway._railwayBuilder.ref(value))
      def follows: EList[SwitchPosition] = that.getFollows
      def exit: Semaphore = that.getExit
      def exit_=(value: Semaphore): Unit = that.setExit(value)
      def exit_=(value: ⇒ Option[Semaphore]): Unit =
        that.setExit(Railway._railwayBuilder.ref(value))
      def definedBy: EList[Sensor] = that.getDefinedBy
    }
    implicit class Semaphore2Sigma(that: Semaphore) {
      def signal: Signal = that.getSignal
      def signal_=(value: Signal): Unit = that.setSignal(value)
    }
    implicit class SwitchPosition2Sigma(that: SwitchPosition) {
      def switch: Switch = that.getSwitch
      def switch_=(value: Switch): Unit = that.setSwitch(value)
      def switch_=(value: ⇒ Option[Switch]): Unit =
        that.setSwitch(Railway._railwayBuilder.ref(value))
      def position: Position = that.getPosition
      def position_=(value: Position): Unit = that.setPosition(value)
      def route: Route = that.getRoute
      def route_=(value: Route): Unit = that.setRoute(value)
      def route_=(value: ⇒ Option[Route]): Unit =
        that.setRoute(Railway._railwayBuilder.ref(value))
    }
    implicit class RailwayElement2Sigma(that: RailwayElement) {
      def id: Option[Int] = Option(that.getId)
      def id_=(value: Int): Unit = that.setId(value)
    }
    implicit class Sensor2Sigma(that: Sensor) {
      def elements: EList[TrackElement] = that.getElements
    }
    implicit class RailwayContainer2Sigma(that: RailwayContainer) {
      def invalids: EList[RailwayElement] = that.getInvalids
      def semaphores: EList[Semaphore] = that.getSemaphores
      def routes: EList[Route] = that.getRoutes
    }
    
    object _railway extends SigmaEcorePackage[RailwayPackage] with
      SegmentScalaSupport with
      TrackElementScalaSupport with
      SwitchScalaSupport with
      RouteScalaSupport with
      SemaphoreScalaSupport with
      SwitchPositionScalaSupport with
      RailwayElementScalaSupport with
      SensorScalaSupport with
      RailwayContainerScalaSupport {
      
      val ePackage = RailwayPackage.eINSTANCE
    }}
object Railway extends Railway {
  private[this] val ePackage = RailwayPackage.eINSTANCE
  
  protected[support] val _railwayBuilder = new EMFBuilder(ePackage)
}