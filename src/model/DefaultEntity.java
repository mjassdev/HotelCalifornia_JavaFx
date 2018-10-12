package model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;

@MappedSuperclass
public class DefaultEntity <T>{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqidcliente")
	@SequenceGenerator(name = "seqidcliente", sequenceName = "seqidcliente", allocationSize = 1)
	private Integer id;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}