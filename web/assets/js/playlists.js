/**
 * Created by jahir on 6/19/17.
 */

function addToFavorites() {
    var player = document.getElementById("song-player");
    var songId = player.getAttribute("current-song-id");
    if (songId !== null && songId !== undefined && songId.length > 0) {
        alert(player +"_"+songId );
        // TODO: Hacer algo con el id de la cancion: songId
    }else{
        alert("0_o");
    }
}

function addToPlaylist() {
    var player = document.getElementById("song-player");
    var songId = player.getAttribute("current-song-id");
    if (songId !== null && songId !== undefined && songId.length > 0) {
        alert(player +"_"+songId );
        // TODO: Mostrar dialogo para escoger playlist o crear una nueva (Leer modals http://materializecss.com/modals.html )
        // TODO: Hacer algo con el id de la cancion: songId
    }else{
        alert("0_o");
    }
}