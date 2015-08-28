@ECHO OFF
echo Installing JOptimizer...
call cd joptimizer-bundle
call install-win.bat
call cd ..;

echo Installing MetaOpt...
call cd metaopt
call mvn clean install
call cd ..

echo "\ndone\n\n";

IF "%~1"=="--with-gurobi" (
	echo "Installing Gurobi..."
	call cd gurobi
	call install-win.bat

	echo "\ndone\n\nRebuilding metaopt using gurobi profile..."
	call cd ../metaopt 
	call %m2_home%\bin\mvn clean install -P gurobi
	call cd ..
)

echo "Metaopt installed\n"

