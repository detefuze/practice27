package ru.mirea.kabo0222.hashtab;
import java.util.*;
public class HashTab {
    // инициализация hashtable
    private Map<Integer, Node> table;
    private int size;
    private int key;
    private Node current;

    // инициализация map
    public void hashtabInit()
    {

        table = new HashMap<>();
    }
    @Override
    public int hashCode() {
        return current.value.charAt(0);
    }

    // метод добавления элемента
    public void hashtabAdd(int k, Node obj)
    {
        key = k;
        Node a = new Node(obj.value);
        if (size == 0) table.put(key, a);
        else
        {
            for (int id : table.keySet())
            {
                // если вообще не индентичны
                if (id != key || table.get(key).hashCode() != a.hashCode()) table.put(key, a);
                // если не индентичны только по value
                else if (id == key && table.get(key).hashCode() == a.hashCode())
                {
                    while (table.containsKey(key)) key++;
                    table.put(key, a);
                }
                // если полностью индентичны
                else
                {
                    if (table.get(key).next == null) table.get(key).next = a;
                }
            }
        }
        size++;
    }

    public void hashtabLookup()
    {
        for (int id : table.keySet())
        {
            if (table.get(id).next == null) System.out.println(table.get(id) + " : " + table.get(id).toString());
            else
            {
                while (table.get(id).next != null)
                {
                    System.out.println(table.get(id) + " : " + table.get(id).toString());
                    table.get(id).next = table.get(id).next.next;
                }
                System.out.println(table.get(id) + " : " + table.get(id).toString());
            }
        }
    }
    public static void main(String[] args) {
        HashTab table = new HashTab();
        table.hashtabInit();
        Node s1 = new Node("Alice");
        Node s2 = new Node("Veronika");
        Node s3 = new Node("Dan");
        Node s4 = new Node("Pole");
        Node s5 = new Node("Ken");
        table.hashtabAdd(123, s1);
        table.hashtabAdd(121, s2);
        table.hashtabAdd(1, s3);
        table.hashtabAdd(12, s4);
        table.hashtabAdd(13, s5);
        table.hashtabLookup();
    }
}
