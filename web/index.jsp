<%--
  Created by IntelliJ IDEA.
  User: jahir
  Date: 6/7/17
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <!-- -->
    <head>
        <title>SoundWave</title>
        <meta lang="es"/>
        <link rel="stylesheet" href="assets/css/materialize.min.css">
        <link rel="stylesheet" href="assets/css/styles.css">
        <link rel="stylesheet" href="assets/css/materialdesignicons.min.css">
    </head>

    <body >
        <div class="navbar-fixed">
            <nav>
                <div class="nav-wrapper cyan">
                    <ul class="left">
                        <li>
                            <a href="#" data-activates="slide-out"
                               class="button-collapse waves-effect waves-light show-on-large">
                                <i class="mdi mdi-menu material-icons"></i>
                            </a>
                        </li>
                        <a href="#" class="brand-logo left waves-effect waves-light">SoundWave</a>
                    </ul>
                    <ul class="right">
                        <li>
                            <form>
                                <div class="input-field">
                                    <input id="search" type="search" required>
                                    <label class="label-icon" for="search">
                                        <i class="mdi mdi-magnify material-icons"></i>
                                    </label>
                                    <i class="mdi mdi-close material-icons"></i>
                                </div>
                            </form>
                        </li>
                        <li>
                            <a class="waves-effect waves-light" href="#">
                                <i class="mdi mdi-upload material-icons"></i>
                            </a>
                        </li>
                        <li>
                            <a class="waves-effect waves-light" href="#">
                                <i class="mdi mdi-account-circle material-icons"></i>
                            </a>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>

        <!-- MENU ITEMS-->
        <ul id="slide-out" class="side-nav">
            <li>
                <div class="nav-title">
                    <h5 class="cyan-text">SoundWave</h5>
                    <a onclick="closeDrawer()"
                       class="waves-effect show-on-large">
                        <i class="mdi mdi-chevron-left"></i>
                    </a>
                </div>
            </li>
            <li>
                <div class="divider"></div>
            </li>
            <li>
                <a class="waves-effect" href="#!">
                    <i class="mdi mdi-music-circle"></i>
                    Canciones
                </a>
            </li>
            <li>
                <a class="waves-effect" href="#!">
                    <i class="mdi mdi-account-box"></i>
                    Artistas
                </a>
            </li>
            <li>
                <a class="waves-effect" href="#!">
                    <i class="mdi mdi-album"></i>
                    Albumes
                </a>
            </li>

            <li>
                <a class="waves-effect" href="#!">
                    <i class="mdi mdi-tag-multiple"></i>
                    Generos
                </a>
            </li>

            <li>
                <div class="divider"></div>
            </li>
            <li>
                <a class="subheader">Personal</a>
            </li>
            <li>
                <a class="waves-effect" href="#!">
                    <i class="mdi mdi-heart"></i>
                    Favoritos
                </a>
            </li>
            <li>
                <a class="waves-effect" href="#!">
                    <i class="mdi mdi-checkbox-multiple-blank"></i>
                    Listas de reproduccion
                </a>
            </li>
            <li>
                <a class="waves-effect" href="#!">Registro</a>
            </li>
        </ul>
        <!-- fin MENU INTEMS-->

        <main>
            <!-- Inicio canciones -->
            <div id="songs" class="section-content">
                <h3 class="cyan-text section-title">Canciones</h3>
                <div class="row">
                    <div class="col s4 m3 l2">
                        <div class="grid-item">
                            <img class="responsive-img" crossorigin=""
                                 src="https://i1.sndcdn.com/artworks-000219688327-32sd7f-t500x500.jpg"
                            onload="loadCardColors(event)"/>
                            <div class="divider"></div>
                            <div class="grid-item-content">
                                <p class="primary-text">Where do I go?</p>
                                <h6 class="secondary-text">Brandon Jonak & Pep.B</h6>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Final canciones -->


            <!-- Inicio Login -->
            <div class="login-container">
                <div class="row">
                    <div class="col s4 m6 l6">
                        <div class="card-panel">
                            <div class="row">
                                <h4 class="primary-text">Iniciar sesion</h4>
                                <h6 class="primary-text">con tu cuenta de SoundWave</h6>
                            </div>
                            <div id="main-fields">
                                <div class="row">
                                    <div class="input-field col s12">
                                        <input id="username" type="text" class="validate">
                                        <label for="username">Nombre de usuario</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="input-field col s12">
                                        <input id="password" type="password" class="validate">
                                        <label for="password">Contraseña</label>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <a id="create-account" class="text-link">Aun no tienes cuenta?</a>
                                <a id="login" class="waves-effect btn cyan" onclick="process();">
                                    Iniciar sesion
                                </a>
                                <a id="logout" class="waves-effect btn cyan" onclick="logOut();">
                                    Cerrar sesion
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Fin login-->

            <!-- Inicio crear cuenta -->
            <div class="login-container">
                <div class="row">
                    <div class="col s4 m6 l6">
                        <div class="card-panel">
                            <div class="row">
                                <h4 class="primary-text">Registrate</h4>
                                <h6 class="primary-text">para tener tu cuenta de SoundWave</h6>
                            </div>
                            <div id="create-account-fields">
                                <div class="row">
                                    <div class="input-field col s12">
                                        <input id="new-fullname" type="text" class="validate">
                                        <label for="new-fullname">Nombre completo</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="input-field col s12">
                                        <input id="new-email" type="email" class="validate">
                                        <label for="new-email">Correo electronico</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="input-field col s12">
                                        <input id="new-username" type="text" class="validate">
                                        <label for="new-username">Nombre de usuario</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="input-field col s12">
                                        <input id="new-password" type="password" class="validate">
                                        <label for="new-password">Contraseña</label>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <a id="create" class="waves-effect btn cyan" onclick="process();">
                                    Crear cuenta
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Fin crear cuenta-->


            <!-- Inicio Boton Pulse -->
            <a class="btn btn-floating btn-large cyan pulse fab">
                <i class="mdi mdi-play"></i>
            </a>
            <!-- Final boton pulse -->
        </main>

        <script src="assets/js/jquery-2.1.4.min.js"></script>
        <script src="assets/js/materialize.min.js"></script>
        <script src="assets/js/vibrant.min.js"></script>
        <script src="assets/js/ui.js"></script>
        <script type="text/javascript">
            $('.button-collapse').sideNav({
                                              menuWidth: 280, // Default is 300
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