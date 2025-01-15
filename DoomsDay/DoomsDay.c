#include <stdio.h>
#include <stdlib.h>

//DoomsDay 알고리즘
//2월의 마지막 날을 둠스데이라고 한다.

//둠스데이 연관 날짜
//둠스데이의 요일을 알면 그 해의 날짜에 대한 요일을 간편하게 구할 수 있다.
//1월: 윤년이 아니면 24일, 윤년인 경우 25일
//2월: 둠스데이
//3월: 7일
//4월: 11일
//5월: 9일
//6월: 6일
//7월: 11일
//8월: 8일
//9월: 5일
//10월: 10일
//11월: 7일
//12월: 12일
//년도 별 둠스데이
//1년 뒤 둠스데이는 하루 뒤 요일
//윤년인 경우 둠스데이는 이틀 뒤 요일
//2000년도의 둠스데이는 화요일

enum Days {MON = 0, TUE = 1, WED = 2, THU = 3, FRI = 4, SAT = 5, SUN = 6};
int isLeapYear(int year);
void setDoomsDay();
int getDayOfWeek(int year, int month, int day);
void printDay(int d);
short yearDoomsDayArr[3000]; // 0년도 부터 2999년까지 둠스데이

int main(){
    setDoomsDay();
    while(1){
        int year, month, day;
        printf("년 입력(1~2999), exit: -1\n");
        scanf("%d", &year);
        if(year == -1){
            return 0;
        }
        printf("월 입력\n");
        scanf("%d", &month);
        printf("일 입력\n");
        scanf("%d", &day);
        int getDay = getDayOfWeek(year, month, day);
        printDay(getDay);
    }
    return 0;
}

int isLeapYear(int year){
    if( year % 4 == 0 ){
        if( year % 100 == 0 && year % 400 != 0){
            return 0;
        }
        return 1;
    }else{
        return 0;
    }
}

void setDoomsDay(){
    yearDoomsDayArr[2000] = 1; // 2000년도의 둠스데이는 화요일
    for(int i=2001; i<sizeof(yearDoomsDayArr); i++){
        if(isLeapYear(i)){
            yearDoomsDayArr[i] = (yearDoomsDayArr[i-1] + 2) % 7;
        }else{
            yearDoomsDayArr[i] = (yearDoomsDayArr[i-1] + 1) % 7;
        }
    }
    for(int i=1999; i>0; i--){
        if(isLeapYear(i+1)){
            yearDoomsDayArr[i] = (yearDoomsDayArr[i+1] + (7 - 2)) % 7;
        }else{
            yearDoomsDayArr[i] = (yearDoomsDayArr[i+1] + (7 - 1)) % 7;
        }
    }
}

int getDayOfWeek(int year, int month, int day){
    if(year < 1 | year > 2999){
        return 0;
    }
    int doomsDay = yearDoomsDayArr[year];
    int sameDay;
    switch(month){
        case 1: 
            sameDay = isLeapYear(year)? 25:24;
            break;
        case 2: 
           // sameDay = doomsDay; //sameDay는 날짜의 개념인데 doomsDay는 요일의 개념으로 사용하였었음.
            sameDay = isLeapYear(year)? 29:28;
            break;
        case 3: 
            sameDay = 7;
            break;
        case 4: 
            sameDay = 4;
            break;
        case 5:
            sameDay = 9;
            break;
        case 6:
            sameDay = 6;
            break;
        case 7:
            sameDay = 11;
            break;
        case 8: 
            sameDay = 8;
            break;
        case 9: 
            sameDay = 5;
            break;
        case 10: 
            sameDay = 10;
            break;
        case 11: 
            sameDay = 7;
            break;
        case 12: 
            sameDay = 12;
            break;
    }

    if(day > sameDay){
        int diff = (day - sameDay) % 7;
        return (doomsDay + diff) % 7;
    }else{
        int diff = (sameDay - day) % 7;
        return (doomsDay + (7-diff)) % 7;
    }
    return -1;
}


void printDay(int d){
    printf("=====\n");
    printf("dayOfWeek : ");
    switch(d){
        case MON: printf("MON\n"); break;
        case TUE: printf("TUE\n"); break;
        case WED: printf("WED\n"); break;
        case THU: printf("THU\n"); break;
        case FRI: printf("FRI\n"); break;
        case SAT: printf("SAT\n"); break;
        case SUN: printf("SUN\n"); break;
    }

    printf("=====\n");

}




