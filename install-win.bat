@ECHO OFF
echo Installing JOptimizer...
CHDIR joptimizer-bundle
call install-win.bat
CHDIR ..

echo Installing MetaOpt...
CHDIR metaopt
call %m2_home%\bin\mvn clean install
CHDIR ..

IF "%~1"=="--with-gurobi" (
	echo Installing Gurobi...
	CHDIR gurobi
	call install-win.bat

	echo Rebuilding metaopt using gurobi profile...
	CHDIR ..\metaopt 
	call %m2_home%\bin\mvn clean install -P gurobi
	CHDIR ..
)

echo Metaopt installed

