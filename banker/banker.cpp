/***********************
*author : suraj s. pawar
* algo  : Banker's algorithm 
*********************/

// CPP program  to implement Banker's Algorithm
#include <stdio.h>
int i, j;
int processes[5] = {0, 1, 2, 3, 4};
//initialize allocation matrix
int allocation[5][3] =
    {
        {0, 1, 0},
        {2, 0, 0},
        {3, 0, 2},
        {2, 1, 1},
        {0, 0, 2}};
//initialize maximum allocation matrix
int maximum[5][3] =
    {
        {0, 5, 3},
        {0, 2, 2},
        {0, 0, 2},
        {0, 2, 2},
        {0, 3, 3}};
//initialize maximum available resource
int available[3] = {4, 5, 6};

int need[5][3];
int work[3];
int safeSequence[5] = {0, 0, 0, 0, 0};
void calculateNeed(int need[][3], int maximum[][3], int allocation[][3])
{
    for (i = 0; i < 5; i++)
        for (j = 0; j < 3; j++)
            need[i][j] = maximum[i][j] - allocation[i][j];
}

//function to check whether system in safe state or not
int Banker(int processes[], int available[3], int maximum[][3], int allocation[][3])
{
    calculateNeed(need, maximum, allocation); //calculate need
    for (j = 0; j < 3; j++)
        work[j] = available[j]; //create copy of available into work

    bool finish[5] = {0, 0, 0, 0, 0};
    int count = 0;
    while (count < 5)
    {
        bool found = false;
        for (i = 0; i < 5; i++)
        {
            if (finish[i] == 0)
            {
                for (j = 0; j < 3; j++)
                {
                    if (need[i][j] > work[j]) //work is copy of available
                        break;
                }
                if (j == 3)
                {
                    for (int k = 0; k < 3; k++)
                        work[k] += allocation[i][k];
                    safeSequence[count++] = i; //add process number in safe sequence
                    finish[i] = 1;
                    found = true; //mark process done
                }
            }
        }
        if (found == false)
        {
            printf("\n -----------------------------");
            printf("\n| System is not in SAFE state |");
            printf("\n -----------------------------");
            return false;
        }
    }
    printf("\nsafe sequence is :");
    printf("\n ------------------------\n");
    for (i = 0; i < 5; i++)
    {
        printf("|<p%d>", safeSequence[i]);
    }
    printf("|\n ------------------------");

    return true;
}
int main()
{
    printf("\n----------------------------------");
    printf("\n       Bankers Algorithm          ");
    printf("\n----------------------------------\n");

    printf("\nprocesses : %d initial sequence : ", 5);
    for (i = 0; i < 5; i++)
    {
        printf("\t<p%d> ", processes[i]);
    }
    printf("\nResource Allocation  : \n");
    for (i = 0; i < 5; i++)
    {
        for (j = 0; j < 3; j++)
        {
            printf("%d\t", allocation[i][j]);
        }
        printf("\n");
    }
    printf("\nmaximum Allocation  : \n");
    for (i = 0; i < 5; i++)
    {
        for (j = 0; j < 3; j++)
        {
            printf("%d\t", maximum[i][j]);
        }
        printf("\n");
    }

    printf("\nAvailable Resource   : \n");
    for (j = 0; j < 3; j++)
    {
        printf("%d\t", available[j]);
    }
    //function call to check state of system
    Banker(processes, available, maximum, allocation);
    printf("\n");
    return 0;
}