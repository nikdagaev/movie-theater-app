<h1>Movie theater app</h1>

<img src="https://emke.uwm.edu/wp-content/uploads/2019/01/SL-102.jpg" alt=""> <hr>

## What is the purpose of this project?
The main purpose of this project is to implement a Movie theater app.

This simple app allows you to add cinema halls, movies, movie sessions, users, shopping carts and assign it to users.

This app implements an N-tier architecture including the following layers:
* DB
* DAO layer
* Service layer
* Controllers layer
<hr>

## How to launch this app:
1. To run the project on your PC, clone it into your local directory and then open it in an IDE.
2. Install MySQL and MySQL Workbench, configure connection to your database by editing _db.properties_ file: <br>
   **YOUR_DRIVER:** _com.mysql.cj.jdbc.Driver_ or any other suitable driver <br>
   **YOUR_URL:** _jdbc:mysql://localhost:3306/<b>database_name</b>?serverTimezone=UTC_ <br>
   **YOUR_LOGIN:** MySQL username <br>
   **YOUR_PASSWORD:** MySQL password <br>
   
4. Configure TomCat Local server (_Add New Configuration_ -> _TomCat Server_ -> _Local_ -> _Fix_ -> _cinema:war exploded_ -> set _Application context_ to "/" -> _OK_).
5. Admin and user will be added by default in DataInitializer.<br><br>
   
   **User: user@theater.ua Password: user111** <br>
   Available: /register <br>
   Get: /cinema-halls, /movies, /movie-sessions/, /orders, /shopping-carts <br>
   Post: /orders, /shopping-carts <br><br>
   **Admin: admin@theater.ua pass: admin111** <br>
   Available: /register <br>
   Get: /cinema-halls, /movies, /movie-sessions/, /users/<br>
   Post: /cinema-halls, /movies, /movie-sessions/<br>
   Put, Delete: /movie-sessions/<br>
6. Run your project.
<hr>

## Technologies used
- Apache Tomcat (version 8.5.69)
- MySQL
- Hibernate
- Spring MVC
- Spring Security
- Spring Core
- Maven
  
  <hr>
