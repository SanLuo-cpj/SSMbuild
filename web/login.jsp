<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <script type="text/javascript" src="static/jquery/jquery-3.4.1.js"></script>
    <link rel="stylesheet" type="text/css" href="static/font-awesome-4.7.0/css/font-awesome.min.css"/>
    <style type="text/css">
        div {
            float: left;
        }

        * {
            padding: 0;
            margin: 0;
        }

        body {
            background-size: cover;

            transition: all 5s;
        }

        .qq {
            background-image: url(static/imag/1.jpg);
        }

        .q1 {
            background-image: url(static/imag/2.jpg);
        }

        .q2 {
            background-image: url(static/imag/3.jpg);
        }


        #qq {
            width: 30%;
            height: 50%;
            background-color: rgba(0, 0, 0, 0.6);
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            border-radius: 50px;
            /*页面边角*/
        }

        #q1 {
            margin-top: 15px;
            margin-left: 50px;
        }

        #q1 h1 {
            color: whitesmoke;
            position: relative;
            box-shadow:salmon;
            left: 150%;
            padding-bottom: 10px;
            border-bottom: 4px solid #005BFF;
        }

        #q2 {
            width: 80%;
            margin: 40px 10%;
        }

        #q2 input {
            color: #ff3c46;
            width: 100%;
            height: 50px;
            padding-left: 10%;
            border-radius: 20px;
            margin-bottom: 10px;
            border: none;
            border-bottom: 1px solid white;
            background-color: rgba(0, 0, 0, 0.397);

        }

        .fa {
            color: white;
            position: relative;
            top: 34px;
            left: 20px;
        }

        #q3 button {
            font-size: 15px;
            width: 130px;
            height: 35px;
            border-radius: 40px;
            border: 200px;
            background-image: linear-gradient(to right, #83d2f1, #144b52);
            color: rgb(14, 14, 14);
            font: 14px/1.5 Verdana, Times New Roman;
            font-size-adjust: .58;

        }
        .fa-user-o{
            width: 20px;
        }
        .fa-unlock{
            width: 20px;
        }

        #q3 {
            margin: 1px 20%;
        }
    </style>

</head>


<body class="qq">
<form action="${pageContext.request.contextPath}/book/login" method="post">
    <div id="qq">
        <div id="q1">
            <h1>Login</h1>
        </div>
        <div id="q2">
            <i class="fa fa-user-o" aria-hidden="true"></i>
            <input type="text" name="username" value="${Login.username}" placeholder="Account" required/>
            <i class="fa fa-unlock" aria-hidden="true"></i>
            <input type="password" name="password" value="${Login.password}" placeholder="Password" required/>
        </div>
        <div id="q3">
            <button type="submit">登 陆</button>
            <button type="button">重置</button>
        </div>
    </div>
</form>
</body>

<script type="text/javascript">
    $(function () {
        let arr = ['qq', 'q1', 'q2'];
        let i = 0;
        setInterval(function () {
            i++;
            $(".qq").addClass(arr[i]);
            if (i >= 3) {
                i = 0;
                $(".qq").removeClass('q1 q2');
            }
        }, 3000);
    })
</script>

<body class="qq">
</body>
</html>