REM installs joptimizer into the local maven repository
call %m2_home%\bin\mvn install:install-file -DgroupId=joptimizer -DartifactId=joptimizer -Dversion=3.2.0 -Dpackaging=jar -Dfile=joptimizer-3.2.0.jar -DpomFile=joptimizer-3.2.0.pom


