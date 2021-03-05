package src.Entidades.Aluno;

import src.Entidades.Utils.Endereco;

public class Aluno {
    private int id;
    private String nome;
    private Endereco endereco;
    private String email;
    private String senha;
    private String telefone;

    private int idExames;
    private int idFichaAnamnese;
    private int idDieta;
    private int idTreino;

    public Aluno() {};

    public Aluno (int id, String nome, Endereco endereco, String email, String senha, String telefone) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
    }

    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }

    public String getEmail() {
        return this.email;
    }

    public String getSenha() {
        return this.senha;
    }
    
    public String getTelefone() {
        return this.telefone;
    }

    public int getIdExames() {
        return this.idExames;
    }

    public int getIdFichaAnamnese() {
        return this.idFichaAnamnese;
    }

    public int getIdDieta() {
        return this.idDieta;
    }

    public int getIdTreino() {
        return this.idTreino;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    } 

    public void setIdExames(int idExames) {
        this.idExames = idExames;
    }

    public void setIdFichaAnamnese(int idFichaAnamnese) {
        this.idFichaAnamnese = idFichaAnamnese;
    }

    public void setIdDieta(int idDieta) {
        this.idDieta = idDieta;
    }

    public void setIdTreino(int idTreino) {
        this.idTreino = idTreino;
    }
}
