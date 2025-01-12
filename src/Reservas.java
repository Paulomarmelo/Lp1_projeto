public class Reservas   {
    private String nomeReserva;
    private int numPessoas;
    private int ChegadaUT;

    public Reservas(String nomeReserva, int numPessoas, int ChegadaUT) {
        this.nomeReserva = nomeReserva;
        this.numPessoas = numPessoas;
        this.ChegadaUT = ChegadaUT;
    }

    public String getNomeReserva() {
        return nomeReserva;
    }

    public void setNomeReserva(String nomeReserva) {
        this.nomeReserva = nomeReserva;
    }

    public int getNumPessoas() {
        return numPessoas;
    }

    public void setNumPessoas(int numPessoas) {
        this.numPessoas = numPessoas;
    }

    public int getChegadaUT() {
        return ChegadaUT;
    }

    public void setChegadaUT(int chegadaUT) {
        this.ChegadaUT = chegadaUT;
    }


}
