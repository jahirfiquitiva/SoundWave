/**
 * Created by jahir on 6/19/17.
 */


function addToFavorites() {
    var xhr = new XMLHttpRequest();

    var player = document.getElementById("song-player");
    var songId = player.getAttribute("current-song-id");

    if (songId !== null && songId !== undefined && songId.length > 0) {
        var username = document.getElementById("user-details").getAttribute("data-username");
        //alert('usuario' + username);
        var toSend = "songId=" + songId + "&username=" + username + "&data=1";
        xhr.open("POST", "PlaylistsServlet", true);
        xhr.onreadystatechange = function () {

            if (xhr.readyState === 4 && xhr.status === 200) {
                if (xhr.responseText.length > 0) {

                    var json = JSON.parse(xhr.responseText);

                    console.log(xhr.responseText);
                    if (json.code === 4) {
                        Materialize.toast("Añadido a favoritos!", 2000);
                    }
                }
            }
        };
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhr.send(toSend);
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
                var json = JSON.parse(xhr.responseText);
                if (json.songs !== undefined) {
                    loadSongsViews(json.songs);
                }
            }
        }
    };
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

    function loadFavolire(list) {
        var songs = document.getElementById("list");
        songs.innerHTML = "<h3 class=\"cyan-text section-title\">Canciones</h3>";
        songs.innerHTML +=
            "<div><a class=\"waves-effect btn cyan\" onclick=\"loadSongsByGenre()\">Genero</a>";
        songs.innerHTML +=
            "<a class=\"waves-effect btn cyan\" onclick=\"loadSongsByArtist()\">Artista</a>";
        songs.innerHTML +=
            "<a class=\"waves-effect btn cyan\" onclick=\"loadSongs()\">Sin filtros</a></div>";

        var row = document.createElement("div");
        row.setAttribute("class", "row");
        for (var i = 0; i < list.length; i++) {
            var imgPath = list[i].img;
            if (i % 6 === 0) {
                songs.appendChild(row);
                row = document.createElement("div");
                row.setAttribute("class", "row");
            }

            var col = document.createElement("div");
            col.setAttribute("class", "col s4 m3 l2");

            var item = document.createElement("div");
            item.setAttribute("class", "grid-item");
            item.setAttribute("data-song-id", list[i].id);
            item.setAttribute("data-path", list[i].path);
            item.setAttribute("data-name", list[i].name);
            item.setAttribute("data-artist", list[i].artist);
            item.setAttribute("onclick", "playSong(event)");

            var img = document.createElement("img");
            img.setAttribute("class", "responsive-img album");
            img.setAttribute("crossorigin", "");
            img.setAttribute("src", imgPath);

            var divider = document.createElement("div");
            divider.setAttribute("class", "divider");

            var content = document.createElement("div");
            content.setAttribute("class", "grid-item-content");

            var title = document.createElement("p");
            title.setAttribute("class", "primary-text");
            title.innerHTML = getShortText(list[i].name);

            var subtitle = document.createElement("h6");
            subtitle.setAttribute("class", "secondary-text");
            subtitle.innerHTML = getShortText(list[i].artist);

            var dots = document.createElement("i");
            dots.setAttribute("class", "mdi mdi-dots-vertical menu");
            dots.setAttribute("data-activates", "songs-menu");

            content.appendChild(title);
            content.appendChild(subtitle);
            // content.appendChild(dots);

            if (imgPath !== undefined && imgPath.length > 1) {
                img.setAttribute("onload", "loadCardColors(event)");
            }
            item.appendChild(img);
            item.appendChild(divider);
            item.appendChild(content);

            col.appendChild(item);

            row.appendChild(col);
        }
        songs.appendChild(row);
    }
}