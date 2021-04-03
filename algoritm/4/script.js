let chooslength = 20;


function createArray(length) {
    let a = [];
    for (let i = 0; i < length; ++i) {
        a[i] = Math.round(Math.random() * length);
    }
    console.log(0 + "%");
    if (length == 20)
        console.log("Было: ", a);
    return a;
}

function createArraySort(length, persent) {
    let a = [];
    for (let i = 0; i < length; ++i) {
        a[i] = Math.round(Math.random() * length);
    }
    a = vkluch(a, 0);
    for (let i = length * persent; i < length; ++i) {
        a[i] = Math.round(Math.random() * (length - a[length * persent - 1]) + a[length * persent - 1]);
    }
    console.log(persent * 100 + "%");
    if (length == 20)
        console.log("Было: ", a);
    return a;
}

function vkluch(a, show = 1) {
    let sravneniya = 3;
    let obmen = 0;
    let time = new Date().getTime();
    for (let i = 1; i < a.length; ++i) {
        sravneniya += 1;
        let x = a[i];
        let j = i - 1;
        while (x < a[j] && j >= 0) {
            sravneniya += 2;
            a[j + 1] = a[j];
            j = j - 1;
            obmen += 1;
        }
        a[j + 1] = x;
    }
    time = new Date().getTime() - time;
    if (a.length == 20 && show == 1)
        console.log("Стало: ", a);
    if (show == 1)
        console.log("Прямое включение\nДлинна: ", a.length, " Сравнения: ", sravneniya, " Обмены: ", obmen, " Время: ", time);
    return a;
}

function vibor(a) {
    let sravneniya = 3;
    let obmen = 0;
    let time = new Date().getTime();
    for (let i = 0; i < a.length - 1; ++i) {
        sravneniya += 1;
        let x = a[i];
        let k = i;
        for (let j = i + 1; j < a.length; ++j) {
            if (a[j] < x) {
                k = j;
                x = a[j];
                obmen += 1;
            }
            sravneniya += 2;
        }
        a[k] = a[i];
        a[i] = x;
        obmen += 1;
    }
    time = new Date().getTime() - time;
    if (a.length == 20)
        console.log("Стало: ", a);
    console.log("Прямой выбор\nДлинна: ", a.length, " Сравнения: ", sravneniya, " Обмены: ", obmen, " Время: ", time);
}

function obmen(a) {
    let sravneniya = 3;
    let obmen = 0;
    let time = new Date().getTime();
    for (let i = 0; i < a.length; ++i) {
        for (let j = a.length - 1; j > i; --j) {
            if (a[j - 1] > a[j]) {
                let x = a[j - 1];
                a[j - 1] = a[j];
                a[j] = x;
                obmen+=1;
            }
            sravneniya+=3;
        }
    }
    time = new Date().getTime() - time;
    if (a.length == 20)
        console.log("Стало: ", a);
    console.log("Прямой обмен\nДлинна: ", a.length," Сравнения: ", sravneniya," Обмены: ", obmen," Время: ", time);
}

function fast(a){
    let sravneniya = 3;
    let obmen = 0;
    let time = new Date().getTime();

    let i =1;
    let j = a.length-1;
    x = a[10];
    do {
        while(a[i]<x){
        sravneniya+=1;
            i++;
        }
        sravneniya+=1;
        while (a[j]>x){
            sravneniya+=1;
            j--;
        }
        sravneniya+=1;
        if(i<=j){
            let w = a[i];
            a[i]=a[j];
            a[j]=w;
            obmen+=1;
        }
        sravneniya+=2;
    }while(i>j);
    time = new Date().getTime() - time;
    if (a.length == 20)
        console.log("Стало: ", a);
    console.log("Метод быстрой сортировки\nДлинна: ", a.length," Сравнения: ", sravneniya," Обмены: ", obmen," Время: ", time);
}