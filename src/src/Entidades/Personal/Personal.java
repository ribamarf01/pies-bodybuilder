package src.Entidades.Personal;

import src.Entidades.Utils.Endereco;

public class Personal {
    private int cref;
    private String nome;
    private Endereco endereco;
    private String email;
    private String senha;
    private String telefone;
    
    public Personal () {};
    
    public Personal (int cref, String nome, Endereco endereco, String email, String senha, String telefone) {
        this.cref = cref;
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
    }

    public int getCref() {
        return this.cref;
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

    public void setCref(int cref) {
        this.cref = cref;
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
}
