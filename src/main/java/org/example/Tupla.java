package org.example;

public class Tupla {

    public Integer valor = 0;
    public Integer contador = 1;

//    public Tupla(Integer valor) {
//        this.valor = valor;
//    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public Integer getContador() {
        return contador;
    }

    public void setContador(Integer contador) {
        this.contador = contador;
    }

    public void incrementarContador() {
        this.contador++;
    }

    @Override
    public boolean equals(Object tupla) {
        return this.valor == ((Tupla) tupla).valor;
    }
}
