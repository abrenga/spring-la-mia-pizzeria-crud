package it.lamiapizzeria.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name="Menu")
public class ModelofmenuDB{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;


	@Column(name="type_of_pizza", nullable=false)
	@NotNull(message="please enter a value")
	@NotBlank(message="please enter a value")
	private String name;

	@Column(name="descrizione", nullable=false)
	@NotNull(message="please enter a value")
	@NotBlank(message="please enter a value")
	private String descrizione;

	@Column(name="url", nullable=true)
	private String urlPhoto;

	@Column(name="prezzo", nullable=false)
	@NotNull(message="please enter a value")
	private float prezzo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getUrlPhoto() {
		return urlPhoto;
	}

	public void setUrlPhoto(String urlPhoto) {
		this.urlPhoto = urlPhoto;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}





}