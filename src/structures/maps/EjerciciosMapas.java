package structures.maps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EjerciciosMapas {
    
    public Map<Integer, Integer> contarDuplicados (List <Integer> list) {
        Map<Integer, Integer> conteo = new HashMap<>();
        for (Integer num : list) {
            conteo.put(num, conteo.getOrDefault(num, 0) + 1);
        }
        return conteo;
    }

    public Integer primerNoRepetido(List<Integer> list) {
        Map<Integer, Integer> conteo = new HashMap<>();
        for (Integer num : list) {
            conteo.put(num, conteo.getOrDefault(num, 0) + 1);
        }
        
        for (Integer num : list) {
            if (conteo.get(num) == 1) {
                return num;
            }
        }
        return null;
    }

    public void rankingPuntajes(List<String[]> entradas) {
        Map<String, Integer> puntajes = new HashMap<>();
        
        for (String[] entrada : entradas) {
            String nombre = entrada[0];
            int puntaje = Integer.parseInt(entrada[1]);
            puntajes.put(nombre, Math.max(puntajes.getOrDefault(nombre, 0), puntaje));
        }

        puntajes.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));
    }


}