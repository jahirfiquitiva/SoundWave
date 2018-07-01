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
                            M.toast({html: "Añadido a favoritos!", displayLength: 2000});
                        } else {
                            M.toast({
                                        html: "Error<br>Por favor, intente de nuevo.",
                                        displayLength: 2000
                                    });
                        }
                    } else {
                        M.toast(
                            {html: "Error<br>Por favor, intente de nuevo.", displayLength: 2000});
                    }
                }
            };
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            xhr.send(toSend);
        } else {
            M.toast({html: "No ha seleccionado cancion", displayLength: 2000});
        }
    } else {
        M.toast({html: "No ha iniciado sesion!", displayLength: 2000});
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
                    var json = JSON.parse(xhr.responseText);
                    if (json.songs !== undefined) {
                        loadFavoritesViews(json.songs);
                    } else {
                        loadFavoritesViews(null);
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
        M.toast({html: "No ha iniciado sesion!", displayLength: 2000});
    }
}

function validateLogin() {
    var username = document.getElementById("user-details").getAttribute("data-username");
    if (username !== null && username !== undefined && username.length > 0) {
        $("#modal1").modal("open");
    } else {
        M.toast({html: "No ha iniciado sesion!", displayLength: 2000});
    }
}

function loadPlaylists() {
    var username = document.getElementById("user-details").getAttribute("data-username");
    if (username !== null && username !== undefined && username.length > 0) {
        var xhr = new XMLHttpRequest();
        xhr.open("POST", "PlaylistsServlet", true);
        xhr.onreadystatechange = function () {
            if (xhr.status === 200 && xhr.readyState === 4) {
                if (xhr.responseText.length > 0) {
                    var a = xhr.responseText;
                    var json = JSON.parse(a);
                    if (json.lists !== undefined) {
                        loadPlaylistsViews(json.lists);
                    } else {
                        loadPlaylistsViews(null);
                    }
                } else {
                    loadPlaylistsViews(null);
                }
            }
        };
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhr.send("data=3&username=" + username);
    } else {
        loadPlaylistsViews(null);
        M.toast({html: "No ha iniciado sesion!", displayLength: 2000});
    }
}

function loadPlaylistsToOptions() {
    var username = document.getElementById("user-details").getAttribute("data-username");
    if (username !== null && username !== undefined && username.length > 0) {
        var xhr = new XMLHttpRequest();
        xhr.open("POST", "PlaylistsServlet", true);
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {
                var mySelect = document.getElementById("lists");
                mySelect.length = 0;
                if (xhr.responseText.length > 0) {
                    var tm = JSON.parse(xhr.responseText);
                    if (tm.lists !== undefined) {
                        for (var i = 0; i < tm.lists.length; i++) {
                            var opt = document.createElement("option");
                            var nId = tm.lists[i].id;
                            var nName = tm.lists[i].name;
                            opt.value = nId;
                            opt.text = nName;
                            mySelect.appendChild(opt);
                        }
                    }
                }
            }
        };
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhr.send("username=" + username + "&data=3");
    }
}

function songsToPlaylistProcess() {
    var username = document.getElementById("user-details").getAttribute("data-username");
    var player = document.getElementById("song-player");
    var songId = player.getAttribute("current-song-id");
    if (username !== null && username !== undefined && username.length > 0) {
        if (songId !== null && songId !== undefined && songId.length > 0) {
            var nName = document.getElementById("new-list-name").value;
            if (nName !== null && nName !== undefined && nName.length > 0) {
                createPlaylist(nName, username, songId);
            } else {
                var sl = document.getElementById("lists");
                var selectedIndex = sl.options[sl.selectedIndex];
                if (selectedIndex !== null && selectedIndex !== undefined) {
                    var selectedPl = selectedIndex.value;
                    if (selectedPl !== null && selectedPl !== undefined && selectedPl.length > 0) {
                        addSongToPlaylist(selectedPl, username, songId);
                    } else {
                        M.toast({
                                    html: "No se selecciono ninguna lista de reproduccion",
                                    displayLength: 2000
                                });
                    }
                } else {
                    M.toast({
                                html: "No se selecciono ninguna lista de reproduccion",
                                displayLength: 2000
                            });
                }
            }
        } else {
            M.toast({html: "No ha seleccionado cancion", displayLength: 2000});
        }
    } else {
        M.toast({html: "No ha iniciado sesion!", displayLength: 2000});
    }
}

function addSongToPlaylist(listId, username, songId) {
    if (listId !== null && listId !== undefined && listId.length > 0) {
        if (songId !== null && songId !== undefined && songId.length > 0) {
            var xhr = new XMLHttpRequest();
            xhr.open("POST", "PlaylistsServlet", true);
            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    if (xhr.responseText.length > 0) {
                        var json = JSON.parse(xhr.responseText);
                        if (json.code !== undefined) {
                            if (json.code === 1) {
                                M.toast({html: "Cancion añadida con exito", displayLength: 2000});
                            } else {
                                M.toast({
                                            html: "Error!<br>Por favor, intente de nuevo",
                                            displayLength: 2000
                                        });
                            }
                        } else {
                            M.toast({
                                        html: "Error!<br>Por favor, intente de nuevo",
                                        displayLength: 2000
                                    });
                        }
                    } else {
                        M.toast(
                            {html: "Error!<br>Por favor, intente de nuevo", displayLength: 2000});
                    }
                }
            };
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            xhr.send("data=6&listid=" + listId + "&username=" + username + "&songid=" + songId);
        }
    }
}

function createPlaylist(listId, username, songId) {
    if (listId !== null && listId !== undefined && listId.length > 0) {
        if (songId !== null && songId !== undefined && songId.length > 0) {
            var xhr = new XMLHttpRequest();
            xhr.open("POST", "PlaylistsServlet", true);
            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    if (xhr.responseText.length > 0) {
                        var json = JSON.parse(xhr.responseText);
                        if (json.code !== undefined) {
                            if (json.code === 1) {
                                M.toast({html: "Lista creada con exito", displayLength: 2000});
                                addSongToPlaylist(listId, username, songId);
                                loadPlaylistsToOptions();
                            } else {
                                M.toast({
                                            html: "Error!<br>Por favor, intente de nuevo",
                                            displayLength: 2000
                                        });
                            }
                        } else {
                            M.toast({
                                        html: "Error!<br>Por favor, intente de nuevo",
                                        displayLength: 2000
                                    });
                        }
                    } else {
                        M.toast(
                            {html: "Error!<br>Por favor, intente de nuevo", displayLength: 2000});
                    }
                }
            };
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            xhr.send("data=5&listid=" + listId + "&username=" + username);
        }
    }
}

function playPlaylist(listId) {
    var username = document.getElementById("user-details").getAttribute("data-username");
    if (username !== null && username !== undefined && username.length > 0) {
        if (listId !== null && listId !== undefined && listId.length > 0) {
            var xhr = new XMLHttpRequest();
            xhr.open("POST", "PlaylistsServlet", true);
            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    if (xhr.responseText.length > 0) {
                        var json = JSON.parse(xhr.responseText);
                        if (json.songs !== undefined) {
                            if (json.songs.length > 0) {
                                var id = json.songs[0].first.id;
                                var name = json.songs[0].first.name;
                                var artist = json.songs[0].second.second.name;
                                var src = json.songs[0].first.path;
                                var img = json.songs[0].second.first.imgPath;
                                playFromPlaylist(listId, id, name, artist, src, img);
                            } else {
                                M.toast({
                                            html: "Error!<br>La lista no tiene canciones",
                                            displayLength: 2000
                                        });
                            }
                        } else {
                            M.toast({
                                        html: "Error!<br>La lista no tiene canciones",
                                        displayLength: 2000
                                    });
                        }
                    } else {
                        M.toast(
                            {html: "Error!<br>La lista no tiene canciones", displayLength: 2000});
                    }
                }
            };
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            xhr.send("data=7&listid=" + listId + "&username=" + username);
        } else {
            M.toast({html: "Error!<br>En la lista " + listId, displayLength: 2000});
        }
    } else {
        M.toast({html: "Error!<br>Por favor, inicie sesion", displayLength: 2000});
    }
}