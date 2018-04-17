#include <iostream>
using namespace std;
int i, n, queue[10], crit = 0;
void add();
void release();
void status();
int main()
{
    int process[10];
    printf("Enter number of process: (max 10)");
    cout << endl;
    scanf("%d", &n);
    int a = 1;
    if (n > 10)
    {
        printf("invalid number");
    }
    else
    {
        for (i = 0; i < n; i++)
        {
            process[i] = a;
            a++;
        }
    }

    for (i = 0; i < 10; i++)
    {
        queue[i] = 0;
    }

    int x = 0;
    while (x == 0)
    {
        int choice;
        printf("MENU\n");
        printf("1: Request\n");
        printf("2: Release\n");
        printf("3: Exit\n");
        printf("4: Status");
        cout << endl;
        scanf("%d", &choice);
        switch (choice)
        {
        case 1:
            add();
            break;
        case 2:
            release();
            break;
        case 3:
            x = 1;
            break;
        case 4:
            status();
            break;
        default:
            printf("Invalid choice");
        }
    }
}
void add()
{
    int p;
    printf("which process you want to add");
    cout << endl;
    scanf("%d", &p);

    if (crit == 0)
    {
        crit = p;
    }
    else
    {
        for (i = 0; i < 9; i++)
        {
            if (queue[i] == 0)
            {
                queue[i] = p;
                break;
            }
        }
    }
}
void release()
{
    if (crit == 0)
    {
        printf("Critical section is already empty\n");
    }
    else
    {
        crit = 0;
        if (queue[0] != 0)
            crit = queue[0];
        for (i = 0; i < 3; i++)
        {
            queue[i] = queue[i + 1];
        }
        printf("%d is accessing crit section", crit);
        cout << endl;
    }
}
void status()
{
    if (crit == 0)
    {
        printf("Critical Section is currently FREE\n");
    }
    else
    {
        printf("Process %d is accessing critical section\n", crit);
    }
    for (i = 0; i < n; i++)
    {
        printf(" ");
        printf("%d", queue[i]);
    }
}