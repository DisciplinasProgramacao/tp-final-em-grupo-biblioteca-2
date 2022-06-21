package Business;

import java.util.ArrayList;
import java.util.List;

public class Emprestimo {

	protected Data dataDeRealizacao;
	protected Data dataDeDevolucao;
	
	
	public Emprestimo(Data dataDeRealizacao)
	{
		this.dataDeRealizacao=dataDeRealizacao;
		this.dataDeDevolucao=dataDeRealizacao;
		
	
	}
	public void realizarEmprestimo(Usuario usuario,Livro livro)
	{
		livro=verificaFisico(livro,usuario);
		if (usuario instanceof Professores && !usuario.livro){
		this.dataDeDevolucao=this.dataDeDevolucao.acrescentaDias(14);
		usuario.livro=true;
		usuario.listaDeLivroDoUsuario.add(livro.nome);
		}
		else if((usuario instanceof AlunoDeGraduacao||usuario instanceof AlunoDePosGraduacao) && !usuario.livro)
		{
			this.dataDeDevolucao=this.dataDeDevolucao.acrescentaDias(7);
			usuario.livro=true;
			usuario.listaDeLivroDoUsuario.add(livro.nome);
		}	
		//lança um erro falando que o usuario ja se encontra com um livro
	}
	private Livro verificaFisico(Livro livro,Usuario usuario)
	{
		if (livro instanceof LivroFisico&& !usuario.livro)
		{
			livro=(LivroFisico)livro;
			((LivroFisico) livro).status=true;
			
		}
		
		return livro;
		
	}
	public void renovarEmprestimo(Usuario usuario,Livro livro,Data atual)
	{
		if (usuario.livro)
		{
			if (usuario.atrasado(dataDeRealizacao, atual))
			{
				System.out.println("nao e possivel renovar");
			}
			else 
			{
				realizarEmprestimo(usuario,livro);
			}
			
		}
	}
	public void devolverEmprestimo(Usuario usuario,LivroFisico livro)
	{
		if (usuario.livro)
		{
			usuario.livro=false;
			livro.status=false;
		}
	}

	

	
	
	
}
