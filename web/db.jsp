<%--
  Created by IntelliJ IDEA.
  User: jahir
  Date: 6/7/17
  Time: 10:29 a.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Databases</title>
        <meta lang="es" charset="UTF-8"/>
        <meta name="keywords" content="html, css, javascript, servlets, java, httprequest">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="assets/css/materialize.min.css">
        <link rel="stylesheet" href="assets/css/styles.css">
        <link rel="stylesheet" href="assets/css/materialdesignicons.min.css">
    </head>
    <body>
        <div class="navbar-fixed">
            <nav>
                <div class="nav-wrapper cyan">
                    <ul class="left">
                        <a href="#" class="brand-logo left waves-effect waves-light">Database</a>
                    </ul>
                </div>
            </nav>
        </div>

        <div class="row">
            <div class="col l8 s12 m5">
                <div class="card-panel">
                    <div id="results">

                    </div>
                </div>
            </div>
            <div class="col s4 m3">
                <div class="card-panel">
                    <div class="row">
                        <h4 class="cyan-text">User data</h4>
                    </div>
                    <div class="row">
                        <div class="input-field col s12">
                            <input id="username" type="text" class="validate">
                            <label for="username">User name</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12">
                            <input id="password" type="password" class="validate">
                            <label for="password">Password</label>
                        </div>
                    </div>
                    <div class="row">
                        <a class="waves-effect btn cyan accent-4" onclick="process();">Log in</a>
                    </div>
                </div>
            </div>
        </div>

        <script src="assets/js/jquery-2.1.4.min.js"></script>
        <script src="assets/js/materialize.min.js"></script>
        <script src="assets/js/core.js"></script>
    </body>
</html>