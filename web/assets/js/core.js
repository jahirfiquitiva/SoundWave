/**
 * Created by jahir on 6/9/17.
 */

function playPauseSong(play) {
    var playIcon = document.getElementById("play-button");
    var pauseIcon = document.getElementById("pause-button");
    playIcon.style.display = !play ? "inline-block" : "none";
    pauseIcon.style.display = play ? "inline-block" : "none";
    var player = document.getElementById("song-player");
    var method = play ? "play" : "pause";
    player[method]();
    updateSongProgress();
    return false;
}

function updateSongProgress() {
    var player = document.getElementById("song-player");
    var played = (100 * player.currentTime) / player.duration;
    document.getElementById("song-progress").style.width = played + "%";
}

function seek(forward) {
    var player = document.getElementById("song-player");
    var duration = player.duration;
    var currentTime = player.currentTime;
    var nTime = forward ? (currentTime + 5) : (currentTime - 5);
    player.currentTime = nTime >= duration ? duration : nTime <= 0 ? 0 : nTime;
    updateSongProgress();
}

function moveSong(e) {
    var player = document.getElementById("song-player");
    var progress = document.getElementById("song-progress");

    var w = window,
        d = document,
        el = d.documentElement,
        g = d.getElementsByTagName('body')[0],
        realWidth = w.innerWidth || el.clientWidth || g.clientWidth,
        realHeight = w.innerHeight || el.clientHeight || g.clientHeight;

    var newProgress = (100 * e.pageX) / realWidth;
    player.currentTime = (player.duration * newProgress) / 100;
    updateSongProgress();
}

function playSong(e) {
    try {
        var panel = e.target.parentElement;
        if (panel !== null && panel !== undefined) {
            var contains = panel.classList.contains('grid-item');
            while (!contains) {
                panel = panel.parentElement;
                contains = panel.classList.contains('grid-item');
            }
            var path = panel.getAttribute("data-path");
            if (path !== null && path !== undefined) {
                var player = document.getElementById("song-player");
                player.src = path;
                playPauseSong(true);
            }
        }
    } catch (ignored) {
    }
}

/* OLD METHODS */

function process() {
    var xhr = new XMLHttpRequest();
    var name = document.getElementById("username").value;
    var pass = document.getElementById("password").value;
    if (name.length > 0 && pass.length > 0) {
        var toSend = "username=" + name + "&password=" + pass + "&login=1";
        xhr.open("POST", "LoginServlet", true);
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {
                document.getElementById("user-title").innerHTML = "User";
                var jsonContent = JSON.parse(xhr.responseText);
                if (jsonContent.name !== undefined) {

                    Materialize.toast("Bienvenido " + jsonContent.name, 2000);
                    document.getElementById("user-title").innerHTML = jsonContent.name;

                    changeVisibility("admin-content", jsonContent.type === "ADMIN");
                    changeVisibility("normal-content", jsonContent.type === "NORMAL");
                    changeVisibility("guest-content", jsonContent.type === "GUEST");

                    if (jsonContent.list !== undefined) {
                        buildTable(jsonContent.list);
                    }

                    if (jsonContent.type === "NORMAL") {
                        document.getElementById("id").innerHTML = jsonContent.id;
                        document.getElementById("user-name").innerHTML = jsonContent.name;
                    }

                    document.getElementById("username").value = "";
                    document.getElementById("password").value = "";
                    changeVisibility("main-fields", false);
                    changeVisibility("login", false);
                    changeVisibility("logout", true);
                } else {
                    Materialize.toast("Error!<br>" + jsonContent.error, 2000);
                    changeVisibility("admin-content", false);
                    changeVisibility("normal-content", false);
                    changeVisibility("guest-content", true);
                }
            }
        };
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhr.send(toSend);
    } else {
        Materialize.toast('Los campos estan vacios.', 2000, 'rounded');
    }
}

function changeVisibility(id, show) {
    document.getElementById(id).style.display = show ? 'block' : 'none';
}

function buildTable(list) {
    var rsAux = document.getElementById("users-table-container");
    rsAux.innerHTML = "";
    var tabResult = document.createElement("table");
    tabResult.setAttribute("id", "users-table");
    tabResult.setAttribute("border", "1");
    tabResult.setAttribute("class", "bordered striped highlight centered");
    rsAux.appendChild(tabResult);
    var tabAux = document.getElementById("users-table");
    var tabHead = document.createElement("thead");
    var row = document.createElement("tr");

    var col = document.createElement("th");
    col.appendChild(document.createTextNode("ID"));
    row.appendChild(col);
    col = document.createElement("th");
    col.appendChild(document.createTextNode("Nombre"));
    row.appendChild(col);
    col = document.createElement("th");
    col.appendChild(document.createTextNode("Tipo"));
    row.appendChild(col);
    tabHead.appendChild(row);
    tabAux.appendChild(tabHead);

    var tabBody = document.createElement("tbody");

    for (var x = 0; x < list.length; x++) {
        var nRow = document.createElement("tr");
        var nCol = document.createElement("td");
        var nnCol = document.createElement("td");
        var nnnCol = document.createElement("td");
        nCol.appendChild(document.createTextNode(list[x].id));
        nnCol.appendChild(document.createTextNode(list[x].name));
        nnnCol.appendChild(document.createTextNode(camelize(list[x].type)));
        nRow.appendChild(nCol);
        nRow.appendChild(nnCol);
        nRow.appendChild(nnnCol);
        tabBody.appendChild(nRow);
    }

    tabAux.appendChild(tabBody);
}

function camelize(str) {
    return str.replace(/(?:^\w|[A-Z]|\b\w)/g, function (letter, index) {
        return index === 0 ? letter.toUpperCase() : letter.toLowerCase();
    }).replace(/\s+/g, '');
}

function createUser() {
    var name = document.getElementById("n-username").value;
    var pass = document.getElementById("n-password").value;
    var type = document.getElementById("n-type").value;
    var xhr = new XMLHttpRequest();
    if (name.length > 0 && pass.length > 0) {
        var toSend = "username=" + name + "&password=" + pass + "&type=" + type + "&login=2";
        xhr.open("POST", "LoginServlet", true);
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {
                console.log(xhr.responseText);
                var json = JSON.parse(xhr.responseText);
                if (json.code === 4) {
                    Materialize.toast("Usuario añadido con exito!", 2000);
                    buildTable(json.list);
                    document.getElementById("n-username").value = "";
                    document.getElementById("n-password").value = "";
                    document.getElementById("n-type").value = "Normal";
                } else if (json.code === 3) {
                    Materialize.toast("Error!<br>" + json.error, 2000);
                }
            }

        };
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhr.send(toSend);
    } else {
        Materialize.toast('Los campos estan vacios.', 2000, 'rounded');
    }
}

function logOut() {
    Materialize.toast("Adios " + document.getElementById("user-title").innerHTML, 2000);
    document.getElementById("user-title").innerHTML = "User";
    document.getElementById("username").value = "";
    document.getElementById("password").value = "";
    changeVisibility("main-fields", true);
    changeVisibility("login", true);
    changeVisibility("logout", false);
    changeVisibility("admin-content", false);
    changeVisibility("normal-content", false);
    changeVisibility("guest-content", true);
}