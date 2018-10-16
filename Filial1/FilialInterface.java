import java.rmi.RemoteException;
import java.rmi.Remote;

public interface FilialInterface extends Remote{
  public boolean verificaDebito(int numero) throws RemoteException;
  public boolean locacaoVeiculo(int numero) throws RemoteException;
  public boolean devolucaoVeiculo(int numero) throws RemoteException;
  public void addCliente(String nome) throws RemoteException;
  public void imprimeListaClientes() throws RemoteException;
  public int verifcaFilialCliente(String nome, int numero) throws RemoteException;
}
