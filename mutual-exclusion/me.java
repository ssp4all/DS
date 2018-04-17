// package mutual_exclusion;
import java.util.*;
public class me 
{
    public static void main(String[] args) 
    {
        int ch,n,co,i,j,cs,critical = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a no. processes :");
        n = sc.nextInt();
        critical = n;
        ArrayList process = new ArrayList();
        ArrayList wait = new ArrayList();

        System.out.println("Enter processess :");
        for( i=0;i<n;i++)
        {
            if(i == 0)
            {
                System.out.println("CRITICAL SECTION is EMPTY");
                j = sc.nextInt();
                process.add(j);
                System.out.println("process goes into CS..");
            }
            else
            {
                j = sc.nextInt();
                wait.add(j);
                System.out.println("Process goes into waiting queue");
            }
        }
//        System.out.println("Enter process co-ordinator number :");
//        co = sc.nextInt();
        do
        {
            System.out.println("");
            System.out.println("**** MENU ****");
            System.out.println("1.ADD");
            System.out.println("2.REMOVE");
            System.out.println("3.VIEW SYSTEM STATUS");
            System.out.println("99.Exit");
            System.out.println("Enter your choice :");
            ch = sc.nextInt();
            
            int p;
                        
            switch(ch)
            {
                case 1:
                    {
                        System.out.println("ADD process");
                        p = sc.nextInt();
                        if(critical == n)
                        {
                            System.out.println("wait ..");
                            wait.add(p);
                            System.out.println("Added to waiting queue");
                        }
                        else
                        {
                            process.add(p);
                            System.out.println("Process added...");
                            critical++;
                        }
                        break;
                    }
                case 2:
                    {
                        if(critical == 0)
                        {
                            System.out.println("critical section is Empty");
                            //wait.add(p);
                        }
                        else
                        {
                            System.out.println("REMOVE");
                            process.remove(0);
                            System.out.println("resource released ...");
                            critical--;
                        }
                            
                        break;

                    }
                case 3:
                    {
                        System.out.println("System status");
                        Iterator it = process.iterator();
                        while(it.hasNext())
                        {
                            System.out.print(it.next()+"\t");
                        }
                        break;
                    }
                
                case 99:
                    {
                        System.out.println("Thank you.....");
                        break;
                    }
                default:
                    {
                        System.out.println("Invalid Input");
                        break;
                    }
                
            }
            
        }while(ch != 99 );
    }
}