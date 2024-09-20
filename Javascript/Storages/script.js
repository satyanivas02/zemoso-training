// Select the elements
const localScoreDisplay = document.getElementById('localScore');
const sessionScoreDisplay = document.getElementById('sessionScore');
const incrementBtn = document.getElementById('incrementBtn');

// Initialize local and session scores
let localScore = parseInt(localStorage.getItem('localScore')) || 0;
let sessionScore = parseInt(sessionStorage.getItem('sessionScore')) || 0;

// Display the initial scores
localScoreDisplay.textContent = localScore;
sessionScoreDisplay.textContent = sessionScore;

// Function to update the scores
function updateScores() {
    // Increment both scores
    localScore++;
    sessionScore++;

    // Update the displays
    localScoreDisplay.textContent = localScore;
    sessionScoreDisplay.textContent = sessionScore;

    // Store the updated scores in Local and Session Storage
    localStorage.setItem('localScore', localScore);
    sessionStorage.setItem('sessionScore', sessionScore);
}

// Add event listener to the button
incrementBtn.addEventListener('click', updateScores);
