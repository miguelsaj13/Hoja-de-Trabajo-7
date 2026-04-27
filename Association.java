/**
 * Interfaz que representa una asociación entre una clave y un valor.
 * Se usa para guardar la palabra en ingles y su traducción.
 * 
 * @param <K> tipo de la clave
 * @param <V> tipo del valor
 */
public interface Association<K, V> {

    /**
     * Obtiene la clave de la asociación.
     * 
     * @return la clave
     */
    public K getKey();

    /**
     * Obtiene el valor asociado a la clave.
     * 
     * @return el valor
     */
    public V getValue();

    /**
     * Cambia el valor asociado a la clave.
     * 
     * @param value nuevo valor a asignar
     */
    public void setValue(V value);
}