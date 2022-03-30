const statesDiv = document.getElementById("states_div");
const startEndDiv = document.getElementById("start_end_div");
const waysDiv = document.getElementById("ways_div");
const showTableDiv = document.getElementById("show_table_div");
const chainDiv = document.getElementById("chain_div");
const divs = [statesDiv, startEndDiv, waysDiv, showTableDiv, chainDiv]

let alfavit = ['ε', 'a', 'b'];
let states = ['q0', 'q1', 'q2', 'q3'];
let edge = [['q1'], ['q2']];
let ways = [
    ['q0', 'ε', 'q3'], 
    ['q0', 'a', 'q1'],
    ['q1', 'b', 'q0'],
    ['q1', 'a', 'q1'], 
    ['q1', 'ε', 'q2'],
    ['q2', 'b', 'q1'],
    ['q3', 'b', 'q2']
];

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
// showDivs(1);

const alfavitInput = document.getElementById("alfavit_input");


function setAlfavet() {
    alfavit = ["ε"];  //эпсилон 
    for (const char of alfavitInput.value) {
        console.log(alfavit.indexOf(char), char);
        if (alfavit.indexOf(char) == -1) {
            alfavit.push(char);
        }
    }
    fillSelect("select_latter", alfavit);
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
    fillSelect("select_state",states);
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
    edge = [[], []];
    const selectStateEdges = [...document.getElementsByClassName("select_state_edge")];
    for (const edgeSelect of selectStateEdges) {
        if (edgeSelect.parentNode.parentNode.id == "starts_select_state") {
            edge[0].push(edgeSelect.value)
        } else if (edgeSelect.parentNode.parentNode.id == "ends_select_state") {
            edge[1].push(edgeSelect.value)
        } else {
            console.log("Не определено, конец или начало");
        }
    }
    console.log(edge);
    showDivs(3);

}

function addWay() {
    const wayContainer = document.getElementById("way_container");

    const rowContainer = document.createElement("div");
    rowContainer.className = "row_container way";

    const selectState1 = document.createElement("select");
    selectState1.className = "select_state";
    pushToSelect(selectState1, states);
    console.log(selectState1.innerHTML);
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
        // console.log(wayStates[0].value);    
        // console.log(wayLetter[0].value);    
        // console.log(wayStates[1].value);    
        newWay.push(wayStates[0].value);
        newWay.push(wayLetter[0].value);
        newWay.push(wayStates[1].value);

        if (newWay[0] != newWay[2] || newWay[1] != "ε") {
            ways.push(newWay);
        }

    }
    console.log(ways);
    document.getElementById("table_container").innerHTML = "";
    createTable();
    showDivs(4);
}

function createTable(alfavit_ = alfavit, states_ = states, ways_ = ways) {
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
createTable()//

function ISI(state, arr = []){
    if(arr.indexOf(state) == -1){
        arr.push(state);
        for (const way_ of ways) {
            if(way_[0] == state && way_[1] == "ε"){
                arr = ISI(way_[2], arr)
            }
        }
    }
    return arr;
}

function determ(){
    const newStates = [];
    let i = 0;

    for (const state_ of states) {
        newStates.push([`S${i}`, ISI(state_)]);
        i++;
    }
    console.log(newStates);
}
determ()