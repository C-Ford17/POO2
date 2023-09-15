package subastas;

public class SubastaLimitada extends Subasta{
    private int pujasPermitidas;
    public SubastaLimitada(String nombreProducto, Usuario usuarioPropietario, int limitePujas) {
        super(nombreProducto, usuarioPropietario);
        this.pujasPermitidas = limitePujas;
    }

    public int getPujasPermitidas() {
        return pujasPermitidas;
    }

    @Override
    public boolean pujar(Usuario usuario, double cantidad) {
        if (this.pujasPermitidas > 0){
            this.pujasPermitidas--;
            boolean pujo = super.pujar(usuario, cantidad);
            if (this.pujasPermitidas == 0){
                ejecutar();
            }
            return pujo;
        }
        return false;
    }

    @Override
    public boolean pujar(Usuario usuario) {
        if (this.pujasPermitidas > 0){
            this.pujasPermitidas--;
            boolean pujo = super.pujar(usuario);
            if (this.pujasPermitidas == 0){
                ejecutar();
            }
            return pujo;
        }
        return false;
    }
}
