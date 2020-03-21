//
// Created by student2007 on 2020-01-28.
//

#include "Node.h"

Node::Node(){
    data.XPos = 0;
    data.YPos = 0;
    next = nullptr;
}

Node::Node(int yPos, int xPos, Node *nextPtr) {
    data.XPos = xPos;
    data.YPos = yPos;
    next = nextPtr;
}

Node * Node::getNext() { return next;}
void Node::setNext(Node *nextPtr) {next = nextPtr;}
void Node::setData(int yPos, int xPos) {
    data.XPos = xPos;
    data.YPos = yPos;
}

int Node::getXPosition() { return data.XPos;}
int Node::getYPosition() { return data.YPos;}