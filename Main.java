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
import Business.Livro;
import Business.LivroDigital;
import Business.LivroFisico;
import Business.Professores;
import Business.Usuario;

public class Main {

	public static void main(String[] args) {
		Scanner teclado=new Scanner(System.in);
		
		
		Emprestimo e=new Emprestimo(new Data(1,1,1));
		Biblioteca b=new Biblioteca();
		Livro livro=new LivroFisico("the walking");
		b.adicionaLivro(livro);
		e.realizarEmprestimo(usuario, livro);
		e.realizarEmprestimo(usuario, livro);
		System.out.println("Menu");
		 int opcao;
		System.out.println("1 - Adicionar Usuario");
        System.out.println("2 -	Adicionar Livro");
        System.out.println("3 - Emprestar Livro");
        System.out.println("4 - Historico de emprestimo");
        System.out.println("5 - Relatorio de alunos suspenso");
       opcao=teclado.nextInt();
       String aux1="";
       String aux2="";
       int opcao2;
        while (opcao!=0)
        {
        	switch (opcao)
        	{
        	case 1:
        		System.out.println("1- Aluno de graduacao, 2-Aluno de pos graduacao, 3-Professor");
        		opcao2=teclado.nextInt();
        		if (opcao2==1)
        		{
        			System.out.println("Digite os dados do usuario [nome],[Matricula]");
            		aux1=teclado.next();
            		aux2=teclado.next();
            		Usuario usuario=new AlunoDeGraduacao(aux1,aux2);
        		}
        		if (opcao2==2) 
        		{
        		System.out.println("Digite os dados do usuario [nome],[Matricula]");
        		aux1=teclado.next();
        		aux2=teclado.next();
        		Usuario usuario=new AlunoDePosGraduacao(aux1,aux2);
        	    }
        		if (opcao2==3)
        		{
        			System.out.println("Digite os dados do usuario [nome],[Matricula]");
            		aux1=teclado.next();
            		aux2=teclado.next();
            		Usuario usuario=new Professores(aux1,aux2);
        		}
        		break;
        	case 2:
        		System.out.println("1 - Livro fisico , 2 - Livro digital");
        		opcao2=teclado.nextInt();
        		if(opcao2==1)
        		{
        			System.out.println("Digite nome do livro");
        			aux1=teclado.next();
        			LivroFisico livro1 = new LivroFisico(aux1);
        		}
        		if(opcao2==2)
        		{
        			System.out.println("Digite nome do livro");
        			aux1=teclado.next();
        			LivroDigital livro1 = new LivroDigital(aux1);
        			
        		}
        		break;
        	case 3:
        		System.out.println("")
        }
        
		
		
	}

}
