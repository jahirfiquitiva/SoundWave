/**
 * Created by jahir on 6/18/17.
 */

function playPauseSong(play) {
    var playIcon = document.getElementById("play-button");
    var pauseIcon = document.getElementById("pause-button");
    var player = document.getElementById("song-player");
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
    if (player.currentTime >= player.duration) {
        player.setAttribute("src", "");
        document.getElementById("song-progress").style.width = "0%";
        document.getElementById("current-album").setAttribute("src", "");
        document.getElementById("song-detail-title").innerHTML = "";
        document.getElementById("song-detail-artist").innerHTML = "";
        return;
    }
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
            document.getElementById("song-detail-name").innerHTML =
                panel.getAttribute("data-name");
            document.getElementById("song-detail-artist").innerHTML =
                panel.getAttribute("data-artist");
            if (path !== null && path !== undefined) {
                var player = document.getElementById("song-player");
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
    var value = document.getElementById("volume-slider").value;
    document.getElementById("song-player").volume = value / 100;
}