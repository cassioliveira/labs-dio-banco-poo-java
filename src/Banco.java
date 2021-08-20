import java.util.List;

import lombok.Data;
import lombok.Getter;

@Data
public class Banco {

	private String nome;

	@Getter
	private List<Conta> contas;

}
