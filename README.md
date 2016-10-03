# seleniumtraining

## set java version to java8
export JAVA_HOME=`/usr/libexec/java_home -v 1.8`


# HUSTEF High level agenda 
1. Introduction to Selenium 
- the story behind Selenium 
- what is Selenium? 
- what is it not?  


2. Selenium and TestNG / JUnit 
- show first TestNG test (test1) 
- talk about assertTrue and assertEquals 
- change to assertEquals 

- add @BeforeTest method 
- dependent test 
- add another dependent test 
- data provider 

- navigation test 






## To start remote selenium server
- put IEDriverServer.exe into the same directory as selenium-server-standalone-2.46.0.jar
- from terminal window start sever as follows: java -jar selenium-server-standalone-2.46.0.jar -Dwebdriver.ie.driver=IEDriverServer.exe


## Grid startup
- Node: java -jar selenium-server-standalone-2.46.0.jar -role wd -nodeConfig "C:\Users\Michael Palotas\Desktop\seleniumtraining\nodeconfigs\nodeConfigWinIEFirefox.json" -hub http://localhost:4444/grid/register -Dwebdriver.ie.driver=IEDriverServer.exe
