function convertTemp() {
    let temp = parseFloat(document.getElementById("temp").value);
    let from = document.getElementById("from").value;
    let to = document.getElementById("to").value;
    let result;

    if (isNaN(temp)) {
        document.getElementById("result").innerHTML = "Enter valid temperature";
        return;
    }

    if (from === to) {
        result = temp;
    }

    else if (from === "C" && to === "F") {
        result = (temp * 9/5) + 32;
    }
    else if (from === "C" && to === "K") {
        result = temp + 273.15;
    }

    else if (from === "F" && to === "C") {
        result = (temp - 32) * 5/9;
    }
    else if (from === "F" && to === "K") {
        result = (temp - 32) * 5/9 + 273.15;
    }

    else if (from === "K" && to === "C") {
        result = temp - 273.15;
    }
    else if (from === "K" && to === "F") {
        result = (temp - 273.15) * 9/5 + 32;
    }

    document.getElementById("result").innerHTML =
        "Result: " + result.toFixed(2) + " °" + to;
}