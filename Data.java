package Business;

import java.io.Serializable;

/**
 * MIT License
 *
 * Copyright(c) 2022 Jo�o Caram <caram@pucminas.br>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

public class Data implements Serializable {
	static final long serialVersionUID = 20221L;

	// #region atributos
	// constante: dias de cada m�s
	private static int[] DIASDOMES = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int ANO_ATUAL = 2022;

	// atributos
	int dia;
	int mes;
	int ano;
	// #endregion

	// #region Construtores

	private void init(int dia, int mes, int ano) {
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
		//if (!this.dataValida()) { // se a data n�o � v�lida... (m�todo da pr�pria classe)
		//	this.dia = this.mes = 1;
		//	this.ano = 1990;
	//	}

	}

	/**
	 * Construtor completo: recebe dia, m�s e ano e valida a data. Datas inv�lidas
	 * v�o para 01/01/1990
	 * 
	 * @param dia Dia
	 * @param mes M�s
	 * @param ano Ano
	 */
	public Data(int dia, int mes, int ano) {
		this.init(dia, mes, ano);
	}

	/**
	 * Construtor para ano atual: recebe dia, m�s e completa com ano atual (2022).
	 * Datas inv�lidas v�o para 01/01/1990
	 * 
	 * @param dia Dia
	 * @param mes M�s
	 * 
	 */
	public Data(int dia, int mes) {
		this.init(dia, mes, ANO_ATUAL);
	}

	/**
	 * Construtor para data padr�o: 01/01/1990
	 */
	public Data() {
		this.init(1, 1, 1990);
	}

	/**
	 * Retorna se o ano da data armazenada � bissexto Para regras do ano bissexto:
	 * http://educacao.uol.com.br/disciplinas/matematica/ano-bissexto-eles-se-repetem-a-cada-4-anos.htm
	 * http://www.sogeografia.com.br/Curiosidades/?pg=4
	 * 
	 * @return Se o ano � bissexto (true) ou n�o (false)
	 */
	public boolean anoBissexto() {
		boolean resposta = false;
		if (this.ano % 400 == 0)
			resposta = true;
		else if (this.ano % 4 == 0 && this.ano % 100 != 0)
			resposta = true;

		return resposta;
	}

	/**
	 * Verifica se a data armazenada � v�lida (m�todo privado)
	 * 
	 * @return TRUE se � v�lida ; FALSE se n�o � v�lida
	 */
	private Boolean dataValida() {
		Boolean resposta = true; // resposta sobre a validade
		if (this.ano < 1900)
			resposta = false;
		else {
			if (this.mes < 1 || this.mes > 12) // m�s<1 ou m�s>12 --> data inv�lida
				resposta = false;
			else {
				if (this.anoBissexto()) // sen�o, caso de 29/02 em ano bissexto --> data v�lida
					DIASDOMES[2] = 29;
				if (this.dia > DIASDOMES[this.mes]) // senao, verifica validade de acordo com o m�s atual
					resposta = false;
				DIASDOMES[2] = 28;
			}
		}
		return resposta; // retorna a resposta obtida
	}

	/**
	 * Acrescenta alguns dias � data e retorna a nova data (sem modificar a atual)
	 * 
	 * @param quant Quantos dias
	 * @return Nova data com os dias adicionados
	 */
	public Data acrescentaDias(int quant) {
		Data aux = new Data(this.dia, this.mes, this.ano);

		aux.dia += quant; // acrescenta a quantidade ao dia atual e, em seguida, devemos ajustar m�s e ano

		if (aux.anoBissexto())
			DIASDOMES[2] = 29; // se o ano � bissexto, altera fevereiro para 29 dias

		while (aux.dia > DIASDOMES[aux.mes]) { // enquanto os dias ultrapassam o limite de dias do m�s atual... ajustar

			aux.dia = aux.dia - DIASDOMES[aux.mes]; // desconta a quantidade de dias do m�s
			aux.mes++; // avan�a o m�s

			if (aux.mes > 12) { // se passar de 12 meses...
				aux.mes = aux.mes - 12; // desconta-se 1 ano
				aux.ano++; // avan�a o ano.
				if (aux.anoBissexto())
					DIASDOMES[2] = 29; // verifica se o novo ano � bissexto para ajustar os dias de fevereiro.
				else
					DIASDOMES[2] = 28;
			}
		}
		return aux;
	}

	/**
	 * Verifica, entre duas datas, qual est� no futuro em rela��o � outra.
	 * Compara��o feita pela transforma��o da data em String AAAAMMDD
	 * 
	 * @param outra Outra data a ser comparada
	 * @return TRUE se esta for futura, FALSE caso contr�rio
	 */
	public boolean maisFutura(Data outra) {
		boolean resposta = false;

		String esta = String.format("%4d", this.ano) + String.format("%2d", this.mes) + String.format("%2d", this.dia);
		String aOutra = String.format("%4d", outra.ano) + String.format("%2d", outra.mes)
				+ String.format("%2d", outra.dia);

		if (esta.compareTo(aOutra) > 0)
			resposta = true;

		return resposta;
	}

	/**
	 * Retorna a data formatada
	 * 
	 * @return String com a data no formato dd/mm/aaaa
	 */
	public String dataFormatada() {

		return (String.format("%02d", this.dia) + "/" + String.format("%02d", this.mes) + "/"
				+ String.format("%4d", this.ano));
	}

}
