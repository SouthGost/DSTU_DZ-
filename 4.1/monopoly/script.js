function createPlacePole(pole){
    const colorDiv = document.createElement("div");
    colorDiv.className = "color";
    
    const poleInfoDiv = document.createElement("div");
    poleInfoDiv.className = "pole_info";
    
    const nameParagraph = document.createElement("p");
    nameParagraph.className = "name";
    nameParagraph.innerText = "Место";
    
    const costParagraph = document.createElement("p");
    costParagraph.className = "cost";
    costParagraph.innerText = "Цена";

    poleInfoDiv.append(nameParagraph);
    poleInfoDiv.append(costParagraph);
    pole.append(colorDiv);
    pole.append(poleInfoDiv);
}

function createPoleWithImage(pole){    
    const poleInfoDiv = document.createElement("div");
    poleInfoDiv.className = "pole_info";
    
    const nameParagraph = document.createElement("p");
    nameParagraph.className = "name";
    nameParagraph.innerText = "Место";

    const img = document.createElement("img");
    img.className = "pole_img";
    
    const costParagraph = document.createElement("p");
    costParagraph.className = "cost";
    costParagraph.innerText = "Цена";

    poleInfoDiv.append(nameParagraph);
    poleInfoDiv.append(costParagraph);
    pole.append(colorDiv);
    pole.append(poleInfoDiv);
}


