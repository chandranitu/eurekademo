# Microservices

#Postman is required
#Zuul gateway no longer working .Inplace of this Spring cloud gateway

http://localhost:8761/ eureka server
http://localhost:8082  backoffice
http://localhost:8081   user
http://localhost:8085   cloud gateway

http://localhost:8082/backoffice/status     test order status
http://localhost:8081/user/status     test user status

#Docker image

docker build -t eurekademo .
docker run -d --name eureka -p 8761:8761  eurekademo

docker build -t user .
docker run -d --name user -p 8081:8081 user

docker build -t backoffice .
docker run -d --name backoffice -p 8082:8082 backoffice

####################### Get and post
Method: GET
http://localhost:8081/backoffice/status
http://localhost:8081/user/data

Method: post
http://localhost:8081/user/data
http://localhost:8081/user/data?key=chandra&value=kumar
key = testkey
value = testvalue

Method: put
http://localhost:8081/user/data
key = testkey
value = updatevalue

Method: delete
http://localhost:8081/user/data
key = testkey


#cloud gateway--------
http://localhost:8085/actuator  
http://localhost:8085/userservice/status
http://localhost:8085/backoffice/status  
#post via gateway
http://localhost:8085/backoffice/bo-save  

{
    "id": "12",
    "rfid": "684955886339",	
    "vehicle_number": "DA4AC4DD",
    "location": "delhi",	
    "price": "30"   
}


#backoffice

http://localhost:8082/backoffice/status    #get

http://localhost:8082/backoffice/bo-save   #post

{
    "id": "2",
    "rfid": "684955886339",	
    "vehicle_number": "DA4AC4DD",
    "location": "delhi",	
    "price": "30"   
}

Basic authentication in postman while sending request- admin/admin123


#mongo
docker run -d --name mongo_db -e MONGO_INITDB_ROOT_USERNAME=admin -e MONGO_INITDB_ROOT_PASSWORD=admin123 -e MONGO_INITDB_DATABASE=test -p 27017:27017 mongo

docker exec -it  mongo_db bash

--windows
 >mongo
 --Linux/Unix
 >mongosh

--in docker container - 
use admin
db.auth( 'admin', 'admin123' )
db.createUser({user: "testUser", pwd: "testUser", roles : [{role: "readWrite", db: "test"}]});

use mydatabase
show dbs
show collections
db.test123.find();

db.createCollection("login");
db.login.insert({"login" : "chandra"});
db.login.insert({"pass" : "chandra"});
db.createCollection("login", user)
db.login.find();
db.COLLECTION_NAME.drop()
db.test.drop()

#misc
create table company(id int,name varchar(50),location varchar(50));
insert into company values (1,'infosys','banglore');
insert into company values (2,'wipro','noida');



1 | 684955886339 | 625145 | Kimberly Molina | 599 Taylor Rest Suite 561    +| DA4AC4DD       |       10000.00 | oneXL         |               |      50.00 | Murphy, Elliott and Williams  | (693)846-0007          | 1991-08-22 00:00:00
    |              |        |                 | West Richard, VA 02469        |                |                |               |               |            |                               |                        | 
  2 | 017201843109 | 643966 | Thomas Osborne  | 3135 Carlos Stream           +| C0B20ACB       |        5000.00 | threeXL       |               |     100.00 | Rangel Inc                    | (642)791-2291x51224    | 1976-07-24 00:00:00
    |              |        |                 | Brianview, PR 13999           |                |                |               |               |            |                               |                        | 
  3 | 004611267403 | 330932 | Kristin Fisher  | 616 Katie Way                +| 1DD2A402       |        8000.00 | twoXL         |               |     120.00 | Anderson, Heath and Christian | 241.554.6222x82256     | 1987-09-07 00:00:00
    |              |        |                 | Jackfort, VT 54563            |                |                |               |               |            |                               |                        | 
  4 | 911444449001 | 828688 | Jodi Conner     | 9257 Olson Island            +| 3A40A340       |        4000.00 | twoXL         |               |      30.00 | Davis-Roberson                | 001-498-908-0910x71906 | 1972-05-22 00:00:00
    |              |        |                 | Bettymouth, NJ 92143          |                |                |               |               |            |                               |                        | 
  5 | 345359756992 | 688448 | Russell Harmon  | 9044 Wade Grove Apt. 584     +| 42D11141       |        2000.00 | twoXL         |               |     100.00 | Bennett-Reynolds              | 898-639-4273x6305      | 1977-06-19 00:00:00
    |              |        |                 | West Michaelchester, PA 42287 |                |                |               |               |            |                               |                        | 
(5 rows)
