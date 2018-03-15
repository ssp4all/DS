//C program  to implement Banker's Algorithm
#include<stdio.h>
int i, j;
int processes[5]={0,1,2,3,4};
//initialize allocation matrix
int allocation[5][3] =
                    {
                        {0,1,0},
                        {2,0,0},
                        {3,0,2},
                        {2,1,1},
                        {0,0,2}
                    };
//initialize max allocation matrix
int max[5][3] =
            {
                {7,5,3},
                {3,2,2},
                {9,0,2},
                {2,2,2},
                {4,3,3}
            };
//initialize max available resource
int available[3] ={3,3,2};

int need[5][3];
int work[5][3];
int safeSequence[5];
void calculateNeed(int need[][5],int max[][5],int allocation[][5])
{
    for(i=0;i<5;i++)
        for(j=0;j<3;j++)
            need[i][j] = max[i][j] - allocation[i][j];
}

//function to check whether system in safe state or not
void Banker(int processes[],int available[][5],int max[][5],int allocation[][5] )
{

    calculateNeed(need,max,allocation);//calculate need

    for(i=0;i<5;i++)
        for(j=0;j<3;j++)
            work[i][j] = available[i][j];

    int finish[5] = {0};
    int count=0;
    while(count<5)
    {
        boolean found = false;

        for(i=0 i<5 i++)
        {
            if(finish[i] == 0)
            {
                for(j=0;j<3;j++)
                {
                    if(need[i][j] > work[i][j])
                        break;
                }
                if( j == 3)
                {
                    for (int k = 0 ; k < 3 ; k++)
                        work[k] += allot[i][k];

                    safeSequence[count++]=i;
                    found = true;
                }

            }
        }
    }
    if(found == false)
        printf("\n System is not in SAFE state");

}

int main()
{
    printf("\n----------------------------------");
    printf("\n       Bankers Algorithm          ");
    printf("\n----------------------------------\n");

    printf("\n processes : %d",5);
    for(i=0;i<5;i++)
    {
        printf("\np%d",processes[i]);
    }
    printf("\n Resource Allocation  : \n");
    for(i=0;i<5;i++)
    {
        for(j=0;j<3;j++)
        {
            printf("%d\t",allocation[i][j]);
        }
        printf("\n");
    }
    printf("\n Maximum Allocation  : \n");
    for(i=0;i<5;i++)
    {
        for(j=0;j<3;j++)
        {
            printf("%d\t",max[i][j]);
        }
        printf("\n");
    }

    printf("\n Available Resource   : \n");
    for(j=0;j<3;j++)
    {
        printf("%d\t",available[j]);
    }

    //function call to check state of system
    Banker(processes,available,max,allocation);
    return 0;
}
