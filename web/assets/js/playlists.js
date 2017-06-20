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
                        console.log(xhr.responseText);
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
            }
        }
    };
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.send(toSend);
}

function addToPlaylist() {
    var player = document.getElementById("song-player");
    var songId = player.getAttribute("current-song-id");
    var username = document.getElementById("user-details").getAttribute("data-username");

    if (username !== null && username !== undefined && username.length > 0) {
        if (songId !== null && songId !== undefined && songId.length > 0) {
            // TODO: Mostrar dialogo para escoger playlist o crear una nueva (Leer modals
            // http://materializecss.com/modals.html ) TODO: Hacer algo con el id de la cancion:
            // songId

        } else {
            Materialize.toast("No ha seleccionado cancion", 2000);
        }
    } else {
        Materialize.toast("No ha iniciado sesion!", 2000);
    }
}