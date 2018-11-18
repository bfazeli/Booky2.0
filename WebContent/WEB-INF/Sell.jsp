<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>BOOKY</title>
</head>
<body>
    
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
       <button type="button" name="back" onclick="history.back()">Back</button>
        
    </form>

</body>
</html>