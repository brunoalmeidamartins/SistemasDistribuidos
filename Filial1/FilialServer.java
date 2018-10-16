import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.util.Scanner;

public class FilialServer{
  FilialServer(){
    try{
      System.setProperty("java.rmi.server.hostname","192.168.43.209");
      LocateRegistry.createRegistry(1100);
      FilialInterface c = new FilialImple();
      Naming.bind("Filial1Service", (Remote) c);
    }catch (Exception e){
      e.printStackTrace();
    }
  }
  public static void main(String[] args){
    new FilialServer();
    System.out.println("Servidor Filial 1 Iniciado!!");
  }
}
