# SimpleCounter

# Author notes
Set up using a simple maven web project archetype.

# Prerequisites

Needs Java 8, Maven at minimum.

# Build and Execute

To build the program:(tested on windows)
```
$ mvn clean install
```
To run the application using an embedded Jetty Server.
```
$ mvn -DskipTests=true test -Pjetty-run
```
Application can be accessed at http://localhost:8080/index.jsp
