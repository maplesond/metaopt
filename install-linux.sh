#!/bin/bash

echo -e "\n\nInstalling JOptimizer...\n"
cd joptimizer-bundle; ./install-linux.sh; cd ..;

echo -e "\ndone.\n\nInstalling MetaOpt...\n"
cd metaopt; mvn clean install; cd ..;

echo -e "\ndone\n\n";

if [ "$1" == "--with-gurobi" ]
then
	echo -e "Installing Gurobi...\n"
	cd gurobi; ./install-linux.sh; 

	echo -e "\ndone\n\nRebuilding metaopt using gurobi profile...\n"
	cd ../metaopt; mvn clean install -P gurobi; cd ..;

	echo -e "\ndone\n\n";
fi

echo -e "Metaopt installed\n"

