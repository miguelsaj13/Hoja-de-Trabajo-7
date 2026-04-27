public class ComparableAssociation<K extends Comparable<K>, V> implements Comparable<ComparableAssociation<K,V>> {
    private K key;
    private V value;

    public ComparableAssociation(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public int compareTo(ComparableAssociation<K,V> other) {
        return this.key.compareTo(other.key);
    }

    @Override
    public String toString() {
        return "(" + key + ", " + value + ")";
    }
}
