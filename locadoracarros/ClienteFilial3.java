import java.rmi.Naming;
import java.util.ArrayList;
import java.util.Scanner;

public class ClienteFilial3 {
    /*
    *Faz a conexao com Banco Principal
    */
    public static int conexaoBancoPrincipal(String operacao, int numero_cliente, String nome_cliente, int filial){
        int resposta = 0; //Resposta da operacao(0 para opercao sem retorno ou X para numero da filial)
        if(operacao.equals("addCliente")){
            try{
               LocadoraInterface obj = (LocadoraInterface) Naming.lookup(urlConexaoBanco(0));
               obj.addCliente(numero_cliente, nome_cliente, filial);
            }catch (Exception e){
                e.printStackTrace();
            }
            
        }else if (operacao.equals("consultaFilial")){
            try{
               LocadoraInterface obj = (LocadoraInterface) Naming.lookup(urlConexaoBanco(0));
               resposta = obj.consultaFilial(numero_cliente, nome_cliente);
            }catch (Exception e){
                e.printStackTrace();
            }
        } else if (operacao.equals("carregaDados")){
            try{
                LocadoraInterface obj = (LocadoraInterface) Naming.lookup(urlConexaoBanco(0));
                obj.carregaDados();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (operacao.equals("escreveArquivo")){
            try{
                LocadoraInterface obj = (LocadoraInterface) Naming.lookup(urlConexaoBanco(0));
                obj.escreveArquivo();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return resposta;
    }
    /*
    *Faz a conexao com Banco da Filial
    */
    public static int conexaoBancoFilial(String operacao, int filial, int numero_cliente, String nome_cliente){
        int resposta = 0; //Resposta da opercao(0 para opercao sem retorno ou X para numero cliente)
        if (filial == 1){
            try{
                LocadoraInterface obj = (LocadoraInterface) Naming.lookup(urlConexaoBanco(filial));
                if(operacao.equals("cadastrarCliente")){
                    resposta = obj.cadastrarCliente(nome_cliente); //Grava no Banco da Filial
                    conexaoBancoPrincipal("addCliente", resposta, nome_cliente, filial);//Grava no Banco Principal
                    System.out.println(" ");
                    System.out.println("Cliente Cadastrado!!");
                    System.out.println(" ");
                }else if(operacao.equals("verificaDebito")){
                    
                    if(obj.verificaDebito(numero_cliente)){ //Cliente possui debito, retorna resposta como 0
                        resposta = 0;
                    }else{ //Cliente nao possui debito, retorna resposta como -1
                        resposta = -1;
                    }
                    
          
                }else if(operacao.equals("locacaoVeiculo")){
                    
                    if(conexaoBancoFilial("verificaDebito", filial, numero_cliente, nome_cliente) == -1){ //Cliente nao possui debito
                        obj.locacaoVeiculo(numero_cliente);
                        System.out.println(" ");
                        System.out.println("Carro Alugado!!");
                        System.out.println(" ");
                        
                        resposta = 0;
                    }else{
                        System.out.println(" ");
                        System.out.println("Cliente possui Debito!");
                        System.out.println(" ");
                        resposta = 0;
                    }
                    

                }else if(operacao.equals("devolucaoVeiculo")){
                    
                    obj.devolucaoVeiculo(numero_cliente);
                    System.out.println(" ");
                    System.out.println("Carro Devolvido!"); //Nao verifica se o cliente possui carro alugado!
                    System.out.println(" ");
                    resposta = 0;
                    
                }else if(operacao.equals("imprimeListaClientes")){
                    
                    ArrayList listaClientes;
                    
                    listaClientes = obj.imprimeListaClientes(); //Imprime lista de clientes da filial
                    
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
                    
                } else if(operacao.equals("escreveArquivo")){
                    obj.escreveArquivo();
                } else if(operacao.equals("carregaDados")){
                    obj.carregaDados();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }else if (filial == 2){
            
            try{
                LocadoraInterface obj = (LocadoraInterface) Naming.lookup(urlConexaoBanco(filial));
                if(operacao.equals("cadastrarCliente")){
                    resposta = obj.cadastrarCliente(nome_cliente); //Grava no Banco da Filial
                    conexaoBancoPrincipal("addCliente", resposta, nome_cliente, filial);//Grava no Banco Principal
                }else if(operacao.equals("verificaDebito")){
                    
                    if(obj.verificaDebito(numero_cliente)){ //Cliente possui debito, retorna resposta como 0
                        resposta = 0;
                    }else{ //Cliente nao possui debito, retorna resposta como -1
                        resposta = -1;
                    }
                    
          
                }else if(operacao.equals("locacaoVeiculo")){
                    
                    if(conexaoBancoFilial("verificaDebito", filial, numero_cliente, nome_cliente) == -1){ //Cliente nao possui debito
                        obj.locacaoVeiculo(numero_cliente);
                        System.out.println(" ");
                        System.out.println("Carro Alugado!!");
                        System.out.println(" ");
                        resposta = 0;
                    }else{
                        System.out.println(" ");
                        System.out.println("Cliente possui Debito!");
                        System.out.println(" ");
                        resposta = 0;
                    }
                    

                }else if(operacao.equals("devolucaoVeiculo")){
                    
                    obj.devolucaoVeiculo(numero_cliente);
                    System.out.println(" ");
                    System.out.println("Carro Devolvido!"); //Nao verifica se o cliente possui carro alugado!
                    System.out.println(" ");
                    resposta = 0;
                    
                }else if(operacao.equals("imprimeListaClientes")){
                    
                    ArrayList listaClientes;
                    
                    listaClientes = obj.imprimeListaClientes(); //Imprime lista de clientes da filial
                    
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
                    
                }  else if(operacao.equals("escreveArquivo")){
                    obj.escreveArquivo();
                } else if(operacao.equals("carregaDados")){
                    obj.carregaDados();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            
        }else{
            
            try{
                LocadoraInterface obj = (LocadoraInterface) Naming.lookup(urlConexaoBanco(filial));
                if(operacao.equals("cadastrarCliente")){
                    resposta = obj.cadastrarCliente(nome_cliente); //Grava no Banco da Filial
                    conexaoBancoPrincipal("addCliente", resposta, nome_cliente, filial);//Grava no Banco Principal
                }else if(operacao.equals("verificaDebito")){
                    
                    if(obj.verificaDebito(numero_cliente)){ //Cliente possui debito, retorna resposta como 0
                        resposta = 0;
                    }else{ //Cliente nao possui debito, retorna resposta como -1
                        resposta = -1;
                    }
                    
          
                }else if(operacao.equals("locacaoVeiculo")){
                    
                    if(conexaoBancoFilial("verificaDebito", filial, numero_cliente, nome_cliente) == -1){ //Cliente nao possui debito
                        obj.locacaoVeiculo(numero_cliente);
                        System.out.println(" ");
                        System.out.println("Carro Alugado!!");
                        System.out.println(" ");                     
                        resposta = 0;
                    }else{
                        System.out.println("Cliente possui Debito!");
                        resposta = 0;
                    }
                    

                }else if(operacao.equals("devolucaoVeiculo")){
                    
                    obj.devolucaoVeiculo(numero_cliente);
                    System.out.println(" ");
                    System.out.println("Carro Devolvido!"); //Nao verifica se o cliente possui carro alugado!
                    System.out.println(" ");
                    resposta = 0;
                    
                }else if(operacao.equals("imprimeListaClientes")){
                    
                    ArrayList listaClientes;
                    
                    listaClientes = obj.imprimeListaClientes(); //Imprime lista de clientes da filial
                    
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
                    
                } else if(operacao.equals("escreveArquivo")){
                    obj.escreveArquivo();
                }  else if(operacao.equals("escreveArquivo")){
                    obj.escreveArquivo();
                } else if(operacao.equals("carregaDados")){
                    obj.carregaDados();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            
        }
        return resposta;
    }
    /*
    *Devolve a URL para onde o Cliente deve conectar
    */
    public static String urlConexaoBanco(int identificacao){
        String url = " ";
        if(identificacao == 0){
            url = "rmi://127.0.0.1/BancoPrincipal";
	      //url = "rmi://192.168.43.209/BancoPrincipal";
        }else if (identificacao == 1){
            url = "rmi://127.0.0.1/BancoFilial1";
              //url = "rmi://192.168.43.209/BancoFilial1";
        }else if (identificacao == 2){
            url = "rmi://127.0.0.1/BancoFilial2";
              //url = "rmi://192.168.43.209/BancoFilial2";
        }else if (identificacao == 3){
            url = "rmi://127.0.0.1/BancoFilial3";
              //url = "rmi://192.168.43.101/BancoFilial3";
        }else{
            url = "ERRO";
        }
        
        return url;
    }
    /*
    *Funcao Principal da Filial
    */
    public static void main(String[] args){
        int FILIAL = 3; //Indica a Filial {1,2,3}
        String opcao = "0";
        Scanner entrada = new Scanner(System.in);

        conexaoBancoFilial("carregaDados", FILIAL, 0, "Vazio");
        conexaoBancoPrincipal("carregaDados", 0, "VAZIO", 0);

        while(true){
            System.out.println("Opcoes: ");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Locacao Veiculo");
            System.out.println("3 - Devolucao Veiculo");
            System.out.println("4 - Imprime Lista de Clientes");
            System.out.println("5 - Sair");
            System.out.print("Digite o numero da Operacao: ");
            
            opcao = entrada.nextLine();
            
            if(opcao.equals("1")){
                
                
                System.out.print("Digite o nome Cliente: ");
                String nome = entrada.nextLine();
                conexaoBancoFilial("cadastrarCliente", FILIAL, 0, nome); //Faz o cadastro no Banco da Filial
                System.out.println(" ");
               
            }else if (opcao.equals("2")){
                
                int filial = -1;
                System.out.println(" ");
                System.out.print("Digite o nome Cliente para localiza-lo: ");
                String nome = entrada.nextLine();
                
                System.out.print("Agora digite o numero do Cliente: ");
                String num = entrada.nextLine();
                int numero = Integer.parseInt(num);
                
                filial = conexaoBancoPrincipal("consultaFilial", numero, nome, FILIAL); //Busca a filial onde o cliente esta
                conexaoBancoFilial("locacaoVeiculo", filial, numero, nome); //Faz a alocacao se o cliente nao tiver debito
                System.out.println(" ");
                
            }else if (opcao.equals("3")){
                
                int filial = -1;
                System.out.println(" ");
                System.out.print("Digite o nome Cliente para localiza-lo: ");
                String nome = entrada.nextLine();
                
                System.out.print("Agora digite o numero do Cliente: ");
                String num = entrada.nextLine();
                int numero = Integer.parseInt(num);
                
                filial = conexaoBancoPrincipal("consultaFilial", numero, nome, FILIAL); //Busca a filial onde o cliente esta
                conexaoBancoFilial("devolucaoVeiculo", filial, numero, nome); //Faz a devolucao do veiculo
                System.out.println(" ");
                
            }else if (opcao.equals("4")){
                
                conexaoBancoFilial("imprimeListaClientes", FILIAL, 0, "Vazio"); //Imprime a lista de clientes da Filial
                System.out.println(" ");
                System.out.println("Lista Impressa na Tela do Servidor da Filial "+FILIAL+"!");
                System.out.println(" ");
                
            }else if (opcao.equals("5")){
                conexaoBancoFilial("escreveArquivo", FILIAL, 0, "Vazio");
                conexaoBancoPrincipal("escreveArquivo", 0, "VAZIO", 0);
                break;
            }else{
                System.out.println(" ");
                System.out.println("Opcao Incorreta!!");
                System.out.println(" ");
            }    
        } 
    }
}
