import java.rmi.*;
public class server
{
    public static void main(String[] args) throws Exception{
        RmiImpl obj = new RmiImpl();
        try {
            Naming.rebind("auth",obj);
        } catch (Exception e) {
            //TODO: handle exception
        }
        
        System.out.println("Server Started");
    }
}