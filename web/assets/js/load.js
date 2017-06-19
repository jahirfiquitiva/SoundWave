/**
 * Created by jahir on 6/18/17.
 */

function loadSongs() {
    var xhr = new XMLHttpRequest();
    var songs = document.getElementById("songs");
    xhr.open("GET", "SongsServlet", true);
    xhr.onreadystatechange = function () {
        if (xhr.status === 200 && xhr.readyState === 4) {
            if (xhr.responseText.length > 0) {
                // alert(xhr.responseText);
                var json = JSON.parse(xhr.responseText);
                var row = document.createElement("div");
                row.setAttribute("class", "row");
                if (json.songs !== undefined) {
                    for (var i = 0; i < json.songs.length; i++) {
                        var imgPath = json.songs[i].img;
                        if (i % 6 === 0) {
                            songs.appendChild(row);
                            row = document.createElement("div");
                            row.setAttribute("class", "row");
                        }

                        var col = document.createElement("div");
                        col.setAttribute("class", "col s4 m3 l2");

                        var item = document.createElement("div");
                        item.setAttribute("class", "grid-item");
                        item.setAttribute("data-song-id", json.songs[i].id);
                        item.setAttribute("data-path", json.songs[i].path);
                        item.setAttribute("data-name", json.songs[i].name);
                        item.setAttribute("data-artist", json.songs[i].artist);
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
                        title.innerHTML = getShortText(json.songs[i].name);

                        var subtitle = document.createElement("h6");
                        subtitle.setAttribute("class", "secondary-text");
                        subtitle.innerHTML = getShortText(json.songs[i].artist);

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
        }
    };
    xhr.send(null);
}

function loadSong() {

    var xhr = new XMLHttpRequest();
    var songs = document.getElementById("songs");
    var toSend = "data=1";
    xhr.open("POST", "SongsServlet", true);
    xhr.onreadystatechange = function () {
        if (xhr.status === 200 && xhr.readyState === 4) {
            if (xhr.responseText.length > 0) {
                // alert(xhr.responseText);
                var json = JSON.parse(xhr.responseText);
                var row = document.createElement("div");
                row.setAttribute("class", "row");
                if (json.songs !== undefined) {
                    for (var i = 0; i < json.songs.length; i++) {
                        var imgPath = json.songs[i].img;
                        if (i % 6 === 0) {
                            songs.appendChild(row);
                            row = document.createElement("div");
                            row.setAttribute("class", "row");
                        }

                        var col = document.createElement("div");
                        col.setAttribute("class", "col s4 m3 l2");

                        var item = document.createElement("div");
                        item.setAttribute("class", "grid-item");
                        item.setAttribute("data-song-id", json.songs[i].id);
                        item.setAttribute("data-path", json.songs[i].path);
                        item.setAttribute("data-name", json.songs[i].name);
                        item.setAttribute("data-artist", json.songs[i].artist);
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
                        title.innerHTML = getShortText(json.songs[i].name);

                        var subtitle = document.createElement("h6");
                        subtitle.setAttribute("class", "secondary-text");
                        subtitle.innerHTML = getShortText(json.songs[i].artist);

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
        }
    };
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.send(toSend);

}

function loadSongArtis() {


    var xhr = new XMLHttpRequest();
    var songs = document.getElementById("songs");

    xhr.open("GET", "SongsServlet", true);
    var toSend = "data=2";
    xhr.onreadystatechange = function () {
        if (xhr.status === 200 && xhr.readyState === 4) {
            if (xhr.responseText.length > 0) {
                // alert(xhr.responseText);
                var json = JSON.parse(xhr.responseText);
                var row = document.createElement("div");
                row.setAttribute("class", "row");
                if (json.songs !== undefined) {
                    for (var i = 0; i < json.songs.length; i++) {
                        var imgPath = json.songs[i].img;
                        if (i % 6 === 0) {
                            songs.appendChild(row);
                            row = document.createElement("div");
                            row.setAttribute("class", "row");
                        }

                        var col = document.createElement("div");
                        col.setAttribute("class", "col s4 m3 l2");

                        var item = document.createElement("div");
                        item.setAttribute("class", "grid-item");
                        item.setAttribute("data-song-id", json.songs[i].id);
                        item.setAttribute("data-path", json.songs[i].path);
                        item.setAttribute("data-name", json.songs[i].name);
                        item.setAttribute("data-artist", json.songs[i].artist);
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
                        title.innerHTML = getShortText(json.songs[i].name);

                        var subtitle = document.createElement("h6");
                        subtitle.setAttribute("class", "secondary-text");
                        subtitle.innerHTML = getShortText(json.songs[i].artist);

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
        }
    };

    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.send(toSend);

}


function loadSongGender() {

    var xhr = new XMLHttpRequest();
    var songs = document.getElementById("songs");
    xhr.open("GET", "SongsServlet", true);
    var toSend = "data=3";
    xhr.onreadystatechange = function () {
        if (xhr.status === 200 && xhr.readyState === 4) {
            if (xhr.responseText.length > 0) {
                // alert(xhr.responseText);
                var json = JSON.parse(xhr.responseText);
                var row = document.createElement("div");
                row.setAttribute("class", "row");
                if (json.songs !== undefined) {
                    for (var i = 0; i < json.songs.length; i++) {
                        var imgPath = json.songs[i].img;
                        if (i % 6 === 0) {
                            songs.appendChild(row);
                            row = document.createElement("div");
                            row.setAttribute("class", "row");
                        }

                        var col = document.createElement("div");
                        col.setAttribute("class", "col s4 m3 l2");

                        var item = document.createElement("div");
                        item.setAttribute("class", "grid-item");
                        item.setAttribute("data-song-id", json.songs[i].id);
                        item.setAttribute("data-path", json.songs[i].path);
                        item.setAttribute("data-name", json.songs[i].name);
                        item.setAttribute("data-artist", json.songs[i].artist);
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
                        title.innerHTML = getShortText(json.songs[i].name);

                        var subtitle = document.createElement("h6");
                        subtitle.setAttribute("class", "secondary-text");
                        subtitle.innerHTML = getShortText(json.songs[i].artist);

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
        }
    };


    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.send(toSend);

}

function getShortText(text) {
    if (text.length <= 20) {
        return text;
    }
    return text.substr(0, 19) + "...";
}

function addfavorites() {
    alert("Añadidos favoritos");

}

function addplayList() {
    alert("Añadido a playList");
}