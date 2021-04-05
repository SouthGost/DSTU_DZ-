let chooslength = 100;

let array = [];

for (let i = 0; i < 100; ++i) {
    array[i] = 0;
}

let sort = false;

let arrayShow = true;

function createArray(length) {
    let a = [];
    for (let i = 0; i < length; ++i) {
        a[i] = Math.round(Math.random() * length);
    }
    sort = false;
    if (arrayShow)
        console.log("Массив: ", a);
    return a;
}

function createArraySort(length) {
    let a = [];
    for (let i = 0; i < length; ++i) {
        a[i] = Math.round(Math.random() * length);
    }
    a = vkluch(a, 0);
    sort = true;
    if (arrayShow)
        console.log("Массив: ", a);
    return a;
}

function vkluch(a) {
    let time = new Date().getTime();
    for (let i = 1; i < a.length; ++i) {
        let x = a[i];
        let j = i - 1;
        while (x < a[j] && j >= 0) {
            a[j + 1] = a[j];
            j = j - 1;
        }
        a[j + 1] = x;
    }
    time = new Date().getTime() - time;
    return a;
}

function myfind(type, a) {
    let x = document.getElementById("find_value").value;
    switch (type) {
        case "line":
            lineFinder(a, x);
            break;
        case "line-border":
            lineBorderFinder(a, x);
            break;
        case "binar":
            if (sort) {
                binarFinder(a, x);
            } else {
                console.log(`Массив не отсортирован`);
            }
            break;
    }
}

function lineFinder(a, x) {
    console.log("Линейный поиск");
    let time = new Date().getTime();
    let i = 0;
    while ((i < a.length) && (a[i] != x)) {
        i++;
    }
    if (a[i] == x) {
        console.log(`${x} находиться на ${i} позиции`);
    } else {
        console.log(`${x} нет в массиве`);
        i = -1;
    }
    time = new Date().getTime() - time;
    console.log(`Потраченное время: ${time}`)
    return i;
}

function lineBorderFinder(a, x) {
    console.log("Линейный поиск с барьером");
    let time = new Date().getTime();
    a[a.length] = x;
    let i = 0;
    while (a[i] != x) {
        i++;
    }
    if (i != a.length - 1) {
        console.log(`${x} находиться на ${i} позиции`);
    } else {
        console.log(`${x} нет в массиве`);
        i = -1;
    }
    a.pop();
    time = new Date().getTime() - time;
    console.log(`Потраченное время: ${time}`)
    return i;
}

function binarFinder(a, x) {
    console.log("Бинарный поиск");
    let time = new Date().getTime();
    let i = BinarFinderLR(a, x, 0, a.length - 1);
    if (i != -1) {
        console.log(`${x} находиться на ${i} позиции`);
    } else {
        console.log(`${x} нет в массиве`);
    }
    time = new Date().getTime() - time;
    console.log(`Потраченное время: ${time}`)
    return i;

}

function BinarFinderLR(a, x, l, r) {
    if (l < r) {
        m = Math.floor((r - l) / 2) + l;
        // if (x == a[m]) {
        //     return m;
        // } else 
        if (x > a[m]) {
            l = m + 1;
        } else {
            r = m;
        }
        return BinarFinderLR(a, x, l, r);
    } else if (x == a[l]) {
        return l;
    } else
    return -1;
}