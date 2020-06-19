<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <style>           
        header, body{
            font-family: 'Raleway', sans-serif;
        }
        
        button {
            background-color: #4CAF50;
            border: none;
            color: white;
            padding: 15px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
        }
        
        .blue{
            background-color: #008CBA;
        }
        
        .red{
            background-color: #f44336;
        }

        input, select, textarea{
            width: 100%;
            padding: 12px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            resize: vertical;
          }
          
          input[type=date]{
            width: 30%;
          }

          /* Style the label to display next to the inputs */
          label {
            padding: 12px 12px 12px 0;
            display: inline-block;
          }

          /* Style the submit button */
          input[type=submit] {
            background-color: #4CAF50;
            border: none;
            color: white;
            padding: 15px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            float: left;
          }

          /* Style the container */
          .container {
            width: 70%;
            margin-left: 13%;
            border-radius: 5px;
            background-color: #f2f2f2;
            padding: 20px;
          }

          /* Floating column for labels: 25% width */
          .col-25 {
            float: left;
            width: 25%;
            margin-top: 6px;
          }
          
          .col-50 {
            float: left;
            width: 50%;
            text-align: center;
            margin-top: 6px;
          }
 
          .title {
            font-size: 24px;
            text-transform: uppercase;
            font-weight: 700;
            text-align: center;
          }

          /* Floating column for inputs: 75% width */
          .col-75 {
            float: left;
            width: 75%;
            margin-top: 6px;
          }

          /* Clear floats after the columns */
          .row:after {
            content: "";
            display: table;
            clear: both;
          }

          /* Responsive layout - when the screen is less than 600px wide, make the two columns stack on top of each other instead of next to each other */
          @media screen and (max-width: 600px) {
            .col-25, .col-75, input[type=submit] {
              width: 100%;
              margin-top: 0;
            }
          }
        </style>
        <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
        <title>Diagnosis Corona</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script type="text/javascript">
            var corona = eval('<%=request.getAttribute("corona")%>');
            var influenza = eval('<%=request.getAttribute("influenza")%>');
            var flu = eval('<%=request.getAttribute("flu")%>');
            var demam = eval('<%=request.getAttribute("demam")%>');
            var diare = eval('<%=request.getAttribute("diare")%>');
            var lainnya = eval('<%=request.getAttribute("lainnya")%>');
        </script>
    </head>
    <body style="background: darkblue">
        <div class="container" style="text-align: center">
            <h2>Infografis</h2>
            <form method="post">
              <div class="row">
                <div class="col-25">
                  <label for="corona">Corona</label>
                </div>
                <div class="col-75">
                  <input readonly type="text" id="corona" name="corona" value="${corona}">
                </div>
              </div>
              <div class="row">
                <div class="col-25">
                  <label for="influenza">Influenza</label>
                </div>
                <div class="col-75">
                  <input readonly type="text" id="influenza" name="influenza" value="${influenza}">
                </div>
              </div>
              <div class="row">
                <div class="col-25">
                  <label for="flu">Flu Biasa</label>
                </div>
                <div class="col-75">
                  <input readonly type="text" id="flu" name="flu" value="${flu}">
                </div>
              </div>
              <div class="row">
                <div class="col-25">
                  <label for="demam">Demam</label>
                </div>
                <div class="col-75">
                  <input readonly type="text" id="demam" name="demam" value="${demam}"></input>
                </div>
              </div>
              <div class="row">
                <div class="col-25">
                  <label for="diare">Diare</label>
                </div>
                <div class="col-75">
                  <input readonly type="text" id="diare" name="diare" value="${diare}"></input>
                </div>
              </div>
              <div class="row">
                <div class="col-25">
                  <label for="lainnya">Lainnya</label>
                </div>
                <div class="col-75">
                  <input readonly type="text" id="lainnya" name="lainnya" value="${lainnya}"></input>
                </div>
              </div>
            </form>
                <br><br>
                <div class="row">
                    <div class="col-25"></div>
                    <div id="piechart"></div>
                </div>
            <br>
            <a href="index.html"><button type="button" class="red">HOME</button></a>
        </div>
        
        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
        <script type="text/javascript">
            
            google.charts.load('current', {'packages':['corechart']});
            google.charts.setOnLoadCallback(drawChart);

            // Draw the chart and set the chart values
            function drawChart() {
              var data = google.visualization.arrayToDataTable([
              ['Diagnosa', 'Jumlah'],
              ['Corona', corona],
              ['Influenza', influenza],
              ['Flu biasa', flu],
              ['Demam', demam],
              ['Diare', diare],
              ['Lainnya', lainnya]
            ]);

              // Optional; add a title and set the width and height of the chart
              var options = {'title':'Diagnosa penyakit', 'width':550, 'height':400};

              // Display the chart inside the <div> element with id="piechart"
              var chart = new google.visualization.PieChart(document.getElementById('piechart'));
              chart.draw(data, options);
            }
        </script>
    </body>
</html>

