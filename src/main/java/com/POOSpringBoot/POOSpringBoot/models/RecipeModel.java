package com.POOSpringBoot.POOSpringBoot.models;

public class RecipeModel {
    private Long id;
    private String titulo;
    private String ingredientes;
    private String instrucciones;

    public RecipeModel(){
    }

    public RecipeModel(Long id, String titulo, String ingredientes, String instrucciones) {
        this.id = id;
        this.titulo = titulo;
        this.ingredientes = ingredientes;
        this.instrucciones = instrucciones;
    }

    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitulo() {
        return this.titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getIngredientes() {
        return this.ingredientes;
    }
    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }
    public String getInstrucciones() {
        return this.instrucciones;
    }
    public void setInstrucciones(String instrucciones) {
        this.instrucciones = instrucciones;
    }
}
