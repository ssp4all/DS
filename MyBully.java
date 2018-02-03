/***********************
*author : suraj s. pawar
* algo  : Bully's algorithm 
*********************/

package bully;
import java.util.*;
public class MyBully {

    public static void main(String[] args) {
        
        ArrayList priority = new ArrayList();
        ArrayList status = new ArrayList();
        
//        System.out.print("Enter number of processes : ");
//        int n = sc.nextInt();
        Scanner sc = new Scanner(System.in);
        
        int ch=0;
        do
        {
            System.out.println("### MENU ###");
            System.out.println("1.Add new priority and status of a process ");
            System.out.println("2.Select a process to send a msg");
            System.out.println("3.System Status");
            
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
                    System.out.println("Election started by "+p+"... ");
                    
                    int down = status.indexOf(0);//to find down process
//                    System.out.println(down);
                    int val = (int)priority.get(down);
                    
                    Iterator it = priority.iterator();
                    int m=0;
                    int co=0;
                    co = down;
                    while(m < (int)priority.size())
                    {
                        if( val < (int)priority.get(m))
                        {
//                            if((int)status.get((int)priority.indexOf(m)-1) == 1)
//                            {
                                co = (int)priority.get(m);
                                break;
//                            }
                            
                        }
                        m++;
                    }    
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
                case 99:
                {
                    System.out.println("Thank you");
                    break;
                }
                default:
                    System.out.println("Invalid Input :(");
            }
        }while(ch != 99);
        
        
        

        
        
        
        
    }
    
}