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
    xhr.open('POST', '/api/users/validate', true);
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4 && xhr.status === 200) {
            console.log(xhr.responseText);
        }
    };
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    const toSend = JSON.stringify({nick, pwd});
    console.log(toSend);
    xhr.send(toSend);
}