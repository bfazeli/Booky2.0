<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>BOOKY</title>
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
    
    <h1>Sell Your Books</h1> 
    <form>
        <label for="textboxName">Name:</label>
        <input type="text" id="textboxName" name="textboxName" placeholder="Enter the name of the book: " >
        <!--Add the 'value' attribute to pre-populate the text box (value="John Doe")-->

       
        <br>
        <label for="authorName">Author:</label>
        <input type="text" id="authorName" name="authorName" placeholder="Enter the name of the author " >
        <!--Add the 'value' attribute to pre-populate the text box (value="John Doe")-->

        <br>
        <label for="ISBNnumber">ISBN:</label>
        <input type="text" id="ISBNnumber" name=""ISBNnumber"" placeholder="ENter the ISBN: " >
        <!--Add the 'value' attribute to pre-populate the text box (value="John Doe")-->
        
         <br>
         <label for="genreName">Genre:</label>
         <input type="text" id="genreName" name="genreName" placeholder="What is the genre: " >
        <!--Add the 'value' attribute to pre-populate the text box (value="John Doe")-->
        <br>
        <p>Add the books description</p>
        <textarea placeholder="Add the description.... " name="aboutme" rows="10" ></textarea>

        <br>
   
        <h3>What is the condition of the book?</h3>
        <select name="reference">
            <option value="1">Excellent</option>
            <option value="2">Good</option>
            <option value="3">Slightly Used</option>
            <option value="4">Slightly Damaged</option>
            <option value="5">Very Damaged</option>

        </select>


        <input type="submit" name="submitButton" value="Submit your book">
    </form>

</body>
</html>