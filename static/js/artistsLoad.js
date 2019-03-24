const artists = [
    {
        name: 'SARL',
        nick: '@sarl',
        genre: 'sad'
    },
    {
        name: 'JFFR',
        nick: '@jffr',
        genre: 'happy'
    },
    {
        name: 'JSMN',
        nick: '@jsmn',
        genre: 'happy'
    },
    {
        name: 'JDGS',
        nick: '@jdgs',
        genre: 'happy'
    }
];


function loadArtists() {

    const columns = document.getElementById('artists-columns');

    for (const artist of artists) {

        const div = document.createElement('div');
        div.classList.add('column');
        div.classList.add('is-one-third');

        const divCL = document.createElement('div');
        divCL.classList.add('card');
        divCL.classList.add('large');

        const divCardCon = document.createElement('div');
        divCardCon.classList.add('card-content');

        const divMed = document.createElement('div');
        divMed.classList.add('media');

        const divML = document.createElement('div');
        divML.classList.add('media-left');

        const divAvatar = document.createElement('div');
        divAvatar.classList.add('avatar-artist');

        const divMedCon = document.createElement('div');
        divMedCon.classList.add('media-content');

        const p = document.createElement('p');
        const pS = document.createElement('p');
        const span = document.createElement('span');
        const pG = document.createElement('p');


        p.innerText = artist.name;
        pS.innerText = artist.nick;
        pG.innerText = artist.genre;


        divMedCon.appendChild(p);
        pS.appendChild(span);
        divMedCon.appendChild(pS);
        divMedCon.appendChild(pG);
        divMed.appendChild(divML);

        divMed.appendChild(divMedCon);
        divCardCon.appendChild(divMed);
        divCL.appendChild(divCardCon);
        div.appendChild(divCL);

        if (columns) {
            columns.appendChild(div);
        }
    }
};

loadArtists();