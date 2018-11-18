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
<div id="menuLeft">
<a href='HomePage'>Home</a> |
<a href='BookListing'>Book Listing</a> | 
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

<div id="menuRight">
<a href='Profile'>Profile</a>
</div>
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
<tr><td>Books For Sale</td><td>Price</td></tr>

</table>
</div>
</body>
</html>