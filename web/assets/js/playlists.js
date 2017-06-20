/**
 * Created by jahir on 6/19/17.
 */

function addToFavorites() {
    var xhr = new XMLHttpRequest();
    var player = document.getElementById("song-player");
    var songId = player.getAttribute("current-song-id");
    var username = document.getElementById("user-details").getAttribute("data-username");
    if (username !== null && username !== undefined && username.length > 0) {
        if (songId !== null && songId !== undefined && songId.length > 0) {
            var toSend = "songId=" + songId + "&username=" + username + "&data=1";
            xhr.open("POST", "PlaylistsServlet", true);
            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    if (xhr.responseText.length > 0) {
                        var json = JSON.parse(xhr.responseText);
                        if (json.code === 1) {
                            Materialize.toast("Añadido a favoritos!", 2000);
                        }
                    }
                }
            };
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            xhr.send(toSend);
        } else {
            Materialize.toast("No ha seleccionado cancion", 2000);
        }
    } else {
        Materialize.toast("No ha iniciado sesion!", 2000);
    }
}

function loadFavorites() {
    var xhr = new XMLHttpRequest();
    var username = document.getElementById("user-details").getAttribute("data-username");
    if (username !== null && username !== undefined && username.length > 0) {
        var toSend = "username=" + username + "&data=2";
        xhr.open("POST", "PlaylistsServlet", true);
        xhr.onreadystatechange = function () {
            if (xhr.status === 200 && xhr.readyState === 4) {
                if (xhr.responseText.length > 0) {
                    console.log(xhr.responseText);
                    var json = JSON.parse(xhr.responseText);
                    if (json.songs !== undefined) {
                        loadFavoritesViews(json.songs);
                    }
                } else {
                    loadFavoritesViews(null);
                }
            }
        };
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhr.send(toSend);
    } else {
        loadFavoritesViews(null);
        Materialize.toast("No ha iniciado sesion!", 2000);
    }
}

function validateLogin() {
    var username = document.getElementById("user-details").getAttribute("data-username");
    if (username !== null && username !== undefined && username.length > 0) {
        $("#modal1").modal("open");
    } else {
        Materialize.toast("No ha iniciado sesion!", 2000);
    }
}

function addToPlaylist() {
    var player = document.getElementById("song-player");
    var songId = player.getAttribute("current-song-id");
    var username = document.getElementById("user-details").getAttribute("data-username");

    if (username !== null && username !== undefined && username.length > 0) {
        if (songId !== null && songId !== undefined && songId.length > 0) {
            // TODO: Añadir cancion a playlist usando songId y obteniendo el nombre de la playlists
        } else {
            Materialize.toast("No ha seleccionado cancion", 2000);
        }
    } else {
        Materialize.toast("No ha iniciado sesion!", 2000);
    }
}

function loadPlaylistsToOptions() {
    var username = document.getElementById("user-details").getAttribute("data-username");
    if (username !== null && username !== undefined && username.length > 0) {
        var mySelect = document.getElementById("list");
        var toSend = "username=" + username + "&data=3";
        var xhr = new XMLHttpRequest();
        xhr.open("POST", "PlaylistsServlet", true);
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {
                if (xhr.responseText.length > 0) {
                    var tm = JSON.parse(xhr.responseText);
                    for (var i = 0; i < tm.length; i++) {
                        alert("Entrando");
                        var opt = document.createElement("option");
                        opt.value = tm[i].id;
                        opt.text = tm[i].ownerName;
                        mySelect.add(opt);
                    }
                }
            }
        };
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhr.send(toSend);
    }
}