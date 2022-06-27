package App;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import Business.AlunoDeGraduacao;
import Business.AlunoDePosGraduacao;
import Business.Biblioteca;
import Business.Data;
import Business.Emprestimo;
import Business.EmprestimoDigital;
import Business.EmprestimoFisico;
import Business.Livro;
import Business.LivroDigital;
import Business.LivroFisico;
import Business.Professores;
import Business.Usuario;

public class Main {

	public static void main(String[] args) {
		System.out.println("APP");
		System.out.println("Menu");
		List <Usuario>usuarios=new ArrayList<>();
		List <LivroFisico>livrosF=new ArrayList<>();
		List <LivroDigital>ebook=new ArrayList<>();
		Data atual=new Data(1,1,2000);
		EmprestimoFisico e=new EmprestimoFisico();
		EmprestimoDigital ed=new EmprestimoDigital();
		Biblioteca b=new Biblioteca();
		Scanner teclado=new Scanner(System.in);
		 int opcao=-1;
      int opcao2;
      
       while (opcao!=0)
       {
    	   System.out.println("1 - Adicionar Usuario");
           System.out.println("2 - Adicionar Livro");
           System.out.println("3 - Emprestar Livro fisico");
           System.out.println("4 - Emprestar Livro digital");
           System.out.println("5 - Devolver Livro");
           System.out.println("6 - Renovar Livro");
           System.out.println("7 - Historico do usuario");
           opcao=teclado.nextInt();
    		switch (opcao)
           	{
           	case 1:
           		System.out.println("1- Aluno de graduacao, 2-Aluno de pos graduacao, 3-Professor");
           		opcao2=teclado.nextInt();
           		if (opcao2==1)
           		{
           			System.out.println("Digite os dados do usuario [nome]");
           			Usuario u=new AlunoDeGraduacao(teclado.next(),atual);
           			usuarios.add(u);
           			b.cadastraUsuario(u);
           			
           			break;
           		}
           		
           		if (opcao2==2) 
           		{
           		System.out.println("Digite os dados do usuario [nome]");
           		Usuario u=new AlunoDePosGraduacao(teclado.next(),atual);
       			usuarios.add(u);
       			b.cadastraUsuario(u);
       			break;
           	    }
           		
           		if (opcao2==3)
           		{
           			System.out.println("Digite os dados do usuario [nome]");
           			Usuario u=new Professores(teclado.next(),atual);
           			usuarios.add(u);
           			b.cadastraUsuario(u);
           			break;
           		}
           		break;
           		
           	case 2:
           		System.out.println("1 - Livro fisico , 2 - Livro digital");
           		opcao2=teclado.nextInt();
           		if(opcao2==1)
           		{
           			System.out.println("Digite nome do livro fisico");
           			LivroFisico l=new LivroFisico(teclado.next());
           			livrosF.add(l);
           			b.adicionaLivro(l);
           			
           		}
           		if(opcao2==2)
           		{
           			System.out.println("Digite nome do livro digital");
           			LivroDigital l2=new LivroDigital(teclado.next());
           			ebook.add(l2);
           			b.adicionaLivro(l2);
           			
           		}
           		break;
           	case 3:
           		System.out.println("Digite o nome do usuario e o nome do livro");
           		String nomeDoUsuario=teclado.next();
           		String nomeDoLivro=teclado.next();
    
           		Usuario x=null;
           		LivroFisico l=null;
           		x=procuraUsuario(nomeDoUsuario,usuarios);
           		l=procuraLivroFisico(nomeDoLivro,livrosF);
           		if (x!=null&&l!=null)
           		{
           			e.realizarEmprestimo(x, l);
           			System.out.println("Emprestimo realizado");
           			System.out.println("Data de realizacao "+x.getDataDeRealizacao().dataFormatada());
           			System.out.println("Data de devolucao "+x.getDataDeDevolucao().dataFormatada());
           		}
           		 if (x==null)
           		{
           			System.out.println("Usuario nao encontrado");
           		}
           		if (l==null)
           		{
           			System.out.println("Livro nao encontrado");
           		}
           			break;
           		
           		
           		
           	case 4:	
           		System.out.println("Digite o nome do usuario e o nome do livro digital");
           		nomeDoUsuario=teclado.next();
           		nomeDoLivro=teclado.next();
           		LivroDigital l1=null;
           		x=null;
           		x=procuraUsuario(nomeDoUsuario,usuarios);
           		l1=procuraLivroDigital(nomeDoLivro,ebook);
           		if (x!=null&&l1!=null)
           		{
           			ed.realizarEmprestimo(x, l1);
           			System.out.println("Emprestimo realizado");
           		}
           		 if (x==null)
           		{
           			System.out.println("Usuario nao encontrado");
           		}
           		if (l1==null)
           		{
           			System.out.println("Livro nao encontrado");
           		}
           		break;
           	case 5:
           System.out.println("Digite o nome do usuario e do livro que deseja devolver");
            nomeDoUsuario=teclado.next();
            nomeDoLivro=teclado.next();
            Usuario x2=null;
       		LivroFisico l2=null;
       		x2=procuraUsuario(nomeDoUsuario,usuarios);
       		l2=procuraLivroFisico(nomeDoLivro,livrosF);
       		if (x2!=null&&l2!=null)
       		{
       			e.devolverEmprestimo(x2, l2, atual);
       			System.out.println("Livro devolvido com sucesso");
       		}
       		 if (x2==null)
       		{
       			System.out.println("Usuario nao encontrado");
       		}
       		if (l2==null)
       		{
       			System.out.println("Livro nao encontrado");
       		}
       		break;
           	case 6:
           		System.out.println("Digite o nome do usuario e do livro que deseja renovar");
           	 nomeDoUsuario=teclado.next();
             nomeDoLivro=teclado.next();
             x2=null;
             l2=null;
             x2=procuraUsuario(nomeDoUsuario,usuarios);
        	l2=procuraLivroFisico(nomeDoLivro,livrosF);
        	if (x2!=null&&l2!=null)
       		{
       			e.renovarEmprestimo(x2, l2, atual);
       			System.out.println("Livro renovado com sucesso");
       		}
       		 if (x2==null)
       		{
       			System.out.println("Usuario nao encontrado");
       		}
       		if (l2==null)
       		{
       			System.out.println("Livro nao encontrado");
       		}
           	case 7:
           		System.out.println("Digite o nome do usuario");
           		nomeDoUsuario=teclado.next();
           		x2=procuraUsuario(nomeDoUsuario,usuarios);
           		System.out.println(x2);
           	 
           }
    		
    			
       }
       
		
	}
	public static Usuario procuraUsuario(String nome,List<Usuario> u)
	{
		for (Usuario ux:u)
   		{
   			if (ux.getNome().equals(nome))
   			{
   				
   				return ux;
   			}
	}
		return null;
}
	public static LivroFisico procuraLivroFisico(String nome,List<LivroFisico> livrosF)
	{
		LivroFisico x=null;
		for (LivroFisico l:livrosF)
			{
				if (l.getNome().equals(nome))
				{
					return l;
				}
			}
		return x;
	}
	public static LivroDigital procuraLivroDigital(String nome,List<LivroDigital>ebook)
	{
		LivroDigital x=null;
		for (LivroDigital l:ebook)
			{
				if (l.getNome().equals(nome))
				{
					return l;
				}
			}
		return x;
	}
}

