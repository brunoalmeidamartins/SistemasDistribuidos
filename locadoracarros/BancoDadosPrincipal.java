
//package locadoracarros;


public class BancoDadosPrincipal {
    private String nome;
    private int numero;
    private int filial;
    
    public BancoDadosPrincipal(String nome, int numero, int filial){
        this.nome = nome;
        this.numero = numero;
        this.filial = filial;
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

    public int getFilial() {
        return filial;
    }

    public void setFilial(int filial) {
        this.filial = filial;
    }
}
