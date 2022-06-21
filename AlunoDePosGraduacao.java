package Business;

public class AlunoDePosGraduacao extends Usuario{
protected boolean usuarioSuspenso;
protected int diasSuspenso;
	public AlunoDePosGraduacao(String nome, String usuario) {
		super(nome, usuario);
		this.usuarioSuspenso=false;
	}
	@Override
	public boolean atrasado(Data dataAtual, Data devolucao) {
		if (devolucao.maisFutura(dataAtual))
		{
			this.diasSuspenso=calculaSuspensao(dataAtual,devolucao);
			this.usuarioSuspenso=true;
			return true;
		}
		return false;
	}
	private int calculaSuspensao(Data dataAtual,Data devolucao)
	{
		int aux=dataAtual.dia+(dataAtual.mes*31)+(dataAtual.ano*372);
		int aux2=devolucao.dia+(dataAtual.mes*31)+(dataAtual.ano*372);
		
		return (aux2-aux);
	}

}
