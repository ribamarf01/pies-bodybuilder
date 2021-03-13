package Entidades.Nutricionista;

public class Alimento {
    private String categoria;
    private String descricao;
    private String[] nutrientes;
    private String[] macronutrientes;

    public Alimento (String categoria, String descricao, String[] nutrientes, String[] macronutrientes) {
        this.categoria = categoria;
        this.descricao = descricao;
        this.nutrientes = nutrientes;
        this.macronutrientes = macronutrientes;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public String[] getNutrientes() {
        return this.nutrientes;
    }

    public String[] getMacronutrientes() {
        return this.macronutrientes;
    }
/*
    private void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    private void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    private void setNutrientes(String[] nutrientes) {
        this.nutrientes = nutrientes;
    }

    private void setMacronutrientes(String[] macronutrientes) {
        this.macronutrientes = macronutrientes;
    } */

}