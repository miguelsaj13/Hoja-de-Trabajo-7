/**
 * Clase encargada de manejar archivos de texto.
 * Permite leer un diccionario, almacenarlo en un BST
 * y traducir un archivo de texto.
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TxtManager {
    BST<ComparableAssociation<String, String>> arbol;

    /**
     * Constructor que inicializa el árbol vacío.
     */
    public TxtManager()
    {
        arbol = new BST<>();
    }

    /**
     * Lee un archivo de diccionario y guarda las palabras
     * con su traducción en el árbol binario.
     * 
     * @param filePath ruta del archivo de diccionario
     */
    public void crearDiccionario(String filePath) {
        try {
            String contenido = Files.readString(Path.of(filePath));

            String[] entradas = contenido.split("\\)");

            for (String entrada : entradas) {
                entrada = entrada.trim();

                if (entrada.isEmpty()) continue;

                entrada = entrada.replace("(", "");

                String[] partes = entrada.split(",");

                if (partes.length < 2) continue;

                String key = partes[0].trim().toLowerCase().replaceAll("[^a-z]", "");
                String value = partes[1].trim();

                if (key.isEmpty() || value.isEmpty()) continue;

                ComparableAssociation<String, String> assoc = new ComparableAssociation<>(key, value);
                arbol.insert(assoc);
            }

        } catch (IOException e) {
            System.out.println("Error leyendo archivo");
        } catch (Exception e) {
            System.out.println("Error insertando en el árbol");
        }
    }

    /**
     * Lee un archivo de texto y traduce cada palabra usando el diccionario.
     * Mantiene la puntuación original.
     * 
     * @param filePath ruta del archivo a traducir
     */
    public void traducirArchivo(String filePath)
    {
        try {
            List<String> lineas = Files.readAllLines(Path.of(filePath));

            for (String linea : lineas)
            {
                String[] palabras = linea.split(" ");

                for (String palabra : palabras)
                {
                    String limpia = palabra.toLowerCase().replaceAll("[^a-z]", "");
                    String puntuacion = palabra.replaceAll("[a-zA-Z]", "");

                    String traducida = traducirPalabra(limpia);

                    System.out.print(traducida + puntuacion + " ");
                }

                System.out.println();
            }

        } catch (IOException e) {
            System.out.println("Error leyendo archivo");
        }
    }

    /**
     * Traduce una sola palabra usando el árbol.
     * Si no existe en el diccionario, la marca con asteriscos.
     * 
     * @param clave palabra a traducir
     * @return traducción o palabra marcada si no existe
     */
    private String traducirPalabra(String clave)
    {
        clave = clave.toLowerCase();
        ComparableAssociation<String, String> palabra = new ComparableAssociation<>(clave, null);
        BinaryTree<ComparableAssociation<String, String>> nodo = arbol.search(palabra);

        if(nodo == null)
        {
            return "*" + clave + "*";
        }
        return nodo.value().getValue();
    }

    /**
     * Muestra el contenido del diccionario usando recorrido in-order.
     */
    public void mostrarDiccionario()
    {
        arbol.inOrder();
    }
}