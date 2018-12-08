<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>BOOKY</title>
    <style>
    body{
    overflow-y : auto;
}
    <%@ include file="/WEB-INF/style.css" %>
    body {background-color: #97bfd1ff};
    </style>
</head>
<body>
    
    <div id="menu">
        <div id="menuLeft">
<a class=bold href='HomePage' style="text-decoration:none">Home</a> |
<a class=bold href='Sell' style="text-decoration:none">Sell</a> |
<a class=bold href='Checkout' style="text-decoration:none">Checkout</a>
        </div>
        
<form style='float:left;' action='BookListing' method='post'>
<input style='margin-left:-332px; margin-top:25px;' type='text' name='search' value='Search for a book'>
        <select>
            <option value='All'>All</option>
            <option value='KeyWord'>KeyWord</option>
            <option value='Title'>Title</option>
            <option value='Author'>Author</option>
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
    
    <h1 class=h2 style="margin-top: 30px ">Sell Your Books</h1> 
    <form action='Sell' method='post'>
        <label for="textboxName" class=h2 style="margin-top: 30px ">Name:</label>
        <input type="text" id="textboxName" name="newBookName" placeholder="Enter the name of the book: " >
        <!--Add the 'value' attribute to pre-populate the text box (value="John Doe")-->

       
        <br>
        <label for="authorName" class=h2 style="margin-top: 30px ">Author:</label>
        <input type="text" id="authorName" name="authorName" placeholder="Enter the name of the author " >
        <!--Add the 'value' attribute to pre-populate the text box (value="John Doe")-->

        <br>
        <label for="ISBNnumber" class=h2 style="margin-top: 30px ">ISBN:</label>
        <input type="text" id="ISBNnumber" name="isbnNumber" placeholder="ENter the ISBN: " >
        <!--Add the 'value' attribute to pre-populate the text box (value="John Doe")-->
        
         <br>
         <label for="genreName" class=h2 style="margin-top: 30px ">Genre:</label>
         <input type="text" id="genreName" name="genreName" placeholder="What is the genre: " >
        <!--Add the 'value' attribute to pre-populate the text box (value="John Doe")-->
        
         <br>
        <label for="price" class=h2 style="margin-top: 30px ">Price:</label>
        <input type="text" id="ISBNnumber" name="price" placeholder="Enter the price: " >
        
        <br>
        <p class=h2 style="margin-top: 30px ">Add the books description</p>
        <textarea placeholder="Add the description.... " name="bookDescription" rows="10" ></textarea>

        <br>
   
        <h3 class=h2 style="margin-top: 30px ">What is the condition of the book?</h3>
        <select name="condition">
            <option value="new">New</option>
            <option value="used">Used</option>

        </select>


        <input type="submit" name="submitButton" value="Submit your book">
        <button type="button" name="back" onclick="history.back()">Back</button>
    </form>

</body>
</html>