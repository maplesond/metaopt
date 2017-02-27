Meta Optimizer
==============

This library is designed to allow users to call out to third party optimization tools via a generic interface.  This makes it easier for users to switch between optimizers in their client codewithout having to write problem definitions for each optimizer.


Supported Optimizers
--------------------

Currently we support the following open source optimizers:

* Apache
* GLPK (support any version supported by the java linear optimization wrapper v1.8)
* JOptimizer 3.5.1

... and the following commercial optimizers:

* Gurobi 6


Install
-------

First of all, make sure you have maven 3 and JDK 1.7+ installed and your PATH environment variable updated.   Specifically, javac and mvn should be on your PATH, and M2_HOME and JAVA_HOME should be set to the respective installation directories.

Next, it is necessary to install the optimizers you wish to use.  Apache and JOptimizer are readily available from maven central and should require no special steps to install, it should automatically be downloaded as part of the maven build cycle for metaopt.  However, if you wish to install the other tools then there are some special steps that you should follow:

* GLPK - Follow the installation instructions for install glpk for java V1.0.29.
* Gurobi - Gurobi is commerical software so you will need to follow their installation instructions and in particular, ensure that the GRB_LICENSE_FILE and GUROBI_HOME environment variables are setup correctly.  Then you will need to install the gurobi.jar to your local maven repository.  A script to do this is provided in the gurobi sub-directory.

* Apache - Readily available from maven central. Will be automatically included.  No special steps necessary.
* GLPK - Follow the installation instructions for install glpk for java V1.0.29.  Metaopt will then pick this up if installed correctly.
* JOptimizer - JOptimizer 3.4.0 is not available on a public maven repository so it is included within this distribution.  Will be automatically included.  No extra steps necessary.
* Gurobi - Gurobi is commerical software so you will need to follow their installation instructions and in particular, ensure that the GRB_LICENSE_FILE and GUROBI_HOME environment variables are setup correctly.  In addition, you will need to instruct the install script that you wish to use gurobi, see below.

Now that the optimizers are installed, you can install metaopt into your local maven repository by either typing in this directory "./install-linux.sh", or "./install-linux.sh --with-gurobi" if you wish to use gurobi.  If using windows replace "...-linux.sh with -win.bat".



Usage
-----

If using maven (which we strongly recommend), then you can simply add the following repository and dependency to your pom::

  <dependency>
    <groupId>uk.ac.earlham.metaopt</groupId>
    <artifactId>metaopt</artifactId>
    <version>0.3.0</version>
  </dependency>

Otherwise you will need to copy the metaopt jar file, along with all dependencies into your classpath.

