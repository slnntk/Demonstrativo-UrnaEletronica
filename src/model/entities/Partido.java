package model.entities;

import java.util.Set;

public class Partido extends processoEleitoral{
    ;
    private String sigla;

    private Set<Candidato> candidatos;

    public Partido() {
    }

    public Partido(Integer id, String nome, String sigla) {
        super(id, nome);
        this.sigla = sigla;
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
                "sigla='" + sigla + '\'' +
                ", candidatos=" + candidatos +
                "} " + super.toString();
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
