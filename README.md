# E34 Selenium Workshop 
Please note: we are providing this software as is. No warranties given. If you have questions please file a ticket on Github. 

## set java version to java8 in case you are using Selenium3 
export JAVA_HOME=`/usr/libexec/java_home -v 1.8`
OR
JAVA_HOME=$(/usr/libexec/java_home)


## Selenium Grid startup 
Please download the selenium jar from seleniumhq.org and replace the version number by the current one in the command below. 
HUB
java -jar selenium-server-standalone-3.0.0.jar -role hub -hubConfig ~/IdeaProjects/e34-selenium-workshop/testngXmlFiles/hubConfig.json

NODE
java -jar selenium-server-standalone-3.0.0.jar -role node -nodeConfig ~/IdeaProjects/e34-selenium-workshop/testngXmlFiles/nodeConfig.json


## A sample application can be found at https://github.com/e34s/hustefapp 
In order to build the application please clone the repository and execute `mvn package`. This will create a war file in the target directory. If you are using docker you can use the 
following command to copy the war file to the tomcat docker container (with the name tomcat-hustef): 
`docker cp target/e34app.war tomcat-hustef:/usr/local/tomcat/webapps/e34app.war`
