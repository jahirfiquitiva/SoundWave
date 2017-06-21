/**
 * Created by jahir on 6/18/17.
 */

function playPauseSong(play) {
    var playIcon = document.getElementById("play-button");
    var pauseIcon = document.getElementById("pause-button");
    var player = document.getElementById("song-player");
    var id = player.getAttribute("current-song-id");
    if (id === null || id === undefined || id.length <= 0) {
        playIcon.style.display = "inline-block";
        pauseIcon.style.display = "none";
        return;
    }
    if (player.getAttribute("src").length > 0) {
        playIcon.style.display = !play ? "inline-block" : "none";
        pauseIcon.style.display = play ? "inline-block" : "none";
        var method = play ? "play" : "pause";
        player[method]();
        updateSongProgress();
    }
    return false;
}

function updateSongProgress() {
    var player = document.getElementById("song-player");
    var id = player.getAttribute("current-song-id");
    var playIcon = document.getElementById("play-button");
    var pauseIcon = document.getElementById("pause-button");
    document.getElementById("song-detail-duration").innerHTML = "";
    if (id === null || id === undefined || id.length <= 0) {
        playIcon.style.display = "inline-block";
        pauseIcon.style.display = "none";
    } else {
        if (player.currentTime >= player.duration) {
            if (player.getAttribute("from-search") === "false") {
                playAnother(true, player.getAttribute("current-song-id"),
                            player.getAttribute("data-playlist-id"));
            } else {
                clearPlayer();
            }
            return;
        }
        var played = (100 * player.currentTime) / player.duration;
        document.getElementById("song-progress").style.width = played + "%";
        var cTimeText = readableDuration(player.currentTime);
        var dTimeText = readableDuration(player.duration);
        document.getElementById("song-detail-duration").innerHTML = cTimeText + " - " + dTimeText;
    }
}

function seek(forward) {
    var player = document.getElementById("song-player");
    var id = player.getAttribute("current-song-id");
    if (id === null || id === undefined || id.length <= 0) {
        return;
    }
    var duration = player.duration;
    var currentTime = player.currentTime;
    var nTime = forward ? (currentTime + 5) : (currentTime - 5);
    player.currentTime = nTime >= duration ? duration : nTime <= 0 ? 0 : nTime;
    updateSongProgress();
}

function moveSong(e) {
    var player = document.getElementById("song-player");
    var id = player.getAttribute("current-song-id");
    if (id === null || id === undefined || id.length <= 0) {
        return;
    }
    var progress = document.getElementById("song-progress");

    var w          = window,
        d          = document,
        el         = d.documentElement,
        g          = d.getElementsByTagName("body")[0],
        realWidth  = w.innerWidth || el.clientWidth || g.clientWidth,
        realHeight = w.innerHeight || el.clientHeight || g.clientHeight;

    var newProgress = (100 * e.pageX) / realWidth;
    player.currentTime = (player.duration * newProgress) / 100;
    updateSongProgress();
}

function playSong(e, fromSearch) {
    try {
        var panel = e.target.parentElement;
        if (panel !== null && panel !== undefined) {
            var contains = panel.classList.contains("grid-item");
            while (!contains) {
                panel = panel.parentElement;
                contains = panel.classList.contains("grid-item");
            }
            var path = panel.getAttribute("data-path");
            document.getElementById("song-detail-name").innerHTML =
                panel.getAttribute("data-name");
            document.getElementById("song-detail-artist").innerHTML =
                panel.getAttribute("data-artist");
            if (path !== null && path !== undefined) {
                var player = document.getElementById("song-player");
                player.setAttribute("current-song-id", panel.getAttribute("data-song-id"));
                player.setAttribute("from-search", fromSearch);
                player.setAttribute("from-playlist", false);
                player.setAttribute("data-playlist-id", "");
                player.src = path;
                for (var i = 0; i < panel.childNodes.length; i++) {
                    var child = panel.childNodes[i];
                    if (child.classList.contains("album")) {
                        var albumPath = child.getAttribute("src");
                        if (albumPath !== undefined && albumPath.length > 0) {
                            document.getElementById("current-album")
                                .setAttribute("src", albumPath);
                        }
                    }
                }
                playPauseSong(true);
            }
        }
    } catch (ignored) {
    }
}

function updateVolume() {
    var value = parseInt(document.getElementById("volume-slider").value);
    var floatVolume = value / 100;
    document.getElementById("song-player").volume =
        floatVolume > 1.0 ? 1.0 : floatVolume < 0.0 ? 0.0 : floatVolume;
}

function volumeDown() {
    if (document.getElementById("volume-slider").value <= 0) {
        return;
    }
    var currentValue = parseInt(document.getElementById("volume-slider").value);
    document.getElementById("volume-slider").value = (currentValue - 5);
    updateVolume();
}

function volumeUp() {
    if (document.getElementById("volume-slider").value >= 100) {
        return;
    }
    var currentValue = parseInt(document.getElementById("volume-slider").value);
    document.getElementById("volume-slider").value = (currentValue + 5);
    updateVolume();
}

function playAnother(next, current, listId) {
    var username = document.getElementById("user-details").getAttribute("data-username");
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "PlayerServlet", true);
    xhr.onreadystatechange = function () {
        if (xhr.status === 200 && xhr.readyState === 4) {
            if (xhr.responseText.length > 0) {
                var song = JSON.parse(xhr.responseText);
                if (song !== null && song !== undefined) {
                    document.getElementById("song-detail-name").innerHTML = song.name;
                    document.getElementById("song-detail-artist").innerHTML = song.artist.name;
                    var player = document.getElementById("song-player");
                    player.setAttribute("current-song-id", song.id);
                    player.src = song.path;
                    document.getElementById("current-album").setAttribute("src", song.img);
                    playPauseSong(true);
                } else {
                    clearPlayer();
                }
            } else {
                clearPlayer();
            }
        }
    };
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.send(
        "data=" + (next ? "1" : "0") + "&current=" + current + "&listId=" + listId + "&username="
        + username);
}

function playPrevious() {
    var player = document.getElementById("song-player");
    playAnother(false, player.getAttribute("current-song-id"),
                player.getAttribute("data-playlist-id"));
}

function playNext() {
    var player = document.getElementById("song-player");
    playAnother(true, player.getAttribute("current-song-id"),
                player.getAttribute("data-playlist-id"));
}

function readableDuration(seconds) {
    var sec = Math.floor(seconds);
    var min = Math.floor(sec / 60);
    min = min >= 10 ? min : "0" + min;
    sec = Math.floor(sec % 60);
    sec = sec >= 10 ? sec : "0" + sec;
    return min + ":" + sec;
}

function playFromPlaylist(listId, songId, songName, songArtist, songSrc, songAlbum) {
    var player = document.getElementById("song-player");
    player.setAttribute("current-song-id", songId);
    player.setAttribute("src", songSrc);
    document.getElementById("current-album").setAttribute("src", songAlbum);
    document.getElementById("song-detail-name").innerHTML = songName;
    document.getElementById("song-detail-artist").innerHTML = songArtist;
    player.setAttribute("from-search", false);
    player.setAttribute("from-playlist", true);
    player.setAttribute("data-playlist-id", listId);
    playPauseSong(true);
}

function clearPlayer() {
    var player = document.getElementById("song-player");
    if (player.getAttribute("from-playlist") === "true" ||
        player.getAttribute("from-search") === "true") {
        var playIcon = document.getElementById("play-button");
        var pauseIcon = document.getElementById("pause-button");
        player["pause"]();
        playIcon.style.display = "inline-block";
        pauseIcon.style.display = "none";
        player.setAttribute("current-song-id", "");
        player.setAttribute("from-search", "");
        player.setAttribute("from-playlist", "");
        player.setAttribute("data-playlist-id", "");
        player.setAttribute("src", "");
        document.getElementById("song-progress").style.width = "0%";
        document.getElementById("current-album").setAttribute("src", "");
        document.getElementById("song-detail-name").innerHTML = "";
        document.getElementById("song-detail-artist").innerHTML = "";
        document.getElementById("song-detail-duration").innerHTML = "";
    }
}