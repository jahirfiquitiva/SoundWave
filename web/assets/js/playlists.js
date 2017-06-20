/**
 * Created by jahir on 6/19/17.
 */

function addToFavorites() {

    var player = document.getElementById("song-player");
    var songId = player.getAttribute("current-song-id");
    var username = document.getElementById("user-name");

    var xhr = new XMLHttpRequest();
    var toSend = "songId=" + songId + "&username=" + username;
    xhr.open("POST", "AddSongServlet", true);
    xhr.onreadystatechange = function () {
        alert('entrando aaa');

        if (xhr.readyState === 4 && xhr.status === 200) {

            if (xhr.responseText.length > 0) {

                var json = JSON.parse(xhr.responseText);
            }
        }
    }

    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.send(toSend);

}

function addToPlaylist() {

    alert('sdfsdfsdf');

    var player = document.getElementById("song-player");
    var songId = player.getAttribute("current-song-id");
    if (songId !== null && songId !== undefined && songId.length > 0) {
        // TODO: Mostrar dialogo para escoger playlist o crear una nueva (Leer modals
        // http://materializecss.com/modals.html ) TODO: Hacer algo con el id de la cancion: songId
    }
}