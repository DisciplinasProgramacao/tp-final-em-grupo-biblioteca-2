package Business;

public abstract class Emprestimo {

	protected Data dataDeRealizacao;
	protected Data dataDeDevolucao;

	public Emprestimo(Data dataDeRealizacao) {
		this.dataDeRealizacao = dataDeRealizacao;
		this.dataDeDevolucao = dataDeRealizacao;
	}

	public Data getDataDeDevolucao() {
		return dataDeDevolucao;
	}
	
}
