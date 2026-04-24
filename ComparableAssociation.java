public class ComparableAssociation<K extends Comparable<K>, V> implements Association<K,V> {
    private K key;
    private V value;

    public ComparableAssociation(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public int compareTo(ComparableAssociation<K,V> other) {
        return this.getKey().compareTo(other.getKey());
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public void setValue(V value) {
        this.value = value;
    }
}
