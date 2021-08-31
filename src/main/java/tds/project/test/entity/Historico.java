package tds.project.test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "url")
public class Historico {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="historico_sequence")
	@SequenceGenerator(name="historico_sequence", sequenceName="historico_seq", allocationSize=1)
	private Long id;
	
	@ManyToOne
	private URL url;
	
	@Column(name="qtdAcessos")
	private Integer qtdAcessos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public URL getUrl() {
		return url;
	}

	public void setUrl(URL url) {
		this.url = url;
	}

	public Integer getQtdAcessos() {
		return qtdAcessos;
	}

	public void setQtdAcessos(Integer qtdAcessos) {
		this.qtdAcessos = qtdAcessos;
	}
	
}
