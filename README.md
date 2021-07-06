# Stream

New features Java 8 e coisas legais sobre Java

## Install

````
Java Home - Variável
export JAVA_HOME="/home/gustavo/dev-tools/java/amazon-corretto-8.292.10.1-linux-x64"
export PATH=$JAVA_HOME/bin:$PATH

Gradle
https://gradle.org/install/ - gradle-7.1.1-bin.zip
$ sudo apt purge gradle                              <- Remove old versions
$ mkdir /opt/gradle
$ unzip -d /opt/gradle gradle-7.1.1-bin.zip
$ ls /opt/gradle/gradle-7.1.1
$ export PATH=$PATH:/opt/gradle/gradle-7.1.1/bin    <- Add on the path
$ gradle -v                                         <- Show Version
$ gradle wrapper                                    <- No projeto ele força a utilizar essa versão de gradle, ele cria um binário do gradle
$ ./gradlew -v                                      <- Descobre a versão do gradle utilizada no projeto

Maven
https://maven.apache.org/download.cgi - apache-maven-3.8.1-bin.zip
$ sudo apt purge maven                              <- Remove old versions
$ sudo mkdir /opt/maven
$ sudo unzip -d /opt/maven apache-maven-3.8.1-bin.zip
$ export PATH=$PATH:/opt/maven/apache-maven-3.8.1/bin    <- Add on the path
$ mvn -N io.takari:maven:wrapper
$ ./mvnw -v

Spring
https://start.spring.io/
java -jar exemplo-maven-0.0.1-SNAPSHOT.jar          <- Start do projeto, verificar pasta target
````

## About

````
````