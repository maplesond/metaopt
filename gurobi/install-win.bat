
REM Assumes that $GUROBI_HOME and $GRB_LICENSE_FILE are set and that maven is installed and on the path

for /f "tokens=1,2 delims==" %%a in ('findstr /B VERSION %GRB_LICENSE_FILE%') do set GRB_VER_NAME=%%a&set GRB_VER=%%b

echo Found Gurobi Version: %GRB_VER%

if not "%GRB_VER%"=="6" (
	echo ERROR: Metaopt requires Gurobi Version 6
	set GUROBI_INSTALL_ERR=1
) else (
	call mvn install:install-file -Dfile=%GUROBI_HOME%/lib/gurobi.jar -DgroupId=gurobi -DartifactId=gurobi -Dversion=%GRB_VER% -Dpackaging=jar

	echo Added gurobi.jar to local maven repository.  Metaopt can now integrate with Gurobi optimiser

	REM compile, test and install the gurobi plugin to the local maven repo
	call %m2_home%\bin\mvn clean install
	
	set GUROBI_INSTALL_ERR=0
)
