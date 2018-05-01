import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
public class RmiImpl extends UnicastRemoteObject implements RmiExample {
    public RmiImpl() throws RemoteException{}

    public int auth(String a , String b) throws RemoteException
    {
        if(a.equals(b))
            return 1;
        else
            return 0;
    }
}