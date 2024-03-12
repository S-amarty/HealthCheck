<!DOCTYPE html>
<html lang="en">
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>EAIFTP HEALTH CHECK</title>
    <style>
        /* Your existing styles remain unchanged */
        body {
font-family: Arial, sans-serif;
margin: 0;
padding: 0;
box-sizing: border-box;
display: flex;
flex-direction: column;
align-items: center;
justify-content: center;
height: 100vh;
}

header {
background-color: #505050;
color: #fff;
text-align: center;
padding: 10px;
width: 50%;
margin-bottom: 20px; /* Add a 20% gap */
}

h1, h2 {

}

.extra-boxes {
display: flex;
justify-content: space-around;
width: 100%;
margin-bottom: 20px; /* Add a 20% gap */
}

.extra-box {
width: 80px;
height: 60px;
background-color: #0396ff;
color: #fff;
text-align: center;
line-height: 60px;
margin: 7px 5px; /* Add a margin between the extra boxes */
}

.extra-box#test {
background-color: #4CAF50; /* Green background color for TEST box */
margin-bottom: 10%; /* Create a 20% gap between TEST and 4x2 boxes */
}

.grid-container {
display: grid;
grid-template-columns: repeat(4, 1fr);
grid-gap: 0; /* Set gap to 0 to remove any gaps between the boxes */
justify-content: center; /* Center the grid */
border: 2px solid #333; /* Add a border to the grid container */
border-radius: 5px; /* Optional: Add border-radius for a rounded appearance */
padding: 10px; /* Optional: Add padding for better visual appearance */
}

.box {
width: 100px;
height: 100px;
color: #fff;
text-align: center;
line-height: 100px;
margin: 0; /* Remove the margin to eliminate any extra spacing */
border-bottom: 2px solid #3498db; /* Add a bottom border to DB, WebLogic, App, Interface boxes */
}

/* Set background-color for DB, WebLogic, App, and Interface boxes */
#box1, #box2, #box3, #box4 {
background-color: #87CEFA; /* Light blue background color */
}

/* Set background-color for OK boxes */
#box5, #box6, #box7, #box8 {
background-color: #90EE90; /* Light green background color for OK boxes */
}

.btn {
    background-color: #0396ff;
    padding: 20px;
    color: #fff;
    border-radius: 4px;
}
        #container {
            display: flex;
            flex-direction: column;
            align-items: center;
        }
    </style>
</head>
<body>
<header>
    <div style="text-align: Center">EAIFTP HEALTH CHECK</div>
</header>

<div class="extra-boxes">
    <button  id="testButton" class="btn">TEST ENV</button>
    <button  id="prodButton" class="btn">PROD ENV</button>
</div>

<div id="container" style="display: none;">
    <div class="extra-box" id="envName" width="10%">TEST</div>

    <div class="grid-container">
        <div class="box" id="box1">DB</div>
        <div class="box" id="box2">WebLogic</div>
        <div class="box" id="box3">App</div>
        <div class="box" id="box4">Interface</div>
       
        <div class="box" id="box5">${statusCode}</div>
       
    </div>
</div>

<script>
    $(document).ready(function(){
        $('#testButton').click(function(){
            $('#container').show();
            $('#envName').text('TEST');
        });

        $('#prodButton').click(function(){
            $('#container').show();
            $('#button1').show();
             $('#envName').text('PROD');
        });
    });
</script>
</body>
</html>
