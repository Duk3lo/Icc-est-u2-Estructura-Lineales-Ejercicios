package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Maps {

    public Map<String, Integer> construirHashMap() {
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("A", 2);
        hashMap.put("B", 3);
        hashMap.put("A", 5);

        for (int i = 0; i < hashMap.size(); i++) {
            System.out.println(hashMap.values().toArray()[i]);
        }
        for (String key : hashMap.keySet()) {
            System.out.println("Llave " + key + " valor " + hashMap.get(key));
        }
        return hashMap;
    }

    public Map<String, Integer> construirLinkedHashMap() {
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("A", 2);
        linkedHashMap.put("B", 3);
        linkedHashMap.put("A", 5);
        linkedHashMap.put("C", 50);
        linkedHashMap.put("D", 5);
        linkedHashMap.put("F", 3);
        linkedHashMap.put("G", 8);
        linkedHashMap.put("H", 85);
        linkedHashMap.put("I", 5);

        System.out.println(linkedHashMap.values());
        System.out.println(linkedHashMap.keySet());

        return linkedHashMap;
    }

    public Map<String, Integer> construirTreeMap() {
        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("B", 3);
        treeMap.put("C", 50);
        treeMap.put("A", 5);
        treeMap.put("I", 5);
        treeMap.put("F", 3);
        treeMap.put("D", 5);
        treeMap.put("G", 8);
        treeMap.put("H", 85);
        treeMap.put("A", 5);

        return treeMap;
    }

    public Map<Person, Integer> construirTreeMapPersons() {
        Map<Person, Integer> treePersons = new TreeMap<>();
        treePersons.put(new Person("Carlos", 23), 1);
        treePersons.put(new Person("Ana", 30), 2);
        treePersons.put(new Person("Luis", 18), 3);
        treePersons.put(new Person("Ana", 20), 4);
        treePersons.put(new Person("Andres", 23), 5);
        treePersons.put(new Person("Ana", 18), 6);

        return treePersons;
    }

    public Map<Integer, Person> construirTreeMapEdadPerson() {
        Map<Integer, Person> treeEdadPerson = new TreeMap<>();
        treeEdadPerson.put(3, new Person("Carlos", 23));
        treeEdadPerson.put(50, new Person("Ana", 30));
        treeEdadPerson.put(5, new Person("Luis", 18));
        treeEdadPerson.put(8, new Person("Ana", 20));
        treeEdadPerson.put(8, new Person("Andres", 23));
        treeEdadPerson.put(8, new Person("Luis", 18));

        return treeEdadPerson;
    }

    public Map<Integer, Person> construirTreeMapPersonsObj(){
        List<Person> list = new ArrayList<>();
        list.add(3, new Person("Carlos", 23, 123));
        list.add(50, new Person("Ana", 30, 124));
        list.add(5, new Person("Luis", 18, 125));
        list.add(8, new Person("Ana", 20, 123));
        list.add(8, new Person("Andres", 23, 129));
        list.add(8, new Person("Luis", 18, 124));

        //OREDENE POR EDAD Y NOMBRE Y
        // NO PERMITE DUPLICADOS POR LA CEDULA
        //Map <CEDULA , PERSONA>

        Map<Integer, Person> personas = new TreeMap<>();

        //FOR al listado para ingresar todas al mapa
        //persons.put(cedula_Persona, Persona);
        for (Person persona : list) {
            personas.put(persona.getCedula(), persona);
        }
        return personas;

    }


    public void printFilter(Map<Person, Integer> treePersons) {
        for (Map.Entry<Person, Integer> entry : treePersons.entrySet()) {
            Person persona = entry.getKey();
            Integer valor = entry.getValue();

            if (valor > 200 && persona.getAge() >= 20) {
                System.out.println(persona);
            }
        }
    }

    
}