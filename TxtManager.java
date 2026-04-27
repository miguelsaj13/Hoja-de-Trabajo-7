//leer el .txt, hacer metodo para guardar las palabras con su traduccion en el arbol con comparableassociation
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TxtManager {
    BST<ComparableAssociation<String, String>> arbol;

    public TxtManager()
    {
        arbol = new BST<>();
    }
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
    public void mostrarDiccionario()
    {
        arbol.inOrder();
    }
}