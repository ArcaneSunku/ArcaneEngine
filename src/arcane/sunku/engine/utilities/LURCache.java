package arcane.sunku.engine.utilities;

import java.util.LinkedHashMap;
import java.util.Map;

@SuppressWarnings("serial")
public class LURCache<K, V> extends LinkedHashMap<K, V> {
    private int size;

    private LURCache(int size) {
        this.size = size;
    }

    public static <K, V> LURCache<K, V> newInstance(int size) {
        return new LURCache<K, V>(size);
    }

    public void setMaxSize(int size) {
        this.size = size;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > size;
    }

}