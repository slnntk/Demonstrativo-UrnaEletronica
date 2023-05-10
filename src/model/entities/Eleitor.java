package model.entities;

abstract class Eleitor {

    private String titulo;
    private boolean hasVoted;

    public Eleitor(String titulo, boolean hasVoted) {
        this.titulo = titulo;
        this.hasVoted = hasVoted;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
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
