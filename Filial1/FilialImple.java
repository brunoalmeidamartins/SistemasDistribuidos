import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;



import java.rmi.Naming;

public class FilialImple extends UnicastRemoteObject implements FilialInterface{
  private static final long serialVersionUID = 1L;
  private ArrayList banco = new ArrayList();
  
  private ArrayList listaClientes = new ArrayList();
  
  protected FilialImple() throws RemoteException{
    super();
  }
  public boolean verificaDebito(int numero) throws RemoteException{
      boolean debito = true;
      Cliente c;
      for(int i =0;i<listaClientes.size();i++){
          c = (Cliente) listaClientes.get(i);
          if(c.getNumero() == numero){
              debito = c.isDebito();
          }
      }
      return debito;
  }
  public boolean locacaoVeiculo(int numero) throws RemoteException{
      boolean operacao_certa = false;
      Cliente c;
      for(int i =0;i<listaClientes.size();i++){
          c = (Cliente) listaClientes.get(i);
          if(c.getNumero() == numero){
              c.setDebito(true);
              operacao_certa = true;
          }
      }
      return operacao_certa;
  }
  public boolean devolucaoVeiculo(int numero) throws RemoteException{
      boolean operacao_certa = false;
      Cliente c;
      for(int i =0;i<listaClientes.size();i++){
          c = (Cliente) listaClientes.get(i);
          if(c.getNumero() == numero){
              c.setDebito(false);
              operacao_certa = true;
          }
      }
      return operacao_certa;
  }
  public void addCliente(String nome) throws RemoteException{
      Cliente cliente = new Cliente(nome);
      listaClientes.add(cliente);
      //Imprime Lista de Clientes
      Cliente c1 = (Cliente) listaClientes.get(listaClientes.size()-1);
      try{
          Matrix c = (Matrix) Naming.lookup("rmi://192.168.43.209/MatrixService");
          c.addCliente(c1.getNumero(),nome,1);
      }catch (Exception e){
          e.printStackTrace();
      }
      imprimeListaClientes();
      System.out.println("---------------------");
  }
  public void imprimeListaClientes() throws RemoteException{
      for(int i =0;i<listaClientes.size();i++){
          Cliente cliente = (Cliente)listaClientes.get(i);
          System.out.println("Nome: "+cliente.getNome()+" Numero: "+cliente.getNumero());
      }
  }
  public int verifcaFilialCliente(String nome, int numero) throws RemoteException{
      int num_filial = 0;
      try{
          Matrix c = (Matrix) Naming.lookup("rmi://192.168.43.209/MatrixService");
          num_filial = c.consultaFilial(numero,nome);
      }catch (Exception e){
          e.printStackTrace();
      }
      return num_filial;
  }
}
