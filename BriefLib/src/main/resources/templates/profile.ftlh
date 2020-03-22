<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Личный кабинет. Мой профиль</title>
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
                <a class="nav-link" href="/index">Главная</a>
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
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" id="profileDropdown"><img src="img/profile.png"width=40px height=40px style="margin-right: 10px"><font color="black">Личный кабинет</font></a>
                <div class="dropdown-menu" aria-labelledby="profileDropdown">
                    <a class="dropdown-item" href="/profile">Мой профиль</a>
                    <a class="dropdown-item" href="/bookmarks">Закладки</a>
                    <a class="dropdown-item" href="#">Мои записи</a>
                    <a class="dropdown-item" href="/changePassword">Изменить пароль</a>
                    <a class="dropdown-item" href="/logout">Выход</a>
                </div>
            </div>
        </form>
    </div>
</nav>

<div class="container" style="margin: 0; margin-top: 2%">
    <div class="row" style="margin-left: 5%">
        <h1>Мой профиль</h1>
    </div>
    <div class="row">
        <div class="col-4">
            <img src="../img/custom-ava.jpg" width="auto" height="240px">
        </div>
        <div class="col-5" style="margin-top: 5%">
            <div class="row">
                <b>${user.email}</b>
            </div>
            <div class="row" style="margin-top: 2%">
                <b>${user.name}</b>
            </div>
            <div class="row" style="margin-top: 7%">
                <a>Редактировать...</a>
            </div>
        </div>
    </div>
</div>



<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>

</body>
</html>
