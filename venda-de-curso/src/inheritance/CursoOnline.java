package inheritance;

public class CursoOnline extends Curso {
    private String url;

    public CursoOnline(String titulo, double preco, String url) {
        super(titulo, preco);
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "\nCurso Online: \nurl: " + url + "\n" + super.toString();
    }
}


