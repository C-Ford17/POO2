package subastas;

public class Programa {
    public static void main(String[] args) {
        Usuario usuario1 = new Usuario("Juan",100);
        Usuario usuario2 = new Usuario("Pedro",150);
        Usuario usuario3 = new Usuario("Enrique",300);
        Subasta subasta = new Subasta("Telefono movil",usuario1);
        usuario1.setSubastaPropia(subasta);
        System.out.println(subasta.pujar(usuario2,100));
        System.out.println(subasta.pujaMayor());
        System.out.println(subasta.pujar(usuario3,50));
        System.out.println(subasta.pujaMayor());
        subasta.ejecutar();
        System.out.println(subasta.pujar(usuario3,200));
        System.out.println(usuario1.getCredito());
        System.out.println(usuario2.getCredito());
        System.out.println(usuario3.getCredito());
        System.out.println(usuario1.getSubastaPropia());
        System.out.println(usuario2.getSubastaPropia());
        System.out.println(usuario3.getSubastaPropia());
    }
}
