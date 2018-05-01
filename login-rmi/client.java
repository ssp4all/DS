import java.rmi.Naming;
import java.util.Scanner;
import java.rmi.*;
public class client {   
    public static void main(String[] args) throws Exception {
    RmiExample r = (RmiExample) Naming.lookup("rmi://localhost/auth");
    
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter ID and password : ");
    String id =sc.nextLine();
    String pass = sc.nextLine();
    int a;
    a = r.auth(id, pass);

    if (a == 1)
        System.out.println("Successful");
    else
        System.out.println("Unsuccesful");

    }
}