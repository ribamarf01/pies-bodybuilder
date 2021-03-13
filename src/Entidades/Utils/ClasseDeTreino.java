package Entidades.Utils;

public class ClasseDeTreino {
    private char classe;
    private String observacoes;
    private String metodologia;   
    private String[] exercicio;
    private String[] series;
    private String[] repeticoes;
    
    public ClasseDeTreino(){};

    public ClasseDeTreino(String[] exercicio, String metodologia, char classe, String[] series, String[] repeticoes, String observacoes) {
        this.exercicio = exercicio;
        this.metodologia = metodologia;
        this.classe = classe;
        this.series = series;
        this.repeticoes = repeticoes;
        this.observacoes = observacoes;
    }
    
    public String[] getExercicio() {
        return this.exercicio;
    }

    public String getMetodologia() {
        return this.metodologia;
    }

    public char getClasse() {
        return this.classe;
    }

    public String[] getSeries() {
        return this.series;
    }

    public String[] getRepeticoes() {
        return this.repeticoes;
    }

    public String getObservacoes() {
        return this.observacoes;
    }

    public void setExercicio(String[] exercicio) {
        this.exercicio = exercicio;
    }

    public void setMetodologia(String metodologia) {
        this.metodologia = metodologia;
    }

    public void setClasse(char classe) {
        this.classe = classe;
    }

    public void setSeries(String[] series) {
        this.series = series;
    }

    public void setRepeticoes(String[] repeticoes) {
        this.repeticoes = repeticoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
    
}
