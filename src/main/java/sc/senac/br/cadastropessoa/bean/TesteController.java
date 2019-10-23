package sc.senac.br.cadastropessoa.bean;

import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import sc.senac.br.cadastropessoa.model.Estado;

@ViewScoped
@ManagedBean
public class TesteController {
	
	private Estado estado;
	private List<Estado> estados;
	
	private int linguagem;
	
	private boolean confirmado;
	
	private List<Integer> linguagens;
	
	public TesteController() {
//		estados = new ArrayList<>();
//		for (Estado e : Estado.values()) {
//			estados.add(e);
//		}
		estados = Arrays.asList(Estado.values());
	}
	
	public void enviar() {
		System.out.println(estado);
		System.out.println(linguagem);
		System.out.println(confirmado);
		System.out.println(linguagens);
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}
	
	public int getLinguagem() {
		return linguagem;
	}
	
	public void setLinguagem(int linguagem) {
		this.linguagem = linguagem;
	}

	public boolean isConfirmado() {
		return confirmado;
	}
	
	public void setConfirmado(boolean confirmado) {
		this.confirmado = confirmado;
	}
	
	public List<Integer> getLinguagens() {
		return linguagens;
	}
	
	public void setLinguagens(List<Integer> linguagens) {
		this.linguagens = linguagens;
	}
	
}
