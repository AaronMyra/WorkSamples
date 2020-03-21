//
// Created by student2007 on 2020-01-28.
//

#ifndef ASSIGNMENT_2_STACK_H
#define ASSIGNMENT_2_STACK_H

#include "Node.h"

class Stack {
private:
    Node *top;

public:
    Stack();
    ~Stack();

    void pop();
    void push(int yPos, int xPos);
    Node getTop();

};


#endif //ASSIGNMENT_2_STACK_H
