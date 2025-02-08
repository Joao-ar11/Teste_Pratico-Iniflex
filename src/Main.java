import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ArrayList<Funcionario> listaFuncionarios = getListaFuncionarios();

        listaFuncionarios.removeIf(funcionario -> funcionario.getNome().equals("João"));

        System.out.println("Lista de funcionários:");
        listaFuncionarios.forEach((funcionario) -> System.out.println("  " + funcionario));

        System.out.println("----------------------------------------------------------------------------------------");

        listaFuncionarios.forEach(funcionario -> funcionario.aumentarSalario(10));

        HashMap<String, ArrayList<Funcionario>> funcionariosSeparadosPorFuncao = separarFuncionariosPorFuncao(listaFuncionarios);

        System.out.println("Funcionários separados por Função:");
        funcionariosSeparadosPorFuncao.forEach((funcao, funcionarios) -> {
            System.out.println("  " + funcao + ":");
            funcionarios.forEach(funcionario -> System.out.println("    " + funcionario));
            System.out.println();
        });
        System.out.println("----------------------------------------------------------------------------------------");

        ArrayList<Funcionario> funcionariosSeparadosPorMes = separarFuncionariosPorMesDeNascimento(listaFuncionarios, 10, 12);

        System.out.println("Funcionarios que nasceram em Outubro e Dezembro:");
        funcionariosSeparadosPorMes.forEach(funcionario -> System.out.println("  " + funcionario));
        System.out.println("----------------------------------------------------------------------------------------");

        Funcionario funcionarioMaisVelho = getFuncionarioMaisVelho(listaFuncionarios);
        int idadeFuncionario = funcionarioMaisVelho.getIdade();

        System.out.println("Funcionário mais velho:");
        System.out.println("Nome: " + funcionarioMaisVelho.getNome() + " - idade: " + idadeFuncionario);
        System.out.println("----------------------------------------------------------------------------------------");

        listaFuncionarios.sort((o1, o2) -> {
            String nome1 = o1.getNome().toLowerCase();
            String nome2 = o2.getNome().toLowerCase();

            return nome1.compareTo(nome2);
        });

        System.out.println("Lista de Funcionários em ordem alfabética: ");
        listaFuncionarios.forEach(funcionario -> System.out.println("  " + funcionario));
    }

    private static ArrayList<Funcionario> getListaFuncionarios() {
        ArrayList<Funcionario> lista = new ArrayList();

        lista.add(new Funcionario("Maria",
                LocalDate.of(2000, 10, 18),
                new BigDecimal(2009.44),
                "Operador"
        ));

        lista.add(new Funcionario("João",
                LocalDate.of(1990, 5, 12),
                new BigDecimal(2284.38),
                "Operador"
        ));

        lista.add(new Funcionario("Caio",
                LocalDate.of(1961, 5, 2),
                new BigDecimal(9836.14),
                "Coordenador"
        ));

        lista.add(new Funcionario("Miguel",
                LocalDate.of(1988, 10, 14),
                new BigDecimal(19119.88),
                "Diretor"
        ));

        lista.add(new Funcionario("Alice",
                LocalDate.of(1995, 1, 5),
                new BigDecimal(2234.68),
                "Recepcionista"
        ));

        lista.add(new Funcionario("Heitor",
                LocalDate.of(1999, 11, 19),
                new BigDecimal(1582.72),
                "Operador"
        ));

        lista.add(new Funcionario("Arthur",
                LocalDate.of(1993, 3, 31),
                new BigDecimal(4071.84),
                "Contador"
        ));

        lista.add(new Funcionario("Laura",
                LocalDate.of(1994, 7, 8),
                new BigDecimal(3017.45),
                "Gerente"
        ));

        lista.add(new Funcionario("Heloísa",
                LocalDate.of(2003, 5, 24),
                new BigDecimal(1606.85),
                "Eletricista"
        ));

        lista.add(new Funcionario("Helena",
                LocalDate.of(1996, 9, 2),
                new BigDecimal(2799.93),
                "Gerente"
        ));

        return lista;
    }

    private static Funcionario getFuncionarioMaisVelho(ArrayList<Funcionario> lista) {
        Funcionario funcionarioMaisVelho = lista.get(0);

        for (int i = 0; i < lista.size(); i++) {
            Funcionario funcionario = lista.get(i);

            if (funcionario.getDataNascimento().isBefore(funcionarioMaisVelho.getDataNascimento())) {
                funcionarioMaisVelho = funcionario;
            }
        }

        return funcionarioMaisVelho;
    }

    private static HashMap<String, ArrayList<Funcionario>> separarFuncionariosPorFuncao(ArrayList<Funcionario> lista) {
        ArrayList<String> funcoes = new ArrayList();

        lista.forEach(funcionario -> {
            if (!funcoes.contains(funcionario.getFuncao())) {
                funcoes.add(funcionario.getFuncao());
            }
        });

        HashMap<String, ArrayList<Funcionario>> funcionariosSeparados = new HashMap();

        funcoes.forEach(funcao -> {
            ArrayList<Funcionario> setor = new ArrayList(
                    lista.stream().filter(funcionario -> {
                        return funcionario.getFuncao().equals(funcao);
                    }).collect(Collectors.toList())
            );

            funcionariosSeparados.put(funcao, setor);
        });

        return funcionariosSeparados;
    }

    private static ArrayList<Funcionario> separarFuncionariosPorMesDeNascimento(ArrayList<Funcionario> lista, int ...meses) {
        ArrayList<Funcionario> novaLista = new ArrayList();

        for (int i = 0; i < meses.length; i++) {
            int mes = meses[i];

            novaLista.addAll(
                    lista.stream().filter(
                            funcionario -> funcionario.getDataNascimento().getMonth().getValue() == mes
                    ).collect(Collectors.toList())
            );
        }

        return novaLista;
    }
}