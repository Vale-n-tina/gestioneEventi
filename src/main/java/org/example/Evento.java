package org.example;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Evento")
public class Evento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name="titolo")
	private String titolo;
	@Column(name="data_evento")
	private LocalDate dataEvento;
	@Column(name = "tipo_evento")
	private String tipoEvento;
	@Column(name = "numero_massimo_partecipanti")
	private int massimoPartecipanti;
	@Column(name = "descrizione")
	private String descrizione;

	public Evento(){

	}

	public Evento(LocalDate dataEvento, int massimoPartecipanti, String tipoEvento, String titolo, String descrizione) {
		this.dataEvento = dataEvento;
		this.massimoPartecipanti = massimoPartecipanti;
		this.tipoEvento = tipoEvento;
		this.titolo = titolo;
		this.descrizione=descrizione;
	}

	public long getId() {
		return id;
	}

	public int getMassimoPartecipanti() {
		return massimoPartecipanti;
	}

	public void setMassimoPartecipanti(int massimoPartecipanti) {
		this.massimoPartecipanti = massimoPartecipanti;
	}

	public String getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(String tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public LocalDate getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(LocalDate dataEvento) {
		this.dataEvento = dataEvento;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
}
