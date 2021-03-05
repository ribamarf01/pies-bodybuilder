package src.Entidades.Personal;

public class Exercicio {
    private int idExercicio;
    private String nome;
    private String membro;
    private char grupo;
    private int idAutor;

    public Exercicio() {} ;

    public Exercicio(int idExercicio, String nome, String membro, char grupo, int idAutor) {
        this.idExercicio = idExercicio;
        this.nome = nome;
        this.membro = membro;
        this.grupo = grupo;
        this.idAutor = idAutor;
    }

    public int getIdExercicio() {
        return this.idExercicio;
    }

    public String getNome() {
        return this.nome;
    }

    public String getMembro() {
        return this.membro;
    }

    public char getGrupo() {
        return this.grupo;
    }

    public int getIdAutor() {
        return this.idAutor;
    }

    public void setIdExercicio(int idExercicio) {
        this.idExercicio = idExercicio;
    } 

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMembro(String membro) {
        this.membro = membro;
    }
    
    public void setGrupo(char grupo) {
        this.grupo = grupo;
    } 

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    } 

}
