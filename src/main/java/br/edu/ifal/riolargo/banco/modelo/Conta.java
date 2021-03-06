package br.edu.ifal.riolargo.banco.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Conta {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Double saldo;
	
	@Column(nullable=false, unique=true)
	private String numero;
	
	@OneToMany(
			mappedBy="conta",
			cascade = CascadeType.ALL,
			orphanRemoval = true
			)
	private List<Transacao> transacoes = new ArrayList<>();

	@ManyToMany( mappedBy="contas" )
	private List<Cliente> clientes = new ArrayList<>();
	
	@OneToMany( mappedBy="conta" )
	private List<Cartao> cartoes = new ArrayList<>();
	
	public List<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	public void addCliente(Cliente cliente) {
		this.clientes.add(cliente);
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public List<Transacao> getTransacoes() {
		return transacoes;
	}
	public void setTransacoes(List<Transacao> transacoes) {
		this.transacoes = transacoes;
	}
	public List<Cartao> getCartoes() {
		return cartoes;
	}
	public void setCartoes(List<Cartao> cartoes) {
		this.cartoes = cartoes;
	}
	
}
