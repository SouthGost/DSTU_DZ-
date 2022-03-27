const statesDiv = document.getElementById("states_div");
const startEndDiv = document.getElementById("start_end_div");
const waysDiv = document.getElementById("ways_div");
const showTableDiv = document.getElementById("show_table_div");
const chainDiv = document.getElementById("chain_div");
const divs = [statesDiv, startEndDiv, waysDiv, showTableDiv, chainDiv]

let alfavit = [];
let states = [];
let edge = [[],[]];

function pushToSelect(select, data) {
    for (const data_ of data) {
        const option = document.createElement("option");
        option.innerText = data_;
        select.append(option)
    }
}

function fillSelect(selectName, data){
    const selectStates = [...document.getElementsByClassName(selectName)];
    for (const select of selectStates) {
        select.innerHTML = ""
        pushToSelect(select, data);
    }
}

function ShowWithRuls(number) {
    if(number >= 0 && number <  divs.length){
        switch (number) {
            case 1:
                fillSelect("select_state", states);
                // selectStateContainer[0].append(selectionOfState);
                break;
            case 2:
                fillSelect("select_latter", alfavit);
                break;    
        }
        divs[number].style.visibility = "visible";
    }
}

function showDivs(number) {
    let i = 0;
    for (; i < number; i++) {
        if(divs[i].style.visibility == "hidden"){
            ShowWithRuls(i);
        }
    }
    for (; i < divs.length; i++) {
        divs[i].style.visibility = "hidden";
    }
}
showDivs(1);

const alfavitInput = document.getElementById("alfavit_input");


function setAlfavet() {
    alfavit = [];
    for (const char of alfavitInput.value) {
        console.log(alfavit.indexOf(char), char);
        if (alfavit.indexOf(char) == -1) {
            alfavit.push(char);
        }
    }
    console.log(alfavit);
    showDivs(1);
}


function addState() {
    const statesContainer = document.getElementById("states_container");
    statesContainer.insertAdjacentHTML("beforeend", `<div class="row_container"><input type="text" class="state_input" value=""><button onclick="delRow(event)">-</button></div>`);
}

function delRow(event) {
    // const inputRows = [...document.getElementsByClassName("")];
    const row = event.target.parentElement;
    // console.log(event.target.parentElement);
    row.parentNode.removeChild(row);
    // inputRows[event.target.name].
}


function setStates() {
    states = [];
    const stateInputs = [...document.getElementsByClassName("state_input")];
    for (const state_ of stateInputs) {
        if (state_.value != "") {
            states.push(state_.value);
        }
    }
    console.log(states);
    showDivs(2);
}

function addEdge(edgesType) {
    const edgeSelectStates = document.getElementById(edgesType);
    const div = document.createElement("div");
    div.className = "row_container";
    const select = document.createElement("select")
    select.className = "select_state select_state_edge";
    pushToSelect(select, states);
    div.append(select);
    div.insertAdjacentHTML("beforeend", `<button onclick="delRow(event)">-</button>`);
    edgeSelectStates.append(div);
}

function setEdge(){
    edge = [[],[]];
    const selectStateEdges = [...document.getElementsByClassName("select_state_edge")];
    for (const edgeSelect of selectStateEdges) {
        if(edgeSelect.parentNode.parentNode.id == "starts_select_state"){
            edge[0].push(edgeSelect.value)
        } else if (edgeSelect.parentNode.parentNode.id == "ends_select_state"){
            edge[1].push(edgeSelect.value)
        } else {
            console.log("Не определено, конец или начало");
        }
    }
    console.log(edge);
    showDivs(3);

}