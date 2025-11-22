public class Deposito extends Operacao {
    public Deposito(double valor) {
        super(valor);
    }

    @Override
    public String getTipo() {
        return "Depósito";
    }
}