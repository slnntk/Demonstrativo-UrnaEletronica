package model.entities;

public class Eleitor {

    private Integer titulo;
    private Integer hasVoted;

    public Eleitor() {
    }

    public Eleitor(Integer titulo, Integer hasVoted) {
        this.titulo = titulo;
        this.hasVoted = hasVoted;
    }

    public Integer getTitulo() {
        return titulo;
    }

    public void setTitulo(Integer titulo) {
        this.titulo = titulo;
    }

    public Integer isHasVoted() {
        return hasVoted;
    }

    public void setHasVoted(Integer hasVoted) {
        this.hasVoted = hasVoted;
    }

    @Override
    public String toString() {
        return "Eleitor{" +
                "titulo='" + titulo + '\'' +
                ", hasVoted=" + hasVoted +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Eleitor eleitor)) return false;

        return getTitulo() != null ? getTitulo().equals(eleitor.getTitulo()) : eleitor.getTitulo() == null;
    }

    @Override
    public int hashCode() {
        return getTitulo() != null ? getTitulo().hashCode() : 0;
    }
}
