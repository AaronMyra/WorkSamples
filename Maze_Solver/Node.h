//
// Created by student2007 on 2020-01-28.
//

#ifndef ASSIGNMENT_2_NODE_H
#define ASSIGNMENT_2_NODE_H


class Node {
private:
    struct Data{
        int XPos;
        int YPos;
    };
    Data data{};
    Node *next;

public:
    Node();
    Node(int yPos, int xPos, Node* nextPtr);
    int getXPosition();
    int getYPosition();
    void setData(int yPos, int xPos);
    Node* getNext();
    void setNext( Node *nextPtr );
};


#endif //ASSIGNMENT_2_NODE_H
