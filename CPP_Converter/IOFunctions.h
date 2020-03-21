//
// Created by w0235012 on 11/13/2019.
//

#ifndef ASSIGNMENT_4_IOFUNCTIONS_H
#define ASSIGNMENT_4_IOFUNCTIONS_H

#include <string>

using namespace std;

struct Exception
{
    const char* err;
    Exception() : err("A file io error occurred"){}
};

bool getFileContents(string filePath, string *contents);
void outputContents(string filePath, string contents);
string replaceFileExtention(string filePath, string newExtention);
string replaceChars(string *fileContents);

#endif //ASSIGNMENT_4_IOFUNCTIONS_H