import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;

public class MatrixServer{
  MatrixServer(){
    try{
      System.setProperty("java.rmi.server.hostname","192.168.43.209");
      LocateRegistry.createRegistry(1099);
      Matrix c = new MatrixImple();
      Naming.bind("MatrixService", (Remote) c);
    }catch (Exception e){
      e.printStackTrace();
    }
  }
  public static void main(String[] args){
    new MatrixServer();
    System.out.println("Servidor Iniciado!!");
  }
}
