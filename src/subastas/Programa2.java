package subastas;

public class Programa2 {
    public static void main(String[] args) {
        Usuario usuario1 = new Usuario("Juan", 100);
        Usuario usuario2 = new Usuario("Enrique", 500);
        SubastaLimitada subastaLimitada = new SubastaLimitada("Disco duro multimedia",usuario1,1);
        SubastaTemporal subastaTemporal = new SubastaTemporal("Teclado",usuario1,3);
        SubastaMinima subastaMinima = new SubastaMinima("Impresora Laser",usuario1,100);
        System.out.println(subastaLimitada.pujar(usuario2,10) + " " + "puja limitada");
        System.out.println(subastaTemporal.pujar(usuario2,10) + " " + "puja temporal");
        System.out.println(subastaTemporal.horasRestantes());
        System.out.println(subastaMinima.pujar(usuario2,10) + " " + "puja minima");
        System.out.println(subastaLimitada.getPujasPermitidas());
        System.out.println(subastaLimitada.pujar(usuario2,20) + " " + "puja limitada");
        System.out.println(subastaTemporal.pujar(usuario2,20) + " " + "puja temporal");
        System.out.println(subastaMinima.pujar(usuario2,20) + " " + "puja minima");
        subastaTemporal.pujar(usuario2);
        if(subastaLimitada.isAbierta()) System.out.println(subastaLimitada.ejecutar() + " " + " limitada");
        else System.out.println("No se ha podido ejecutar la subasta limitada");
        if(subastaTemporal.isAbierta()) System.out.println(subastaTemporal.ejecutar() + " " + " temporal");
        else System.out.println("No se ha podido ejecutar la subasta temporal");
        if(subastaMinima.isAbierta()) System.out.println(subastaMinima.ejecutar() + " " + " minima");
        else System.out.println("No se ha podido ejecutar la subasta minima");
        System.out.println(usuario1.getCredito());
        System.out.println(usuario2.getCredito());
        System.out.println(subastaTemporal.horasRestantes());
    }
}
