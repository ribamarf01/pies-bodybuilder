package Entidades.Aluno;

import java.util.ArrayList;

import Entidades.Utils.OpcoesAnamnese;

public class FichaAnamnese {

    public ArrayList<OpcoesAnamnese> getOpcoes() {
        return opcoes;
    }

    public void setOpcoes(ArrayList<OpcoesAnamnese> opcoes) {
        this.opcoes = opcoes;
    }
    
    private ArrayList<OpcoesAnamnese> opcoes;
    
    public FichaAnamnese() {};
    
    public FichaAnamnese(ArrayList<OpcoesAnamnese> opcoes) {
        this.opcoes = opcoes;
    }

}
