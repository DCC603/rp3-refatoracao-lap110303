public class Main {

    public static void main(String[] args) {

        // Criação do objeto Cliente primeiro (Composição)
        Cliente joao = new Cliente("João", "111.111.111-11", "31 1111-1111");

        // Injeção do cliente na conta
        Conta minhaConta = new Conta(joao, 111, 222222, "Gil", 0.00);

        // Uso de métodos semânticos (depositar/sacar) ao invés de chars 'd'/'s'
        minhaConta.depositar(450);
        minhaConta.sacar(50);
        minhaConta.sacar(50);
        minhaConta.sacar(50);

        System.out.println(minhaConta);
    }
}