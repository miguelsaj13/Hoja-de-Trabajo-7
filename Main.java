/**
 * 
 * crea el diccionario, lo muestra y traduce un archivo de texto.
 */
public class Main {

    /**
     * Método principal que inicia la ejecución del programa.
     * 
     * @param args argumentos de la línea de comandos (no se utilizan)
     */
    public static void main(String[] args) {
        TxtManager controladorArchivos = new TxtManager();
        System.out.println("Hoja de trabajo 7 - Miguel Sajquín (252149)");
        System.out.println("Árboles binarios de búsqueda");
        System.out.println("");
        System.out.println("");
        controladorArchivos.crearDiccionario("diccionario.txt");
        System.out.println("Mostrando el diccionario (árbol binario) In-order:");
        controladorArchivos.mostrarDiccionario();
        System.out.println("Traduciendo el texto.txt:");
        System.out.println("");
        controladorArchivos.traducirArchivo("texto.txt");
        System.out.println("");
    }
}