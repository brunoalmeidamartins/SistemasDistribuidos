import java.rmi.Naming;
public class Filial{
  public static void main(String[] args){
    try{
      Matrix c = (Matrix) Naming.lookup("rmi://192.168.0.100/Matrix");
      System.out.println("Adicao : "+c.add(10,15));
    }catch (Exception e){
      e.printStackTrace();
    }
  }
}
