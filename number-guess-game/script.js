let randomNumber = Math.floor(Math.random() * 100) + 1;

function checkGuess() {
    let guess = parseInt(document.getElementById("guess").value);
    let message = document.getElementById("message");

    if (isNaN(guess)) {
        message.innerHTML = "Please enter a number!";
    }
    else if (guess < randomNumber) {
        message.innerHTML = "Too Low! Try Again ⬇️";
    }
    else if (guess > randomNumber) {
        message.innerHTML = "Too High! Try Again ⬆️";
    }
    else {
        message.innerHTML = "Correct! You guessed it 🎉";
    }
}