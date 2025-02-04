public class Mesa {
    private int id;
    private int capacidade;
    private boolean ocupada;
    private int ultimaAcaoTempo; // Atributo para armazenar a última unidade de tempo em que uma ação foi realizada

    public Mesa(int id, int capacidade) {
        this.id = id;
        this.capacidade = capacidade;
        this.ocupada = false;
        this.ultimaAcaoTempo = -1; // Inicializa como -1 para indicar que nenhuma ação foi realizada
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public int getUltimaAcaoTempo() {
        return ultimaAcaoTempo;
    }

    public void setUltimaAcaoTempo(int ultimaAcaoTempo) {
        this.ultimaAcaoTempo = ultimaAcaoTempo;
    }

    @Override
    public String toString() {
        return "Mesa [ID=" + id +
                ", Capacidade=" + capacidade +
                ", Ocupada=" + ocupada +
                ", Última Ação Tempo=" + ultimaAcaoTempo + "]";
    }
}

