#!/bin/bash

#REM installs not-public-available dependencies in local maven repository

mvn install:install-file -DgroupId=seventytwomiles -DartifactId=architecture-rules -Dversion=3.0.0-M1 -Dpackaging=jar -Dfile=architecture-rules-3.0.0-M1.jar -DpomFile=architecture-rules-3.0.0-M1.pom

mvn install:install-file -DgroupId=joptimizer -DartifactId=joptimizer -Dversion=3.2.0 -Dpackaging=jar -Dfile=joptimizer-3.2.0.jar -DpomFile=joptimizer-3.2.0.jar

