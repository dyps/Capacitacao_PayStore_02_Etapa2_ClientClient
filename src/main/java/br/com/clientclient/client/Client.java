package br.com.clientclient.client;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder(builderClassName = "Builder")
@Table(name = "TB_Client")
public class Client implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ClientSeq")
	@SequenceGenerator(name = "ClientSeq", sequenceName = "CLIENT_SEQ", allocationSize = 1)
	@NotNull //para validar ao ser puxado pela compra
	private Long id;

	private String name;
	private Integer age;
	private String telephone;
	@Email
	private String email;
	@Enumerated(EnumType.STRING)
	private Sex sex;


	public static Client to(@Valid ClientDTO clientDTO) {
		return Client.builder()
				.id(clientDTO.getId())
				.name(clientDTO.getName())
				.age(clientDTO.getAge())
				.telephone(clientDTO.getTelephone())
				.email(clientDTO.getEmail())
				.sex(clientDTO.getSex())
				.build();
	}

}
