<html>
<head>
    <title>Upload Form</title>
</head>
<body>
<h2>User Details</h2>

<form method="post"  enctype="multipart/form-data" action="upload">
    File Name: <input type="text" name="name"/>
    <br>
   Browse File <input type="file" name="file">
    <br>
    <br>
    <br>
    <input type="submit" name="upload" value="Upload">
</form>
</body>
</html>