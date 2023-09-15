package subastas;

public class SubastaTemporal extends SubastaLimitada{
    private int periodo;
    private final long horaComienzo;
    public SubastaTemporal(String nombreProducto, Usuario usuarioPropietario, int horas) {
        super(nombreProducto, usuarioPropietario, horas * 2);
        this.periodo = horas;
        this.horaComienzo = System.currentTimeMillis();
    }

    public int getPeriodo() {
        return periodo;
    }

    public long horasRestantes(){
        return this.periodo - ((System.currentTimeMillis() - this.horaComienzo)/3600000);
    }

    @Override
    public boolean pujar(Usuario usuario, double cantidad) {
        if (horasRestantes() >= 0){
            return super.pujar(usuario, cantidad);
        }
        return false;
    }

    public boolean pujar(Usuario usuario) {
        if (horasRestantes() >= 0){
            return super.pujar(usuario);
        }
        return false;
    }

    @Override
    public boolean ejecutar() {
        if (horasRestantes() == 0) return super.ejecutar();
        return false;
    }
}
