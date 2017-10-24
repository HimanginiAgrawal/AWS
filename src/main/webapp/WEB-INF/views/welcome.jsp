<%--
  User: Himangini
  Date: 10-14-2017
  Time: 08:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title>Welcome to Amazon Web Services</title>
</head>
<body>
<h3>User Login Details</h3>
<h4>  First Name is ${userFName} </h4>
<h4>  Last Name is ${userLName} </h4>
</body>
<br>
<br>
<h3>Please choose an option below</h3>
<form method="post"  enctype="multipart/form-data" action="upload">
    File Name: <input type="text" name="name"/>
    <br>
   File <input type="file" name="file">
    <br>
    <br>
    <br>
    <input type="submit" name="upload" value="Upload">
</form>
</body>
</html>
<form method="post"  action="delete">
   <br>
   File Name: <input type='text' name='filename'>
    <br>
    <br>
    <br>
    <input type="submit" name="delete" value="Delete">
</form>
<form method="post"  action="read">
   <br>
   File Name: <input type='text' name='name'>
    <br>
    <br>
    <br>
    <input type="submit" name="read" value="Download">
</form>
<form method="post"  action="list">
<br>
    Bucket Name: <input type="text" name="bucketname"/>
    <br>
    <br>
    <br>
    <input type="submit" name="upload" value="List Bucket Contents">
</form>

</html>
