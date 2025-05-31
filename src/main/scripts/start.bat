@echo off
setlocal
set DIR=%~dp0
"%DIR%\..\jre\bin\java" -jar "%DIR%\..\libs\TCPSimulator.jar"
