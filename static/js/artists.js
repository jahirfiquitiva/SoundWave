function loadArtists() {
    const xhr = new XMLHttpRequest();
    xhr.open('GET', '/api/artists', true);
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                try {
                    const json = JSON.parse(xhr.responseText);
                    const artists = json.artists || [];

                    const columns = document.getElementById('artists-columns');
                    if (columns) {
                        const noFound = document.getElementById('no-artists');
                        if (noFound) {
                            if (artists.length > 0) {
                                noFound.classList.add('is-hidden');
                                columns.classList.remove('is-hidden');
                            } else {
                                noFound.classList.remove('is-hidden');
                                columns.classList.add('is-hidden');
                            }
                        }
                        for (const artist of artists) {
                            const div = document.createElement('div');
                            div.classList.add('column');
                            div.classList.add('is-3');

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
                            divAvatar.classList.add('avatar-artist');

                            const divMedCon = document.createElement('div');
                            divMedCon.classList.add('media-content');
                            divMedCon.classList.add('has-text-centered');

                            const artistPhoto = document.createElement('img');
                            artistPhoto.src = artist.photo || "";
                            divMedCon.appendChild(artistPhoto);

                            const p = document.createElement('p');
                            p.classList.add('artist-name');
                            p.classList.add('card-footer-item');
                            p.innerText = artist.name || "Unknown";
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

loadArtists();