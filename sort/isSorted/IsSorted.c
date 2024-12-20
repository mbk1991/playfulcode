#include <stdio.h>
#include <string.h>
#include <stdlib.h>


//정수 배열의 정렬을 확인하는 함수 작성

int isSorted(int* array, int length);

int main(){

    char str[100];
    printf("숫자 배열을 공백으로 구분하여 입력하세요.");
    fgets(str, sizeof(str), stdin);

    int intArray[100];
    char* token;
    token = strtok(str," ");

    int idx = 0;
    while(token != NULL){
        printf("%s\n", token);
        intArray[idx] = atoi(token);
        token = strtok(NULL, " ");
        idx++;
    }


    int inputArr[idx];
    for(int i=0; i<idx; i++){
        inputArr[i] = intArray[i];
    }


    if(isSorted(inputArr, sizeof(inputArr)/sizeof(int))){
        printf("is Sorted\n");
    }else{
        printf("is not Sorted\n");
    }



}

int isSorted(int* array, int length){
    for(int i=0; i<length-1; i++){
        if(array[i] > array[i+1]){
            return 0;
        }
    }
    return 1;
}
