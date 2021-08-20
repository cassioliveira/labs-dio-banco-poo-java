
public class Main {

	public static void main(String[] args) throws InterruptedException {

		Cliente cliente = new Cliente();
		cliente.setNome("Cassio");

		Conta contaCorrente = new ContaCorrente(cliente);
		contaCorrente.depositar(500);
		contaCorrente.sacar(50);
		contaCorrente.imprimirSaldo();
		contaCorrente.imprimirExtrato();

		Conta contaPoupanca = new ContaPoupanca(cliente);
		contaCorrente.transferir(200, contaPoupanca);
		contaPoupanca.depositar(75);

		contaPoupanca.imprimirSaldo();
		contaPoupanca.imprimirExtrato();
		
		
		

	}

}
