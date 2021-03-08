package Entidades.Nutricionista;

import java.util.ArrayList;
import Entidades.Utils.Refeicao;

public class Dieta {
    
    private ArrayList<Refeicao> refeicoes; 
    
    public Dieta(){};
    
    public ArrayList<Refeicao> getRefeicoes() {
        return this.refeicoes;
    }
    
    public void setRefeicoes(ArrayList<Refeicao> r) {
        this.refeicoes = r;
    }

}
