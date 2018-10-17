import java.rmi.Naming;
public class BancoFilial2 {
    public static void main(String[] args){
        try{
            LocadoraInterface servidorBancoFilial2 = new BancoFilial2Imple();
            Naming.rebind("BancoFilial2", servidorBancoFilial2); //Oferta o servico com o nome BancoFilial2
            System.out.println("Servidor Banco Filial2 UP!!!");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
}