/**
 * Clase que representa una asociación entre una clave y un valor.
 * La clave es comparable para poder ordenar los objetos en estructuras como BST.
 * 
 * @param <K> tipo de la clave
 * @param <V> tipo del valor
 */
public class ComparableAssociation<K extends Comparable<K>, V> implements Comparable<ComparableAssociation<K,V>> {
    private K key;
    private V value;

    /**
     * Constructor que crea una asociación con clave y valor.
     * 
     * @param key clave de la asociación
     * @param value valor asociado a la clave
     */
    public ComparableAssociation(K key, V value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Obtiene la clave de la asociación.
     * 
     * @return la clave
     */
    public K getKey() {
        return key;
    }

    /**
     * Obtiene el valor de la asociación.
     * 
     * @return el valor
     */
    public V getValue() {
        return value;
    }

    /**
     * Cambia el valor asociado a la clave.
     * 
     * @param value nuevo valor
     */
    public void setValue(V value) {
        this.value = value;
    }

    /**
     * Compara esta asociación con otra usando la clave.
     * 
     * @param other otra asociación a comparar
     * @return negativo si es menor, positivo si es mayor, 0 si son iguales
     */
    @Override
    public int compareTo(ComparableAssociation<K,V> other) {
        return this.key.compareTo(other.key);
    }

    /**
     * Devuelve una representación en texto de la asociación.
     * 
     * @return string con formato (key, value)
     */
    @Override
    public String toString() {
        return "(" + key + ", " + value + ")";
    }
}