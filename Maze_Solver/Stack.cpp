//
// Created by student2007 on 2020-01-28.
//

#include <iostream>
#include "Stack.h"

using namespace std;

Stack::Stack():top(nullptr) {}

Stack::~Stack() {
    while (top != nullptr){
        pop();
    }
}

void Stack::pop() {
    if (top != nullptr) {
        Node *node = top;
        top = node->getNext();
        delete node;
    }
}

void Stack::push(int yPos, int xPos) {
    top = new Node(yPos, xPos, top);
}

Node Stack::getTop() { return *top;}