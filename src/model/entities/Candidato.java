package model.entities;

public abstract class Candidato {

    private Integer id;
    private Integer numero;
    private String nome;
    private Integer votos;
    private Partido partido;

    public Candidato(Integer id, Integer numero, String nome, Integer votos, Partido partido) {
        this.id = id;
        this.numero = numero;
        this.nome = nome;
        this.votos = votos;
        this.partido = partido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
                "id=" + id +
                ", numero=" + numero +
                ", nome='" + nome + '\'' +
                ", votos=" + votos +
                ", partido=" + partido +
                '}';
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
