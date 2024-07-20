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



#user
kicklock
http://localhost:8081/user/status     user status
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
http://localhost:8083/switch/status    #get



#TMS  Fake Data 

http://localhost:8086/switch/status    #get



#Mongo ---------------
docker run -d --name mongo_db -e MONGO_INITDB_ROOT_USERNAME=admin -e MONGO_INITDB_ROOT_PASSWORD=admin123 -e MONGO_INITDB_DATABASE=test -p 27017:27017 mongo

docker exec -it  mongo_db bash

-- windows client for CMD
 >mongo
-- Linux/Unix  client for CMD
 >mongosh

--In docker container - 
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

#keycloak
# docker compose has changed in ubuntu 24 (docker compose NOT docker-compose)
docker compose -f docker-compose-keyCloak.yml up -d

#postgres
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

