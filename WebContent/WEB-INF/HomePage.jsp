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
type='text' name='search' value='' placeholder = "Search for a book">
<select name='filter'>
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
<br>

<p style="margin-top: 50px">Welcome to BOOKY, where you can buy or sell used books for cheaper price!
<br>Here is a list of featured books for today.</p>
</body>
</html>