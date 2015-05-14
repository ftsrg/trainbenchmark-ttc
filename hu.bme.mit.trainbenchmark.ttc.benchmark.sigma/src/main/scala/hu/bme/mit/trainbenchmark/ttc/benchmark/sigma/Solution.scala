package hu.bme.mit.trainbenchmark.ttc.benchmark.sigma

import hu.bme.mit.trainbenchmark.ttc.railway.Signal
import hu.bme.mit.trainbenchmark.ttc.railway.support.Railway
import hu.bme.mit.trainbenchmark.ttc.railway.support.Railway._railway._

object Solution extends Railway {

  val PosLength = SigmaBenchmarkCase[Segment, Segment](
    query = segment => if (segment.length < 0) Some(segment) else None,
    repair = segment => segment.length += -segment.length + 1
  )

  val SwitchSensor = SigmaBenchmarkCase[Switch, Switch](
    query = switch => if (switch.sensor.isEmpty) Some(switch) else None,
    repair = switch => switch.sensor = Sensor()
  )

  val SwitchSet = SigmaBenchmarkCase[SwitchPosition, (Semaphore, Route, SwitchPosition, Switch)](
    query = swP => {
      for {
        semaphore <- Option(swP.route.entry) if semaphore.signal == Signal.GO // faulty meta-model - if it is possible not to have entry -> cardinality should be 0..1
        sw = swP.switch if sw.currentPosition != swP.position
      } yield (semaphore, swP.route, swP, sw)
    },

    repair = {
      case (_, _, swP, sw) => sw.currentPosition = swP.position
    }
  )

  val RouteSensor = SigmaBenchmarkCase[Route, (Route, Sensor, SwitchPosition, Switch)](
    query = { route =>
      val matches = for {
        swP <- route.follows
        sw = swP.switch
        sensor <- sw.sensor if !(route.definedBy contains sensor)
      } yield (route, sensor, swP, sw)

      println(matches.size)

      matches.headOption
    },

    repair = {
      case (route, sensor, _, _) => route.definedBy += sensor
    }
  )

//  val RouteSensor = SigmaBenchmarkCase[Sensor, (Route, Sensor, SwitchPosition, Switch)](
//    query = sensor => {
//      val matches = for {
//        sw <- sensor.elements collect { case x: Switch => x }
//        swP <- sw.positions
//        route = swP.route if !(route.definedBy contains sensor)
//      } yield (route, sensor, swP, sw)
//
//      println(matches.size)
//
//      matches.headOption
//    },
//
//    repair = {
//      case (route, sensor, _, _) => route.definedBy += sensor
//    }
//  )

  val SemaphoreNeighbour = SigmaBenchmarkCase[Route,(Semaphore, Route, Route, Sensor, Sensor, TrackElement, TrackElement)](
    query = { route1 =>
      val matches = for {
        sensor1 <- route1.definedBy if route1.exit != null
        te1 <- sensor1.elements
        te2 <- te1.connectsTo
        sensor2 <- te2.sensor
        semaphore <- Option(route1.exit) // faulty meta-model - if it is possible not to have exit -> cardinality should be 0..1
        route2 <- sensor2.sContainer[Route] if route1 != route2 && semaphore != route2.entry
      } yield (semaphore, route1, route2, sensor1, sensor2, te1, te2)

      matches.headOption
    },

    repair = {
      case (semaphore, _, route2, _, _, _, _) => route2.entry = semaphore
    }
  )

}