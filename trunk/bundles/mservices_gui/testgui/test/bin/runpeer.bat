@echo off

set XARGS=init-win

if not "%1" == "" set XARGS=%1

java -Dorg.knopflerfish.gosg.jars="file:%MAVEN_HOME%\.maven\\repository\\" -jar "%MAVEN_HOME%\.maven\repository\osgi\jars\framework-1.3.0-aop.jar" -xargs %XARGS%.xargs
