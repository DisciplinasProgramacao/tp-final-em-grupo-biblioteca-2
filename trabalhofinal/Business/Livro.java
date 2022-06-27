package Business;

public abstract class Livro {
	protected String nome;
	protected static int codigo;
	protected int contador;
	public boolean status;

	public static int getCodigo() {
		return codigo;
	}

	public Livro(String nome) {
		this.nome = nome;
		this.contador = 0;
		contador = ++codigo;
		this.status = false;
	}

	public String getNome() {
		return nome;
	}

}
