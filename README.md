# Spring-ORM-using-Spring-MVC

A sample project using the Spring + ORM(hibernate) for a Spring MVC application(not the spring boot application).

# What can be learnt

1. Building a Spring MVC application from scratch using Maven-archetype-webapp project
  # Spring MVC application
   1. Creating the Dispatcher servlet(i.e Front controller) and the configuration file(Dispatcher servelet expects the configuration file while its creation)
   2. Setting up the View Resolver in the configuration file
  Note: In this pkg the config file -- SelExpLmsConfig.java
                        dispatcher servlet -- SelExpLmsInitalizer.java
   3. **Folder structure.. like when including the external dependencies say like CSS/JS/Images into the application**                     
   4. **Loading the multiple static resources **
    By default, the path in the **href attr for the link tag** is treated as **URL**.. So, there will be a GET request sent similar to the other APIs 
    unlike loading the css file, which leads to 404 err as there is no handler method defined in the controller. It is same for loading the files 
    present inside the webjars/an external file.
    
   So, to overcome the error we use the Resoruce Handlers in the configuration file. 
    
    For eg: In this project we tried to load the same bootstrap.min.css file present inside the webJars & seperately as the external css
    file present in the resources folder.
    
   ** Resource Location for the .css file is mentioned as "/webjars"... and this can be found from the pom.xml.** The group Id for this jar is "org.webjars".
    that means those css files will be present inside the webjars folder.

2. Mixing the Spring & ORM together.. which is the agenda of this project
   # ORM Things
   1. Autowiring the Session factory using the **LocalSessionFactoryBean class**
   2. Ideally, while creating the sessionFactory, we pass the config file. This config file contains the information
      2.1 Data source related
      2.2 Packages to be scanned
      2.3 Any other hibernate specific properties
