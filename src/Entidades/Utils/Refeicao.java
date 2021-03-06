package Entidades.Utils;

public class Refeicao {

    /**
     * @return the alimento
     */
    public String[] getAlimento() {
        return alimento;
    }

    /**
     * @param alimento the alimento to set
     */
    public void setAlimento(String[] alimento) {
        this.alimento = alimento;
    }

    /**
     * @return the quantidade
     */
    public String[] getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(String[] quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the horario
     */
    public String getHorario() {
        return horario;
    }

    /**
     * @param horario the horario to set
     */
    public void setHorario(String horario) {
        this.horario = horario;
    }

    /**
     * @return the observacoes
     */
    public String getObservacoes() {
        return observacoes;
    }

    /**
     * @param observacoes the observacoes to set
     */
    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    private String nome;
    private String[] alimento;
    private String[] quantidade;
    private String horario;
    private String observacoes;
}
