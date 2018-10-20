
//package locadoracarros;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import java.io.*;

public class BancoFilial3Imple extends UnicastRemoteObject implements LocadoraInterface {
    
    private ArrayList listaClientes = new ArrayList(); //Guarda a lista de Clientes da Filial
    
    protected BancoFilial3Imple()throws RemoteException{
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

    @Override
     public void escreveArquivo() throws RemoteException{
        int i = 0;

        try {
            FileWriter f0 = new FileWriter("./banco_filial3.txt");
            String newLine = System.getProperty("line.separator");

            for (i = 0; i < listaClientes.size(); i++){
                DadosClientes c = (DadosClientes) listaClientes.get(i);
                String escreverCliente = Integer.toString(c.getCont()) + " " + (String) c.getNome() + " " + Integer.toString(c.getNumero()) + " " + Boolean.toString(c.isDebito());
                System.out.println(escreverCliente); 
                
                // byte b1[]=escreverCliente.getBytes();
                f0.write(escreverCliente);
                f0.write(newLine);
            }
            
            f0.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
     }

    @Override
     public void carregaCliente(String nome, int numero, Boolean debito, int cont) throws RemoteException{
        DadosClientes c = new DadosClientes(nome, numero, debito, cont);
        listaClientes.add(c);
     }

    @Override
     public void carregaDados() throws RemoteException{
        listaClientes = new ArrayList();
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader("./banco_filial3.txt"));
            String line = reader.readLine();
            while (line != null) {
                String[] tokens = line.split(" ");

                int cont = Integer.parseInt(tokens[0]);
                String nome = tokens[1];
                int numero = Integer.parseInt(tokens[2]);
                Boolean debito;

                if (tokens[3].equals("true")){
                    debito = true;
                } else {
                    debito = false;
                }
                
                carregaCliente(nome, numero, debito, cont);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
     }

     @Override
     public void carregaClienteBancoPrinciapal(String nome, int numero, int filial) throws RemoteException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     }
}
