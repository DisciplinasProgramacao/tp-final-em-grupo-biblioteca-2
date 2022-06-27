package Business;

public class AlunoDePosGraduacao extends Usuario {
	protected boolean usuarioSuspenso;
	protected int diasSuspenso;

	public AlunoDePosGraduacao(String nome, Data dataDeRealizacao) {
		super(nome, dataDeRealizacao);
		this.usuarioSuspenso = false;
	}

	@Override
	public boolean atrasado(Data dataAtual, Data devolucao) {
		if (devolucao.maisFutura(dataAtual)) {
			this.diasSuspenso = calculaSuspensao(dataAtual, devolucao);
			this.usuarioSuspenso = true;
			return true;
		}
		return false;
	}

	private int calculaSuspensao(Data dataAtual, Data devolucao) {
		int aux = dataAtual.dia + (dataAtual.mes * 31) + (dataAtual.ano * 372);
		int aux2 = devolucao.dia + (dataAtual.mes * 31) + (dataAtual.ano * 372);

		return (aux2 - aux);
	}

	@Override
	public void addEmprestimo(LivroFisico livro) {
		livros.add(livro);
		this.dataDeDevolucao = this.dataDeDevolucao.acrescentaDias(7);

	}

}
