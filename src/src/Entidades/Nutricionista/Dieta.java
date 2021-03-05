package src.Entidades.Nutricionista;

public class Dieta {
    
    private String refeicao;
    private String tipo;
    private String alimento;
    private int[] quantidade;
    private String[] horario;
    private String[] observacoes;

    public Dieta(String refeicao, String tipo, String alimento, int[] quantidade, String[] horario, String[] observacoes) {
        this.refeicao = refeicao;
        this.tipo = tipo;
        this.alimento = alimento;
        this.quantidade = quantidade;
        this.horario = horario;
        this.observacoes = observacoes;
    }

    public String getRefeicao() {
        return this.refeicao;
    }

    public String getTipo() {
        return this.tipo;
    }

    public String getAlimento() {
        return this.alimento;
    }

    public int[] getQuantidade() {
        return this.quantidade;
    }

    public String[] getHorario() {
        return this.horario;
    }

    public String[] getObservacoes() {
        return this.observacoes;
    }
/*
    private void setRefeicao(String refeicao) {
        this.refeicao = refeicao;
    }

    private void setTipo(String tipo) {
        this.tipo = tipo;
    }

    private void setAlimento(String alimento) {
        this.alimento = alimento;
    }

    private void setQuantidade(int[] quantidade) {
        this.quantidade = quantidade;
    }

    private void setHorario(String[] horaria) {
        this.horario = horario;
    }

    private void setObservacoes(String[] observacoes) {
        this.observacoes = observacoes;
    } */

}
