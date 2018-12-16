<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booky</title>
<style><%@ include file="/WEB-INF/style.css" %></style>
</head>
<body>
<h1>Edit Profile Information</h1>
<form action="EditProfile" method="post">
<table>
<tr><td><img id="profileImg" src="${link}" alt="Profile Picture"></<td><td><input type='file' name='imgLink'></td></tr>
<tr><th>First Name:</th><td><input type="text" value="${firstName}" name="changeFirstName"></td></tr>
<tr><th>Last Name:</th><td><input type="text" value="${lastName}" name="changeLastName"></td></tr>
<tr><th>Email:</th><td><input type="text" value="${email}" name="changeEmail"></td></tr>
<tr><th>Phone Number:</th><td><input type="text" value="${phoneNumber}" name="changePhoneNumber"></td></tr>
<tr><th>Address:</th><td><input type="text" value="${address}" name="changeAddress"></td></tr>
</table>
<input type='submit' value='Save Changes' name='save'> <input type="button" value="Back" onclick="history.back()">
</form>
<script>
</script>
</body>
</html>