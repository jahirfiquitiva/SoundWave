function login() {
    const xhr = new XMLHttpRequest();
    const nickInput = document.getElementById('nick-input');
    let nick = '';
    if (nickInput) {
        nick = nickInput.value || '';
    }
    const pwdInput = document.getElementById('pwd-input');
    let pwd = '';
    if (pwdInput) {
        pwd = pwdInput.value || '';
    }

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