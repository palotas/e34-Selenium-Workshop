# seleniumtraining

## set java version to java8
export JAVA_HOME=`/usr/libexec/java_home -v 1.8`


# HUSTEF High level agenda 
1. Introduction to Selenium 
- the story behind Selenium 
- what is Selenium? 
- what is it not?  
- Selenium 3

(30 minutes) 


2. Selenium and TestNG / JUnit 
- show first TestNG test (test1) 
- talk about assertTrue and assertEquals 
- change to assertEquals 

- add @BeforeTest method 
- dependent test 
- add another dependent test 
- data provider 
(20 minutes) 

3. Selenium API 
- firstTest (open a regular page) 
- page title test 
- findelement test 
- countNavEntries 
- Scroll
- navigation test 
- implicit wait 
- explicit wait 
(30 minutes) 


4. RemoteWebdriver 
- remote webdriver 
- desired capabilties 

5. Page Objects

6. Misc
- data provider Test 



Topics covered:
Introduction and current trends in test automation
Selenium: an overview of Selenium / Webdriver and Selenium Grid
Where to use Selenium and where not
The Selenium protocol
Selenium in conjunction with test frameworks like JUnit and TestNG
Testing dynamic pages with Selenium
Easy maintenance with Page Objects
Reporting
Mobile automation with Selenium
Selenium in the future


## copy war file to tomcat docker container 
docker cp target/hustefapp.war grave_poincare:/usr/local/tomcat/webapps/hustef.war


## To start remote selenium server
- put IEDriverServer.exe into the same directory as selenium-server-standalone-2.46.0.jar
- from terminal window start sever as follows: java -jar selenium-server-standalone-2.46.0.jar -Dwebdriver.ie.driver=IEDriverServer.exe


## Grid startup
- Node: java -jar selenium-server-standalone-2.46.0.jar -role wd -nodeConfig "C:\Users\Michael Palotas\Desktop\seleniumtraining\nodeconfigs\nodeConfigWinIEFirefox.json" -hub http://localhost:4444/grid/register -Dwebdriver.ie.driver=IEDriverServer.exe
