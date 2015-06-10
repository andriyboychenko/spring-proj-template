set JBOSS_HOME=C:\jboss-as-7.1.1.Final

call mvn clean install

cd target
copy spring-proj-template-0.0.1-SNAPSHOT.war "%JBOSS_HOME%\standalone\deployments"
cd "%JBOSS_HOME%\bin"
standalone.bat