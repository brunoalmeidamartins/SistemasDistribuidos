import java.rmi.RemoteException;
import java.rmi.Remote;

public interface Matrix extends Remote{
  public long add(long a, long b) throws RemoteException;
  public int addCliente(int numero, String nome, int filial) throws RemoteException;
  public int consultaFilial(int numero, String nome) throws RemoteException;
}
