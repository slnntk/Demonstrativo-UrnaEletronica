package model.entities;

public class Candidato extends processoEleitoral{

    private Integer numero;
    private Integer votos;
    private Partido partido;

    public Candidato() {

    }

    public Candidato(Integer id, String nome, Integer numero, Integer votos, Partido partido) {
        super(id, nome);
        this.numero = numero;
        this.votos = votos;
        this.partido = partido;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getVotos() {
        return votos;
    }

    public void setVotos(Integer votos) {
        this.votos = votos;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    @Override
    public String toString() {
        return "Candidato{" +
                "numero=" + numero +
                ", votos=" + votos +
                ", partido=" + partido +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Candidato candidato)) return false;

        if (getNumero() != null ? !getNumero().equals(candidato.getNumero()) : candidato.getNumero() != null)
            return false;
        if (getNome() != null ? !getNome().equals(candidato.getNome()) : candidato.getNome() != null) return false;
        return getPartido() != null ? getPartido().equals(candidato.getPartido()) : candidato.getPartido() == null;
    }

    @Override
    public int hashCode() {
        int result = getNumero() != null ? getNumero().hashCode() : 0;
        result = 31 * result + (getNome() != null ? getNome().hashCode() : 0);
        result = 31 * result + (getPartido() != null ? getPartido().hashCode() : 0);
        return result;
    }
}
