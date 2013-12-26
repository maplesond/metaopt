Meta Optimizer
==============

This library is designed to allow users to call out to third party optimization tools in a relativly simple java way.


Supported Optimizers
--------------------

Currently we support the following open source optimizers:

* Apache
* GLPK (support any version supported by the java linear optimization wrapper v1.8)
* JOptimizer 3.2.0

... and the following commercial optimizers:

* Gurobi 5


Install
-------

First of all, make sure you have maven 3 and JDK 1.7 installed.  Next, it is necessary to install the optimizers you wish to use.  Apache is readily available from maven central and should require no special steps to install, it should automatically be downloaded as part of the maven build cycle for metaopt.  However, if you wish to install the other tools then there are some special steps that you should follow:

* GLPK - Follow the installation instructions for install glpk for java V1.0.29.
* JOptimizer - JOptimizer 3.2.0 is not available on a public maven repository so it is included within this distribution.  To install it, just run the install script for your appropriate platform, which can be found in the joptimizer-bundle sub-directory.
* Gurobi - Gurobi is commerical software so you will need to follow their installation instructions and in particular, ensure that the GRB_LICENSE_FILE and GUROBI_HOME environment variables are setup correctly.  Then you will need to install the gurobi.jar to your local maven repository.  A script to do this is provided in the gurobi sub-directory.

Now that the optimizers are installed, you can install metaopt into your local maven repository by typing ``mvn clean install`` in the metaopt sub-directory.

In addition, if you want to use gurobi, there is a further step.  You will also have to do into the gurobi sub-directory and type ``mvn clean install`` in order to add the gurobi plugin.  You will not be able to compile and add the gurobi plugin if you do not have gurobi properly installed and have the gurobi.jar file added to you local maven repo.



Usage
-----

If using maven, then you can simply add the following repository and dependency to your pom::

  <dependency>
    <groupId>uk.ac.tgac.metaopt</groupId>
    <artifactId>metaopt</artifactId>
    <version>0.1</version>
  </dependency>

Now some examples of how to create some simple problems and what the classes do...



