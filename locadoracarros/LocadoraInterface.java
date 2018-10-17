
//package locadoracarros;
import java.rmi.RemoteException;
import java.rmi.Remote;

public interface LocadoraInterface extends Remote{
    /*
    *Funcoes do Banco de Dados Principal
    */
  public long add(long a, long b) throws RemoteException;
  public int addCliente(int numero, String nome, int filial) throws RemoteException;
  public int consultaFilial(int numero, String nome) throws RemoteException;
  /*
  *Funcoes da Filiais
  */
  public boolean verificaDebito(int numero) throws RemoteException;
  public boolean locacaoVeiculo(int numero) throws RemoteException;
  public boolean devolucaoVeiculo(int numero) throws RemoteException;
  public int cadastrarCliente(String nome) throws RemoteException;
  public void imprimeListaClientes() throws RemoteException;
}
