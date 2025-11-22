import java.util.ArrayList;
import java.util.List;

public class Conta {

    // TODO(#1): Dados movidos para a classe Cliente
    private Cliente cliente;

    // TODO(#1): Dados de agência poderiam ser uma classe Agência, 
    // mas mantivemos simples aqui, agrupando apenas logicamente.
    private int numAgencia;
    private int numConta;
    private String gerente;

    // TODO(#2): Renomeado de 'valor' para 'saldo'
    private double saldo;

    private List<Operacao> operacoes;

    public Conta(Cliente cliente, int numAgencia, int numConta, String gerente, double saldoInicial) {
        this.cliente = cliente;
        this.numAgencia = numAgencia;
        this.numConta = numConta;
        this.gerente = gerente;
        this.saldo = saldoInicial;
        this.operacoes = new ArrayList<>();
    }

    // TODO(#3): Métodos específicos ao invés de um genérico com 'char'
    public void depositar(double valor) {
        if (valor <= 0) return; // Validação básica
        
        this.saldo += valor;
        this.operacoes.add(new Deposito(valor));
    }

    public void sacar(double valor) {
        if (valor <= 0) return;
        
        this.saldo -= valor;
        this.operacoes.add(new Saque(valor));
    }

    // TODO(#5): Extração da lógica de geração de extrato
    private String gerarExtrato() {
        StringBuilder sb = new StringBuilder();
        for (Operacao op : this.operacoes) {
            sb.append(op.toString()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        // TODO(#4): Delega a formatação dos dados do cliente para a classe Cliente
        String dadosCliente = this.cliente.toString();

        String dadosConta = String.format("Ag.: %d\nConta: %d\nGerente: %s\nSaldo: %.2f",
                this.numAgencia, this.numConta, this.gerente, this.saldo);

        return "-----CLIENTE-----\n" +
                dadosCliente +
                "\n\n" +
                "-----CONTA-----\n" +
                dadosConta +
                "\n\n" +
                "-----EXTRATO-----\n" +
                this.gerarExtrato() + 
                "\n";
    }
}