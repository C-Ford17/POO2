package subastas;

public class Usuario {
    private final String nombre;
    private double credito;
    private Subasta subastaPropia;

    public Usuario(String nombre, double credito, Subasta subasta) {
        this.nombre = nombre;
        this.credito = credito;
        this.subastaPropia = subasta;
    }

    public Usuario(String nombre, double credito){
        this(nombre,credito,null);
    }

    public Usuario(String nombre) {
        this(nombre,0,null);
    }

    public String getNombre() {
        return nombre;
    }

    public Subasta getSubastaPropia() {
        return subastaPropia;
    }

    public void setSubastaPropia(Subasta subastaPropia) {
        this.subastaPropia = subastaPropia;
    }

    public double getCredito() {
        return credito;
    }

    public void incrementarCredito(double incremento){
        this.credito += incremento;
    }

    public void decrementarCredito(double decremento){
        this.credito -= decremento;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", credito=" + credito +
                ", subastaPropia=" + subastaPropia +
                '}';
    }
}
