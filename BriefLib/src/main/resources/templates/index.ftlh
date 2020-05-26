<!DOCTYPE html>
<html>
<#import "spring.ftl" as spring />
<head>
    <meta charset="UTF-8">
    <title>BriefLib</title>
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
                <a class="nav-link" href="/index"><@spring.message 'all.page.header.main'/> <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#"><@spring.message 'all.page.header.help'/></a>
            </li>
        </ul>
        <form class="form-inline">
<#--            <div class="input-group">-->
<#--                <div class="input-group-prepend">-->
<#--        				<span class="input-group-text" id="basic-addon1" style="height: 40px">-->
<#--    				      	<li class="nav-item dropdown" style="list-style-type: none; margin: -20px">-->
<#--						        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"/>-->
<#--						        <div class="dropdown-menu" aria-labelledby="navbarDropdown">-->
<#--						          <a class="dropdown-item" href="#"><@spring.message 'all.page.header.all'/></a>-->
<#--						          <a class="dropdown-item" href="#"><@spring.message 'all.page.header.author'/></a>-->
<#--						          <a class="dropdown-item" href="#"><@spring.message 'all.page.header.class'/></a>-->
<#--						          <a class="dropdown-item" href="#"><@spring.message 'all.page.header.title'/></a>-->
<#--						        </div>-->
<#--				      		</li>        					-->
<#--        				</span>-->
<#--                </div>-->
<#--                <input class="form-control mr-sm-2" type="search" placeholder="<@spring.message 'all.page.header.search'/>" aria-label="Search">-->
<#--            </div>-->
<#--            <button class="btn btn-outline-success my-2 my-sm-0" style="margin-right:25px" type="submit"><@spring.message 'all.page.header.search'/></button>-->
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
<h1 style="margin-left: 20px; margin-top: 50px"> <@spring.message 'home.page.welcome.test'/> </h1>
<div class="container" style="margin-top: 100px; margin-right: 280px">
<div class="row">
    <div class="col">
        <@spring.message 'home.page.introduction.b1'/> <b><@spring.message 'home.page.introduction.b2'/></b> <@spring.message 'home.page.introduction.b3'/><br><br>
        <@spring.message 'home.page.introduction.b4'/><br><br><@spring.message 'home.page.introduction.b5'/>
    </div>
    <div class="col">
        <div class="container" style="margin-left: 100px" align="center">
            <div class="row">
                <h4 style="margin-top: 90px"><@spring.message 'home.page.introduction.b6'/></h4>
            </div>
            <div class="row"> </div>
            <div class="row">
                <button class="btn btn-default" style="margin-left: 130px; margin-right: 20px"><a href="/signIn"><@spring.message 'all.page.header.signin'/></a></button><button class="btn btn-default" style="margin-left: 20px"><a href="/signUp"><@spring.message 'all.page.header.signup'/></a></button>
            </div>
            <div>
            </div>
        </div>
    </div>
</div>
</div>


<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>

</body>
</html>