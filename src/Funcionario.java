import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDate;
import java.util.Locale;

public class Funcionario extends Pessoa {

    private BigDecimal salario;
    private String funcao;
    private static final BigDecimal SALARIO_MINIMO = new BigDecimal(1212.00);

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public String getSalarioFormatado() {
        return String.format(Locale.GERMAN,"%,.2f", this.salario);
    }

    public BigDecimal calcularSalariosMinimos() {
        return salario.divide(SALARIO_MINIMO, MathContext.DECIMAL32);
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public void aumentarSalario(int porcentagem) {
        BigDecimal aumento = salario.multiply(new BigDecimal(porcentagem))
                .divide(new BigDecimal(100));
        salario = salario.add(aumento);
    }

    @Override
    public String toString() {
        return "Nome: " + String.format("%1$7s", this.getNome()) +
                " - Data de Nascimento: " + this.getDataNascimentoFormatada() +
                " - Salário: " + String.format("%1$9s", this.getSalarioFormatado()) +
                " - Função: " + String.format("%1$13s",  this.getFuncao());
    }
}
