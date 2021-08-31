package tds.project.test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "url")
public class URL {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="url_sequence")
	@SequenceGenerator(name="url_sequence", sequenceName="url_seq", allocationSize=1)
	private Long id;
	
	@Column(name="original")
	private String original;
	
	@Column(name="encurtada")
	private String encurtada;
	
	@Column(name="encurtada")
	private Integer valorUrlEncurtada;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOriginal() {
		return original;
	}

	public void setOriginal(String original) {
		this.original = original;
	}

	public String getEncurtada() {
		return encurtada;
	}

	public void setEncurtada(String encurtada) {
		this.encurtada = encurtada;
	}

	public Integer getValorUrlEncurtada() {
		return valorUrlEncurtada;
	}

	public void setValorUrlEncurtada(Integer valorUrlEncurtada) {
		this.valorUrlEncurtada = valorUrlEncurtada;
	}
	
}
