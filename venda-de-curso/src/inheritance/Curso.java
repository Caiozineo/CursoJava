package inheritance;

public abstract class Curso {
    private static int contadorId = 0; // Contador estático para gerar IDs únicos
    private int id; // ID único do curso
    private String titulo;
    private double preco;

    public Curso(String titulo, double preco) {
        this.id = ++contadorId; // Incrementa o contador e atribui ao ID
        this.titulo = titulo;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\nNome: " + titulo + "\nPreço: R$" + preco + "\n";
    }
}
