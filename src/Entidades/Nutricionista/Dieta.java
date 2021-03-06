package Entidades.Nutricionista;

import java.util.ArrayList;
import Entidades.Utils.Refeicao;

public class Dieta {
    
    private Refeicao[] refeicoes; 
    
    public Dieta(){};
    
    public Refeicao[] getRefeicoes() {
        return this.refeicoes;
    }
    
    public void setRefeicoes(Refeicao[] r) {
        this.refeicoes = r;
    }

}
