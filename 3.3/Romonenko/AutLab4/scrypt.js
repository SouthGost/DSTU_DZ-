const statesDiv = document.getElementById("states_div");
const startEndDiv = document.getElementById("start_end_div");
const waysDiv = document.getElementById("ways_div");
const showTableDiv = document.getElementById("show_table_div");
const chainDiv = document.getElementById("chain_div");
const divs = [statesDiv, startEndDiv, waysDiv, showTableDiv, chainDiv]

function showDiv(number){
    let i = 0;
    for( ; i < number;i++){
        divs[i].style.visibility = "visible";
    }
    for( ; i < divs.length;i++){
        divs[i].style.visibility = "hidden";
    }
}
//showDiv(0);

const alfavitInput = document.getElementById("alfavit_input");

const alfavit = [];

function setAlfavet(){
    for (const char of alfavitInput.value) {
        console.log(alfavit.indexOf(char), char);
        if(alfavit.indexOf(char) == -1){
            alfavit.push(char);
        }
    }
    console.log(alfavit);
    showDiv(1);
}

const statesContainer = document.getElementById("states_container");

function addState(){
    statesContainer.innerHTML+=`<div class="input_row"><input type="text" class="state_input" value=""><button>-</button></div>`;
}

function deleteState(index){
    const inputRow = document.getElementsByClassName("input_row");
    const stateInput = document.getElementsByClassName("state_input");

}