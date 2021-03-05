package src.Entidades.Aluno;

public class Exames {

    private int idExames;
    private String[] arquivos;

    public Exames (int idExames) {
        this.idExames = idExames;
    }

    public int getIdExames() {
        return this.idExames;
    }

    public String[] getArquivos() {
        return this.arquivos;
    }
/*
    private void setIdExames(int idExames) {
        this.idExames = idExames;
    }

    private void setArquivos(String[] arquivos) {
        this.arquivos = arquivos;
    } */
    
}