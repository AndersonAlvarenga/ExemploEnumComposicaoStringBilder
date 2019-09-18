package principal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entidade.Cliente;
import entidade.Ordem;
import entidade.OrdemItem;
import entidade.Produto;
import entidade.enuns.StatusOrdem;

public class Principal {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formato2 = new SimpleDateFormat("dd/MM/yyyy HH/mm/ss");
		System.out.print("Entre com os dados do cliente: \nNome: ");
		String nome = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Data de aniversário DD/MM/YYYY: ");
		Date dataAniversario = formato.parse(sc.nextLine());
		Cliente cliente = new Cliente(nome, email, dataAniversario);
		System.out.print("Entre com os dados da ordem: \nStatus: ");
		StatusOrdem status = StatusOrdem.valueOf(sc.nextLine());
		Ordem novaOrdem = new Ordem(status, cliente);
		System.out.println("Quantos itens terão na ordem");
		int quantidadeOrdem = sc.nextInt();
		for (int i = 0; i < quantidadeOrdem; i++) {
			System.out.println("Entre com os dados do item #" + i + 1);
			System.out.print("Nome do produto: ");
			String nomeProduto = sc.next();
			System.out.print("Valor do produto: ");
			Double preco = sc.nextDouble();
			System.out.print("Quantidade de itens: ");
			Integer quant = sc.nextInt();
			Produto produto = new Produto(nomeProduto, preco);
			OrdemItem ordemItem = new OrdemItem(quant, produto);
			novaOrdem.addItem(ordemItem);
		}
		StringBuilder string = new StringBuilder();
		System.out.println("\n");
		string.append("Sumary da Ordem\n");
		string.append("Momento da ordem: "+formato2.format(novaOrdem.getData())+"\n");
		string.append("Status da Ordem: "+novaOrdem.getStatus()+"\n");
		string.append("Cliente: "+novaOrdem.getCliente().getNome()+
				" ("+formato.format(novaOrdem.getCliente().getDataAniversario())+") "
				+" - "+novaOrdem.getCliente().getEmail()+"\n");
		string.append("Ordem Itens: \n");
		System.out.println(string);	
		novaOrdem.imprimirItem();
		System.out.print("Valor total da compra: ");
		System.out.println(novaOrdem.total());
		sc.close();
	}

}
