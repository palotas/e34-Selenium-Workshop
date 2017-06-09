# JENKINS 
jenkins is installed on vm-105.element34.net
/home/e34/demo.jenkins.sh

Jenkins container: demo_jenkins
Volume Container: jenkins_volume

## set java version to java8 in case you are using Selenium3 
export JAVA_HOME=`/usr/libexec/java_home -v 1.8`
OR
JAVA_HOME=$(/usr/libexec/java_home)
