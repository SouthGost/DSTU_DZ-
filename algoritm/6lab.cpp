#include <iostream>
using namespace std;

struct S_elem{
    int data;
    S_elem* next;

    S_elem() {
        data = 0;
        next = NULL;
    }
};

struct Stack {
    S_elem* head;
    S_elem* tail;
    int length = 0;

    Stack() {
        head = NULL;
        tail = NULL;
    }
};

void addInStack(Stack* stack, int data) {
    S_elem* elem = new S_elem();
    elem->data = data;
    elem->next = NULL;
    if(stack->length == 0){
        stack->head = elem;
        stack->tail = elem;
    } else {
        elem->next = stack->head;
        stack->head = elem;
    }
    stack->length++;
}

void deleteFromStack(Stack* stack) {
    if (stack->length != 0) {
        S_elem* h = stack->head;
        if (stack->length != 1) {
            stack->head = stack->head->next;
        } else {
            stack->head = NULL;
            stack->tail = NULL;
        }
        stack->length--;
        h->next = NULL;
        delete h;
    } else {
        throw - 1;
    }
}

void printStack(Stack* stack) {
    if (stack->length != 0) {
        S_elem* h = stack->head;
        cout << "Длинна = " << stack->length << endl;
        cout <<"<-----------------------------" << endl;
        while (h != NULL) {
            cout << h->data << endl;
            h = h->next;
        }
        cout <<  "----------------------------->" << endl;
    }
}

int main()
{
    setlocale(LC_ALL, "Russian");
    Stack* stack = new Stack();
    addInStack(stack, 1);
    addInStack(stack, 2);
    printStack(stack);
    deleteFromStack(stack);
    deleteFromStack(stack);
    printStack(stack);
    addInStack(stack, 3);
    addInStack(stack, 4);
    deleteFromStack(stack);
    printStack(stack);
    addInStack(stack, 5);
    printStack(stack);
    system("pause");
    return 0;
}