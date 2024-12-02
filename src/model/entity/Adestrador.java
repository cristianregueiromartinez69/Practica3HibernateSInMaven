package model.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "adestrador")
public class Adestrador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    @Column(name = "nacemento")
    private LocalDate nacemento;

    public Adestrador(Integer id, String nome, LocalDate nacemento) {
        this.id = id;
        this.nome = nome;
        this.nacemento = nacemento;
    }

    public Adestrador(String nome, LocalDate nacemento) {
        this.nome = nome;
        this.nacemento = nacemento;
    }

    public Adestrador() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getNacemento() {
        return nacemento;
    }

    public void setNacemento(LocalDate nacemento) {
        this.nacemento = nacemento;
    }

    @Override
    public String toString() {
        return "\nAdestrador: " +
                "\nid: " + id +
                "\nnome: " + nome +
                "\nnacemento: " + nacemento;
    }
}