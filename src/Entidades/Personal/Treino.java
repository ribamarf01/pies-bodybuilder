package Entidades.Personal;

import java.util.ArrayList;
        
import Entidades.Utils.ClasseDeTreino;

public class Treino {
    
    private ArrayList<ClasseDeTreino> treinos;
    
    /*
    class FichaTreino { ArrayList<Treino>  }
    
    Treino {
        char classe;
        exercicio {
            int id,
            int series,
            int repeticoes
        },
        metodologia,
        observacoes
    }
    */
    
    public Treino(){};

    public Treino(ArrayList<ClasseDeTreino> treinos) {
        this.treinos = treinos;
    }
    
    public ArrayList<ClasseDeTreino> getTreino() {
        return this.treinos;
    }
    
    public void setTreino(ArrayList<ClasseDeTreino> treinos) {
        this.treinos = treinos;
    }
    
}