package ejercicios2;

public class Serie {
    private int actor;
    private String titulo;
    private String autor;

    public Serie(String titulo, String autor){
        this.titulo=titulo;
        this.autor=autor;
        this.actor=0;
    }

    public Serie (){
        this.titulo="";
        this.autor="";
        this.actor=0;

    }

    public int getActor() {
        return actor;
    }

    public void setActor(int actor) {
        this.actor = actor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
    
}
