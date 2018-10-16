import java.rmi.RemoteException;
import java.rmi.Remote;

public interface Matrix extends Remote{
  public long add(long a, long b) throws RemoteException;
}
