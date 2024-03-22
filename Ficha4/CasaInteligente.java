package Ficha4;

import java.util.*;
import java.util.stream.Collectors;

public class CasaInteligente {
    private List<Lampada> lampadas;

    public CasaInteligente() {
        this.lampadas = new ArrayList<Lampada>();
    }

    public CasaInteligente(List<Lampada> lampadas) {
        this.lampadas = new ArrayList<Lampada>(lampadas);
    }

    public CasaInteligente(CasaInteligente casa) {
        this.lampadas = new ArrayList<Lampada>(casa.getLampadas());
    }

    public List<Lampada> getLampadas() {
        return this.lampadas;
    }

    public void setLampadas(List<Lampada> lampadas) {
        this.lampadas = lampadas;
    }

    public CasaInteligente clone() {
        return new CasaInteligente(this);
    }

    public String toString() {
        return "Lâmpadas da casa : " + this.lampadas.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof CasaInteligente)) return false;
        CasaInteligente casa = (CasaInteligente) obj;
        return this.lampadas.equals(casa.getLampadas());
    }

    public void addLampada(Lampada l) {
        this.lampadas.add(l);
    }

    public Set<Lampada> lampadasEmModoEco(){
        return this.lampadas
                .stream()
                .filter(lampada -> lampada.estaEmModoEco())
                .collect(Collectors.toSet());
    }

    public void reset(){
        this.lampadas
                .stream()
                .map(Lampada::resetPeriodo);
    }

    public Set<Lampada> podiumEconomia(){
        this.lampadas.sort(Lampada::compareTo);
        Set<Lampada> best3 =  this.lampadas.stream().collect(Collectors.toSet());
        return best3;
    }
}