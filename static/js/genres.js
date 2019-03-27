function loadGenres() {
    const xhr = new XMLHttpRequest();
    xhr.open('GET', '/api/genres', true);
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                try {
                    const json = JSON.parse(xhr.responseText);
                    const genres = json.genres || [];

                    const columns = document.getElementById('genres-columns');
                    if (columns) {
                        const noFound = document.getElementById('no-genres');
                        if (noFound) {
                            if (genres.length > 0) {
                                noFound.classList.add('is-hidden');
                                columns.classList.remove('is-hidden');
                            } else {
                                noFound.classList.remove('is-hidden');
                                columns.classList.add('is-hidden');
                            }
                        }
                        columns.innerHTML = '';
                        for (const genre of genres) {
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
                            divAvatar.classList.add('avatar-genre');

                            const divMedCon = document.createElement('div');
                            divMedCon.classList.add('media-content');
                            divMedCon.classList.add('has-text-centered');

                            const genrePhoto = document.createElement('img');
                            genrePhoto.src = genre.imgPath || "";
                            divMedCon.appendChild(genrePhoto);

                            const p = document.createElement('p');
                            p.classList.add('genre-name');
                            p.classList.add('card-footer-item');
                            p.innerText = genre.name || "Unknown";
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

loadGenres();