package model.entities;

import java.util.Set;

abstract class Partido {

    private Integer id;
    private String nome;
    private String sigla;

    private Set<Candidato> candidatos;

    public Partido(Integer id, String nome, String sigla) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
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

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Set<Candidato> getCandidatos() {
        return candidatos;
    }

    @Override
    public String toString() {
        return "Partido{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sigla='" + sigla + '\'' +
                ", candidatos=" + candidatos +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Partido partido)) return false;

        if (getId() != null ? !getId().equals(partido.getId()) : partido.getId() != null) return false;
        if (getNome() != null ? !getNome().equals(partido.getNome()) : partido.getNome() != null) return false;
        if (getSigla() != null ? !getSigla().equals(partido.getSigla()) : partido.getSigla() != null) return false;
        return getCandidatos() != null ? getCandidatos().equals(partido.getCandidatos()) : partido.getCandidatos() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getNome() != null ? getNome().hashCode() : 0);
        result = 31 * result + (getSigla() != null ? getSigla().hashCode() : 0);
        result = 31 * result + (getCandidatos() != null ? getCandidatos().hashCode() : 0);
        return result;
    }


}
