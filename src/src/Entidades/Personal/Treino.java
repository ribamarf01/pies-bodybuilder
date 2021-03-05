package src.Entidades.Personal;

public class Treino {
    private String[] exercicio;
    private String[] metodologia;
    private char[] classe;
    private int[] series;
    private int[] repeticoes;
    private String[] observacoes;

    public Treino(String[] exercicio, String[] metodologia, char[] classe, int[] series, int[] repeticoes, String[] observacoes) {
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

    public String[] getMetodologia() {
        return this.metodologia;
    }

    public char[] getClasse() {
        return this.classe;
    }

    public int[] getSeries() {
        return this.series;
    }

    public int[] getRepeticoes() {
        return this.repeticoes;
    }

    public String[] getObservacoes() {
        return this.observacoes;
    }
/*
    private void setExercicio(String[] exercicio) {
        this.exercicio = exercicio;
    }

    private void setMetodologia(String[] metodologia) {
        this.metodologia = metodologia;
    }

    private void setClasse(char[] classe) {
        this.classe = classe;
    }

    private void setSeries(int[] series) {
        this.series = series;
    }

    private void setRepeticoes(int[] repeticoes) {
        this.repeticoes = repeticoes;
    }

    private void setObservacoes(String[] observacoes) {
        this.observacoes = observacoes;
    } */

}