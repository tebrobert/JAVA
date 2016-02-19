@echo off
cls

javac -encoding "UTF-8" Test.java
if exist Test.class java Test

del *.class
