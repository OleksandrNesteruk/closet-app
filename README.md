#  Closet-app

Do you know how many cloth in your closet?And rarely ask yourself: `To which of my cloth this red shirt match?` Usually we have huge mess 
there and even don`t know what we have in our closet. This web application, helps you to store and manage information 
about your clothing, like closet in real life but much better, because you know what you have and what you need.

This restful web-app was written using Hibernate and SpringBoot frameworks. This app provides: `registration, authorization,
authentication` and also supports CRUD operations for working with relational database. Each new user is assigned a role
that gives access to specific functionality of app. 

#### User can use the following functionality:

- User can store and manage data about his clothing with CRUD operations:
- Add clothing to your closet; `POST: /closet/add-clothing`
- Update clothing in your closet; `PUT: /closet/update-clothing/{id}`
- Delete clothing from closet; `DELETE: /closet/delete-clothing/{id}`
- Get information about your closet; `GET: /closet/by-user`

#### Admin can use the following functionality:
- Admin can simply use dynamic CriteriaQuery in SpringBoot, which implemented by using Specification interface and strategy 
pattern.
- Also, implemented pagination and sorting feature. By default, size of items in one page is 20 and sorting by brand in ASC order.
You can sort by many parameters in different orders.
- Send GET request to fetch some filtering data.Here some examples:
  - to fetch all black and white cloth with brands adidas and puma:   `/clothing?colorIn=black,white&brandIn=adidas,puma`
  - to fetch all cloth, where Set< Season > seasons = winter, summer: 
`/clothing?seasonIn=winter,summer`
  - to fetch all red cloth with price between 100 and 1000. Also sorting by brand in DESC and price in ASC with 5 items in one page:
`/clothing?colorIn=red&priceIn=100,1000&sortBy=brand:DESC;price:ASC&size=5`
- From filtering examples, you can see how to use CriteriaQuery and dynamically write your own query. 
Also, it is easy to expand the numbers of parameters to search data.  
## Structure
#### Project has a three-tier architecture:
- Repository(DAO) layer: works with database.
- Controllers layer: handling requests and responses.
- Service layer: include business logic.

## Database structure
![database.png](database.png)

## Used technologies
* Java(11);
* Apache Tomcat;
* Maven, Lombok, Mapstruct;
* MySQL, SQL;
* Hibernate, JPA;
* Spring Core, MVC, Security;
* SpringBoot;
* Strategy pattern, SOLID principals, REST;

## Launch
1. Clone or download repository;
2. Create schema named `closet` in MySQL;
3. Add your database URL, username, password and JDBC driver into corresponding fields in `src/main/resources/application.properties`;
4. You can inject custom data in `src/main/java/springboot.garderobapp/init/DataInitializer`.
5. Run the application.

