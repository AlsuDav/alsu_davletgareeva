<!DOCTYPE html>
<html>
<#import "spring.ftl" as spring />
<head>
    <meta charset="UTF-8">
    <title>BriefLib</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-2.2.4.js" charset="utf-8"></script>
    <!--search-->
    <script type="application/javascript">
        function search(page) {
            var size = 5;
            if ($("#query").val().length >= 3) {
                $.ajax({
                    url: "/search/notes",
                    data: {
                        "q": $("#query").val(),
                        "page": page - 1,
                        "size": size
                    },
                    dataType: "json",
                    success: function (msg) {
                        if (msg.notes.length > 0) {
                            $("#resptext").html("");
                            $("#pages-button-spawn").html("");

                            for (var i = 0; i < msg.notes.length; i++) {
                                $("#resptext").append("<div class=\"container\">\n" +
                                    " <div class=\"row\">\n" +
                                    "     <div class=\"col-md-1\"></div>\n" +
                                    "     <div class=\"col-md-10\">\n" +
                                    "     <div id=\"postlist\">\n" +
                                    "     <div class=\"panel\">\n" +
                                    "     <div class=\"panel-heading\">\n" +
                                    "     <div class=\"text-center\">\n" +
                                    "     <div class=\"row\">\n" +
                                    "     <div class=\"col-sm-9\">\n" +
                                    "     <h3 class=\"pull-left\"> <a href=\"/note/" + msg.notes[i].id+ "\">" + msg.notes[i].common_title + "</a></h3>\n" +

                                    " </div>\n" +
                                    " <div class=\"col-sm-3\">\n" +
                                    "     <h4 class=\"pull-right\">\n" +
                                    "    <small>" +  msg.notes[i].createdAtString + "</small>\n" +
                                    "     </h4>\n" +
                                    "     </div>\n" +
                                    "     </div>\n" +
                                    "     </div>\n" +
                                    "     </div>\n" +
                                    "     <div class=\"panel-body\">\n" +
                                    msg.notes[i].description +
                                    "     </div>\n" +

                                    "     <div class=\"panel-footer\">\n" +
                                    "     <span class=\"label label-default\">Posted by <i>" +  msg.notes[i].user.name+ "</i></span>\n" +
                                    " </div>\n" +
                                    " </div>\n" +

                                    " </div>\n" +
                                    " </div>\n" +
                                    " <div class=\"col-md-1\"></div>\n" +
                                    "     <div class=\"col-md-3\">\n" +
                                    "     </div>\n" +
                                    "     <div class=\"col-md-1\">\n" +
                                    "     </div>\n" +
                                    "     </div>\n" +
                                    "    </div>");
                            }
                            for (var i = 1; i <= msg.count; i++) {
                                $("#pages-button-spawn").append("<button class='like-disable' onclick=\"search(" + i + ")\"> " + i + "</button>");
                            }
                        } else {
                            $("#resptext").html("no result");
                        }

                    }
                })
            }
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
                <a class="nav-link" href="/notes"><@spring.message 'all.page.header.main'/> <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#"><@spring.message 'all.page.header.help'/></a>
            </li>
        </ul>
        <form class="form-inline">
            <div class="input-group">
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
<#--				      		</li>-->
<#--        				</span>-->
<#--                </div>-->
                <input class="form-control mr-sm-2" id="query" placeholder="<@spring.message 'all.page.header.search'/>" type = "text" oninput="search(1)"/>
<#--                <input class="form-control mr-sm-2" type="search" placeholder="<@spring.message 'all.page.header.search'/>" aria-label="Search">-->
            </div>
<#--            <button class="btn btn-outline-success my-2 my-sm-0" style="margin-right:25px" type="submit"><@spring.message 'all.page.header.search'/></button>-->
            <div class="btn-group">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" id="profileDropdown"><img src="img/profile.png"width=40px height=40px style="margin-right: 10px"><font color="black"><@spring.message 'all.page.header.profile'/></font></a>
                <div class="dropdown-menu" aria-labelledby="profileDropdown">
                    <a class="dropdown-item" href="/profile"><@spring.message 'profile.page.myprofile'/></a>
                    <a class="dropdown-item" href="/bookmarks"><@spring.message 'profile.page.bookmarks'/></a>
                    <a class="dropdown-item" href="/myNotes"><@spring.message 'profile.page.mynotes'/></a>
                    <a class="dropdown-item" href="/changePassword"><@spring.message 'profile.page.changepassword'/></a>
                    <a class="dropdown-item" href="/logout"><@spring.message 'profile.page.logout'/></a>
                </div>
            </div>
        </form>
    </div>
</nav>
<#--<p><input id="query" placeholder="<@spring.message 'all.page.header.search'/>" type = "text" oninput="search(1)"/></p>-->


<div class="row" id="resptext">
<#list notes as note>
    <br>
<div class="container">
    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10">
            <div id="postlist">
                <div class="panel">
                    <div class="panel-heading">
                        <div class="text-center">
                            <div class="row">
                                <div class="col-sm-9">
                                    <h3 class="pull-left"> <a href="/note/${note.id}"> ${note.common_title}</a></h3>
                                </div>
                                <div class="col-sm-3">
                                    <h4 class="pull-right">
                                        <small>${note.createdAtString}</small>
                                    </h4>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="panel-body">
                        ${note.description}
                    </div>

                    <div class="panel-footer">
                        <span class="label label-default">Posted by <i>${note.user.name}</i></span>
                    </div>
                </div>

            </div>
        </div>
        <div class="col-md-1"></div>
        <div class="col-md-3">
        </div>
        <div class="col-md-1">
        </div>
    </div>
</div>
</#list>
</div>
<div id="pages-button-spawn">
    pages:
    <button class='like-disable' onclick="search(1)"> 1</button>
</div>

<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<!--<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>

</body>
</html>