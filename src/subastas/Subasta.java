package subastas;

import java.util.LinkedList;

public class Subasta {
    protected String nombreProducto;
    protected Usuario usuarioPropietario;
    protected boolean abierta;
    protected LinkedList<Puja> listaPujas;

    public Subasta(String nombreProducto, Usuario usuarioPropietario) {
        this.nombreProducto = nombreProducto;
        this.usuarioPropietario = usuarioPropietario;
        this.abierta = true;
        this.listaPujas = new LinkedList<>();
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public Usuario getUsuarioPropietario() {
        return usuarioPropietario;
    }

    public boolean isAbierta() {
        return abierta;
    }

    public LinkedList<Puja> getListaPujas() {
        return listaPujas;
    }

    public Puja pujaMayor(){
        if (!this.listaPujas.isEmpty())return this.listaPujas.peekLast();
        return null;
    }

    public boolean pujar(Usuario usuario, double cantidad){
        if (isAbierta() && usuario.getCredito() >= cantidad && !this.usuarioPropietario.equals(usuario)) {
            if(listaPujas.isEmpty() || cantidad > pujaMayor().getDinero()){
                Puja puja = new Puja(usuario, cantidad);
                this.listaPujas.add(puja);
                return true;
            }
        }
        return false;
    }

    public boolean pujar(Usuario usuario){
        if (pujaMayor() != null) return pujar(usuario, pujaMayor().getDinero()+1);
        return pujar(usuario, 1);
    }

    public boolean ejecutar(){
        if (!listaPujas.isEmpty() && isAbierta()){
            pujaMayor().getUsuario().decrementarCredito(pujaMayor().getDinero());
            this.usuarioPropietario.incrementarCredito(pujaMayor().getDinero());
            this.abierta = false;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Subasta{" +
                "nombreProducto='" + nombreProducto + '\'' +
                ", usuarioPropietario=" + usuarioPropietario.getNombre() +
                ", abierta=" + abierta +
                ", listaPujas=" + listaPujas +
                '}';
    }
}
