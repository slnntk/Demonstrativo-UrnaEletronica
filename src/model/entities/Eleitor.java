package model.entities;

public abstract class Eleitor {

    private Integer titulo;
    private boolean hasVoted;

    public Eleitor(Integer titulo, boolean hasVoted) {
        this.titulo = titulo;
        this.hasVoted = hasVoted;
    }

    public Integer getTitulo() {
        return titulo;
    }

    public void setTitulo(Integer titulo) {
        this.titulo = titulo;
    }

    public boolean isHasVoted() {
        return hasVoted;
    }

    public void setHasVoted(boolean hasVoted) {
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
