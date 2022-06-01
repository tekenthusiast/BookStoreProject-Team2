##Higher level overview

This project includes two web services. One service, found in the `com.client.company.hr` package, consumes a second web service,
found in the `com.comany.hr` package. Both web services are spring-boot based REST services, and both use
maven for managing dependencies.

The entry point for the Client web service is the `ClientApplication.java` class. On the other hand,
the entry point for server is the `Application.java` class. These are the main classes of the services. They each contain
a `public static void main()` method that starts up the Spring Application context. While running a spring application, 
if the main application class is not specified, Spring will search for a main class in the class path. It will fail to 
start if it can't find any main class or finds multiple ones.

Detailed information about spring boot can be found [here](`https://www.baeldung.com/spring-boot-start`)

###Annotations and Configurations

While the Spring Application context starts up, it looks for any spring annotated classes
and adds every annotated class to the application context. Here are some common spring annotations:
  - `@Configuration`: Tells spring that this is a Spring configuration class. They're used by spring containers
    as a source of bean definitions.
  - `@Service`: Tells spring that this class contains bussiness logic.
  - `@Bean`: Indicates that a class is a Spring bean. This annotation is a method-level annotation.
  - `@Component`: A class-level annotation equivalent of `@Bean`
  - `@Controller`: A class-level annotation that is a specialization of `@Component`. It marks a 
    class as a web request handler.
  - `@Repository`: Data Access Objects can be annotated with `@Repository`(A class-level annotation)  

Spring provides annotation-based auto-wiring(dependency injection) via the `@Autowired` annotation. 
More information about spring annotations can be found [here](https://www.baeldung.com/spring-boot-annotations
)

A YAML configuration file is one of the most common ways of configuring Spring applications such as server configurations.
Different configurations can be provided for different profiles. 

For example, application-client.yml is a yml configuration
for the Client application. When running the Client Application, we have to specify the name of the spring profile(client).
On the other hand, the Server Application is configured by application.yml. We don't need to specify anything when running 
the server because it uses the default profile and automatically picks up the configurations in application.yml.
More information about YAML configurations and configuration properties can be found [here](https://www.baeldung.com/spring-yaml)
and [here](https://www.baeldung.com/configuration-properties-in-spring-boot)

### Embedded web servers
Spring boot applications come with embedded web servers. Tomcat is the default
embedded web server for many spring boot starters. However, it is possible to modify 
the `pom.xml` file and use other embedded containers such as jettty or undertow.
More details can be found [here](https://www.baeldung.com/spring-boot-servlet-containers)

### Dependency management
Dependencies are managed by maven and configured inside the `pom.xml` file. Details about dependency management
and adding new dependencies to your existing maven project can be found [here](https://maven.apache.org/guides/introduction/introduction-to-dependency-mechanism.html)

`Feign` and `Swagger` are two dependencies used in the two spring boot applications in this project. The client
application uses the `Feign` dependency added in the pom.xml file while the server uses the `Swagger` dependency.

####Feign
Feign is a library that will help your service connect to http APIs with minimal overhead and with customizable decoders(for decording the http response)
and error handling. It's an Http client binder inspired by Retrofit, JAXRS-2.0, and Web Socket.
It uses tools like Jersy and CXF to write java clients for REST or SOAP services. More information about
the open-feign project can be found [here](https://github.com/OpenFeign/feign).

####Swagger
Swagger 2 is an open source project used to describe and document RESTful APIs. it's language
agnostic. It will generate HTML, JavaScript and CSS files to dynamically generate
documentation from a Swagger-compliant API. The swagger ui project will bundle these files
and visualize the API on the browser.


## How to run the services

Before you can run the services, make sure you have the following pre-requisites:
   - Java 11 is installed and correctly configured into your IDE
   - Maven is installed
   - IntelliJ(preferred not required)

To build the project via the command line, execute `mvn clean install` under
the root project directories.

####Running the server
Right click on `com.company.hr.Application` and click on 'Run'. you can also run it via the command line
using this command `mvn spring-boot:run`

There's no need to specify any profile while running the server. It will run using the 'default' profile and automatically
pick up configurations inside of the application.yml

####Running the client

Before running the client application, make sure the server application is running. 
You can run the client application by executing the following maven command under the client
project's root directory:
`mvn spring-boot:run -Dspring.profiles.active=client`.

To run the client application using IntelliJ, you'll first need to configure IntelliJ so that it
picks up the right profile(client) and reads the right configuration yml file(application-client.yml).
This configuration file specifies the port that the client application should listen on(which should be different
to that of the server).

To modify the profile in IntelliJ:
`Run" -> "Edit Configurations", then add '-Dspring.profiles.active=client'
as a VM Option for the ClientApplication.`

Once the correct profile is configured, Right click on `ClientApplication.java` found under the
`com.client.company.hr` package and click on `Run`.

