
//package locadoracarros;


public class DadosClientes {
    private static int cont = 0;
    private String nome;
    private int numero;
    private boolean debito;

    public DadosClientes(String nome) {
        this.nome = nome;
        this.numero = ++cont;
        this.debito = false;
    }

    public static int getCont() {
        return cont;
    }

    public static void setCont(int cont) {
        DadosClientes.cont = cont;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isDebito() {
        return debito;
    }

    public void setDebito(boolean debito) {
        this.debito = debito;
    }
    
}
