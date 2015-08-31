echo Installing JOptimizer...
cd joptimizer-bundle
call install-win.bat
echo JOptimizer installed to local maven repo

echo Installing MetaOpt...
cd ..\metaopt
call %m2_home%\bin\mvn clean install
cd ..

if "%~1"=="--with-gurobi" (
	echo Installing Gurobi...
	cd gurobi
	call install-win.bat 
	cd ..

	if "%GUROBI_INSTALL_ERR"=="0" (
		echo Rebuilding metaopt using gurobi profile...
		cd ..\metaopt 
		call %m2_home%\bin\mvn clean install -P gurobi
		echo Metaopt installed to local maven repo with gurobi support
	) else (
		echo ERROR: Metaopt did not install correctly due to problem installing gurobi plugin
	)
) else (
	echo Metaopt installed to local maven repo
)



