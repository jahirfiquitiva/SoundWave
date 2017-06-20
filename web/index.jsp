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
        <meta name="viewport"
              content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no">
        <link rel="stylesheet" href="assets/css/materialize.min.css">
        <link rel="stylesheet" href="assets/css/styles.css">
        <link rel="stylesheet" href="assets/css/materialdesignicons.min.css">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

        <!-- 'theme-color' will set background color in Chrome browser on Android 5.0+ -->
        <meta name="theme-color" content="#4285F4">

        <!-- Favicons -->
        <link rel="shortcut icon" href="assets/favicons/sw72.png">
        <link rel="apple-touch-icon" href="assets/favicons/sw57.png">
        <link rel="apple-touch-icon" sizes="72x72" href="favicons/sw72.png">
        <link rel="apple-touch-icon" sizes="114x114" href="favicons/sw114.png">
        <link rel="apple-touch-icon-precomposed" href="favicons/sw32.png">

        <link rel="icon" href="assets/favicons/sw32.png" sizes="32x32">
        <meta name="msapplication-TileColor" content="#4285F4">
        <meta name="msapplication-TileImage" content="assets/favicons/sw72.png">
    </head>

    <body onload="loadSongs();">

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
                        <a href="#"
                           class="brand-logo left waves-effect waves-light">SoundWave
                        </a>
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
                            <a class="waves-effect waves-light" href="#!"
                               onclick="updateComponents('account-container')">
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
                <a class="waves-effect" href="#!" onclick="updateComponents('songs');">
                    <i class="mdi mdi-music-circle"></i>
                    Canciones
                </a>

            </li>
            <li>
                <a class="waves-effect" href="#!"
                   onclick="updateComponents('artists-list');">
                    <i class="mdi mdi-account-box"></i>
                    Artistas
                </a>
            </li>

            <li>
                <a class="waves-effect" href="#!"
                   onclick="updateComponents('genres');">
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
                <a class="waves-effect" href="#!" onclick="updateComponents('favorites-list')">
                    <i class="mdi mdi-heart"></i>
                    Favoritos
                </a>
            </li>
            <li>
                <a class="waves-effect" href="#!" onclick="updateComponents('playlists_list')">
                    <i class="mdi mdi-library-music"></i>
                    Listas de reproduccion
                </a>
            </li>
            <li>
                <a class="waves-effect" href="#!"
                   onclick="updateComponents('account-container')">
                    <i class="mdi mdi-account-circle"></i>
                    Cuenta
                </a>
            </li>
            <li>
                <div class="divider"></div>
            </li>
            <li>
                <a class="waves-effect" href="#!" onclick="updateComponents('about-section')">
                    <i class="mdi mdi-information"></i>
                    Acerca de
                </a>
            </li>
        </ul>
        <!-- fin MENU INTEMS-->

        <main>
            <!-- Inicio canciones -->
            <div id="songs" style="display:none;" class="section-content">
            </div>
            <!-- Final canciones -->

            <!-- Inicio seccion cuenta -->
            <div id="account-container">
                <!-- Inicio Login -->
                <div class="login-container" id="login-section">
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
                                            <label for="username">Correo electronico o nombre de
                                                                  usuario</label>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="input-field col s12">
                                            <input id="password" type="password"
                                                   class="validate">
                                            <label for="password">Contraseña</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <a id="create-account" class="text-link"
                                       onclick="showRegister()">
                                        Aun no tienes cuenta?
                                    </a>
                                    <br>
                                    <a id="login" class="waves-effect btn cyan"
                                       onclick="login();">
                                        Iniciar sesion
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Fin login -->
                <!-- Inicio detalles usuario -->
                <div class="login-container" id="user-details" style="display: none;">
                    <div class="row">
                        <div class="col s4 m6 l6">
                            <div class="card-panel">
                                <div class="row">
                                    <h4 id="user-name" class="primary-text"></h4>
                                    <h6 id="user-type" class="primary-text"></h6>
                                </div>
                                <div class="row">
                                    <a id="logout" class="waves-effect btn cyan"
                                       onclick="logout();">
                                        Cerrar sesion
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Final detalles usuario -->

                <!-- Inicio crear cuenta -->
                <div class="login-container" id="register-section" style="display: none;">
                    <div class="row">
                        <div class="col s4 m6 l6">
                            <div class="card-panel">
                                <div class="row">
                                    <h4 class="primary-text">Registrate</h4>
                                    <h6 class="primary-text">para tener tu cuenta de
                                                             SoundWave</h6>
                                </div>
                                <div id="create-account-fields">
                                    <div class="row">
                                        <div class="input-field col s12">
                                            <input id="new-fullname" type="text"
                                                   class="validate">
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
                                            <input id="new-username" type="text"
                                                   class="validate">
                                            <label for="new-username">Nombre de usuario</label>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="input-field col s12">
                                            <input id="new-password" type="password"
                                                   class="validate">
                                            <label for="new-password">Contraseña</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <a id="cancel" class="waves-effect btn cyan"
                                       onclick="hideRegister();">
                                        Cancelar
                                    </a>
                                    <br><br>
                                    <a id="create" class="waves-effect btn cyan"
                                       onclick="createUser();">
                                        Crear cuenta
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Fin crear cuenta -->
            </div>
            <!-- Fin cuenta -->

            <!-- Inicio de lista de artistas-->
            <div id="artists-list" style="display:none;" class="section-content">
                <div class="container">
                    <!-- Page Content goes here -->
                    <ul class="collection with-header" id="artists-collection">
                    </ul>
                </div>
            </div>
            <!-- Fin de lista de artistas -->

            <!-- Inicio lista de generos -->
            <div id="genres" style="display:none;" class="section-content">
            </div>
            <!-- fin de lista de generos -->

            <!-- Inicio de lista de playlists -->
            <div id="playlists_list" style="display:none;" class="section-content">
            </div>
            <!-- fin de lista de playlists -->

            <!-- Lista de Facoritos -->
            <div id="favorites-list" style="display:none;" class="section-content">
            </div>
            <!-- Fin lista de favoritos -->

            <!-- Inicio seccion acerca de -->
            <div id="about-section" style="display: none;">
                <div class="container">
                    <h3 class="center">SoundWave</h3>
                    <img src="assets/favicons/sw-product-icon-192.png" class="product-icon"/>
                    <br>
                    <ul class="collection with-header">
                        <li class="collection-header"><h4>Aplicacion desarrollada por:</h4></li>
                        <li class="collection-item avatar">
                            <img src="https://github.com/jahirfiquitiva/Website-Resources/raw/master/myself/me-square-white.png"
                                 alt="" class="circle">
                            <span class="title">Jahir Fabian Fiquitiva Ricaurte</span>
                            <p>201521721</p>
                        </li>
                        <li class="collection-item avatar">
                            <img src="https://avatars1.githubusercontent.com/u/24307023?v=3&u=5b427b2395b788024075cb6a1de6e1b2c5245935&s=400"
                                 alt="" class="circle">
                            <span class="title">Sergio Andrés Rojas León</span>
                            <p>201520089</p>
                        </li>
                        <li class="collection-item avatar">
                            <i class="mdi mdi-account circle green">insert_chart</i>
                            <span class="title">Victor Andres Suarez Cardenas</span>
                            <p>201520838</p>
                        </li>
                    </ul>
                </div>
            </div>
            <!-- Fin seccion acerca de -->

        </main>

        <!-- inicio player -->
        <div class="player">
            <div class="progress" onmousedown="moveSong(event)">
                <div class="determinate" id="song-progress" style="width: 0"></div>
            </div>
            <div id="song-picture">
                <img id="current-album" src="" crossorigin=""
                     class="responsive-img player-img"/>
            </div>
            <div class="song-details">
                <h5 id="song-detail-name" class="primary-text"></h5>
                <h6 id="song-detail-artist" class="secondary-text"></h6>
            </div>

            <div class="buttons">
                <i class="mdi mdi-star waves-ripple" onclick="addToFavorites()"></i>
                <i class="mdi mdi-skip-previous waves-ripple" onclick="playPrevious()"></i>

                <a class="waves-ripple" onclick="seek(false)">
                    <i class="mdi mdi-skip-backward waves-ripple"></i>
                </a>
                <a class="waves-ripple pulse" onclick="playPauseSong(true)">
                    <i id="play-button" class="mdi mdi-play-circle">
                    </i>
                </a>
                <a class="waves-ripple pulse" onclick="playPauseSong(false)">
                    <i id="pause-button" class="mdi mdi-pause-circle"></i>
                </a>
                <a class="waves-ripple" onclick="seek(true)">
                    <i class="mdi mdi-skip-forward waves-ripple"></i>
                </a>
                <i class="mdi mdi-skip-next waves-ripple" onclick="playNext()"></i>

                <i class="mdi mdi-playlist-plus waves-ripple" onclick="addToPlaylist()"></i>
            </div>
            <div class="whole-volume-container">
                <i class="mdi mdi-volume-high volume-icon-low" onclick="volumeUp()"></i>
                <div class="volume-container">
                    <form>
                        <p class="range-field">
                            <input type="range" id="volume-slider" min="0" max="100" value="100"
                                   oninput="updateVolume()" onchange="updateVolume()"/>
                        </p>
                    </form>
                </div>
                <i class="mdi mdi-volume-low volume-icon" onclick="volumeDown()"></i>
            </div>
            <audio id="song-player" preload="none" ontimeupdate="updateSongProgress()"
                   current-song-id="" crossorigin="">
                <source src="" type="audio/mpeg"/>
            </audio>
        </div>
        <!-- fin player -->

        <script src="assets/js/load.js"></script>
        <script src="assets/js/core.js"></script>
        <script src="assets/js/music.js"></script>
        <script src="assets/js/playlists.js"></script>
        <script src="assets/js/jquery-2.1.4.min.js"></script>
        <script src="assets/js/materialize.min.js"></script>
        <script src="assets/js/vibrant.min.js"></script>
        <script src="assets/js/ui.js"></script>

        <script type="text/javascript">
            $('.button-collapse').sideNav({
                                              menuWidth:    280, // Default is 300
                                              edge:         'left', // Choose the horizontal origin
                                              closeOnClick: true, // Closes side-nav on <a> clicks, useful for Angular/Meteor
                                              draggable:    true // Choose whether you can drag to open on touch screens
                                          }
            );
            $('.slider').slider({
                                    indicators: false,
                                    interval:   2500
                                });
        </script>
        <script type="text/javascript">
            $(document).ready(function () {
                $('select').material_select();
            });
        </script>

        <!--
         <form method="POST" action="ServUpload" enctype="multipart/form-data">

            File: <input type="file" name="file" id="file"/> <br/>
            Destination:<input type="text" value="/tmp" name="destination"/> </br>

            <input type="submit" value="Upload" name="upload" id="upload"/>

        </form>
        -->
    </body>
</html>
