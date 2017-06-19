/**
 * Created by jahir on 6/9/17.
 */

function login() {
    var xhr = new XMLHttpRequest();
    var name = document.getElementById("username").value;
    var pass = document.getElementById("password").value;
    if (name.length > 0 && pass.length > 0) {
        var toSend = "username=" + name + "&password=" + pass + "&login=1";
        console.log(toSend);
        xhr.open("POST", "LoginServlet", true);
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {
                var jsonContent = JSON.parse(xhr.responseText);
                if (jsonContent.name !== undefined) {
                    Materialize.toast("Bienvenido " + jsonContent.name, 2000);
                    document.getElementById("username").value = "";
                    document.getElementById("password").value = "";
                    document.getElementById("user-name").innerHTML = jsonContent.name;
                    document.getElementById("user-type").innerHTML = camelize(jsonContent.type);
                    changeVisibility("user-details", true);
                    changeVisibility("login", false);
                    changeVisibility("logout", true);
                    changeVisibility("login-section", false);
                } else {
                    Materialize.toast("Error!<br>" + jsonContent.error, 2000);
                }
            }
        };
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhr.send(toSend);
    } else {
        Materialize.toast('Los campos estan vacios.', 2000, 'rounded');
    }
}

function changeVisibility(id, show) {
    document.getElementById(id).style.display = show ? 'block' : 'none';
}

function camelize(str) {
    return str.replace(/(?:^\w|[A-Z]|\b\w)/g, function (letter, index) {
        return index === 0 ? letter.toUpperCase() : letter.toLowerCase();
    }).replace(/\s+/g, '');
}

function createUser() {
    var fullname = document.getElementById("new-fullname").value;
    var email = document.getElementById("new-email").value;
    var name = document.getElementById("new-username").value;
    var pass = document.getElementById("new-password").value;
    var type = document.getElementById("new-type").value;
    var xhr = new XMLHttpRequest();
    if (name.length > 0 && pass.length > 0) {
        var toSend = "fullname=" + fullname + "&email=" + email + "&username=" + name + "&password="
                     + pass + "&type=" + type + "&login=2";
        xhr.open("POST", "LoginServlet", true);
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {
                if (xhr.responseText.length > 0) {
                    var json = JSON.parse(xhr.responseText);
                    if (json.code === 4) {
                        Materialize.toast("Usuario añadido con exito!", 2000);
                        // buildTable(json.list);
                        document.getElementById("username").value =
                            document.getElementById("new-username").value;
                        document.getElementById("password").value =
                            document.getElementById("new-password").value;
                        login();
                        document.getElementById("new-fullname").value = "";
                        document.getElementById("new-email").value = "";
                        document.getElementById("new-username").value = "";
                        document.getElementById("new-password").value = "";
                        document.getElementById("new-type").value = "Normal";
                        hideRegister();
                    } else if (json.code === 3) {
                        Materialize.toast("Error!<br>" + json.error, 2000);
                    }
                }
            }
        };
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhr.send(toSend);
    } else {
        Materialize.toast('Los campos estan vacios.', 2000, 'rounded');
    }
}

function logout() {
    Materialize.toast("Adios " + document.getElementById("user-name").innerHTML, 2000);
    document.getElementById("username").value = "";
    document.getElementById("password").value = "";
    document.getElementById("user-name").innerHTML = "";
    document.getElementById("user-type").innerHTML = "";
    changeVisibility("user-details", false);
    changeVisibility("login", true);
    changeVisibility("logout", false);
    changeVisibility("login-section", true);
}

function showRegister() {
    changeVisibility("user-details", false);
    changeVisibility("login-section", false);
    changeVisibility("register-section", true);
}

function hideRegister() {
    changeVisibility("user-details", false);
    changeVisibility("login-section", true);
    changeVisibility("register-section", false);
}