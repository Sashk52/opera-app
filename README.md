Opera
Project emulates work of opera.
User can choose and book performances according available in particular time-slot.
Shopping-cart, orders and ticket entities match real-time booking.
Authentication

In this project used N-tier architecture with DB layer, DAO layer, Service layer, Controllers layer and View layer.
Project was developed according to SOLID principles with authorization and authentication.

Technologies used

backend: Java, Spring Core/MVC/Security, Hibernate, Jackson, Tomcat
database: MySQL
To start the project you need:

    1.Download and install the JDK
    2.Download and install servlet container (for example Apache Tomcat)
    3.Download and install MySQL Server
    4.Create new db according dp.prorepties file. 
    4.Setup new connection with
        user: "your username"
        password: "your password"
        url: jdbc:mysql://"your host name":"your port"/"your name db"?useUnicode=true&serverTimezone=UTC
    5. Setup initial roles in InjectData (controllers package)
    6. Run a project
