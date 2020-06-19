<%-- 
    Document   : hasil
    Created on : Jun 18, 2020, 1:24:28 AM
    Author     : se7en
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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

        input[type=text], input[type=date], select, textarea{
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
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            float: right;
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body style="background: darkblue">
        <div class="container">
            <h2 class="title">Diagnosa</h2>
            <form method="post">
              <div class="row">
                <div class="col-25">
                  <label for="diagnosa">Diagnosa</label>
                </div>
                <div class="col-75">
                  <input readonly type="text" id="diagnosa" name="diagnosa" value="${diagnosa}">
                </div>
              </div>
              <div class="row">
                <div class="col-25">
                  <label for="nama">Nama</label>
                </div>
                <div class="col-75">
                  <input readonly type="text" id="name" name="nama" value="${nama}">
                </div>
              </div>
              <div class="row">
                <div class="col-25">
                  <label for="tanggal">Tanggal Survey</label>
                </div>
                <div class="col-75">
                  <input readonly type="text" id="tanggal" name="tanggal" value="${tanggal}">
                </div>
              </div>
              <div class="row">
                <div class="col-25">
                  <label for="subject">Gejala Utama</label>
                </div>
                <div class="col-75">
                  <input readonly type="text" id="gejala" name="gejala" value="${gejala}"></input>
                </div>
              </div>
              <div class="row">
                <div class="col-25">
                  <label for="subject">Penanganan</label>
                </div>
                <div class="col-75">
                    <input readonly type="text" id="cure" name="cure" value="1. ${penanganan1}"></input><br>
                  <input readonly type="text" id="cure" name="cure" value="2. ${penanganan2}"></input><br>
                  <input readonly type="text" id="cure" name="cure" value="3. ${penanganan3}"></input>
                </div>
              </div>
            </form>
                <br>
                <a href="index.html"><button type="button">OK</button></a>
          </div>
    </body>
</html>
