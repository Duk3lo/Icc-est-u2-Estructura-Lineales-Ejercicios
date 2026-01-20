package models;

import java.util.List;

public class Maquina implements Comparable<Maquina> {
    private String nombre;
    private String ip;
    private List<Integer> codigos;
    private int subred;
    private int riesgo;

    public Maquina(String nombre, String ip, List<Integer> codigos) {
        this.nombre = nombre;
        this.ip = ip;
        this.codigos = codigos;
        this.subred = calcularSubRed();
    }

    private int calcularSubRed() {
        String[] octetos = ip.split("\\.");
        String subred = octetos[2];
        return Integer.parseInt(subred);
    }

    //private int calcularRiesgo() {return 0;}

    public String getNombre() {
        return nombre;
    }

    public String getIp() {
        return ip;
    }

    public List<Integer> getCodigos() {
        return codigos;
    }

    public int getSubred() {
        return subred;
    }

    public void setSubred(int subred) {
        this.subred = subred;
    }

    public int getRiesgo() {
        return riesgo;
    }

    public void setRiesgo(int riesgo) {
        this.riesgo = riesgo;
    }

    @Override
    public int compareTo(Maquina o) {
        if (this.subred != o.subred) {
            return Integer.compare(this.subred, o.subred);
        }
        return this.nombre.compareTo(o.nombre);
    }
}