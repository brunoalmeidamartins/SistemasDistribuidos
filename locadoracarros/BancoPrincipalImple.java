
//package locadoracarros;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import java.io.*;


public class BancoPrincipalImple extends UnicastRemoteObject implements LocadoraInterface {
    private static final long serialVersionUID = 1L;
    private ArrayList banco = new ArrayList();
    
    protected BancoPrincipalImple()throws RemoteException{
        super();
    }
    /*
    *Funcoes do Banco Principal
    */
    @Override
    public long add(long a, long b) throws RemoteException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return a+b;
    }

    @Override
    public int addCliente(int numero, String nome, int filial) throws RemoteException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        BancoDadosPrincipal cliente = new BancoDadosPrincipal(nome, numero, filial); //Cria um objeto cliente para adicionar na lista
        banco.add(cliente); //Adiciona o cliente no lista "Banco"
        System.out.println(" ");
        System.out.println("Lista de Clientes Cadastrado em todas as Filiais:");
        for(int i =0;i<banco.size();i++){
            BancoDadosPrincipal b = (BancoDadosPrincipal) banco.get(i);
            System.out.println("Nome: "+b.getNome()+" Numero: "+b.getNumero()+" Filial: "+b.getFilial());
        }
        System.out.println(" ");
        return 0;
    }

    @Override
    public int consultaFilial(int numero, String nome) throws RemoteException { //Procura na lista "Banco" onde o cliente esta. Devolve a filial.
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println(" ");
        System.out.println("Procurando ...");
        System.out.println("Numero: "+numero+" Nome: "+nome+"\n");
        int filial = 0;
        for(int i =0;i<banco.size();i++){
            BancoDadosPrincipal b = (BancoDadosPrincipal) banco.get(i);
            if (b.getNome().equals(nome) && b.getNumero() == numero){
                filial = b.getFilial();
                System.out.println("Encontrado! Filial: "+filial);

            }else{
               //System.out.println("Nao encontrado!"); 
            }
        }
        if (filial == 0){
            System.out.println("Nao encontrado!");
        }
        System.out.println(" ");
        return filial;
    }
    
    /*
    *Operacoes Filiais
    */
    @Override
    public boolean verificaDebito(int numero) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean locacaoVeiculo(int numero) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean devolucaoVeiculo(int numero) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int cadastrarCliente(String nome) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void imprimeListaClientes() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void escreveArquivo() throws RemoteException {
        String filepath = "./banco_principal.txt";
        int i = 0;

        try {
            FileWriter f0 = new FileWriter(filepath);
            String newLine = System.getProperty("line.separator");

            for (i = 0; i < banco.size(); i++){
                BancoDadosPrincipal c = (BancoDadosPrincipal) banco.get(i);
                String escreverCliente = (String) c.getNome() + " " + Integer.toString(c.getNumero()) + " " + Integer.toString(c.getFilial());
                System.out.println(escreverCliente); 
                
                f0.write(escreverCliente);
                f0.write(newLine);
            }
            
            f0.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void carregaClienteBancoPrinciapal(String nome, int numero, int filial) throws RemoteException{
        BancoDadosPrincipal c = new BancoDadosPrincipal(nome, numero, filial);
        banco.add(c);
    }
    
    @Override
     public void carregaCliente(String nome, int numero, Boolean debito, int cont) throws RemoteException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     }

    @Override
    public void carregaDados() throws RemoteException{
        banco = new ArrayList();
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader("./banco_principal.txt"));
            String line = reader.readLine();
            while (line != null) {
                String[] tokens = line.split(" ");

                String nome = tokens[0];
                int numero = Integer.parseInt(tokens[1]);
                int filial = Integer.parseInt(tokens[2]);
                
                carregaClienteBancoPrinciapal(nome, numero, filial);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
