import java.rmi.*;
import java.util.*;
public class client{
    public static void main(String args[]) throws Exception
    {
        RmiExample r = (RmiExample) Naming.lookup("rmi://localhost/add");
        int ch,result=0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Enter no1 :");
            int a = sc.nextInt();
            System.out.println("Enter no2 : ");
            int b = sc.nextInt();
            System.out.println("@@@ MENU @@@");
            System.out.println("1: ADD");
            System.out.println("2: SUB");
            System.out.println("99: Exit");
            
            System.out.println("Enter choice");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    result = r.add(a, b);
                    System.out.println(result);

                    break;
                case 2:
                    result = r.sub(a, b);
                    System.out.println(result);

                    break;
                default:
                    break;
            }
            
        } while (ch != 99);

    }
}