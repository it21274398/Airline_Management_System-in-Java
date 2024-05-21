package vishw;
public class HashTable {
    private int size;
    private Entry[] table;

    public HashTable(int size) {
        this.size = size;
        this.table = new Entry[size];
    }

    public int hashFunction(String key) {
        int hash = 0;
        for (char c : key.toCharArray()) {
            hash += (int) c;
        }
        return hash % size;
    }

    public void insert(String key, String value) {
        int index = hashFunction(key);
        int originalIndex = index;
        while (table[index] != null) {
            index = (index + 1) % size;
            if (index == originalIndex) {
                throw new RuntimeException("Hash table is full");
            }
        }
        table[index] = new Entry(key, value);
    }

    public String search(String key) {
        int index = hashFunction(key);
        int originalIndex = index;
        while (table[index] != null) {
            if (table[index].key.equals(key)) {
                return table[index].value;
            }
            index = (index + 1) % size;
            if (index == originalIndex) {
                break;
            }
        }
        return null;
    }

    public void delete(String key) {
        int index = hashFunction(key);
        int originalIndex = index;
        while (table[index] != null) {
            if (table[index].key.equals(key)) {
                table[index] = null;
                return;
            }
            index = (index + 1) % size;
            if (index == originalIndex) {
                break;
            }
        }
    }

    private static class Entry {
        String key;
        String value;

        Entry(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }
}
