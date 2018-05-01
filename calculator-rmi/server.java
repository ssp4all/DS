import java.rmi.*;
public class server{

    public static void main(String args[]) throws RemoteException{
        RmiImpl obj = new RmiImpl();
        try {
            Naming.rebind("add",obj);
            Naming.rebind("sub",obj);
            
        } catch (Exception e) {
            //TODO: handle exception
        }
        System.out.println("Server Started...");
    }
}