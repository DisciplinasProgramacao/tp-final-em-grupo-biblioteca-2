package Business;

public class AlunoDeGraduacao extends Usuario{
	protected boolean usuarioSuspenso;
	protected int diasSuspenso;
	public AlunoDeGraduacao(String nome, String usuario) {
		super(nome, usuario);
	this.usuarioSuspenso=false;
	}
	@Override
	public boolean atrasado(Data dataAtual, Data devolucao) {
		
		if (devolucao.maisFutura(dataAtual))
		{
			
			this.diasSuspenso+=calculaSuspensao(dataAtual,devolucao);
			this.usuarioSuspenso=true;
			return true;
		}
		return false;
	}
	private int calculaSuspensao(Data dataAtual,Data devolucao)
	{
		int aux=dataAtual.dia+(dataAtual.mes*31)+(dataAtual.ano*372);
		int aux2=devolucao.dia+(dataAtual.mes*31)+(dataAtual.ano*372);
		
		return (aux2-aux)*2;
	}
	@Override
	public String toString() {
		return " AlunoDeGraduacao [usuarioSuspenso=" + usuarioSuspenso + ", diasSuspenso=" + diasSuspenso + "]";
	}
	
	
}
