#include <iostream>
#include <iomanip>      // std::setw
using namespace std;

struct elem {
    int data;
    elem* el1 = NULL;
    elem* el2 = NULL;
};

struct Tree {
    elem* barrier = new elem();
    elem* start = barrier;
};

void addafter(elem* el, int x, elem* barrier) {
    if (x > el->data) {
        if (el->el1 == barrier) {
            elem* elN = new elem();
            elN->data = x;
            elN->el1 = barrier;
            elN->el2 = barrier;
            el->el1 = elN;
        } else {
            addafter(el->el1, x, barrier);
        }
    } else {
        if (el->el2 == barrier) {
            elem* elN = new elem();
            elN->data = x;
            elN->el1 = barrier;
            elN->el2 = barrier;
            el->el2 = elN;
        }
        else {
            addafter(el->el2, x, barrier);
        }
    }
}

void addToTree(Tree* tree, int x){
    if (tree->start == tree->barrier) {
        elem* el = new elem();
        el->data = x;
        el->el1 = tree->barrier;
        el->el2 = tree->barrier;
        tree->start = el;
    } else {
        addafter(tree->start, x, tree->barrier);
    }
}

void ShowElem(elem* el, int lvl, elem* barrier) {
    if (el->el1 != barrier) {
        ShowElem(el->el1, lvl + 5, barrier);
    }
    if (lvl >= 0) {
        cout << std::setw(lvl) << ' ';
    }
    if (el->el1 != barrier) {
        cout << " /\n" << setw(lvl) << ' ';
    }
    cout << el->data << "\n ";
    if (el->el2 != barrier) {
        cout << setw(lvl) << ' ' << " \\\n";
        ShowElem(el->el2, lvl + 5, barrier);
    }
}

void ShowTree(Tree* tree) {
    if (tree->start != tree->barrier) {
        ShowElem(tree->start, 0, tree->barrier);
    }
}

int cutMaxEl(elem* el, elem* barrier) {
    elem* h = el;
    int x;
    if (h->el2->el1 == barrier) {
        x = h->el2->data;
        if (h->el2->el2 != barrier) {
            h->el2 = h->el2->el2;
        } else {
            elem* t = h->el2;
            h->el2 = barrier;
            delete t;
        }
    } else {
        h = h->el2;
        while (h->el1->el1 != barrier) {
            h = h->el1;
        }
        x = h->el1->data;
        if (h->el1->el2 != barrier) {
            h->el1 = h->el1->el2;
        }
        else {
            elem* t = h->el1;
            h->el1 = barrier;
            delete t;
        }
    }
    return x;
}

int cutMinEl(elem* el, elem* barrier) {
    elem* h = el;
    int x;
    if (h->el1->el2 == barrier) {
        x = h->el1->data;
        if (h->el1->el1 != barrier) {
            h->el1 = h->el1->el1;
        }
        else {
            elem* t = h->el1;
            h->el1 = barrier;
            delete t;
        }
    }
    else {
        h = h->el1;
        while (h->el2->el2 != barrier) {
            h = h->el2;
        }
        x = h->el2->data;
        if (h->el2->el1 != barrier) {
            h->el2 = h->el2->el1;
        }
        else {
            elem* t = h->el2;
            h->el2 = barrier;
            delete t;
        }
    }
    return x;
}

void deleteElem(elem* el, int x, elem* barrier) {
    if (el->data == x) {
        cout << "<Cry>CLOVLENNA OSHIBKA </Cry>";
    } else if(x>el->data){
        if (el->el1 != barrier) {
            if (el->el1->data == x) {
                if (el->el1->el1 != barrier) {
                    el->el1->data = cutMinEl(el->el1, barrier);
                } else if (el->el1->el2 != barrier){
                    el->el1->data = cutMaxEl(el->el1, barrier);
                } else {
                    elem* h = el->el1;
                    el->el1 = barrier;
                    delete h;
                }
            } else {
                deleteElem(el->el1, x, barrier);
            }
        }
    } else {
        if (el->el2 != barrier) {
            if (el->el2->data == x) {
                if (el->el2->el1 != barrier) {
                    el->el2->data = cutMinEl(el->el2, barrier);
                } else if (el->el2->el2 != barrier) {
                    el->el2->data = cutMaxEl(el->el2, barrier);
                }
                else {
                    elem* h = el->el2;
                    el->el2 = barrier;
                    delete h;
                }
            }
            else {
                deleteElem(el->el2, x, barrier);
            }
        }
    }

}

void deleteFromTree(Tree* tree, int x) {
    if (tree->start != tree->barrier) {
        if (tree->start->data == x) {
            if (tree->start->el1 != tree->barrier) {
                tree->start->data = cutMinEl(tree->start, tree->barrier);
            }
            else if (tree->start->el2 != tree->barrier) {
                tree->start->data = cutMaxEl(tree->start, tree->barrier);
            }
            else {
                elem* h = tree->start;
                tree->start = tree->barrier;
                delete h;
            }
        } else {
            deleteElem(tree->start, x, tree->barrier);
        }
    }
}

void printET(const std::string& prefix, const elem* node, bool isLeft, elem* barrier)
{
    if (node != barrier)
    {
        std::cout << prefix;

        std::cout << (isLeft ? "\\" : "/");

        // print the value of the node
        std::cout << node->data << std::endl;

        printET(prefix + (isLeft ? "| " : " "), node->el2, true, barrier);
        printET(prefix + (isLeft ? "| " : " "), node->el1, false, barrier);
    }
}

void printT(const Tree* node)
{
    printET("", node->start, false, node->barrier);
}

bool findElem(elem* el, int x, elem* barrier) {
    bool isElem = false;
    if (el->data == x) {
        if (el != barrier) {
            isElem = true;
        }
    } else if(el->data < x) {
        isElem = findElem(el->el1, x, barrier);
    } else {
        isElem = findElem(el->el2, x, barrier);
    }
    return isElem;
}

bool findInTree(Tree* tree, int x) {
    tree->barrier->data = x;
    return findElem(tree->start, x, tree->barrier);
}

int main() {
    Tree* qwe = new Tree();
/*   addToTree(qwe, 12);
    addToTree(qwe,9);
    addToTree(qwe, 18); 
    addToTree(qwe, 6);
    addToTree(qwe, 15);
    addToTree(qwe, 26); 
    addToTree(qwe, 14); 
    addToTree(qwe, 10);
    addToTree(qwe, 21); 
    addToTree(qwe, 7);
    addToTree(qwe, 16); 
    addToTree(qwe, 13); 
    addToTree(qwe, 1); 
    addToTree(qwe, 8);
    printT(qwe);
    deleteFromTree(qwe, 12);
    printT(qwe);
    //ShowTree(qwe);

// */ 
/* */
    addToTree(qwe, 10);
    addToTree(qwe, 15);
    addToTree(qwe, 16);
    addToTree(qwe, 5);
    addToTree(qwe, 6);
    addToTree(qwe, 7);
    addToTree(qwe, 8);
    addToTree(qwe, 9);
    addToTree(qwe, 14);
    addToTree(qwe, 13);
    addToTree(qwe, 12);
    addToTree(qwe, 11);
    //printT(qwe);
    deleteFromTree(qwe, 7);
    ShowTree(qwe);
    cout << "---------------------------\n";
    cout << findInTree(qwe, 10) << endl;
    cout << findInTree(qwe, 7) << endl;
    cout << findInTree(qwe, 11) << endl;
    cout << findInTree(qwe, 10) << endl;
    cout << findInTree(qwe, 9) << endl;
    cout << findInTree(qwe, 16) << endl;
    cout << findInTree(qwe, 4) << endl;
    cout << findInTree(qwe, 50) << endl;
    cout << findInTree(qwe, 1) << endl;
    
 //   */
    return 0;
}
