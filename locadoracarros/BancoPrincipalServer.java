
//package locadoracarros;

import java.rmi.Naming;
public class BancoPrincipalServer {
    public static void main(String[] args){
        try{
            LocadoraInterface servidorBancoPrincipal = new BancoPrincipalImple();
            Naming.rebind("BancoPrincipal", servidorBancoPrincipal);
            System.out.println("Servidor Banco Principal UP!!!");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
}
