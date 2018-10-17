
//package calculadora;
import java.rmi.Remote;
import java.rmi.RemoteException;
public interface CalculadoraInterface extends Remote {
    public int add(int a, int b) throws RemoteException;
    public int sub(int a, int b) throws RemoteException;
}
