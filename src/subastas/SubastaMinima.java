package subastas;

public class SubastaMinima  extends Subasta{

    private double dineroMinimo;
    public SubastaMinima(String nombreProducto, Usuario usuarioPropietario, double minimo) {
        super(nombreProducto, usuarioPropietario);
        this.dineroMinimo = minimo;
    }

    public double getDineroMinimo() {
        return dineroMinimo;
    }

    public void setDineroMinimo(double dineroMinimo) {
        this.dineroMinimo = dineroMinimo;
    }

    @Override
    public boolean ejecutar() {
        if (pujaMayor().getDinero() >= this.dineroMinimo) return super.ejecutar();
        return false;
    }

    public void cerrarSubasta(){
        this.abierta = false;
    }
}
