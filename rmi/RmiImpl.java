import java.rmi.*;
import java.rmi.server.*;
public class RmiImpl extends UnicastRemoteObject implements RmiExample
{
	public RmiImpl() throws RemoteException
	{}
	public int auth(String a,String b) throws RemoteException
	{
        if(a.equals(b))
            return 0;
        else
            return 1;
	}

}