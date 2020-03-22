    <!DOCTYPE html>
    <html>
    <head>
        <meta charset="UTF-8">
        <title>Регистрация</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>
    <body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Главная</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Помощь</a>
                </li>
            </ul>
            <form class="form-inline">
                <div class="input-group">
                    <div class="input-group-prepend">
        				<span class="input-group-text" id="basic-addon1" style="height: 40px">
    				      	<li class="nav-item dropdown" style="list-style-type: none; margin: -20px">
						        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"/>
						        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
						          <a class="dropdown-item" href="#">Все</a>
						          <a class="dropdown-item" href="#">Автор</a>
						          <a class="dropdown-item" href="#">Класс</a>
						          <a class="dropdown-item" href="#">Название</a>
						        </div>
				      		</li>
        				</span>
                    </div>
                    <input class="form-control mr-sm-2" type="search" placeholder="Поиск" aria-label="Search">
                </div>
                <button class="btn btn-outline-success my-2 my-sm-0" style="margin-right:25px" type="submit">Поиск</button>
                <div class="btn-group">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" id="profileDropdown"><img src="profile.png"width=40px height=40px style="margin-right: 10px"><font color="black">Личный кабинет</font></a>
                    <div class="dropdown-menu" aria-labelledby="profileDropdown">
                        <a class="dropdown-item" href="#">Вход</a>
                        <a class="dropdown-item" href="#">Регистрация</a>

                    </div>
                </div>
            </form>
        </div>
    </nav>
    <form action="/signUp" method="post" oninput='password2.setCustomValidity(password.value !== password2.value ? "Пароли не совпадают" : "")'>
        <div class="container" style="margin-left: 40%; margin-top: 5%">
            <div class="row" style="margin-left: 2%">
                <h1>Регистрация</h1>
            </div>
            <div class="row" style="margin-top: 4%">
                <input type="text" name="name" required placeholder="Имя" size="30">
            </div>
            <div class="row" style="margin-top: 2%">
                <input type="email" name="email" required placeholder="Email" size="30">
            </div>
            <div class="row" style="margin-top: 2%">
                <input type="password" name="password" required placeholder="Пароль" size="30">
            </div>
            <div class="row" style="margin-top: 2%">
                <input type="password" name="password2" required placeholder="Подтверждение пароля" size="30">
            </div>
            <div class="row" style="margin-top: 2%">
                <button type="submit" class="btn btn-default" style="width: 300px">Зарегистрироваться</button>
            </div>
        </div>
    </form>


    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>

    </body>
    </html>