import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public abstract class Conta implements IConta {

	private static final int AGENCIA_PADRAO = 1;

	protected static List<String> log = new ArrayList<>();

	private static int SEQUENCIAL = 1;
	protected int agencia;
	protected int numero;
	protected double saldo;
	private Cliente cliente;

	public Conta(Cliente cliente) {
		this.agencia = AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}

	@Override
	public void sacar(double valor) {
		this.saldo -= valor;
		log.add("Saque efetuado no valor de R$ " + valor);
	}

	@Override
	public void depositar(double valor) {
		this.saldo += valor;
		log.add("Depósito efetuado no valor de R$ " + valor);
	}

	@Override
	public void transferir(double valor, Conta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
		log.add("Transferência efetuada no valor de R$ " + valor);
	}

	protected void imprimirDadosConta() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Conta: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
		System.out.println("\n------- Operações ------");
	}

	@Override
	public void imprimirExtrato() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:MM:ss");
		for (String acao : log) {
			System.out.println(formatter.format(LocalDateTime.now()) + " - " + acao);
		}
		System.out.println("\n\n");
	}

}
