    <!DOCTYPE html>
    <html> <!--xmlns:https="http://www.w3.org/1999/xhtml" xmlns="http://www.w3.org/1999/html">-->
    <#import "spring.ftl" as spring />
    <head>

        <meta charset="UTF-8">
        <title>Sign Up</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-2.2.4.js" charset="utf-8"></script>
        <script>
            function sendCode() {
                $.ajax({
                    url: "/signUp/sendConfirmCode",
                    data: {
                        "phone": $('#phone').val()
                    },
                    success: function (code) {
                        $('#code').attr('value', ''+ code);
                    }
                })
            }

            function signUp() {
                $.ajax({
                    type: "POST",
                    url: "/signUp",
                    data: {
                        name: $('#name').val(),
                        email: $('#email').val(),
                        password: $('#password').val(),
                        phone: $('#phone').val(),
                        confirmCode: $('#confirmCode').val(),
                        code: $('#code').val()
                    },
                    success: function (msg) {
                        if (msg == 'ok') {
                            window.location.href = "/signIn"
                        } else {
                            alert('wrong code, try again')
                        }
                    }
                })
            }
            </script>
    </head>
    <body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="/index"><@spring.message 'all.page.header.main'/> <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#"><@spring.message 'all.page.header.help'/></a>
                </li>

            </ul>
            <form class="form-inline">
                <div class="input-group">
                    <div class="input-group-prepend">
        				<span class="input-group-text" id="basic-addon1" style="height: 40px">
    				      	<li class="nav-item dropdown" style="list-style-type: none; margin: -20px">
						        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"/>
						        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
						          <a class="dropdown-item" href="#"><@spring.message 'all.page.header.all'/></a>
						          <a class="dropdown-item" href="#"><@spring.message 'all.page.header.author'/></a>
						          <a class="dropdown-item" href="#"><@spring.message 'all.page.header.class'/></a>
						          <a class="dropdown-item" href="#"><@spring.message 'all.page.header.title'/></a>
						        </div>
				      		</li>
        				</span>
                    </div>
                    <input class="form-control mr-sm-2" type="search" placeholder="<@spring.message 'all.page.header.search'/>" aria-label="Search">
                </div>
                <button class="btn btn-outline-success my-2 my-sm-0" style="margin-right:25px" type="submit"><@spring.message 'all.page.header.search'/></button>
                <div class="btn-group">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" id="profileDropdown"><img src="../img/profile.png" width=40px height=40px style="margin-right: 10px" alt=""><font color="black"><@spring.message 'all.page.header.profile'/></font></a>
                    <div class="dropdown-menu" aria-labelledby="profileDropdown">
                        <a class="dropdown-item" href="/signIn"><@spring.message 'sign_in.page.titee'/></a>
                        <a class="dropdown-item" href="/signUp"><@spring.message 'all.page.header.signup'/></a>

                    </div>
                </div>
            </form>
        </div>
    </nav>

    <form action="/signUp" method="post" oninput='password2.setCustomValidity(password.value !== password2.value ? "<@spring.message 'sign_up.page.passvalue'/>" : "")'>
        <div class="container" style="margin-left: 40%; margin-top: 5%">
            <div class="row" style="margin-left: 2%">
                <h1><@spring.message 'sign_up.page'/></h1>
            </div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
            <input type="hidden" id="code" name="code" value="qq">
            <div class="row" style="margin-top: 2%" >
                <input type="text" id="name" name="name" required placeholder="<@spring.message 'sign_up.page.name.placeholder'/>" size="30">
            </div>
            <div class="row" style="margin-top: 2%">
                <input type="email" id="email" name="email" required placeholder="Email" size="30">
            </div>
            <div class="row" style="margin-top: 2%">
                <input type="password" id = "password" name="password" required placeholder="<@spring.message 'sign_in.page.password.placeholder'/>" size="30">
            </div>
            <div class="row" style="margin-top: 2%">
                <input type="password" name="password2" required placeholder="<@spring.message 'sign_up.page.pass.equals'/>" size="30">
            </div>
            <div class="row" style="margin-top: 2%">
                <input type="tel" id="phone" name="phone" placeholder="phone" size="30" pattern="[+]{7}[0-9]{11,14}" required>

            </div>
            <div class="row" style="margin-top: 2%">
            <input type="button" onclick="sendCode()"class="btn btn-default" style="width: 150px" value="send code"/>
            </div>
            <div class="row" style="margin-top: 2%">
                <input type="text" id="confirmCode" name="confirmCode"  placeholder="<@spring.message 'sign_up.page.code'/>" size="30">
            </div>



            <div class="row" style="margin-top: 2%">
                <input type="button" onclick="signUp()" class="btn btn-default" value="<@spring.message 'sign_up.page.upsubmit'/>" style="width: 255px"/>
            </div>

        </div>

    </form>

    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>

    <!--<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>-->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>

    </body>
    </html>
