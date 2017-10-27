# AWS

AWS extension
======================

The repository contains the source code for a web application which is accessible over public internet.<br/>
The application uses various aws features and is a highly available, highly scalable, cost effective solution

•	University Name: http://www.sjsu.edu/<br/>
•	Course: Cloud Technologies<br/>
•	Professor Sanjay Garje<br/>
•	ISA: Divyankitha Urs<br/>
•	Student: https://www.linkedin.com/in/himangini-agrawal-6a344029

Introduction
============================
The idea of my application is to give user a reliable, scalable, secure and highly performing infrastructure for the most demanding features of AWS. Extremely available and highly scalable web hosting is usually a complex and expensive proposition. My Application provides Cloud Storage, File Synchronization and Personal Cloud features. The user can keep safe and secured data without much hassle using very simple GUI features maintaining a repository in cloud, saving the cost of high end hardware requirements.
Application creates a database for the registered users, where users maintain their folders contents to which are then synchronized with AWS features. App users are given unlimited storage leveraging all the amazon features. 

Feature List
---
1.	S3<br/>
Scope of application is limited to the registered users, where user once logged in can manage their S3 bucket giving functionalities such as – <br/>
•	Upload files to S3 bucket (also tracking the user details)<br/>
•	Download files which are already present in the bucket<br/>
•	Delete the not required files from S3 bucket<br/>
•	User details and date and time are tracked against all operations<br/>
2.	EC2<br/>
Application uses EC2 features for web hosting and has auto scaling implemented for the purposes of instance scaling and management. 
Elastic Load Balancing is applied across EC2 instances to distribute incoming traffic and increase fault tolerance.
3.	CloudFront<br/>
CloudFront is configured to speeds up the distribution of dynamic web content to all the users worldwide
4.	S3 Transfer Acceleration<br/>
Bucket created in the application uses S3 Transfer Acceleration to make customers upload to a centralized bucket from all over the world
5.	Route53<br/>
Application uses R53 for DNS web service to route end users from a domain name to a numeric IP address
6.	Lambda<br/>
Lambda function is invoked to start and stop EC2 instances running the application at scheduled intervals
7.	CloudWatch<br/>
CloudWatch is triggering an event to invoke lambda. 
CloudWatch is configured at predefined times 
8.	SNS<br/>
Simple Notification Service(SNS) sends mail to the user every time an EC2 instance is started on stopped
9.	RDS<br/>
Relational Database Service is used in the application for deploying scalable MySQL servers with resizable hardware capacity

Pre-Requisites 
================================
Basic Hardware Requirements –<br/>
•	Intel Core i7<br/>
•	2.40 GHz Processor<br/>
•	8GB RAM <br/>

Basic Software Requirements –<br/>
•	Windows <br/>
•	Apache Maven 3.5.0<br/>
•	Java 8<br/>
•	Apache Tomcat 8<br/>
•	MySQL Server 5.7<br/>
•	MySQL Workbench 6.3<br/>
•	Spring Tool Suite 3.9<br/>

Framework and Libraries –<br/>
•	Springboot Framework<br/>
•	JDBC Connector<br/>
•	AWS Java SDK<br/>
•	Java Persistent API<br/>


Application Snippet
====
1.	Home Page of the application which is accessible by the domain name on public internet. User is supposed to enter the credentials to go ahead.
<img src="https://s3-us-west-2.amazonaws.com/himanginiaws/Home.PNG" />
 
2.	Second Page of the application where user is expected to select the service of his/her choice
<img src="https://s3-us-west-2.amazonaws.com/himanginiaws/Upload-Delete.PNG" />
 
3.	More options available such as Download the file and List all the contents of your bucket


4.	After choosing a file name for upload or delete a Bucket detail page will appear
This page tracks the date and time of operation and the user details of the operator
  <img src="https://s3-us-west-2.amazonaws.com/himanginiaws/Upload-Download.PNG" />
 
5.	If User selects a file for downloading a page giving details of the file with a downloadable link is prompted, such as below where Hello is the name of the file

<img src="https://s3-us-west-2.amazonaws.com/himanginiaws/Download-File.PNG" />
 
6.	If the user wants to check all the files under his/her bucket, he/she has to give the name of the bucket in the input box and page giving list of all the files present in the bucket is displayed.

 <img src="https://s3-us-west-2.amazonaws.com/himanginiaws/Bucket-Contents.PNG" />

Setup
---
•	Install STS <br/>
•	Download the github repo on local machine<br/>
•	Import the project from download forlder to STS as maven project<br/>
•	Goto src/main/java under S3 services, give your AWS access key and secret key<br/>
•	Configure the project to run on Tomcat 8<br/>
•	System should have Java 8 and Tomcat 8<br/>
•	Run the project on server<br/>
•	Give below Credentials to use the app-<br/>
username - ha<br/>
password - ha<br/>

NOTE- The application will by default use my S3 bucket, to use your own bucket create the bucket and provide the name in source code under S3 services






