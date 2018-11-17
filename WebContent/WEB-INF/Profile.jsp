<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booky</title>
<style><%@ include file="/WEB-INF/style.css" %></style>
</head>

<body>
<div id="menu">
<p id="menuLeft">
<a href='HomePage'>Home</a> |
<a href='BookListing'>Book Listing</a> | 
<a href='Sell'>Sell</a> |
<a href='Checkout'>Checkout</a>
<form action='BookListing' method='post'>
<input type='text' name='search' value='Search for a book'>
<input type='submit' name='submit' value='Search'>
</form></p>

<p id="menuRight">
<a href='Profile'>Profile</a>
</p>
</div>

<div style='float:left; clear:both;'>
<form style='action='Profile' method='post'>
<h2 style="margin-left:25px;">John Doe</h2>
<img id="profileImg" src="${link}" alt="Profile Picture">
<br>
<input  type='file' name='imgLink'>
<br>
<input type='submit' value='Upload' name='upload'>
</form>
</div>

<div style='float: right;'>
<table style="border:1px solid black; float:right; margin-right:35%; margin-top:25px;'">
<tr><td>Books For Sale:</td><td>Price</td></tr>
<tr><td></td><td></td></tr>
</table>
</div>
</body>
</html>