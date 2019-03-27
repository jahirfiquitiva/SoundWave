function loadSongs(key) {
    const xhr = new XMLHttpRequest();
    const actualKey = key || '';
    let reqUrl = '/api/songs';
    if (typeof actualKey !== 'undefined' && actualKey.length > 0) {
        reqUrl += `?key=${key}`;
    }
    console.log(`Doing request to ${reqUrl}`);
    xhr.open('GET', reqUrl, true);
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                try {
                    const json = JSON.parse(xhr.responseText);
                    const songs = json.songs || [];

                    const columns = document.getElementById('songs-columns');
                    if (columns) {
                        const noFound = document.getElementById('no-songs');
                        if (noFound) {
                            if (songs.length > 0) {
                                noFound.classList.add('is-hidden');
                                columns.classList.remove('is-hidden');
                            } else {
                                noFound.classList.remove('is-hidden');
                                columns.classList.add('is-hidden');
                            }
                        }
                        columns.innerHTML = '';
                        for (const song of songs) {
                            const div = document.createElement('div');
                            div.classList.add('column');
                            div.classList.add('is-2');

                            const divCL = document.createElement('div');
                            divCL.classList.add('card');
                            divCL.classList.add('large');
                            divCL.classList.add('has-same-height');

                            const divCardCon = document.createElement('div');
                            divCardCon.classList.add('card-content');

                            const divCardFoot = document.createElement('div');
                            divCardFoot.classList.add('card-footer');

                            const divMed = document.createElement('div');
                            divMed.classList.add('media');

                            const divAvatar = document.createElement('div');
                            divAvatar.classList.add('avatar-song');

                            const divMedCon = document.createElement('div');
                            divMedCon.classList.add('media-content');
                            divMedCon.classList.add('has-text-centered');

                            const songPhoto = document.createElement('img');
                            divMedCon.appendChild(songPhoto);

                            const photoXhr = new XMLHttpRequest();
                            photoXhr.open('GET', `/api/albums?id=${song.albumId}`, true);
                            photoXhr.onreadystatechange = () => {
                                if (photoXhr.readyState === 4 && photoXhr.status === 200) {
                                    try {
                                        const json = JSON.parse(photoXhr.responseText);
                                        const album = json.album;
                                        if (album) {
                                            songPhoto.src = album.imgPath || "";
                                        }
                                    } catch (e) {
                                    }
                                }
                            };
                            photoXhr.send(null);

                            const p = document.createElement('p');
                            p.classList.add('song-name');
                            p.classList.add('card-footer-item');
                            p.innerText = song.name || "Unknown";
                            divCardFoot.appendChild(p);

                            divMed.appendChild(divMedCon);
                            divCardCon.appendChild(divMed);
                            divCL.appendChild(divCardCon);
                            divCL.appendChild(divCardFoot);
                            div.appendChild(divCL);

                            columns.appendChild(div);
                        }
                    }
                } catch (e) {
                    console.error(e);
                }
            }
        }
    };
    xhr.send(null);
}

function search() {
    const searchInp = document.getElementById('search-input');
    if (searchInp) {
        const key = searchInp.value || '';
        loadSongs(key.length > 0 ? key : undefined);
    }
}

loadSongs();