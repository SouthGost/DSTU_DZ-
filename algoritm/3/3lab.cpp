#include <iostream>
using namespace std;

void transleteToEng(const char* strRus, char** rus, char** eng) {
    for (int i = 0; i < 10; i++) {
        if (strcmp(rus[i], strRus) == 0) {
            cout << strRus <<": "<< eng[i] << endl;
            return;
        }
    }
    cout << "Я такого не знаю\n";
}

void transleteToRus(const char* strEng, char** rus, char** eng) {
    for (int i = 0; i < 10; i++) {
        if (strcmp(eng[i], strEng) == 0) {
            cout << strEng << ": " << rus[i] << endl;
            return;
        }
    }
    cout << "Я такого не знаю\n";
}

void WritePointer(int * p,int x) {
    *p = x;
}

void ReadPointer(int* p) {
    cout << *p << endl;
}

void SetPointer(int* p1, int* p2) {
    p1 = p2;
}

void FreePointer(int &p) {
    p = NULL;
}

int main(){
    setlocale(LC_ALL, "Russian");

    int a = 3;
    int b = 6;
    int* t =  &a;
    WritePointer(t, 4);
    ReadPointer(t);
    int* c = &b;
    SetPointer(t, c);
    ReadPointer(t);
    ReadPointer(c);
    FreePointer(*c);
    ReadPointer(c);
    ReadPointer(t);
    //cout << *t << endl;
   // t = c;

   // FreePointer(*t);
   // cout << *c << endl;


    /* 2
    char** english = new char* [10];
    char** russian = new char* [10];
    english[0] = _strdup("rabbit");
    english[1] = _strdup("mountain");
    english[2] = _strdup("fridge");
    english[3] = _strdup("drink");
    english[4] = _strdup("sea");
    english[5] = _strdup("bear");
    english[6] = _strdup("wall");
    english[7] = _strdup("backpack");
    english[8] = _strdup("ten");
    english[9] = _strdup("circle");

    russian[0] = _strdup("кролик");
    russian[1] = _strdup("гора");
    russian[2] = _strdup("холодильник");
    russian[3] = _strdup("пить");
    russian[4] = _strdup("море");
    russian[5] = _strdup("медведь");
    russian[6] = _strdup("стена");
    russian[7] = _strdup("рюкзак");
    russian[8] = _strdup("десять");
    russian[9] = _strdup("круг");

    transleteToEng("пить", russian, english);
    transleteToRus("seaw", russian, english);
    */
}
