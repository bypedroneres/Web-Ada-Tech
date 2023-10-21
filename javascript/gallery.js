// Function to fetch and display paintings from the Europeana API
function fetchAndDisplayPaintings() {
    const apiKey = "alicenis"; // Replace with your API key
    const endpoint = "https://www.europeana.eu/api/v2/search.json";

    // Parameters for your API request (you can customize these)
    const queryParams = {
        query: "painting", // Your search query
        media: true, // Include media (images) in the response
        profile: "rich", // Use the "rich" profile for more details
        wskey: apiKey, // Your API key
    };

    // Construct the URL with query parameters
    const url = new URL(endpoint);
    url.search = new URLSearchParams(queryParams);

    // Make the API request
    fetch(url)
        .then(response => response.json())
        .then(data => {
            const galleryContainer = document.querySelector(".gallery-container");
            data.items.forEach(item => {
                // Check if the item has an image
                if (item.edmIsShownBy) {
                    const paintingImage = document.createElement("img");
                    paintingImage.src = item.edmIsShownBy[0];
                    paintingImage.alt = item.title[0]; // Set alt text to the painting title

                    // Create a container for the title and description
                    const infoContainer = document.createElement("div");
                    infoContainer.classList.add("info-container");

                    // Display the title
                    const titleElement = document.createElement("h3");
                    titleElement.textContent = item.title[0];

                    // Display the description
                    const descriptionElement = document.createElement("p");
                    descriptionElement.textContent = item.dcDescription ? item.dcDescription[0] : "Description not available";

                    // Append title and description to the info container
                    infoContainer.appendChild(titleElement);
                    infoContainer.appendChild(descriptionElement);

                    // Append the painting and info container to the gallery
                    galleryContainer.appendChild(paintingImage);
                    galleryContainer.appendChild(infoContainer);
                }
            });
        })
        .catch(error => {
            console.error("Error fetching paintings:", error);
        });
}

// Call the function to fetch and display paintings when the page loads
fetchAndDisplayPaintings();
