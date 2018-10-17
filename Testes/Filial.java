import java.rmi.Naming;
public class Filial{
  public static void main(String[] args){
    try{
      Matrix c = (Matrix) Naming.lookup("rmi://192.168.0.5/MatrixService");
      System.out.println("Adicao : "+c.add(10,15));
      System.out.println("Retorno: "+c.addCliente(1,"Bruno",1));
    }catch (Exception e){
      e.printStackTrace();
    }
  }
}
