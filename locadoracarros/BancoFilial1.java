import java.rmi.Naming;
public class BancoFilial1 {
    public static void main(String[] args){
        try{
            LocadoraInterface servidorBancoFilial1 = new BancoFilial1Imple();
            Naming.rebind("BancoFilial1", servidorBancoFilial1); //Oferta o servico com o nome BancoFilial1
            System.out.println("Servidor Banco Filial1 UP!!!");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
}