
//package locadoracarros;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;


public class BancoFilial2Imple extends UnicastRemoteObject implements LocadoraInterface {
    
    private ArrayList listaClientes = new ArrayList(); //Guarda a lista de Clientes da Filial
    
    protected BancoFilial2Imple()throws RemoteException{
        super();
    }
    /*
    *Funcoes do Banco Principal
    */
    @Override
    public long add(long a, long b) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int addCliente(int numero, String nome, int filial) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int consultaFilial(int numero, String nome) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /*
    *Funcoes das Filiais
    */
    @Override
    public boolean verificaDebito(int numero) throws RemoteException { //Verifica se o cliente possui algum debito
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        boolean debito = true;
        DadosClientes c;
        for(int i =0;i<listaClientes.size();i++){
            c = (DadosClientes) listaClientes.get(i);
            if(c.getNumero() == numero){
                debito = c.isDebito();
            }
        }
        return debito;
    }

    @Override
    public boolean locacaoVeiculo(int numero) throws RemoteException { //Faz a alocacao de um veiculo
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        boolean operacao_certa = false;
        DadosClientes c;
        for(int i =0;i<listaClientes.size();i++){
            c = (DadosClientes) listaClientes.get(i);
            if(c.getNumero() == numero){
                c.setDebito(true); //Seta debito como Verdadeiro
                operacao_certa = true;
            }
        }
        return operacao_certa;
    }

    @Override
    public boolean devolucaoVeiculo(int numero) throws RemoteException { //Faz a devolucao do veiculo
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        boolean operacao_certa = false;
        DadosClientes c;
        for(int i =0;i<listaClientes.size();i++){
            c = (DadosClientes) listaClientes.get(i);
            if(c.getNumero() == numero){
                c.setDebito(false); //Seta debito como Verdadeiro
                operacao_certa = true;
            }
        }
        return operacao_certa;
    }

    @Override
    public int cadastrarCliente(String nome) throws RemoteException { //Cadastra o cliente no Banco de Dados da filial
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        DadosClientes cliente = new DadosClientes(nome);
        listaClientes.add(cliente);
        return cliente.getNumero(); //Retorna o numero do Cliente Cadastrado
    }

    @Override
    public void imprimeListaClientes() throws RemoteException { //Imprime a lista de Clientes da Filial
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println(" ");
        for(int i =0;i<listaClientes.size();i++){
            DadosClientes cliente = (DadosClientes) listaClientes.get(i);
            String debito = " ";
            //Verifica se o cliente possui debito
            if (cliente.isDebito()){
                debito = "Possui Debito";
            }else{
                debito = "Nao possui Debito";
            }
            System.out.println("Nome: "+cliente.getNome()+" Numero: "+cliente.getNumero()+" Situacao: "+debito);
        }
        System.out.println(" ");
    } 
}
