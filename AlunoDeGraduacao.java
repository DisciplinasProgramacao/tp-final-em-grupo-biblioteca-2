package Business;

public class AlunoDeGraduacao extends Usuario {
	protected boolean usuarioSuspenso;
	protected int diasSuspenso;
	public AlunoDeGraduacao(String nome) {
		super(nome);
		this.usuarioSuspenso = false;
		
	}

	@Override
	public boolean atrasado(Data dataAtual, Data devolucao) {
		if (dataAtual.maisFutura(devolucao)) {
			System.out.println("entrou");
			System.out.println("devolucao"+devolucao.dataFormatada());
			System.out.println("atual"+dataAtual.dataFormatada());
			this.diasSuspenso += calculaSuspensao(dataAtual, devolucao);
			this.usuarioSuspenso = true;
			return true;
		}
		return false;
	}

	private int calculaSuspensao(Data dataAtual, Data devolucao) {
		int aux = dataAtual.dia + (dataAtual.mes * 31) + (dataAtual.ano * 372);
		int aux2 = devolucao.dia + (dataAtual.mes * 31) + (dataAtual.ano * 372);

		return (aux - aux2) * 2;
	}

	

}
