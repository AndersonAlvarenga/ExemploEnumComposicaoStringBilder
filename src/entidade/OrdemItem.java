package entidade;

public class OrdemItem {
	private Integer quantidade;
	private Double precoTotal;
	private Produto produto;

	public OrdemItem() {
	}

	public OrdemItem(Integer quantidade, Produto produto) {
		this.quantidade = quantidade;
		this.produto = produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Double subTotal() {
		precoTotal = produto.getPreco() * quantidade;
		return precoTotal;

	}

}
