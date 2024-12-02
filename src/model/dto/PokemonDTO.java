package model.dto;

import model.entity.Adestrador;
import model.entity.Pokedex;

import java.io.Serializable;
import java.time.LocalDate;

public class PokemonDTO implements Serializable {

    private Integer id;
    private String nombre;
    private LocalDate fechaNacimiento;
    private Pokedex pokedexentry;
    private Adestrador adestrador;

    public PokemonDTO(Integer id, String nombre, LocalDate fechaNacimiento, Pokedex pokedexentry, Adestrador adestrador) {
        this.id = id;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.pokedexentry = pokedexentry;
        this.adestrador = adestrador;
    }

    public PokemonDTO(String nombre, LocalDate fechaNacimiento, Pokedex pokedexentry, Adestrador adestrador) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.pokedexentry = pokedexentry;
        this.adestrador = adestrador;
    }

    public PokemonDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Pokedex getPokedexentry() {
        return pokedexentry;
    }

    public void setPokedexentry(Pokedex pokedexentry) {
        this.pokedexentry = pokedexentry;
    }

    public Adestrador getAdestrador() {
        return adestrador;
    }

    public void setAdestrador(Adestrador adestrador) {
        this.adestrador = adestrador;
    }

    @Override
    public String toString() {
        return "PokemonDTO: " +
                "\nid: " + id +
                "\nnombre: " + nombre +
                "\nfechaNacimiento: " + fechaNacimiento +
                "\npokedexentry: " + pokedexentry +
                "\nadestrador: " + adestrador;
    }
}
