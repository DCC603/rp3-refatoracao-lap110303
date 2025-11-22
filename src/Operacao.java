public abstract class Operacao {
    protected double valor;

    public Operacao(double valor) {
        this.valor = valor;
    }

    // Cada filho decide qual é o seu tipo
    public abstract String getTipo();

    @Override
    public String toString() {
        return this.getTipo() + ":\t" + this.valor;
    }
    
    public double getValor() {
        return valor;
    }
}