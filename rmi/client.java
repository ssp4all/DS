import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

public class client {
    public static void main(String[] arg) throws Exception {
        // RmiExample r = (RmiExample) Naming.lookup("rmi://192.168.109.15/auth");
        RmiExample r = (RmiExample) Naming.lookup("rmi://localhost/auth");
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter ID and Password : ");
        String id = sc.nextLine();
        String pass = sc.nextLine();
        int a;
        a = r.auth(id, pass);
        if (a == 0) {
            System.out.println("Successfull ");

        } else {
            System.out.println("unsucessfull");

        }
    }
}