import java.rmi.Naming;
public class BancoFilial3 {
    public static void main(String[] args){
        try{
            LocadoraInterface servidorBancoFilial3 = new BancoFilial3Imple();
            Naming.rebind("BancoFilial3", servidorBancoFilial3); //Oferta o servico com o nome BancoFilial3
            System.out.println("Servidor Banco Filial3 UP!!!");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
}