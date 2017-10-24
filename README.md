# AWS

AWS extension
======================

The repository contains the source code for a web application which is accessible over public internet.
The application uses various aws features and is a highly available, highly scalable, cost effective solution

•	University Name: http://www.sjsu.edu/
•	Course: Cloud Technologies
•	Professor Sanjay Garje
•	ISA: Divyankitha Urs
•	Student: https://www.linkedin.com/in/himangini-agrawal-6a344029

Introduction
============================
The idea of my application is to give user a reliable, scalable, secure and highly performing infrastructure for the most demanding features of AWS. Extremely available and highly scalable web hosting is usually a complex and expensive proposition. My Application provides Cloud Storage, File Synchronization and Personal Cloud features. The user can keep safe and secured data without much hassle using very simple GUI features maintaining a repository in cloud, saving the cost of high end hardware requirements.
Application creates a database for the registered users, where users maintain their folders contents to which are then synchronized with AWS features. App users are given unlimited storage leveraging all the amazon features. 
Feature List
1.	S3
Scope of application is limited to the registered users, where user once logged in can manage their S3 bucket giving functionalities such as – 
•	Upload files to S3 bucket (also tracking the user details)
•	Download files which are already present in the bucket
•	Delete the not required files from S3 bucket
•	User details and date and time are tracked against all operations
2.	EC2
Application uses EC2 features for web hosting and has auto scaling implemented for the purposes of instance scaling and management. 
Elastic Load Balancing is applied across EC2 instances to distribute incoming traffic and increase fault tolerance.
3.	CloudFront
CloudFront is configured to speeds up the distribution of dynamic web content to all the users worldwide
4.	S3 Transfer Acceleration
Bucket created in the application uses S3 Transfer Acceleration to make customers upload to a centralized bucket from all over the world
5.	Route53
Application uses R53 for DNS web service to route end users from a domain name to a numeric IP address
6.	Lambda
Lambda function is invoked to start and stop EC2 instances running the application at scheduled intervals
7.	CloudWatch
CloudWatch is triggering an event to invoke lambda. 
CloudWatch is configured at predefined times 
8.	SNS
Simple Notification Service(SNS) sends mail to the user every time an EC2 instance is started on stopped
9.	RDS
Relational Database Service is used in the application for deploying scalable MySQL servers with resizable hardware capacity

Technologies Used
================================
Basic Hardware Requirements –
•	Intel Core i7
•	2.40 GHz Processor
•	8GB RAM 

Basic Software Requirements –
•	Windows 
•	Apache Maven 3.5.0
•	Java 8
•	Apache Tomcat 8
•	MySQL Server 5.7
•	MySQL Workbench 6.3
•	Spring Tool Suite 3.9

Framework and Libraries –
•	Springboot Framework
•	JDBC Connector
•	AWS Java SDK
•	Java Persistent API


Application Snippet
====
1.	Home Page of the application which is accessible by the domain name on public internet. User is supposed to enter the credentials to go ahead.
<img src="https://s3-us-west-2.amazonaws.com/himanginiaws/Home.PNG" />
 
2.	Second Page of the application where user is expected to select the service of his/her choice
<img src="https://s3-us-west-2.amazonaws.com/himanginiaws/Upload-Delete.PNG" />
 
3.	More options available such as Download the file and List all the contents of your bucket
 <img src="https://s3-us-west-2.amazonaws.com/himanginiaws/Upload-Download.PNG" />

4.	After choosing a file name for upload or delete a Bucket detail page will appear
This page tracks the date and time of operation and the user details of the operator
 <img src="https://s3-us-west-2.amazonaws.com/himanginiaws/Bucket-Contents.PNG" />
 
5.	If User selects a file for downloading a page giving details of the file with a downloadable link is prompted, such as below where Hello is the name of the file

<img src="https://s3-us-west-2.amazonaws.com/himanginiaws/Download-File.PNG" />
 
6.	If the user wants to check all the files under his/her bucket, he/she has to give the name of the bucket in the input box and page giving list of all the files present in the bucket is displayed.

 <img src="https://s3-us-west-2.amazonaws.com/himanginiaws/Bucket-Contents.PNG" />

Solutions for Problem Statement
---
•	Register with Amazon Web Services
•	Create an IAM user and provide the user access to S3 and EC2
•	Create access key and secret key and provide the details in code
•	Create a bucket in S3
•	Create a CloudFront and make the bucket an edge location. This is to speed up our web page content
•	Use the SpringFramework to ease the coding part
•	Once the application is built, launch a RDS instance on MySQL engine
•	Choose Multi-AZ deployment for high scalability
•	Create a table using workbench which will interact with the code
•	Launch EC2 instances attach the above IAM role
•	Create an ELB connecting all the EC2 instances and apply auto scaling feature
•	Assign an elastic IP which can now access the application hosted on EC2
•	Register a private domain. Once the domain is active, use Route53 to create Name Servers and Start of Authority
•	CloudWatch is applied on EC2 instance for CPU utilization and NetworkIN/OUT
•	Based on CloudWatch logs a Lambda Function is invoked generating an email to the list and autoscaling EC2 instance
•	Create a new record set under Route53 which will use your domain name to point to ELB
•	Finally, access your web contents over public internet using domain name
For Monitoring and Alarm,
•	CloudWatch is implemented on EC2 instances, if the instances enter unhealthy state a Lambda Function is invoked which will spun up a new EC2 instance with similar configurations
•	An SNS event will send a mail to the user stating EC2 details
For Auto Recovery Process,
•	A bucket for cross-region replication with same user data is created
•	Multi AZ architecture for database and application deployment is implemented
For Re-balancing the traffic,
•	Elastic load balancing is configured on EC2 instances and auto scaling group is created. Thereby, giving maximum application availability in case of huge traffic.
•	Every S3 bucket has Transfer Acceleration enabled to fully utilize the internet bandwidth
•	Single AZ DB is implemented as part of this project which can be scaled.
For cost saving,
•	Appropriate size of EC2 instance is launched, which can later be scaled in number
Steps to covert the single AZ DB into multi-AZ, 
1.	Launch two same RDS instances(clone) in two different AZs present in the same region, where one should act as Master and other one Standby. 
2.	There should be a synchronous replication of data between Master and Standby.
3.	 For higher availability RDS service switches the database name from Master to Standby.  
4.	Both the instances should be present on same Virtual Private Cloud




