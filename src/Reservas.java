public class Reservas {
    private String nome;
    private int quantPessoas;
    private int tempoChegada;

    public Reservas(String nome, int quantPessoas, int tempoChegada) {
        this.nome = nome;
        this.quantPessoas = quantPessoas;
        this.tempoChegada = tempoChegada;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantPessoas() {
        return quantPessoas;
    }

    public void setQuantPessoas(int quantPessoas) {
        this.quantPessoas = quantPessoas;
    }

    public int getTempoChegada() {
        return tempoChegada;
    }

    public void setTempoChegada(int tempoChegada) {
        this.tempoChegada = tempoChegada;
    }
}
