import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class MatrixImple extends UnicastRemoteObject implements Matrix{
  private static final long serialVersionUID = 1L;
  private ArrayList banco = new ArrayList();
  protected MatrixImple() throws RemoteException{
    super();
  }
  public long add(long a, long b) throws RemoteException{
    return a+b;
  }
  public int addCliente(int numero, String nome, int filial) throws RemoteException{
    //System.out.println("Chegou aqui!!");
    //System.out.print(numero+" ");
    //System.out.print(nome+" ");
    //System.out.print(filial+"\n");
    BancoMatrix cliente = new BancoMatrix(nome,numero,filial);
    banco.add(cliente);
    for(int i =0; i<banco.size();i++){
        BancoMatrix b = (BancoMatrix) banco.get(i);
        System.out.println("Nome: "+b.getNome()+" Numero: "+b.getNumero()+" Filial: "+b.getFilial());
    }
    return 0;
  }
  public int consultaFilial(int numero, String nome) throws RemoteException{
      System.out.println("Procurando ...");
      System.out.println("Numero: "+numero+" Nome: "+nome+"\n");
      int filial = 0;
      for(int i =0;i<banco.size();i++){
          BancoMatrix b = (BancoMatrix) banco.get(i);
          if (b.getNome().equals(nome) && b.getNumero() == numero){
              filial = b.getFilial();
              System.out.println("Encontrado! Filial: "+filial);
              
          }else{
             //System.out.println("Nao encontrado!"); 
          }
      }
      if (filial == 0){
          System.out.println("Nao encontrado!");
      }
      return filial;
  }
}
