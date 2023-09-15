package subastas;

public class Puja {
    private Usuario usuario;
    private double dinero;

    public Puja(Usuario usuario, double dinero) {
        this.usuario = usuario;
        this.dinero = dinero;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public double getDinero() {
        return dinero;
    }

    @Override
    public String toString() {
        return "Puja{" +
                "usuario=" + usuario +
                ", dinero=" + dinero +
                '}';
    }
}
