package models;


public class Node<T> {

    private T value;
    private int edad;

    public Node (T value, int edad){
        this.value = value;
        this.edad = edad;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        return result;
    }

      public T getValue(){
        return value;
    }


    public int getEdad(){
        return edad;
    }


}
