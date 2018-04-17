
import java.rmi.*;
import java.rmi.server.*;
public class server
{
    public static void main(String[]arg) throws RemoteException
    {
        RmiImpl Obj=new RmiImpl();
        try
        {
            Naming.rebind("auth",Obj);
        }
        catch(Exception e){}

        System.out.println("Server Started...");
    }
}