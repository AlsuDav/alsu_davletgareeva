<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <script type="application/javascript" src="webjars/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>

<p><input id="query" oninput="f()"/></p>

<script type="application/javascript">
    function f() {
        if ($("#query").val().length >= 1) {
            $.ajax({
                url: "/users/search",
                data: {"name": $("#query").val()},
                dataType: "json",
                success: function (msg) {
                    if (msg.length > 0) {
                        $("#res").html("");
                        for (var i = 0; i < msg.length; i++) {
                            $("#res").append("<li>" + msg[i].name + "</li>").append("<p>"+msg[i].email + "</p>");
                        }
                    } else {
                        $("#res").html("No results..");
                    }
                }
            })
        }
        else {
            $("#res").html("");
        }
    }
</script>
<div id="res">
    <table>
        <tr>
            <th>Имя</th>
            <th>email</th>
        </tr>
        <#list users as user>
            <tr>
                <td>${user.name}</td>
                <td>${user.email}</td>
                <td><a href="/users/${user.id}">Посмотреть</a></td>
            </tr>
        </#list>
    </table>
</div>
</body>
</html>
