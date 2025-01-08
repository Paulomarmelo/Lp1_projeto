public class Mesa {

    private int id;
    private int capacide;
    private boolean ocupada;


    public Mesa(int id, int capacide, boolean ocupada) {
        this.id = id;
        this.capacide = capacide;
        this.ocupada = ocupada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacide() {
        return capacide;
    }

    public void setCapacide(int capacide) {
        this.capacide = capacide;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }
}
