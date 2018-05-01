import java.rmi.*;
public interface RmiExample extends Remote 
{
    public int add(int a,int b) throws RemoteException;

    public int sub(int a, int b) throws RemoteException;

}