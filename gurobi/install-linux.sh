#!/bin/bash

echo -e "\nAssuming that GUROBI_HOME and GRB_LICENSE_FILE are set and that maven is installed and on the path\n"
echo -e "GUROBI_HOME=$GUROBI_HOME"
echo -e "GRB_LICENSE_FILE=$GRB_LICENSE_FILE"

GRB_VER_LINE=$(grep VERSION $GRB_LICENSE_FILE)
GRB_VER_PARTS=(${GRB_VER_LINE//=/ })
GRB_VER=${GRB_VER_PARTS[1]}

echo -e "\nFound Gurobi Version: $GRB_VER\n"

mvn install:install-file -Dfile=$GUROBI_HOME/lib/gurobi.jar -DgroupId=gurobi -DartifactId=gurobi -Dversion=$GRB_VER -Dpackaging=jar

echo -e "\nAdded gurobi.jar to local maven repository.  Metaopt can now integrate with Gurobi optimiser\n"

# Compile, test and install the plugin into your local maven repo

mvn clean install
echo "Compiled, tested and installed plugin into your local maven repo"

