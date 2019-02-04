function toggleDrawer() {
    let drawer = document.getElementById('drawer');
    if (drawer) {
        drawer.classList.remove('is-hidden');
    }
    let check = document.getElementById('drawer-check');
    if (check !== null && check !== undefined) {
        check.click();
    }
}