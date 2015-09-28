REM installs joptimizer into the local maven repository

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
                        echo Failed to find maven.  Please ensure both maven and JDK 1.8+ are installed correctly on your s
ystem.
                        exit 1
                )
        )

)


call %maven_bin% install:install-file -DgroupId=joptimizer -DartifactId=joptimizer -Dversion=3.4.0 -Dpackaging=jar -Dfile=joptimizer-3.4.0.jar -DpomFile=joptimizer-3.4.0.pom


