#!/bin/bash

# installs joptimizer into your local maven repo

mvn install:install-file -DgroupId=joptimizer -DartifactId=joptimizer -Dversion=3.4.0 -Dpackaging=jar -Dfile=joptimizer-3.4.0.jar -DpomFile=joptimizer-3.4.0.pom


