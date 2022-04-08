const statesDiv = document.getElementById("states_div");
const startEndDiv = document.getElementById("start_end_div");
const waysDiv = document.getElementById("ways_div");
const showTableDiv = document.getElementById("show_table_div");
const chainDiv = document.getElementById("chain_div");
const divs = [statesDiv, startEndDiv, waysDiv, showTableDiv, chainDiv]

// let alfavit = ['ε', 'a', 'b'];
// let states = ['q0', 'q1', 'q2', 'q3'];
// let edges = [['q0'], ['q2']];
// let ways = [
//     ['q0', 'ε', 'q3'],
//     ['q0', 'a', 'q1'],
//     ['q1', 'b', 'q0'],
//     ['q1', 'a', 'q1'],
//     ['q1', 'ε', 'q2'],
//     ['q2', 'b', 'q1'],
//     ['q3', 'b', 'q2']
// ];

// let alfavit = ['ε', 'a', 'b'];
// let states = ['q0', 'q1', 'q2', 'q3'];
// let edges = [['q0'], ['q3']];
// let ways = [
//     ['q0', 'ε', 'q1'],
//     ['q0', 'b', 'q2'],
//     ['q1', 'a', 'q3'],
//     ['q1', 'a', 'q2'],
//     ['q2', 'b', 'q2'],
//     ['q2', 'b', 'q3'],
//     ['q3', 'a', 'q3'],
//     ['q3', 'a', 'q0'],
//     ['q3', 'ε', 'q2']
// ];

let alfavit = ['0', '1'];
let states = ['q0', 'q1', 'q2', 'q3', 'q4','q5','q6'];
let edges = [['q0'], ['q3','q4','q5','q6']];
let ways = [
    ['q0', '0', 'q0'],
    ['q0', '1', 'q1'],
    ['q1', '1', 'q1'],
    ['q1', '0', 'q2'],
    ['q2', '0', 'q0'],
    ['q2', '1', 'q3'],
    ['q3', '0', 'q4'],
    ['q3', '1', 'q3'],
    ['q4', '0', 'q5'],
    ['q4', '1', 'q3'],
    ['q5', '0', 'q5'],
    ['q5', '1', 'q3'],
    ['q6', '0', 'q4'],
    ['q6', '1', 'q5'],
];

// let alfavit = [];
// let states = [];
// let edges = [[], []];
// let ways = [

// ];

function pushToSelect(select, data) {
    for (const data_ of data) {
        const option = document.createElement("option");
        option.innerText = data_;
        select.append(option)
    }
}

function fillSelect(selectName, data) {
    const selectStates = [...document.getElementsByClassName(selectName)];
    for (const select of selectStates) {
        select.innerHTML = ""
        pushToSelect(select, data);
    }
}

function ShowWithRuls(number) {
    if (number >= 0 && number < divs.length) {
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
        divs[i].style.visibility = "visible";
        // if (divs[i].style.visibility == "hidden") {
        //     ShowWithRuls(i);
        // }
    }
    for (; i < divs.length; i++) {
        divs[i].style.visibility = "hidden";
    }
}


const alfavitInput = document.getElementById("alfavit_input");


function setAlfavet() {
    alfavit = ["ε"];  //эпсилон 
    for (const char of alfavitInput.value) {
        // console.log(alfavit.indexOf(char), char);
        if (alfavit.indexOf(char) == -1) {
            alfavit.push(char);
        }
    }
    fillSelect("select_latter", alfavit);
    // console.log(alfavit);
    showDivs(1);
}


function addState() {
    const statesContainer = document.getElementById("states_container");
    statesContainer.insertAdjacentHTML("beforeend", `<div class="row_container"><input type="text" class="state_input" value=""><button onclick="delRow(event)">-</button></div>`);
}

function delRow(event) {
    const row = event.target.parentElement;
    row.parentNode.removeChild(row);
}


function setStates() {
    states = [];
    const stateInputs = [...document.getElementsByClassName("state_input")];
    for (const state_ of stateInputs) {
        if (state_.value != "") {
            states.push(state_.value);
        }
    }
    // console.log(states);
    fillSelect("select_state", states);
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

function setEdge() { /// проблемма добавления концов
    edges = [[], []];
    const selectStateEdges = [...document.getElementsByClassName("select_state_edge")];
    for (const edgeSelect of selectStateEdges) {
        if (edgeSelect.parentNode.parentNode.id == "starts_select_state") {
            edges[0].push(edgeSelect.value)
        } else if (edgeSelect.parentNode.parentNode.id == "ends_select_state") {
            edges[1].push(edgeSelect.value)
        } else {
            console.log("Не определено, конец или начало");
        }
    }
    // console.log(edges);
    showDivs(3);

}

function addWay() {
    const wayContainer = document.getElementById("way_container");

    const rowContainer = document.createElement("div");
    rowContainer.className = "row_container way";

    const selectState1 = document.createElement("select");
    selectState1.className = "select_state";
    pushToSelect(selectState1, states);
    // console.log(selectState1.innerHTML);
    rowContainer.append(selectState1);

    const columnContainer = document.createElement("div");
    columnContainer.className = "column_container";
    columnContainer.innerHTML += `
                    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 350 100">
                        <defs>
                            <marker id="arrowhead" markerWidth="10" markerHeight="7" refX="0" refY="3.5" orient="auto">
                                <polygon points="0 0, 10 3.5, 0 7" />
                            </marker>
                        </defs>
                        <line x1="0" y1="50" x2="250" y2="50" stroke="#000" stroke-width="8"
                            marker-end="url(#arrowhead)" />
                    </svg>
    `;

    const selectLatter = document.createElement("select");
    pushToSelect(selectLatter, alfavit);
    selectLatter.className = "select_latter";
    columnContainer.append(selectLatter);

    rowContainer.append(columnContainer);

    const selectState2 = document.createElement("select");
    pushToSelect(selectState2, states);
    selectState2.className = "select_state";
    rowContainer.append(selectState2);

    rowContainer.innerHTML += `<button onclick="delRow(event)">-</button>`;

    wayContainer.insertAdjacentHTML("beforeend", rowContainer.outerHTML);
}

function setWays() {
    ways = [];
    const wayElements = [...document.getElementsByClassName("way")];
    for (const wayElement_ of wayElements) {
        const newWay = [];
        const wayStates = [...wayElement_.getElementsByClassName("select_state")];
        const wayLetter = [...wayElement_.getElementsByClassName("select_latter")];
        newWay.push(wayStates[0].value);
        newWay.push(wayLetter[0].value);
        newWay.push(wayStates[1].value);

        if (newWay[0] != newWay[2] || newWay[1] != "ε") {
            ways.push(newWay);
        }

    }
    // console.log(ways);
    document.getElementById("table_container").innerHTML = "";
    createTable();
    determ();
    showDivs(4);
}

function createTable(alfavit_ = alfavit, states_ = states, edges_ = edges, ways_ = ways) {
    const tableContainer = document.getElementById("table_container");
    const table = document.createElement('table');
    const thead = document.createElement('thead');
    const tbody = document.createElement('tbody');

    const row_letter = document.createElement('tr');
    row_letter.appendChild(document.createElement('td'));
    for (const letter of alfavit_) {
        const td_letter = document.createElement('td');
        td_letter.innerHTML = letter;
        row_letter.appendChild(td_letter);
    }
    thead.appendChild(row_letter);

    const state_rows = [];
    for (const state_ of states_) {
        const row_states_by_latter = [];

        const tr_state = document.createElement('tr');
        const td_state = document.createElement('td');
        td_state.innerHTML = state_;
        if (edges_[0].indexOf(state_) != -1 && edges_[1].indexOf(state_) != -1) {
            td_state.className += "td_edge";
        } else if (edges_[0].indexOf(state_) != -1) {
            td_state.className += "td_start";
        } else if (edges_[1].indexOf(state_) != -1) {
            td_state.className += "td_end";
        }
        tr_state.appendChild(td_state);
        for (const letter of alfavit_) {
            const td_states_by_latter = document.createElement('td');
            tr_state.appendChild(td_states_by_latter);
            row_states_by_latter.push(td_states_by_latter);
        }
        state_rows.push(row_states_by_latter);
        tbody.appendChild(tr_state);
    }

    for (const way_ of ways_) {
        const row = states_.indexOf(way_[0]);
        const colum = alfavit_.indexOf(way_[1]);
        const data = way_[2];
        state_rows[row][colum].innerHTML += data;
    }

    table.appendChild(thead);
    table.appendChild(tbody);
    tableContainer.appendChild(table);

}


function myConcat(arr1, arr2) {
    const arr = [...arr1];
    for (const elem of arr2) {
        if (arr.indexOf(elem) == -1) {
            arr.push(elem);
        }
    }
    return arr;
}

function myIsContain(mainArr, secondArr) {
    for (const secondElem of secondArr) {
        if (mainArr.indexOf(secondElem) == -1) {
            return false
        }
    }
    return true;
}

function myEqual(arr1, arr2) {
    for (const elem1 of arr1) {
        if (arr2.indexOf(elem1) == -1) {
            return false;
        }
    }
    for (const elem2 of arr2) {
        if (arr1.indexOf(elem2) == -1) {
            return false;
        }
    }
    return true;
}

function ISI(state, arr = []) {
    if (arr.indexOf(state) == -1) {
        arr.push(state);
        for (const way_ of ways) {
            if (way_[0] == state && way_[1] == "ε") {
                arr = ISI(way_[2], arr)
            }
        }
    }
    return arr;
}

function determ() {
    const newAlfavit = [...alfavit];
    newAlfavit.splice(newAlfavit.indexOf("ε"), 1);

    const newStates = [];
    const newStatesName = [];


    for (let i = 0; i < states.length; i++) {
        newStates.push(ISI(states[i]));
        newStatesName.push(`S${i}`);
    }
    // console.log(newStates);

    const newEdges = [];
    const newStartEdge = [];
    for (const edgeStart of edges[0]) {
        const newEdgeComponents = [...newStates[states.indexOf(edgeStart)]];
        for (const component of newEdgeComponents) {
            if (newStartEdge.indexOf(newStatesName[states.indexOf(component)])) {
                newStartEdge.push(newStatesName[states.indexOf(component)]);
            }
        }
    }
    newEdges.push(newStartEdge);
    const newEndEdge = [];
    for (const edgeEnd of edges[1]) {
        for (let i = 0; i < newStates.length; i++) {
            if (newStates[i].indexOf(edgeEnd) != -1 && newEndEdge.indexOf(newStatesName[i])) {
                newEndEdge.push(newStatesName[i]);
            }
        }
    }
    newEdges.push(newEndEdge);
    // console.log(newEdges);

    const dostizimost = [];
    for (const newLetter of newAlfavit) {
        const letterArr = [];
        for (const state_ of states) {
            let dostizimostFromState = [];
            for (const state__ of newStates[states.indexOf(state_)]) {
                for (const way_ of ways) {
                    if (way_[0] == state__ && way_[1] == newLetter) {
                        dostizimostFromState.push(way_[2]);
                    }
                }
            }
            let tempArr = [];
            for (const dostState_ of dostizimostFromState) {
                tempArr = myConcat(tempArr, newStates[states.indexOf(dostState_)]);
            }
            dostizimostFromState = myConcat(dostizimostFromState, tempArr);
            letterArr.push(dostizimostFromState)
        }
        dostizimost.push(letterArr);
    }
    // console.log(dostizimost);

    const newWays = [];
    for (let i = 0; i < newStates.length; i++) {
        for (let j = 0; j < newAlfavit.length; j++) {
            for (const newState_ of newStates) {
                if (myIsContain(dostizimost[j][i], newState_)) {
                    newWays.push([
                        newStatesName[i],
                        newAlfavit[j],
                        newStatesName[newStates.indexOf(newState_)]
                    ])
                }
            }

        }
    }
    // console.log(newWays);

    createTable(newAlfavit, newStatesName, newEdges, newWays);

    const finalStates = [];
    const finalStatesName = [];
    finalStates.push(newEdges[0]);
    finalStatesName.push("P0");
    const finalEdges = [["P0"], []];
    const finalWays = [];


    for (let i = 0; i < finalStates.length; i++) {
        for (const newLetter of newAlfavit) {
            let arrOfNewStates = [];
            for (const newState_ of finalStates[i]) {
                const arrOfNewStates_ = [];
                for (const newWay_ of newWays) {
                    if (newWay_[0] == newState_ && newWay_[1] == newLetter) {
                        arrOfNewStates_.push(newWay_[2]);
                    }
                }
                arrOfNewStates = myConcat(arrOfNewStates, arrOfNewStates_);
            }
            if(arrOfNewStates.length != 0){
                let isFind = false;
                for (let j = 0; j < finalStates.length; j++) {
                    if (myEqual(arrOfNewStates, finalStates[j])) {
                        isFind = true;
                        finalWays.push([finalStatesName[i], newLetter, finalStatesName[j]]);
                        break;
                    }
                }
                if (!isFind) {
                    finalStates.push(arrOfNewStates);
                    finalStatesName.push(`P${finalStatesName.length}`);
                    finalWays.push([finalStatesName[i], newLetter, finalStatesName[finalStatesName.length - 1]]);
                }
            }
        }
    }

    for (const newEnd of newEdges[1]) {
        for (let i = 0; i < finalStates.length; i++) {
            if(finalStates[i].indexOf(newEnd) != -1 && finalEdges[1].indexOf(finalStatesName[i]) == -1){
                finalEdges[1].push(finalStatesName[i]);
            }
        }
    }

    // console.log("finalStates", finalStates);
    // console.log("finalWays", finalWays);

    createTable(newAlfavit, finalStatesName, finalEdges, finalWays);
    alfavit = newAlfavit;
    states = finalStatesName;
    edges = finalEdges;
    ways = finalWays;
    showDivs(5);
    minim()
}

function minim(){

    let notGetingState = [];
    do {
        notGetingState = [...states];
        for (const way_ of ways) {
            const idState = notGetingState.indexOf(way_[2]);
            if(idState != -1){
                notGetingState.splice(idState,1);
            }
        }
        console.log("не достежимые",notGetingState);
        for(let i = 0; i < notGetingState.length; i++) {
            for (let j = 0; j < ways.length; j++) {
                if(ways[j][0] == notGetingState[i]){
                    ways.splice(j,1);
                }
            }
            states.splice(states.indexOf(notGetingState[i]),1);
        }
    } while (notGetingState.length != 0);

    let grups = [[],[]];
    for (const state_ of states) {
        if(edges[1].indexOf(state_) != -1){
            grups[1].push(state_);
        } else {
            grups[0].push(state_);
        }
    }
    console.log(grups)
    let newGrups = [...grups];

    do {
        grups = [... newGrups];
        for (let i = 0; i < grups.length; i ++) {
            for (let j = 0; j < grups[i].length; j++) {
                for (const way_ of ways) {
                    if(way_[0] === grups[i][j]){
                        if(grups[i].length != 1 && !grups[i].includes(way_[2])){
                            newGrups[i].splice(j,1);
                            newGrups.push([grups[i][j]]);
                        }
                    }
                }
                
            }
        }
        console.log(newGrups);
    }while(grups != newGrups);

}


function chekChain(){
    const chain_input = document.getElementById("chain_input");
    const chain =  chain_input.value;
    const chain_p = document.getElementById("chain_p");
    let myError = "";

    for (const start_edge of edges[0]) {
        try{
            let currentState = start_edge;
            for (const letter of chain) {
                if(alfavit.indexOf(letter) == -1){
                    throw new Error("Нет символа " + letter +" в алфавите")
                }
                let isFind = false;
                for (const way_ of ways) {
                    if(way_[0] == currentState && way_[1] == letter){
                        isFind = true;
                        currentState = way_[2];
                        break;
                    }
                }
                if(!isFind){
                    throw new Error("Попал в тупик")
                }
            }
            if(edges[1].indexOf(currentState) != -1){
                chain_p.innerText = "автомат содержит цепочку"
                return;
            }
        }catch(error){
            myError = error.message;
        }
    }
    if(myError == ""){
        myError = "автомат не содержит цепочку"
    }
    chain_p.innerText = myError;
    
}



// showDivs(0);
createTable()//
// determ()//
minim()