<%--
  Created by IntelliJ IDEA.
  User: jahir
  Date: 6/7/17
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <!-- -->
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

        <!-- MENU ITEMS-->
        <ul id="slide-out" class="side-nav">
            <li>
                <div class="nav-title">
                    <h5>Soul Music</h5><a onclick="closeDrawer()"
                                          class="waves-effect show-on-large"><i class="mdi mdi-chevron-left"></i></a>
                </div>
            </li>
            <li>
                <div class="divider"></div>
            </li>
            <li>
                <a class="waves-effect" href="#!"><i class="mdi mdi-music-circle"></i>Canciones</a>
            </li>
            <li><a class="waves-effect" href="#!"><i class="mdi mdi-account-box"></i>Artistas</a>
            </li>
            <li><a class="waves-effect" href="#!"><i class="mdi mdi-album"></i>Albumes</a>
            </li>
            <li><a class="waves-effect" href="#!"><i class="mdi mdi-tag-multiple"></i>Generos</a></li>
            <li>
                <div class="divider"></div>
            </li>
            <li><a class="waves-effect" href="#!"><i class="mdi mdi-heart"></i>Favoritos</a></li>
            <li><a class="waves-effect" href="#!"><i class="mdi mdi-checkbox-multiple-blank"></i>Playlists</a></li>
            <li><a class="waves-effect" href="#!">Registro</a></li>
        </ul>
        <!-- fin MENU INTEMS-->


        <main>
            <div class="slider">
                <ul class="slides">
                    <li>
                        <img src="assets/images/imag1.PNG"/>
                        <div class="caption center-align">
                            <h3>Disfruta tus mejores canciones</h3>
                            <h5 class="light grey-text text-lighten-3">Busca las mejores canciones y
                                                                       artistas.</h5>
                        </div>
                    </li>
                    <li>
                        <img src="assets/images/imag2.jpg"/>  <!-- random image -->
                        <div class="caption left-align">
                            <h3>Se parte de nuestro proyecto</h3>
                        </div>
                    </li>
                    <li>
                        <img src="assets/images/imag3.jpg"/> <!-- random image -->
                        <div class="caption right-align">
                            <h3>Crea tus propias playlists</h3>
                            <h5 class="light grey-text text-lighten-3">Selecciona tu musica
                                                                       favorita</h5>
                        </div>
                    </li>
                </ul>
            </div>
            <!-- Inicio Boton Pulse -->
            <a class="btn btn-floating btn-large cyan pulse fab"><i
                    class="mdi mdi-play"></i></a>
            <!-- Final boton pulse -->
        </main>

        <script src="assets/js/jquery-2.1.4.min.js"></script>
        <script src="assets/js/materialize.min.js"></script>
        <script src="assets/js/ui.js"></script>
        <script type="text/javascript">
            $('.button-collapse').sideNav({
                                              menuWidth: 256, // Default is 300
                                              edge: 'left', // Choose the horizontal origin
                                              closeOnClick: true, // Closes side-nav on <a> clicks, useful for Angular/Meteor
                                              draggable: true // Choose whether you can drag to open on touch screens
                                          }
            );
            $('.slider').slider({
                                    indicators: false,
                                    interval: 2500
                                });
        </script>

    </body>
</html>