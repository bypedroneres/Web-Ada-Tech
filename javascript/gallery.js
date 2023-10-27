
const apiKey = '6afef6a0-c533-47b1-9399-8cc0c8906c32';

const endpoint = `https://api.harvardartmuseums.org/object?apikey=${apiKey}&size=1&classification=Paintings`;

function fetchAndDisplayPainting() {
    fetch(endpoint)
        .then(response => response.json())
        .then(data => {
            const imageUrl = data.records[0].primaryimageurl;
            const imageElement = document.getElementById('painting-image');
            imageElement.src = imageUrl;
        })
        .catch(error => {
            console.error('Error fetching painting:', error);
        });
}

fetchAndDisplayPainting();

setInterval(fetchAndDisplayPainting, 3000);