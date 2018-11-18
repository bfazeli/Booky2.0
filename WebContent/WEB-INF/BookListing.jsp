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
<a href='Checkout'>Checkout</a></p>
<p id="menuRight">
<a href='Profile'>Profile</a>
</p></div>
<br>

<form action='BookListing' method='post'>
<input type='text' name='search' value='Search for a book'>
<select>
	<option value='All'>All</option>
	<option value='KeyWord'>KeyWord</option>
	<option value='Title'>Title</option>
	<option value='Author'>Author</option>
</select>
<input type='submit' name='submit' value='Search'>
</form>
</body>
</html>