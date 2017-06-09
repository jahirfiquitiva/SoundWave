<%--
  Created by IntelliJ IDEA.
  User: jahir
  Date: 6/7/17
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Soul Music</title>
        <meta lang="es"/>
        <link rel="stylesheet" href="assets/css/materialize.min.css">
        <link rel="stylesheet" href="assets/css/styles.css">
        <link rel="stylesheet" href="assets/css/materialdesignicons.min.css">
    </head>
    <body>
        <div class="navbar-fixed">
            <nav>
                <div class="nav-wrapper cyan">
                    <ul class="left">
                        <li><a href="#" data-activates="slide-out"
                               class="button-collapse waves-effect waves-light show-on-large"><i
                                class="mdi mdi-menu material-icons"></i></a></li>
                        <a href="#" class="brand-logo left waves-effect waves-light">Soul Music</a>
                    </ul>
                    <ul class="right">
                        <li>
                            <form>
                                <div class="input-field">
                                    <input id="search" type="search" required>
                                    <label class="label-icon" for="search"><i
                                            class="mdi mdi-magnify material-icons"></i></label>
                                    <i class="mdi mdi-close material-icons"></i>
                                </div>
                            </form>
                        </li>
                        <li><a class="waves-effect waves-light" href="#"><i
                                class="mdi mdi-account-circle material-icons"></i></a>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>
        <ul id="slide-out" class="side-nav">
            <li><a class="waves-effect" href="#!">Canciones</a></li>
            <li><a class="waves-effect" href="#!">Artistas</a></li>
        </ul>

        <script src="assets/js/jquery-2.1.4.min.js"></script>
        <script src="assets/js/materialize.min.js"></script>
        <script type="text/javascript">
            $('.button-collapse').sideNav({
                                              menuWidth: 256, // Default is 300
                                              edge: 'left', // Choose the horizontal origin
                                              closeOnClick: true, // Closes side-nav on <a> clicks, useful for Angular/Meteor
                                              draggable: true // Choose whether you can drag to open on touch screens
                                          }
            );
        </script>

    </body>
</html>
