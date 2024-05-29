import inheritance.Curso;
import inheritance.CursoOnline;
import inheritance.CursoPresencial;
import repositories.CursoRepositorio;
import services.CursoServico;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CursoServico cursoServico = new CursoServico(new CursoRepositorio());

        while (true) {
            System.out.println("1. Adicionar Curso");
            System.out.println("2. Atualizar Curso");
            System.out.println("3. Remover Curso");
            System.out.println("4. Buscar Curso por ID");
            System.out.println("5. Listar Todos os Cursos");
            System.out.println("0. Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consome a nova linha após o nextInt

            switch (opcao) {
                case 1:
                    adicionarCurso(scanner, cursoServico);
                    break;
                case 2:
                    atualizarCurso(scanner, cursoServico);
                    break;
                case 3:
                    removerCurso(scanner, cursoServico);
                    break;
                case 4:
                    buscarCursoPorId(scanner, cursoServico);
                    break;
                case 5:
                    listarTodosOsCursos(cursoServico);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    private static void adicionarCurso(Scanner scanner, CursoServico cursoServico) {
        System.out.println("Digite o título do curso:");
        String titulo = scanner.nextLine();
        System.out.println("Digite o preço do curso:");
        double preco = scanner.nextDouble();
        scanner.nextLine(); // Consome a nova linha após o nextDouble

        System.out.println("O curso é online ou presencial? (Digite 'online' ou 'presencial'):");
        String tipoCurso = scanner.nextLine();

        if (tipoCurso.equalsIgnoreCase("online")) {
            System.out.println("Digite a URL do curso:");
            String url = scanner.nextLine();
            CursoOnline cursoOnline = new CursoOnline(titulo, preco, url);
            cursoServico.adicionar(cursoOnline);
        } else if (tipoCurso.equalsIgnoreCase("presencial")) {
            System.out.println("Digite o endereço do curso:");
            String endereco = scanner.nextLine();
            CursoPresencial cursoPresencial = new CursoPresencial(titulo, preco, endereco);
            cursoServico.adicionar(cursoPresencial);
        } else {
            System.out.println("Tipo de curso inválido!");
        }
    }

    private static void atualizarCurso(Scanner scanner, CursoServico cursoServico) {
        System.out.println("Digite o ID do curso a ser atualizado:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consome a nova linha após o nextInt

        Curso curso = cursoServico.buscarPorId(id);
        if (curso == null) {
            System.out.println("Curso não encontrado!");
            return;
        }

        System.out.println("Digite o novo título do curso:");
        String titulo = scanner.nextLine();
        System.out.println("Digite o novo preço do curso:");
        double preco = scanner.nextDouble();
        scanner.nextLine(); // Consome a nova linha após o nextDouble

        if (curso instanceof CursoOnline) {
            System.out.println("Digite a nova URL do curso:");
            String url = scanner.nextLine();
            ((CursoOnline) curso).setUrl(url);
        } else if (curso instanceof CursoPresencial) {
            System.out.println("Digite o novo endereço do curso:");
            String endereco = scanner.nextLine();
            ((CursoPresencial) curso).setEndereco(endereco);
        }

        curso.setTitulo(titulo);
        curso.setPreco(preco);
        cursoServico.atualizar(curso);
        System.out.println("Curso atualizado com sucesso!");
    }

    private static void removerCurso(Scanner scanner, CursoServico cursoServico) {
        System.out.println("Digite o ID do curso a ser removido:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consome a nova linha após o nextInt

        Curso curso = cursoServico.buscarPorId(id);
        if (curso == null) {
            System.out.println("Curso não encontrado!");
            return;
        }

        cursoServico.remover(curso);
        System.out.println("Curso removido com sucesso!");
    }

    private static void buscarCursoPorId(Scanner scanner, CursoServico cursoServico) {
        System.out.println("Digite o ID do curso:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consome a nova linha após o nextInt

        Curso curso = cursoServico.buscarPorId(id);
        if (curso == null) {
            System.out.println("Curso não encontrado!");
        } else {
            System.out.println(curso);
        }
    }

    private static void listarTodosOsCursos(CursoServico cursoServico) {
        List<Curso> cursos = cursoServico.buscarTodos();
        for (Curso curso : cursos) {
            System.out.println(curso);
        }
    }
}
