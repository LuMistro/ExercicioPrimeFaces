package sc.senac.br.cadastropessoa.model;

public enum Estado {

	PARANA("Paraná"),
	SANTA_CATARINA("Santa Catarina"),
	RIO_GRANDE_DO_SUL("Rio Grande do Sul");
	
	private String descricao;
	
	private Estado(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}
