//
// Created by student on 10/04/19.
//

#include <stdio.h>
#include "clearBuffer.h"
//Clear scaf buffer (loop until '\n' or 10)
void clearBuffer(){
    int buffer;
    while ((buffer = getchar()) != 10);
}