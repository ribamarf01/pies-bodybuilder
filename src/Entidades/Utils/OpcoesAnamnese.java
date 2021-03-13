package Entidades.Utils;

public class OpcoesAnamnese {
    
    public String getOpcao() {
        return this.opcao;
    }
    
    public void setOpcao(String opcao) {
        this.opcao = opcao;
    }

    public boolean isOpMarcada() {
        return opMarcada;
    }

    public void setOpMarcada(boolean opMarcada) {
        this.opMarcada = opMarcada;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    private String opcao;
    private boolean opMarcada;
    private String descricao;
    
}
