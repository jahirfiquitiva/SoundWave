function getInputValue(id) {
    try {
        const inp = document.getElementById(id);
        if (inp) {
            return inp.value || '';
        }
        return '';
    } catch (e) {
        return '';
    }
}

function login() {
    const xhr = new XMLHttpRequest();
    const nick = getInputValue('nick-input');
    const pwd = getInputValue('pwd-input');

    const loginInfo = document.getElementById('login-info');
    const loginForms = document.getElementById('login-forms');

    xhr.open('POST', '/api/users/validate', true);
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4 && xhr.status === 200) {
            try {
                const json = JSON.parse(xhr.responseText);
                const valid = json.valid || false;
                const user = json.user || undefined;
                if (valid) {
                    alert("Inicio de sesión exitoso");
                    if (loginInfo) {
                        loginInfo.innerHTML =
                            `<h3>Iniciaste sesión como ${user.name || 'Unknown'}</h3>`;
                        loginInfo.classList.remove('is-hidden');
                    }
                    if (loginForms) {
                        loginForms.classList.add('is-hidden');
                    }
                } else {
                    alert("Usuario o contraseña invalídos");
                    if (loginInfo) {
                        loginInfo.classList.add('is-hidden');
                    }
                    if (loginForms) {
                        loginForms.classList.remove('is-hidden');
                    }
                }
            } catch (e) {
                alert("Ocurrió un error inesperado");
                if (loginForms) {
                    loginForms.classList.remove('is-hidden');
                }
            }
        }
    };
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send(JSON.stringify({nick, pwd}));
}

function createUser() {
    const name = getInputValue('new-name-input');
    const lastName = getInputValue('new-surname-input');
    const age = getInputValue('new-age-input');
    const nick = getInputValue('new-nick-input');
    const email = getInputValue('new-email-input');
    const pwd = getInputValue('new-pwd-input');
    const pwdC = getInputValue('new-pwdc-input');

    if (pwd === pwdC) {
        if (email.length <= 0) {
            alert("Email inválido");
        } else if (nick.length <= 0) {
            alert("Nick inválido");
        } else if (pwd.length <= 0) {
            alert("Contraseña inválida");
        } else {
            const xhr = new XMLHttpRequest();
            xhr.open('POST', '/api/users', true);
            xhr.onreadystatechange = () => {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    console.log(xhr.responseText);
                }
            };
            xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
            xhr.send(JSON.stringify({name, lastName, age, nick, email, pwd}));
        }
    } else {
        alert("Las contraseñas no coinciden");
    }
}

function getCurrentUser() {
    const xhr = new XMLHttpRequest();
    xhr.open('GET', '/api/users/current', true);
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4 && xhr.status === 200) {
            console.log(xhr.responseText);
        }
    };
    xhr.send(null)
}

getCurrentUser();