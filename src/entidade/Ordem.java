package entidade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import entidade.enuns.StatusOrdem;

public class Ordem {
	private Date data = new Date();
	private StatusOrdem status;
	private Cliente cliente;

	private List<OrdemItem> ordemItem = new ArrayList<>();

	public Ordem() {
	}

	public Ordem(StatusOrdem status, Cliente cliente) {
		this.cliente = cliente;
		this.status = status;
	}

	public Date getData() {
		return data;
	}

	public StatusOrdem getStatus() {
		return status;
	}

	public void setStatus(StatusOrdem status) {
		this.status = status;
	}
	

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void addItem(OrdemItem item) {
		ordemItem.add(item);
	}

	public void removeItem(OrdemItem item) {
		ordemItem.remove(item);
	}

	public Double total() {
		Double valorTotal = 0.0;
		for (OrdemItem c : ordemItem) {
			valorTotal += c.subTotal();
		}
		return valorTotal;

	}
	public void imprimirItem() {
		for (OrdemItem c : ordemItem) {
			StringBuilder string2 = new StringBuilder();
			string2.append(c.getProduto().getNome()+", ");
			string2.append("Quantidade: "+c.getQuantidade()+", ");
			string2.append("Subtotal: "+c.subTotal());
			System.out.println(string2.toString());	
		}
	}
}