package leo.com.cursomc.domain;

import java.io.Serializable;
import java.util.Objects;

public class Categorie implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String nome;

    public Categorie(){

    }

    public Categorie(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categorie categorie = (Categorie) o;
        return id.equals(categorie.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}