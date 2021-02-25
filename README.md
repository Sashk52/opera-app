# Opera
Project emulates work of opera.
User can choose and book performances according available in particular time-slot.
Shopping-cart, orders and ticket entities match real-time booking.

In this project used N-tier architecture with DB layer, DAO layer, Service layer, Controllers layer and View layer.
Project was developed according to SOLID principles with authorization and authentication.

Opera client can perform the following actions:

* register on the opera's website;
* log in and out;
* look through the available performence;
* book performance to own cart;
* place orders.

Admins in their turn can:

* view all registered users;
* view all registered performances;
* view all registered stages;
* view all registered performances sessions;
* delete users from the database;
* view all orders placed at the opera;


## Technologies used

### Backend
JDK 14, Spring Core/MVC/Security, Hibernate, Jackson, Tomcat, Maven
### Database 
MySQL

__To start the project you need:__ 

1. Download and install the JDK
2. Download and install servlet container (for example Apache Tomcat)
3. Download and install MySQL Server
4. Create new db according dp.prorepties file. 
5. Setup new connection with
        user: "your username"
        password: "your password"
        url: jdbc:mysql://"your host name":"your port"/"your name db"?useUnicode=true&serverTimezone=UTC
6.  Run a project
