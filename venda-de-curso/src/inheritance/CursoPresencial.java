package inheritance;

public class CursoPresencial extends Curso {
    private String endereco;

    public CursoPresencial(String titulo, double preco, String endereco) {
        super(titulo, preco);
        this.endereco = endereco;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "\nCurso Presencial: \nEndereço: " + endereco + ", " + super.toString();
    }
}
