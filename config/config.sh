# it is recommended to override the settings in the config-override.sh file
# -- this way, the current configuration will not be committed to Git

cleanup()
{
  return $?
}

control_c()
# run if user hits control-c
{
  echo -en "\nInterrupt received, exiting.\n"
  cleanup
  exit $?
}

# trap keyboard interrupt (control-c)
trap control_c SIGINT

minSize=1
maxSize=2
queries="PosLength RouteSensor SwitchSensor SwitchSet SemaphoreNeighbor"
tools="emfincquery"
changeSets="fixed proportional"
timeout=1m
vmargs="-Xmx4G"
runs=3
iterationCount=5

touch config/config-override.sh
. config/config-override.sh
