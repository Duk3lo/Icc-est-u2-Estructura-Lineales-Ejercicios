package structures.sets;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import models.Person;

public class Sets {

    public Set<String> cosntruirHashSet() {
        Set<String> hashSet = new HashSet<>();
        hashSet.add("A");
        hashSet.add("B");
        hashSet.add("C");
        hashSet.add("A"); // duplicado
        hashSet.add("D");
        hashSet.add("E");
        hashSet.add("F");
        hashSet.add("aghagdsgdhagdh");
        return hashSet;
    }

    public Set<String> cosntruirLinkedHashSet() {
        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("A");
        linkedHashSet.add("B");
        linkedHashSet.add("C");
        linkedHashSet.add("A"); // duplicado
        linkedHashSet.add("D");
        linkedHashSet.add("wefbdakjghask");
        linkedHashSet.add("sabasbvosvbbdosbi");
        linkedHashSet.add("chkvvuwvewvr");
        linkedHashSet.add("fuivbewbuiv");
        linkedHashSet.add("iowehieve");
        return linkedHashSet;
    }

    public Set<String> cosntruirTreeSet() {
        Set<String> treeSet = new TreeSet<>();
        treeSet.add("D");
        treeSet.add("A");
        treeSet.add("E");
        treeSet.add("I");
        treeSet.add("O");
        treeSet.add("B");
        treeSet.add("a"); // mayúsculas y minúsculas
        return treeSet;
    }

    // 🔹 ESTE ES EL QUE USA App
    public Set<String> cosntruirTreeSetConComparador() {
        Set<String> treeSet = new TreeSet<>(
            (p1, p2) -> p1.compareToIgnoreCase(p2)
        );
        treeSet.add("D");
        treeSet.add("A");
        treeSet.add("E");
        treeSet.add("I");
        treeSet.add("O");
        treeSet.add("B");
        treeSet.add("a");
        return treeSet;
    }

    // 🔹 ESTE ES EL QUE USA App
    public Set<Person> construirTreeSetPersonasConComparador() {
        Set<Person> treePersons = new TreeSet<>(
            (p1, p2) -> {
                int cmpNombre = p2.getName().compareToIgnoreCase(p1.getName());
                if (cmpNombre != 0) return cmpNombre;
                return Integer.compare(p2.getAge(), p1.getAge());
            }
        );

        treePersons.add(new Person("Carlos", 23));
        treePersons.add(new Person("Ana", 30));
        treePersons.add(new Person("Luis", 18));
        treePersons.add(new Person("Ana", 20));
        treePersons.add(new Person("Andres", 23));
        treePersons.add(new Person("Luis", 18)); // duplicado lógico

        return treePersons;
    }
}
