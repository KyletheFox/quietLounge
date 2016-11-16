#The Quiet Lounge API#
*Software Design Class Project*

**About:**
As many of you know, there are tons of distractions when you are at college. Getting you school work done can be challenging. This project is designed to help you. The goal of this app is too help students find a quiet space to study and get their home work done. 

**How it Works:**
This project creates a web API that accept HTTP requests that contain the last known decible levels of specific locations. Any device that has the abiltiy to send such a request will be able to access the data and insert new data. The request sends the device a JSON object with last recorded sound level and there cooresponding latitude and longitude cooridnates.

**Disclamer:**
This repo only contains the web API part of our project. To interact with the web API, our team built an Android App to interact with users. You can view that repo at https://github.com/hongul/Quiet_Lounge.

**Details**
This project is run and deployed as a Spring Boot Application. For those unfairmilar with this type of project, it basically allows your program to configure the server that war file is deployed on. To complie and run this project on your local machine, I suggest using Eclipse. That was the platform I built this project in.

###Steps To Build##
1. Download/clone/fork repo.
2. Open Eclipse.
3. Make sure you have the "The Spring Tool Suite™ (STS) for ECLIPSE 3.8.2.RELEASE" plugin installed.
4. Import the repo as "Existing Maven Project".
5. Right click the quiteLoungeApp folder and download the source files: Maven -> Download Source
6. Right click the project root folder again and run as "Spring Boot App": Run As -> Spring Boot App
7. Server is now up and running (Most likely on localhost:8080)
8. You can now make HTTP requests to the server to insert/get the data

**Tutorial**
There are 3 different requests that this service can handle.

1. host/getLoungeData "GET"
	-- Gets the most recent data of the lounges that are being tracked
2. host/inputSound "POST"
	-- Takes 3 Params (lat,lng and sound)
	-- Inserts new data into the system. The latitude and longitude position must be within a certain distance for the data to be added to the database
3. host/ping "GET"
	-- Simple test to make sure server is up and running

***For those that don't want to build the project yourself, there is a public endpoint set up for you to interact with. http://quietlounge.us-east-1.elasticbeanstalk.com

