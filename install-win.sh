REM installs metaopt and dependencies into the local maven repository
@ECHO OFF
echo.

set maven_bin="mvn"
set errorlevel=0
where %maven_bin%

if %ERRORLEVEL% NEQ 0 (
	set maven_bin="mvn.bat"	
	where %maven_bin%	
	if %ERRORLEVEL% NEQ 0 (

		if defined m2_home (
			set maven_bin=%m2_home%\bin\mvn
		) else if defined maven_home (
			set maven_bin=%maven_home%\bin\mvn
		) else if defined m2 (
			set maven_bin=%m2%\mvn
		) else (
			echo Failed to find maven.  Please ensure both maven and JDK 1.8+ are installed correctly on your system.
			exit 1
		)	
	)
)

echo Detected maven executable successfully
echo.
echo.
echo Installing MetaOpt...
cd ..\metaopt
call %maven_bin% clean install
cd ..

if "%~1"=="--with-gurobi" (
	echo Installing Gurobi...
	cd gurobi
	call install-win.bat 
	cd ..

	if "%GUROBI_INSTALL_ERR"=="0" (
		echo Rebuilding metaopt using gurobi profile...
		cd ..\metaopt 
		call %maven_bin% clean install -P gurobi
		echo Metaopt installed to local maven repo with gurobi support
	) else (
		echo ERROR: Metaopt did not install correctly due to problem installing gurobi plugin
	)
) else (
	echo Metaopt installed to local maven repo
)

