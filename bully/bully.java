/***********************
*author : suraj s. pawar
* algo  : Bully's algorithm 
*********************/

import static java.lang.Math.abs;
import java.util.*;
public class bully {

    public static void main(String[] args) {
        
        ArrayList priority = new ArrayList();
        ArrayList status = new ArrayList();

        Scanner sc = new Scanner(System.in);
        
        int ch=0;
        do
        {
            System.out.println("### MENU ###");
            System.out.println("1.Add new priority and status of a process ");
            System.out.println("2.Start Election");
            System.out.println("3.System Status");
            System.out.println("4.Turn a process down");
            System.out.println("5.Turn a process up");
            
            System.out.println("99.Exit");
            
            System.out.print("\nEnter your choice :");
            ch = sc.nextInt();
            
            switch(ch)
            {
                case 1:
                {
                    System.out.print("Enter priority and status(1=up and 0=down) :");
                    int p = sc.nextInt();
                    priority.add(p);
                    int s = sc.nextInt();
                    status.add(s);
                    break;
                }
                case 2:
                {
                    //becoz main coordinator is down we need new coordinator so start new election
                    System.out.print("Please select a process to start election :");
                    int p = sc.nextInt();
                    System.out.println("Election started by process "+p+"...");

                    int down = status.indexOf(0);//to find down process index
                    int val = (int)priority.get(down);//get priority of down process 
                    int len = (int)priority.size();//current length of arraylist ie., after election staretd
                    int m=0,n=0,count=0;
                    int co=down,temp=0;

                    while(m < len)
                    {
                        if( val < (int)priority.get(m))
                        {
                            if((int)status.get(m) == 1)
                            {
                                temp = (int)priority.get(m);
                            }
                        }
                        if(temp>co)
                            co=temp;
                        m++;
                    }    
                    //msg transfer
                    while(p<co)
                    {
                        while(count < abs(p-co))
                        {
                            if((int)status.get(p-1) == 1)
                                System.out.println("Election msg send from "+p+" to "+(p+count+1));
                            count++;    
                        }
                        count=0;
                        p++;
                    }
                    //print new co-ordinator
                    System.out.println("New Co-ordinator is :"+(co));
                    break;
                }
                case 3:
                {
                    Iterator itr1 = priority.iterator(); // iterator for process
                    Iterator itr2 = status.iterator();  //  iterator for status

                    int a = 1;
                    while(itr1.hasNext() && itr2.hasNext())
                    {
                        System.out.println("Process "+ a +" has priority ans status : "+itr1.next()+"   "+itr2.next() );
                        a++;
                    }
                    int down = status.indexOf(0);//to find down process
                    System.out.println("Process "+(down+1)+" is down");//print down process
                    break;
                }
                case 4:
                {
                    System.out.print("Enter a process to turn down :");
                    int d = sc.nextInt();
                    status.set(d-1, 0);
                    break;
                }
                case 5:
                {
                    System.out.print("Enter a process to turn up :");
                    int u = sc.nextInt();
                    status.set(u-1, 1);
                    break;
                }
                case 99:
                {
                    System.out.println("Thank you");
                    break;
                }
                default:
                    System.out.println("Invalid Input :(");
            }
        }while(ch != 99);
        sc.close();
    }
}