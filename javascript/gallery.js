
const apiKey = '6afef6a0-c533-47b1-9399-8cc0c8906c32';

const endpoint = `https://api.harvardartmuseums.org/object?apikey=${apiKey}&size=100`;

let objects = [];
let currentIndex = 0;

function fetchAndDisplayObjects() {
    if (objects.length === 0) {
        fetch(endpoint)
            .then(response => response.json())
            .then(data => {
                objects = data.records;
                displayNextObject();
            })
            .catch(error => {
                console.error('Error fetching objects:', error);
            });
    } else {
        displayNextObject();
    }
}

function displayNextObject() {
    const imageElement = document.getElementById('painting-image');
    const imageUrl = objects[currentIndex].primaryimageurl;
    imageElement.src = imageUrl;
    
    // Move to the next object or loop back to the first
    currentIndex = (currentIndex + 1) % objects.length;
}

// Call the function to fetch and display objects initially
fetchAndDisplayObjects();

// Set an interval to change the object every 3 seconds (3000 milliseconds)
setInterval(fetchAndDisplayObjects, 3000);