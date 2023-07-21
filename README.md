# Spring-ORM-using-Spring-MVC
A LMS(Learning Management System project) built using the Spring MVC + ORM framework(Hibernate) + Bootstrap.
# What can be learnt

1. Building a Spring MVC application from scratch using Maven-archetype-webapp project(as its a web application).
2. The flow sequence starting from the JSP to DB. In breief way..
      **JSP -> Controller -> Service(Contains the actual business Logic) --> DAO(Methods that interact with the DB)**
3. Usage of DTO(Note: These DTO are created using new keyword in Java files..)
4. Mixing the Spring & ORM together.. which is the agenda of this project
  # Spring MVC Things
  
   1. Creating the **Dispatcher servlet**(i.e Front controller) and the configuration file(Dispatcher servelet expects the configuration file while its creation)
   2. Setting up the **View Resolver** in the configuration file
           Note: In this pkg the config file -- SelExpLmsConfig.java
                        dispatcher servlet -- SelExpLmsInitalizer.java
   3. **Folder structure.. like when including the external dependencies say like CSS/JS/Images into the application**                     
   4. **Loading the multiple static resources** 
        By default, the path in the **href attr for the link tag** is treated as **URL**.. So, there will be a GET request sent similar to the other APIs 
        unlike loading the css file, which leads to 404 err as there is no handler method defined in the controller. It is same for loading the files 
        present inside the webjars/an external file.
      
        So, to overcome the error we use the Resoruce Handlers in the configuration file. 
        For eg: In this project we tried to load the same bootstrap.min.css file present inside the webJars & seperately as the external css
        file present in the resources folder.
    
        ** Resource Location for the .css file is mentioned as "/webjars"... and this can be found from the pom.xml.** The group Id for this jar is "org.webjars".
           that means those css files will be present inside the webjars folder.
   6. Usage of **#Spring MVC Form tags** inside the JSP
            i.e path & modelAttribute
   7. **Loading and retreiving the values into Session**
                          @SessionAttributes -- CourseController.java
                          
             Ideally a each instructor will have one/multiple courses and each course has one/multiple lessons. W.r.t view phase, each lesson page will be
             containing a video surrounded by Previous & Next buttons which requires basic information like .. Total no of lessons & first Lesson Number
            Last lesson number assigned for that course in the DB to display or hide those buttons times of need.

            To have the above details accessible across multiple pages, we used **LessonDTO**(a data transfer object instead of exposing the originial entity)
            and @SessionAttributes annotation to make this DTO available across the session.
   # ORM Things
   1. Unlike creating directly the Session Factory similar to native hibernate application, in Spring-ORM, there multiple FactoryBean available to provide the
       SessionFactory to us.
      Note: In this application, we used one such FactoryBean called **LocalSessionFactoryBean** to create the SessionFactory. Read the Description of
            **LocalSessionFactoryBean** class to understand more. Use ctrl+Click.
            
   2. Ideally, while creating the sessionFactory, we pass the config file. This config file contains the information
      2.1 Data source related -- this will help to connect to the DB
      2.2 Packages to be scanned -- These pkg contains the entities(i.e Java tables which are templates for the DB tables) used for transferring the data from DB to Java
      2.3 Any other hibernate specific properties like.. **hibernate.format.sql** .. etc,

      So, we pass these inputs while creating this bean -- Refer **SelExpLmsConfig.java**
      
   3. Usage of **HibernateTransactionManager**, to avoid manual begin and commiting the transaction while performing the DB Operation.
       Note: We use  @EnableTransactionManagement annotation. Refer -- SelExpLmsConfig.java 

  # Hibernate Things
   1. What's a transaction?
   2. Hibernate Properties
   3. Concepts of Entities, Relationships like One-to-Many, Many-to-One, Transactions.
   4. Technically speaking.. annotations like @Entity, @Id, @OneToMany, @ManyToOne, @Table, @Column etc.,
   5. 
