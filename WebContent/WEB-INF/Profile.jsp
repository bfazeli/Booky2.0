<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booky</title>
<style><%@ include file="/WEB-INF/style.css" %>
body {background-color: #97bfd1ff;}</style>
<style>
table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
 text-align: center;
  padding: 8px;
    font-family: Verdana; 
}
tr:nth-child(odd){background-color: #6296c5; color: #000000}

th {
  background-color: #90d5ff;
  color: black;
}

</style>
</head>

<body>
<div id="menu">
<div id="menuLeft">
<a href='HomePage'>Home</a> |
<a href='Sell'>Sell</a> |
<a href='Checkout'>Checkout</a>
</div>

<form style='float:left;' action='BookListing' method='post'>
<input style='margin-left:25px; margin-top:15px;' 
type='text' name='search' value='Search for a book'>
<select>
    <option value='All'>All</option>
    <option value='KeyWord'>KeyWord</option>
    <option value='Title'>Title</option>
    <option value='Author'>Author</option>
</select>
<input type='submit' name='submit' value='Search'>
</form>

<div id='menuRight'>
<img id="profileImg2" src="${link}" alt="Profile Picture">
</div>

<div id="menuRight">
<a href='Profile'>${firstName} ${lastName}</a>
</div>
</div>
<br>
<div style='float:left; clear:both;'>
<table>
<tr><th style="font-size:25px;" id='name'>${firstName} ${lastName}</th></tr>
<tr><td><img id="profileImg" src="${link}" alt="Profile Picture"></td></tr>
<tr><th style="font-size:12px;" id='email'>${email}</th></tr>
<tr><th style="font-size:12px;" id='phoneNumber'>${phoneNumber}</th></tr>
<tr><th style="font-size:12px;" id='address'>${address}</th></tr>
<tr><td><a href='EditProfile'>Edit Profile</a></td></tr>
</table>
</div>

<div style='float: right;'>
<table style="border:1px solid black; float:right; margin-right:35%; margin-top:25px;'">
<tr><td>Books For Sale</td><td>Price</td></tr>
<c:forEach items="${myBooks}" var="b">
<tr><td>${b.getTitle()}</td><td>${b.getPrice()}</td></tr>
</c:forEach>
</table>
</div>
</body>
</html>