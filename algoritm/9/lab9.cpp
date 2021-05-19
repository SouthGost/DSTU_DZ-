#include <iostream>
#include <iomanip>      // std::setw
using namespace std;

struct elem {
    int data;
    elem* el1 = NULL;
    elem* el2 = NULL;
};

struct Tree {
    elem* start = NULL;
};

void addafter(elem* el, int x) {
    if (x > el->data) {
        if (el->el1 == NULL) {
            elem* elN = new elem();
            elN->data = x;
            el->el1 = elN;
        } else {
            addafter(el->el1, x);
        }
    } else {
        if (el->el2 == NULL) {
            elem* elN = new elem();
            elN->data = x;
            el->el2 = elN;
        }
        else {
            addafter(el->el2, x);
        }
    }
}

void addToTree(Tree* tree, int x){
    if (tree->start == NULL) {
        elem* el = new elem();
        el->data = x;
        tree->start = el;
    } else {
        addafter(tree->start, x);
    }
}

void ShowElem(elem* el, int lvl) {
    if (el->el1 != NULL) {
        ShowElem(el->el1, lvl + 5);
    }
    if (lvl >= 0) {
        cout << std::setw(lvl) << ' ';
    }
    if (el->el1 != NULL) {
        cout << " /\n" << setw(lvl) << ' ';
    }
    cout << el->data << "\n ";
    if (el->el2 != NULL) {
        cout << setw(lvl) << ' ' << " \\\n";
        ShowElem(el->el2, lvl + 5);
    }
}

void ShowTree(Tree* tree) {
    if (tree->start != NULL) {
        ShowElem(tree->start,0);
    }
}

int cutMaxEl(elem* el) {
    elem* h = el;
    int x;
    if (h->el2->el1 == NULL) {
        x = h->el2->data;
        if (h->el2->el2 != NULL) {
            h->el2 = h->el2->el2;
        } else {
            elem* t = h->el2;
            h->el2 = NULL;
            delete t;
        }
    } else {
        h = h->el2;
        while (h->el1->el1 != NULL) {
            h = h->el1;
        }
        x = h->el1->data;
        if (h->el1->el2 != NULL) {
            h->el1 = h->el1->el2;
        }
        else {
            elem* t = h->el1;
            h->el1 = NULL;
            delete t;
        }
    }
    return x;
}

int cutMinEl(elem* el) {
    elem* h = el;
    int x;
    if (h->el1->el2 == NULL) {
        x = h->el1->data;
        if (h->el1->el1 != NULL) {
            h->el1 = h->el1->el1;
        }
        else {
            elem* t = h->el1;
            h->el1 = NULL;
            delete t;
        }
    }
    else {
        h = h->el1;
        while (h->el2->el2 != NULL) {
            h = h->el2;
        }
        x = h->el2->data;
        if (h->el2->el1 != NULL) {
            h->el2 = h->el2->el1;
        }
        else {
            elem* t = h->el2;
            h->el2 = NULL;
            delete t;
        }
    }
    return x;
}

void deleteElem(elem* el, int x) {
    if (el->data == x) {
        cout << "<Cry>CLOVLENNA OSHIBKA </Cry>";
    } else if(x>el->data){
        if (el->el1 != NULL) {
            if (el->el1->data == x) {
                if (el->el1->el1 != NULL) {
                    el->el1->data = cutMinEl(el->el1);
                } else if (el->el1->el2 != NULL){
                    el->el1->data = cutMaxEl(el->el1);
                } else {
                    elem* h = el->el1;
                    el->el1 = NULL;
                    delete h;
                }
            } else {
                deleteElem(el->el1, x);
            }
        }
    } else {
        if (el->el2 != NULL) {
            if (el->el2->data == x) {
                if (el->el2->el1 != NULL) {
                    el->el2->data = cutMinEl(el->el2);
                } else if (el->el2->el2 != NULL) {
                    el->el2->data = cutMaxEl(el->el2);
                }
                else {
                    elem* h = el->el2;
                    el->el2 = NULL;
                    delete h;
                }
            }
            else {
                deleteElem(el->el2, x);
            }
        }
    }

}

void deleteFromTree(Tree* tree, int x) {
    if (tree->start != NULL) {
        if (tree->start->data == x) {
            if (tree->start->el1 != NULL) {
                tree->start->data = cutMinEl(tree->start);
            }
            else if (tree->start->el2 != NULL) {
                tree->start->data = cutMaxEl(tree->start);
            }
            else {
                elem* h = tree->start;
                tree->start = NULL;
                delete h;
            }
        } else {
            deleteElem(tree->start, x);
        }
    }
}

void printET(const std::string& prefix, const elem* node, bool isLeft)
{
    if (node != NULL)
    {
        std::cout << prefix;

        std::cout << (isLeft ? "\\" : "/");

        // print the value of the node
        std::cout << node->data << std::endl;

        printET(prefix + (isLeft ? "| " : " "), node->el2, true);
        printET(prefix + (isLeft ? "| " : " "), node->el1, false);
    }
}

void printT(const Tree* node)
{
    printET("", node->start, false);
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
    
 //   */
    return 0;
}
