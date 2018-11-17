<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Credit Card Validation Demo</title>

    <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="WebContent/WEB-INF/styles.css">
    <link rel="stylesheet" type="text/css" href="WebContent/WEB-INF/demo.css">
</head>
<style><%@ include file="/WEB-INF/style.css" %></style>
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
	
    <!-- The HTML for our form will go here -->

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="WebContent/WEB-INF/payment.js" charset="utf-8"></script>
    <script src="WebContent/WEB-INF/script.js"></script>
</body>
<div class="creditCardForm">
    <div class="heading">
        <h1>Confirm Purchase</h1>
    </div>
    <div class="payment">
        <form>
            <div class="form-group owner">
                <label for="owner">Owner</label>
                <input type="text" class="form-control" id="owner">
            </div>
            <div class="form-group CVV">
                <label for="cvv">CVV</label>
                <input type="text" class="form-control" id="cvv">
            </div>
            <div class="form-group" id="card-number-field">
                <label for="cardNumber">Card Number</label>
                <input type="text" class="form-control" id="cardNumber">
            </div>
            <div class="form-group" id="expiration-date">
                <label>Expiration Date</label>
                <select>
                    <option value="01">January</option>
                    <option value="02">February </option>
                    <option value="03">March</option>
                    <option value="04">April</option>
                    <option value="05">May</option>
                    <option value="06">June</option>
                    <option value="07">July</option>
                    <option value="08">August</option>
                    <option value="09">September</option>
                    <option value="10">October</option>
                    <option value="11">November</option>
                    <option value="12">December</option>
                </select>
                <select>
                    <option value="16"> 2016</option>
                    <option value="17"> 2017</option>
                    <option value="18"> 2018</option>
                    <option value="19"> 2019</option>
                    <option value="20"> 2020</option>
                    <option value="21"> 2021</option>
                </select>
            </div>
            <div class="form-group" id="credit_cards">
            <img id="visa" src="<%=request.getContextPath() + "/Images/visa.jpg"%>">
            <img id="mastercard" src="<%=request.getContextPath() + "/Images/mastercard.jpg"%>">
            <img id="amex" src="<%=request.getContextPath() + "/Images/amex.jpg"%>">
            
                
            </div>
            <div class="form-group" id="pay-now">
                <button type="submit" class="btn btn-default" id="confirm-purchase">Confirm</button>
            </div>
        </form>
    </div>
</div>
</html>