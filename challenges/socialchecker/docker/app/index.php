<!doctype html>
<html>
    <head>
        <title>Social Checker</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <link href="https://fonts.googleapis.com/css2?family=Jost:wght@200&display=swap" rel="stylesheet"> 
        <style>
        * {
            font-family: 'Jost', sans-serif;
            font-size: 20px;
        }
        html {
            background: url('bg.jpg');
            background-size: cover;
        }
        body {
            width: 480px;
            padding-top: 10px;
            padding-left: 40px;
            padding-right: 40px;
            padding-bottom: 30px;
            margin-left: auto;
            margin-right: auto;
            margin-top: 60px;
            background-color: white;
            border: 1px solid #dddddd;
            border-radius: 4px;
        }
        .box {
            background-color: lightblue;
            color: blue;
            margin: 10px;
        }
        select, input {
            width: 480px;
            height: 32px;
            background-color: #444444;
            color: #dddddd;
            border: 1px solid #666666;
            border-radius: 4px;
        }
        h1 {
            font-size: 32px;
        }
        </style>
        <script>
        function doCheck() {
          $.post("check.php", {"url": $("#url").val()}, function(data) {
            $("#result").text(data);
          });
        }
        </script>
    </head>
    <body>
        <h1>Social Checker</h1>
        Check if your favourite social media site is online!<br/><br/>
        <select id="url">
          <option value="twitter.com">twitter.com</option>
          <option value="facebook.com">facebook.com</option>
          <option value="linkedin.com">linkedin.com</option>
          <option value="instagram.com">instagram.com</option>
          <option value="pinterest.com">pinterest.com</option>
          <option value="tumblr.com">tumblr.com</option>
          <option value="wechat.com">wechat.com</option>
          <option value="whatsapp.com">whatsapp.com</option>
        </select><br/><br/>
        <input id="submit" type="submit" value="Check it!" onclick="javascript:doCheck();"/><br/><br/>
        <div class="box" id="result"></div>
    </body>
</html>