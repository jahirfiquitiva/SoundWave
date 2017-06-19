/**
 * Created by jahir on 6/17/17.
 */
function closeDrawer() {
    $('.button-collapse').sideNav('hide');
    $('#sidenav-overlay').trigger('click');
}

function loadCardColors(e) {
    var image = e.target;
    var vibrant = new Vibrant(image);

    var panel = e.target.parentElement;
    while (!panel.classList.contains('grid-item')) {
        panel = panel.parentElement;
    }

    var colorHex = vibrant.VibrantSwatch.getHex();

    if (colorHex !== null) {
        panel.style.backgroundColor = colorHex;

        var rgbColor = hexToRgb(colorHex);
        var isLight = isLightColor(rgbColor);

        for (var i = 0; i < panel.childNodes.length; i++) {
            var firstChild = panel.childNodes[i];
            if (firstChild.className === "divider") {
                firstChild.style.color = isLight ? "rgba(0,0,0,0.12)" : "rgba(255,255,255,0.12)";
                firstChild.style.backgroundColor =
                    isLight ? "rgba(0,0,0,0.12)" : "rgba(255,255,255,0.12)";
            } else if (firstChild.className === "grid-item-content") {
                for (var j = 0; j < firstChild.childNodes.length; j++) {
                    var item = firstChild.childNodes[j];
                    var classname = item.className;
                    if (classname !== undefined) {
                        if (classname === "primary-text") {
                            item.style.color =
                                isLight ? "rgba(0,0,0,0.87)" : "rgba(255,255,255,255)";
                        } else if (classname === "secondary-text") {
                            item.style.color =
                                isLight ? "rgba(0,0,0,0.6)" : "rgba(255,255,255,0.75)";
                        } else if (classname.indexOf("menu") !== -1) {
                            item.style.color =
                                isLight ? "rgba(0,0,0,0.6)" : "rgba(255,255,255,0.75)";
                        }
                    }
                }
                break;
            }
        }
    }
}

function hexToRgb(hex) {
    // Expand shorthand form (e.g. "03F") to full form (e.g. "0033FF")
    var shorthandRegex = /^#?([a-f\d])([a-f\d])([a-f\d])$/i;
    hex = hex.replace(shorthandRegex, function (m, r, g, b) {
        return r + r + g + g + b + b;
    });

    var result = /^#?([a-f\d]{2})([a-f\d]{2})([a-f\d]{2})$/i.exec(hex);
    return result ? {
        r: parseInt(result[1], 16),
        g: parseInt(result[2], 16),
        b: parseInt(result[3], 16)
    } : null;
}

function isLightColor(color) {
    if (color === null) {
        return null;
    }
    var r = color.r;
    var g = color.g;
    var b = color.b;
    if (r === 0 && g === 0 && b === 0) {
        return true;
    } else if (r === 255 && g === 255 && b === 255) {
        return false;
    } else {
        return (1 - (0.299 * r + 0.587 * g + 0.114 * b) / 255) < 0.475;
    }
}