@ECHO OFF

set maven_bin="mvn"

FOUND = where %maven_bin%

if FOUND != 0 (

	set maven_bin="mvn.bat"
	FOUND = where %maven_bin%

	if FOUND != 0 (

		if defined %m2_home% (
			set maven_bin=%m2_home%\bin\mvn
		)
		else if defined %maven_home% (
			set maven_bin=%maven_home%\bin\mvn
		)
		else if defined %m2% (
			set maven_bin=%m2%\mvn
		)
		else (
			echo Failed to find maven.  Please ensure both maven and JDK 1.8+ are installed correctly on your system.
			exit 1
		)		
	)

)


echo Installing JOptimizer...
CHDIR joptimizer-bundle
call install-win.bat
CHDIR ..

echo Installing MetaOpt...
CHDIR metaopt
call %maven_bin% clean install
CHDIR ..

IF "%~1"=="--with-gurobi" (
	echo Installing Gurobi...
	CHDIR gurobi
	call install-win.bat

	echo Rebuilding metaopt using gurobi profile...
	CHDIR ..\metaopt 
	call %maven_bin% clean install -P gurobi
	CHDIR ..
)

echo Metaopt installed

