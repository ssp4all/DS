import java.rmi.*;
public interface RmiExample extends Remote
{
	public int auth(String a ,String b) throws RemoteException;
}