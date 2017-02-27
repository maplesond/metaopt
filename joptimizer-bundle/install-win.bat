REM installs joptimizer into the local maven repository
@ECHO OFF

set maven_bin="mvn"
set errorlevel=0
where %maven_bin%

if %ERRORLEVEL% NEQ 0 (
	echo gibbs
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

call %maven_bin% install:install-file -DgroupId=joptimizer -DartifactId=joptimizer -Dversion=3.4.0 -Dpackaging=jar -Dfile=joptimizer-3.4.0.jar -DpomFile=joptimizer-3.4.0.pom


