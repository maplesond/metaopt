@ECHO OFF
echo Installing JOptimizer...
CD joptimizer-bundle
call install-win.bat
CD ..

echo Installing MetaOpt...
CD metaopt
call %m2_home%\bin\mvn clean install
CD ..

IF "%~1"=="--with-gurobi" (
	echo Installing Gurobi...
	CD gurobi
	call install-win.bat

	echo Rebuilding metaopt using gurobi profile...
	CD ..\metaopt 
	call %m2_home%\bin\mvn clean install -P gurobi
	CD ..
)

echo Metaopt installed

