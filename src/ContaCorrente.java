
public class ContaCorrente extends Conta {

	public ContaCorrente(Cliente cliente) {
		super(cliente);
	}

	@Override
	public void imprimirSaldo() {
		System.out.println("\n====== Extrato de Conta Poupança ======");
		super.imprimirDadosConta();
	}

}
