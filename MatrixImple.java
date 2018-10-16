import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MatrixImple extends UnicastRemoteObject implements Matrix{
  private static final long serialVersionUID = 1L;

  protected MatrixImple() throws RemoteException{
    super();
  }
  public long add(long a, long b) throws RemoteException{
    return a+b;
  }
}
