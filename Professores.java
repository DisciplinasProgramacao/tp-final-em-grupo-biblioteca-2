package Business;

public class Professores extends Usuario{
protected boolean estaAtrasado;
	public Professores(String nome, String usuario) {
		super(nome, usuario);
		this.estaAtrasado=false;
	}
	@Override
	public boolean atrasado(Data dataAtual, Data devolucao) {
		if (dataAtual.maisFutura(devolucao))
		{
			this.estaAtrasado=true;
			return true;
		}
		else {
			this.estaAtrasado=false;
		return false;	}
		
	}
}
