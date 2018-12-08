<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booky</title>
<style><%@ include file="/WEB-INF/style.css" %></style>
<style>
body {background-color: #97bfd1ff;}

table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
 text-align: center;
  padding: 8px;
    font-family: Verdana; 
}

tr:nth-child(even){background-color: #6296c5}

tr:nth-child(odd){background-color: #3b76b2; color: #000000}

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

<form style='float:left;' action='HomePage' method=get>
<input style='margin-left:-350px; margin-top:25px;' 
type='text' name='search' value='' placeholder="Search for a book">
<select name='filter'>
    <option value='all'>ALL</option>
    <option value='keyword'>KEYWORD</option>
    <option value='title'>TITLEe</option>
    <option value='author'>AUTHOR</option>
</select>
<input class="example_b" style="text-decoration:none" type='submit' name='submit' value='Search' >
</form>

<div id='menuRight'>
<img id="profileImg2" src="${link}" alt="Profile Picture">
</div>

<div id="menuRight">
<a href='Profile'>${firstName} ${lastName}</a>
</div>
</div>

<center>
<p class=h2 style="margin-top: 30px">Welcome to BOOKY, where you can buy or sell used books for cheaper price!
<br class=h2>Here is a list of featured books for today.</p>
</center>
<br>
<p>${alert}</p>

<table>
<tr><th>Title</th><th>Author</th><th>Genre</th><th>Condition</th><th>Description</th></tr>
<c:forEach items="${books}" var="b">
    <tr>
        <td>${b.getTitle()}</td>
        <td>${b.getAuthor()}</td>
        <td>${b.getGenre()}</td>
        <td>${b.getCondition()}</td>
        <td>${b.getDescription()}</td>
        <input type='hidden' name='bookAddedToCart' value='${b.getBookID()}'>
        <td><input type='submit' value='Add to Cart'></td>
    </tr>
</c:forEach>
</table>

</body>
</html>