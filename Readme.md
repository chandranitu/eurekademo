# Microservices orchestration and Management
----------------------------------------------------

#Postman is required
#Zuul gateway no longer working for spring 3.x.Inplace of this we will use Spring cloud gateway for API call 

http://localhost:8761 eureka server
http://localhost:8081   user
http://localhost:8082  backoffice
http://localhost:8083   switch
http://localhost:8084   Admin
http://localhost:8085   cloud gateway API
http://localhost:8086   TMS fake data
http://localhost:8080   keycloak

#Have to capture
Accounting
gis ,geo fencing
reporting
voilation
ola research
cockpit centralize dashboard
Keycloak
--------------

#Eureka server
http://localhost:8761

#Docker image build

docker build -t eurekademo .
docker run -d --name eureka -p 8761:8761  eurekademo

docker build -t user .
docker run -d --name user -p 8081:8081 user

docker build -t backoffice .
docker run -d --name backoffice -p 8082:8082 backoffice


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

#Admin
http://localhost:8084/admin/status    #get


#swagger

http://localhost:8081/swagger-ui/index.html

#user

http://localhost:8081/userservice/status     user status


#Method: post   save

http://localhost:8081/userservice/data?key=xyz&value=asdad&roles=admin  -- working

http://localhost:8081/userservice/data
paste in raw
{
    "key": "quantum",
    "value": "password123",
    "roles": [
       {
        "elementOne":"valueOne"
       },
       {
        "elementTwo":"valueTwo"
       }
       ]
}

{
      "address": "colombo",
      "username": "hesh",
      "password": "123",
      "registetedDate": "2015-4-3",
      "firstname": "hesh",
      "contactNo": "07762",
      "accountNo": "16161",
      "lastName": "jay",         
      "listName":[
       {
        "elementOne":"valueOne"
       },
       {
        "elementTwo":"valueTwo"
       },
       ...]
     }



#Method: put  modify
http://localhost:8081/user/data


#Method: delete
http://localhost:8081/user/data?key=chandra



{
    "roles": ["ADMIN", "USER"]
}

{
    "_id": "1",
    "username": "john_doe",
    "password": "password123",
    "roles": ["ADMIN", "USER"]
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

Method: GET
http://localhost:8082/backoffice/status

-- Basic authentication in postman while sending request- admin/admin123



#switch
-- Mongo table-vehicle
http://localhost:8083/switch/status    #get
-- Run vehicle.py before working. It will insert vehicle data in mongo DB

43DC1D4B

#TMS  Fake Data 

http://localhost:8086/switch/status    #get



#Mongo ---------------
docker run -d --name mongo -e MONGO_INITDB_ROOT_USERNAME=admin -e MONGO_INITDB_ROOT_PASSWORD=admin123 -e MONGO_INITDB_DATABASE=test -p 27017:27017 mongo

docker exec -it  mongo bash

-- windows client for CMD
 >mongo
-- Linux/Unix  client for CMD
 >mongosh

--In docker container - 
use admin
db.auth( 'admin', 'admin123' )

use test;
db.createUser({
  user: "testUser",
  pwd: "testUser",
  roles: [{ role: "dbAdmin", db: "test" },
  { role: "readWrite", db: "test" }   ]
})

db.getUsers()

use test
db.auth( 'testUser', 'testUser' )


use mydatabase
show dbs
show collections
db.users.find();
db.vehicle.find();

db.createCollection("login");
db.login.insert({"login" : "chandra"});
db.login.insert({"pass" : "chandra"});
db.createCollection("login", user)
db.login.find();
db.COLLECTION_NAME.drop()
db.test.drop()

#keycloak  #postgres

# docker compose has changed in ubuntu 24 (docker compose NOT docker-compose)
docker compose -f docker-compose-keyCloak.yml up -d


http://localhost:8080/
http://192.168.68.118:8080
https://192.168.68.118:8443
http://192.168.1.22:8080
admin/Admin@1234

create database keycloak_db;
CREATE USER keycloak WITH PASSWORD 'keycloak@123';
GRANT ALL PRIVILEGES ON DATABASE "keycloak_db" to keycloak;

.env file
------------------
POSTGRES_DB=keycloak_db
POSTGRES_USER=keycloak
POSTGRES_PASSWORD=keycloak@123
KEYCLOAK_ADMIN=admin
KEYCLOAK_ADMIN_PASSWORD=Admin@1234


