package model.entities;

import java.util.Set;

public class Partido extends processoEleitoral{

    private Set<Candidato> candidatos;

    public Partido() {
    }

    public Partido(Integer id, String nome) {
        super(id, nome);
    }

    public Partido(String nome) {
        super(nome);
    }

    public Set<Candidato> getCandidatos() {
        return candidatos;
    }

    @Override
    public String toString() {
        return "Partido{" +
                "sigla='" + '\'' +
                ", candidatos=" + candidatos +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Partido partido)) return false;
        if (!super.equals(o)) return false;

        return getCandidatos() != null ? getCandidatos().equals(partido.getCandidatos()) : partido.getCandidatos() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getCandidatos() != null ? getCandidatos().hashCode() : 0);
        return result;
    }
}
