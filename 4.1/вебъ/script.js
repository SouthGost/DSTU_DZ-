const playingField = document.getElementById("playing_field");
const gun = document.getElementById("gun");

gun.style.left = "20px"
let width = window.innerWidth;


function addEnemy(x, y) {
    const enemy = document.createElement("div");
    enemy.className = "enemy";
    enemy.style.top = `${y}px`;
    enemy.style.left = `${x}px`;
    playingField.append(enemy);
}

// for (let i = 10; i < 1000; i += 110) {
//     addEnemy(i, 20);
// }

document.addEventListener("keypress", (event) => {
    let left = gun.style.left.slice(0, -2) * 1;
    switch (event.code) {
        case "KeyA":
            if(left > 20){
                gun.style.left = `${left-1}px`; 
            }
            break;
        case "KeyD":
            if(left < 1000){
                gun.style.left = `${left+1}px`; 
            }
            break;
    }

    console.log(event.code)
})