#include <stdio.h>
#include <ctype.h>
#include <string.h>
#include <setjmp.h>
#include <stdlib.h>
#include "clearBuffer.h"
#define ENCRYPT(numSequence) (numSequence ^ mask)
#define DECRYPT(numSequence) (numSequence ^ mask)

enum options {ENCRYPTING, DECRYPTING};

int main() {

    FILE *inputFilePtr, *outputFilePtr;
    char *fileLocation[40], charRepeat,
    *startCipher[50] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
                        'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
                        'U', 'V', 'W', 'X', 'Y', 'Z', '!', '@', '#', '$',
                        '%', '&', '(', ')', ':', ';', '?', '.', ',', '/'},
    *subCipher[50] = {':', ';', '?', '.', ',', '/', '0', '1', '2', '3',
                      '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D',
                      'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
                      'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
                      'Y', 'Z', '!', '@', '#', '$', '%', '&', '(', ')'};
    int repeat = 0, switchOption;
    enum options options;
    static jmp_buf error;
    unsigned int mask = 0xa5;
    unsigned int numSequence[80], numSequence2[80];
    unsigned char charSequence[80];
    char fileChar;
    do {

        printf("\nTo encrypt enter 0, to decrypt enter 1? ");
        scanf("%i", &switchOption);
        clearBuffer();

        if (setjmp(error) || switchOption > 1 || switchOption < 0){
            printf("Invalid entry. Please try again.");
        }

        else {

            switch (switchOption){

                case ENCRYPTING:
                    printf("\nENCRYPT\n-----------------------\n");
                    printf("Enter file location: ");
                    scanf("%s", fileLocation);
                    clearBuffer();

                    // Open the files
                    inputFilePtr = fopen(fileLocation, "r");
                    outputFilePtr = fopen("./encrypted_output.txt", "w");

                    // Check if file exists
                    if (inputFilePtr == NULL)
                    {
                        printf("Could not open file %s", fileLocation);
                        return 1;
                    }

                    //LOOP FOR FILE
                    int counter = 0;
                    printf("\n\nEncrypted Number Sequence\n");
                    printf("--------------------------------------------------------------\n\n");
                    for (fileChar = toupper(getc(inputFilePtr)); fileChar != EOF; fileChar = toupper(getc(inputFilePtr))){

                             if (fileChar == ' '){
                                charSequence[counter] = ' ';
                             }

                             else if (fileChar == '\n'){
                                charSequence[counter] = '\n';
                             }

                             else {
                                 for (int i = 0; i < 50; i++){

                                     if (fileChar == startCipher[i]){
                                         charSequence[counter] = subCipher[i];
                                         break;
                                     }
                                 }
                             }

                        //CONVERT FROM SUM CHAR TO IN
                        numSequence[counter] = charSequence[counter];

                        //PREFORM BITWISE OR
                        numSequence2[counter] = ENCRYPT(numSequence[counter]);

                        printf("%i", numSequence2[counter]);
                        printf(" ");
                        counter++;
                        if (fileChar == '\n'){
                            printf("\n");
                        }
                    }

                    numSequence2[counter] = ENCRYPT(0);
                    printf("%i", numSequence2[counter]);

                    //Output to file
                    for(int i = 0; i < (sizeof(numSequence2) / sizeof(numSequence2[0])); i++){

                        fprintf(outputFilePtr, "%i", numSequence2[i]);
                        fprintf(outputFilePtr, "%c", ' ');
                        if (numSequence2[i] == 165){
                            break;
                        }
                    }

                    printf("%c", '\n');

                    //EMPTY ARRAYS
                    memset(numSequence, 0, sizeof(numSequence));
                    memset(numSequence2, 0, sizeof(numSequence2));
                    memset(charSequence, 0, sizeof(charSequence));

                    //CLOSE & DEALLOCATE FILES
                    fclose(inputFilePtr);
                    fclose(outputFilePtr);

                    break;


                case DECRYPTING:
                    printf("\nDECRYPTING\n-----------------------\n");
                    printf("Enter file location: ");
                    scanf("%s", fileLocation);
                    clearBuffer();
                    printf("\n");

                    // Open the files
                    inputFilePtr = fopen(fileLocation, "r");

                    if (inputFilePtr == NULL)
                    {
                        printf("\n\nCould not open file %s\n\n", fileLocation);
                        return 1;
                    }

                    //LOOP FOR FILE
                    char charArray[4];
                    printf("\n\nDecrypted Message\n");
                    printf("--------------------------------------------------------------\n\n");
                    int outerCounter = 0, innerCounter = 0;

                    for (fileChar = getc(inputFilePtr); fileChar != EOF; fileChar = getc(inputFilePtr)){

                        if (fileChar != ' '){
                            charArray[innerCounter] = fileChar;
                            innerCounter++;
                        }
                        else {

                            numSequence2[outerCounter] = atoi(charArray);
                            numSequence[outerCounter] = DECRYPT(numSequence2[outerCounter]);

                            if (numSequence[outerCounter] == 32){
                                charSequence[outerCounter] = ' ';

                            }

                            else if (numSequence[outerCounter] == 10){
                                charSequence[outerCounter] = '\n';

                            }

                            if (numSequence[outerCounter] == 0){
                                charSequence[outerCounter] = '\0';
                                break;
                            }

                            else {

                                for (int i = 0; i < 50; i++){

                                    if (numSequence[outerCounter] == subCipher[i]){
                                        charSequence[outerCounter] = startCipher[i];

                                        break;
                                    }
                                }
                            }

                            printf("%c", charSequence[outerCounter]);
                            memset(charArray, 0, sizeof(charArray));
                            innerCounter = 0;
                            outerCounter++;
                        }

                        if (fileChar == '\n'){
                            printf("\n");
                        }
                    }
                    break;


                default:{
                    printf("Invalid input. Please try again.");
                }
            }
        }
        printf("\n\nWould you like to encrypt or decrypt another file? (Y) or (N): ");
        scanf("%c", &charRepeat);
        clearBuffer();
        if (toupper(charRepeat) == 'N' || toupper(charRepeat) == 'Y'){

            if (toupper(charRepeat) == 'Y'){
                repeat = 1;
            }

            else if (toupper(charRepeat) == 'N'){
                repeat = 0;
            }

        }
        else {
            printf("Invalid entry.");
            return 1;
        }
    }
    while (repeat == 1);
    return 0;
}