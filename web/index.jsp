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
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--<link rel="shortcut icon" type="image/x-icon" href="/images/icon1.ico" /> -->
    </head>

    <body>
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
                                 src="https://i1.sndcdn.com/artworks-000227625218-5u67k2-t500x500.jpg"
                                 onload="loadCardColors(event)"/>
                            <div class="divider"></div>
                            <div class="grid-item-content">
                                <h5 class="primary-text">Spirit of Things</h5>
                                <p class="secondary-text">Floatinurboat NCS</p>
                                <i class="mdi mdi-dots-vertical menu"></i>
                            </div>
                        </div>
                    </div>

                    <div class="col s4 m3 l2">
                        <div class="grid-item">
                            <img class="responsive-img" crossorigin=""
                                 src="https://i1.sndcdn.com/artworks-000225347036-c2bg8r-t500x500.jpg"
                                 onload="loadCardColors(event)"/>
                            <div class="divider"></div>
                            <div class="grid-item-content">
                                <h5 class="primary-text">Sleepless</h5>
                                <p class="secondary-text">NCS Release</p>
                                <i class="mdi mdi-dots-vertical menu"></i>
                            </div>
                        </div>
                    </div>
                    <div class="col s4 m3 l2">
                        <div class="grid-item">
                            <img class="responsive-img" crossorigin=""
                                 src="https://i1.sndcdn.com/artworks-000225852881-pk95lg-t500x500.jpg"
                                 onload="loadCardColors(event)"/>
                            <div class="divider"></div>
                            <div class="grid-item-content">
                                <h5 class="primary-text">Lightning</h5>
                                <p class="secondary-text">NCS Release</p>
                                <i class="mdi mdi-dots-vertical menu"
                                   data-activates="songs-menu"></i>
                            </div>
                        </div>
                    </div>
                    <div class="col s4 m3 l2">
                        <div class="grid-item">
                            <img class="responsive-img" crossorigin=""
                                 src="https://i1.sndcdn.com/artworks-000225347036-c2bg8r-t500x500.jpg"
                                 onload="loadCardColors(event)"/>
                            <div class="divider"></div>
                            <div class="grid-item-content">

                                <h5 class="primary-text">Gave To Me</h5>
                                <p class="secondary-text">NCS Release</p>
                                <i class="mdi mdi-dots-vertical menu"></i>
                            </div>
                        </div>
                    </div>
                    <div class="col s4 m3 l2">
                        <div class="grid-item">
                            <img class="responsive-img" crossorigin=""
                                 src="https://i1.sndcdn.com/artworks-000219688327-32sd7f-t500x500.jpg"
                                 onload="loadCardColors(event)"/>
                            <div class="divider"></div>
                            <div class="grid-item-content">
                                <h5 class="primary-text">Where do I go?</h5>
                                <p class="secondary-text">Brandon Jonak & Pep.B</p>
                                <i class="mdi mdi-dots-vertical menu"></i>
                            </div>

                        </div>
                    </div>
                    <div class="col s4 m3 l2">
                        <div class="grid-item">
                            <img class="responsive-img" crossorigin=""
                                 src="https://i1.sndcdn.com/artworks-000227526682-qlodkc-t500x500.jpg"
                                 onload="loadCardColors(event)"/>
                            <div class="divider"></div>
                            <div class="grid-item-content">
                                <h5 class="primary-text">Imposible</h5>
                                <p class="secondary-text">Alien</p>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col s4 m3 l2">
                        <div class="grid-item">
                            <img class="responsive-img" crossorigin=""
                                 src="https://i1.sndcdn.com/artworks-000228761930-uw4sqw-t500x500.jpg"
                                 onload="loadCardColors(event)"/>
                            <div class="divider"></div>
                            <div class="grid-item-content">
                                <h5 class="primary-text">Droeloe</h5>
                                <p class="secondary-text">Monsterscat</p>
                            </div>

                        </div>
                    </div>
                    <div class="col s4 m3 l2">
                        <div class="grid-item">
                            <img class="responsive-img" crossorigin=""
                                 src="https://i1.sndcdn.com/artworks-000228011793-1mp015-t500x500.jpg"
                                 onload="loadCardColors(event)"/>
                            <div class="divider"></div>
                            <div class="grid-item-content">
                                <h5 class="primary-text">Slushii</h5>
                                <p class="secondary-text">Monsterscat</p>
                            </div>

                        </div>
                    </div>

                    <div class="col s4 m3 l2">
                        <div class="grid-item">
                            <img class="responsive-img" crossorigin=""
                                 src="https://i1.sndcdn.com/artworks-000227210598-cg71d7-t500x500.jpg"
                                 onload="loadCardColors(event)"/>
                            <div class="divider"></div>
                            <div class="grid-item-content">
                                <h5 class="primary-text">RIOT</h5>
                                <p class="secondary-text">Monsterscat</p>
                            </div>

                        </div>
                    </div>
                    <div class="col s4 m3 l2">
                        <div class="grid-item">
                            <img class="responsive-img" crossorigin=""
                                 src="https://i1.sndcdn.com/artworks-000225651456-ypd7ay-t500x500.jpg"
                                 onload="loadCardColors(event)"/>
                            <div class="divider"></div>
                            <div class="grid-item-content">
                                <h5 class="primary-text">Dirty audio</h5>
                                <p class="secondary-text">Monsterscat</p>
                            </div>

                        </div>
                    </div>
                    <div class="col s4 m3 l2">
                        <div class="grid-item">
                            <img class="responsive-img" crossorigin=""
                                 src="https://i1.sndcdn.com/artworks-000224978962-mn9lmp-t500x500.jpg"
                                 onload="loadCardColors(event)"/>
                            <div class="divider"></div>
                            <div class="grid-item-content">
                                <h5 class="primary-text">Kontinuum</h5>
                                <p class="secondary-text">NCS Release</p>
                            </div>

                        </div>
                    </div>
                    <div class="col s4 m3 l2">
                        <div class="grid-item">
                            <img class="responsive-img" crossorigin=""
                                 src="https://i1.sndcdn.com/artworks-000224616021-j9uv1f-t500x500.jpg"
                                 onload="loadCardColors(event)"/>
                            <div class="divider"></div>
                            <div class="grid-item-content">
                                <h5 class="primary-text">Skyline</h5>
                                <p class="secondary-text">Kovan & Electro Light</p>
                            </div>

                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col s4 m3 l2">
                        <div class="grid-item">
                            <img class="responsive-img" crossorigin=""
                                 src="https://i1.sndcdn.com/artworks-000223136404-gh0bj7-t500x500.jpg"
                                 onload="loadCardColors(event)"/>
                            <div class="divider"></div>
                            <div class="grid-item-content">
                                <h5 class="primary-text">Unknown Brain</h5>
                                <p class="secondary-text">Marvin Divine - NCS Release</p>
                            </div>

                        </div>
                    </div>
                    <div class="col s4 m3 l2">
                        <div class="grid-item">
                            <img class="responsive-img" crossorigin=""
                                 src="https://i1.sndcdn.com/artworks-000222434012-2yqck6-t500x500.jpg"
                                 onload="loadCardColors(event)"/>
                            <div class="divider"></div>
                            <div class="grid-item-content">
                                <h5 class="primary-text">Sicc</h5>
                                <p class="secondary-text">RetroVision & Domastic</p>
                            </div>

                        </div>
                    </div>
                    <div class="col s4 m3 l2">
                        <div class="grid-item">
                            <img class="responsive-img" crossorigin=""
                                 src="https://i1.sndcdn.com/artworks-000222122845-o35pkp-t500x500.jpg"
                                 onload="loadCardColors(event)"/>
                            <div class="divider"></div>
                            <div class="grid-item-content">
                                <h5 class="primary-text">Don't Let It Go</h5>
                                <p class="secondary-text">Anikdote & Culture Code</p>
                            </div>

                        </div>
                    </div>
                    <div class="col s4 m3 l2">
                        <div class="grid-item">
                            <img class="responsive-img" crossorigin=""
                                 src="https://i1.sndcdn.com/artworks-000224856191-2t8qlj-t500x500.jpg"
                                 onload="loadCardColors(event)"/>
                            <div class="divider"></div>
                            <div class="grid-item-content">
                                <h5 class="primary-text">We do</h5>
                                <p class="secondary-text">Monstercat</p>
                            </div>

                        </div>
                    </div>
                    <div class="col s4 m3 l2">
                        <div class="grid-item">
                            <img class="responsive-img" crossorigin=""
                                 src="https://i1.sndcdn.com/artworks-000224856191-2t8qlj-t500x500.jpg"
                                 onload="loadCardColors(event)"/>
                            <div class="divider"></div>
                            <div class="grid-item-content">
                                <h5 class="primary-text">Discovery</h5>
                                <p class="secondary-text">Monstercat</p>
                            </div>

                        </div>
                    </div>
                    <div class="col s4 m3 l2">
                        <div class="grid-item">
                            <img class="responsive-img" crossorigin=""
                                 src="https://i1.sndcdn.com/artworks-000220489672-uqnbk6-t500x500.jpg"
                                 onload="loadCardColors(event)"/>
                            <div class="divider"></div>
                            <div class="grid-item-content">
                                <h5 class="primary-text">Bass Drop</h5>
                                <p class="secondary-text">Monstercat</p>
                            </div>

                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col s4 m3 l2">
                        <div class="grid-item">
                            <img class="responsive-img" crossorigin=""
                                 src="https://i1.sndcdn.com/artworks-000221373876-hm35dg-t500x500.jpg"
                                 onload="loadCardColors(event)"/>
                            <div class="divider"></div>
                            <div class="grid-item-content">
                                <h5 class="primary-text">Make me move</h5>
                                <p class="secondary-text">Karra & NCS Release</p>
                            </div>

                        </div>
                    </div>
                    <div class="col s4 m3 l2">
                        <div class="grid-item">
                            <img class="responsive-img" crossorigin=""
                                 src="https://i1.sndcdn.com/artworks-000220484881-v2muub-t500x500.jpg"
                                 onload="loadCardColors(event)"/>
                            <div class="divider"></div>
                            <div class="grid-item-content">
                                <h5 class="primary-text">Whole</h5>
                                <p class="secondary-text">Chime & Adam Tell</p>
                            </div>

                        </div>
                    </div>
                    <div class="col s4 m3 l2">
                        <div class="grid-item">
                            <img class="responsive-img" crossorigin=""
                                 src="https://i1.sndcdn.com/artworks-000219943203-3go96g-t500x500.jpg"
                                 onload="loadCardColors(event)"/>
                            <div class="divider"></div>
                            <div class="grid-item-content">
                                <h5 class="primary-text">All eyer on me</h5>
                                <p class="secondary-text">Michael White-NCS </p>
                            </div>

                        </div>
                    </div>
                    <div class="col s4 m3 l2">
                        <div class="grid-item">
                            <img class="responsive-img" crossorigin=""
                                 src="https://i1.sndcdn.com/artworks-000219341859-7euouf-t500x500.jpg"
                                 onload="loadCardColors(event)"/>
                            <div class="divider"></div>
                            <div class="grid-item-content">
                                <h5 class="primary-text">Free</h5>
                                <p class="secondary-text">Elektronomia & JJD</p>
                            </div>

                        </div>
                    </div>
                    <div class="col s4 m3 l2">
                        <div class="grid-item">
                            <img class="responsive-img" crossorigin=""
                                 src="https://i1.sndcdn.com/artworks-000218689296-qxjf8b-t500x500.jpg"
                                 onload="loadCardColors(event)"/>
                            <div class="divider"></div>
                            <div class="grid-item-content">
                                <h5 class="primary-text">Psycho</h5>
                                <p class="secondary-text">Four eyes-NCS</p>
                            </div>

                        </div>
                    </div>
                    <div class="col s4 m3 l2">
                        <div class="grid-item">
                            <img class="responsive-img" crossorigin=""
                                 src="https://i1.sndcdn.com/artworks-000220114872-2lx5v1-t500x500.jpg"
                                 onload="loadCardColors(event)"/>
                            <div class="divider"></div>
                            <div class="grid-item-content">
                                <h5 class="primary-text">Sweet</h5>
                                <p class="secondary-text">Unlike Pluto</p>
                            </div>

                        </div>
                    </div>

                </div>
            </div>
            <!-- Final canciones -->
            <div class="divider"></div>
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
                                <a id="create-account" class="text-link">Aun no tienes cuenta?
                                </a>
                                <a id="login" class="waves-effect btn cyan"
                                   onclick="process();">
                                    Iniciar sesion
                                </a>
                                <a id="logout" class="waves-effect btn cyan"
                                   onclick="logOut();">
                                    Cerrar sesion
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Fin login -->
            <div class="divider"></div>
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
                                        <input id="new-password" type="password"
                                               class="validate">
                                        <label for="new-password">Contraseña</label>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <a id="create" class="waves-effect btn cyan"
                                   onclick="process();">
                                    Crear cuenta
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Fin crear cuenta-->
            <div class="divider"></div>
            <!-- Inicio de lista de artistas-->
            <div id="artists-list" class="section-content">
                <div class="container">
                    <!-- Page Content goes here -->
                    <ul class="collection with-header">
                        <li class="collection-header"><h4>Artistas</h4></li>
                        <li class="collection-item avatar">
                            <img src="https://i1.sndcdn.com/artworks-000227625218-5u67k2-t500x500.jpg"
                                 alt="" class="circle">
                            <span class="title">NCS </span>
                            <p>NCS Release <br>
                               Genero: Mix ING.Electronica
                            </p>
                            <a href="#!" class="secondary-content">
                                <i class="mdi mdi-library-music"></i>
                            </a>
                        </li>
                        <li class="collection-item avatar">
                            <i class="material-icons circle">img art</i>
                            <span class="title">SARL</span>
                            <p>First Line <br>
                               Second Line
                            </p>
                            <a href="#!" class="secondary-content">
                                <i class="mdi mdi-library-music"></i>
                            </a>
                        </li>
                        <li class="collection-item avatar">
                            <i class="material-icons circle green">img art</i>
                            <span class="title">Title</span>
                            <p>First Line <br>
                               Second Line
                            </p>
                            <a href="#!" class="secondary-content">
                                <i class="mdi mdi-library-music"></i>
                            </a>
                        </li>
                        <li class="collection-item avatar">
                            <i class="material-icons circle red">play_arrow</i>
                            <span class="title">Title</span>
                            <p>First Line <br>
                               Second Line
                            </p>
                            <a href="#!" class="secondary-content">
                                <i class="mdi mdi-library-music"></i>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
            <!-- Fin de lista de artistas -->
            <div class="divider"></div>
            <!-- Inicio lista de generos -->
            <div id="genres" class="section-content">
                <h3 class="cyan-text section-title">Generos</h3>
                <div class="row">
                    <div class="col s4 m3 l2">
                        <div class="grid-item">
                            <img class="responsive-img" crossorigin="anonymous"
                                 src="https://i1.sndcdn.com/artworks-000227378436-y07in3-t500x500.jpg"
                                 onload="loadCardColors(event)"/>
                            <div class="divider"></div>
                            <div class="grid-item-content">
                                <p class="primary-text">Electro House</p>
                            </div>
                        </div>
                    </div>

                    <div class="col s4 m3 l2">
                        <div class="grid-item">
                            <img class="responsive-img" crossorigin=""
                                 src="http://3.bp.blogspot.com/--pem6TeduTg/TiXe97AyVlI/AAAAAAAAACU/ou6R6fM-j58/s1600/pop.jpg"
                                 onload="loadCardColors(event)"/>
                            <div class="divider"></div>
                            <div class="grid-item-content">
                                <p class="primary-text">Dubstep</p>
                            </div>
                        </div>
                    </div>
                    <div class="col s4 m3 l2">
                        <div class="grid-item">
                            <img class="responsive-img" crossorigin=""
                                 src="https://i1.sndcdn.com/artworks-000228571109-9v1ty0-t500x500.jpg"
                                 onload="loadCardColors(event)"/>
                            <div class="divider"></div>
                            <div class="grid-item-content">
                                <p class="primary-text">Electro Dance</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- fin de lista de generos -->
            <div class="divider"></div>
            <!-- Inicio de lista de playlists -->
            <div id="playlists-list" class="section-content">
                <div class="container">
                    <ul class="collection with-header">
                        <li class="collection-header"><h4>Listas de reproduccion</h4></li>
                        <li class="collection-item">
                            <div class="playlist-title">
                                Music
                                <a href="#!" class="secondary-content">
                                    <i class="mdi mdi-play"></i>
                                </a>
                            </div>
                        </li>
                        <li class="collection-item">
                            <div>Colegio
                                <a href="#!" class="secondary-content">
                                    <i class="mdi mdi-play"></i>
                                </a>
                            </div>
                        </li>
                        <li class="collection-item">
                            <div>Gym
                                <a href="#!" class="secondary-content">
                                    <i class="mdi mdi-play"></i>
                                </a>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
            <!-- fin de lista de playlists -->

            <!-- Menu canciones -->
            <ul id='songs-menu' class='dropdown-content'>
                <li>
                    <a href="#!">one</a>
                </li>
                <li>
                    <a href="#!">two</a>
                </li>
                <li class="divider"></li>
                <li>
                    <a href="#!">
                        <i class="material-icons">view_module</i>
                        four
                    </a>
                </li>
                <li>
                    <a href="#!">
                        <i class="material-icons">cloud</i>
                        five
                    </a>
                </li>
            </ul>
            <!-- Fin menu canciones -->
        </main>


        <!-- Inicio Boton Pulse -->
        <a class="btn btn-floating btn-large cyan pulse fab">
            <i class="mdi mdi-play"></i>
        </a>
        <!-- Final boton pulse -->

        <!-- inicio player -->
        <div class="player">
            <!--
            <form action="#">
                <p class="range-field">
                    <input type="range" readonly id="song-progress" min="0" max="100" value="0"/>
                </p>
            </form>
            -->
            <div class="progress">
                <div class="determinate" id="song-progress" style="width: 0%"></div>
            </div>
            <div class="buttons">
                <i class="mdi mdi-skip-previous waves-ripple"></i>
                <a href="#" class="waves-ripple pulse" onclick="playSong(event,true)">
                    <i id="play-button" class="mdi mdi-play-circle">
                    </i>
                </a>
                <a href="#" class="waves-ripple pulse" onclick="playSong(event,false)">
                    <i id="pause-button" class="mdi mdi-pause-circle"></i>
                </a>
                <i class="mdi mdi-skip-next waves-ripple"></i>
            </div>
            <audio id="song-player" preload="none" ontimeupdate="updateSongProgress()">
                <source src="assets/music/where_do_i_go.mp3" type="audio/mpeg"/>
            </audio>
        </div>
        <!-- fin player -->

        <script src="assets/js/jquery-2.1.4.min.js"></script>
        <script src="assets/js/materialize.min.js"></script>
        <script src="assets/js/vibrant.min.js"></script>
        <script src="assets/js/ui.js"></script>
        <script src="assets/js/core.js"></script>
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
            $('.menu').dropdown({
                                    constrainWidth: false, // Does not change width of dropdown to that of the activator
                                    gutter: 0, // Spacing from edge
                                    belowOrigin: false, // Displays dropdown below the button
                                    alignment: 'left', // Displays dropdown with edge aligned to the left of button
                                    stopPropagation: false // Stops event propagation
                                }
            );
        </script>

    </body>
    </htm