package org.example;

import jakarta.persistence.EntityManager;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
	public static void main(String[] args) {
		EntityManager entity = EntityManagerUtil.getEntityManager();
		try {
			//creiamo un evento nel DB

			entity.getTransaction().begin();
			Evento evento1 = new Evento(LocalDate.of(2025, 03, 10), 400, "pubblico", "mucca Assassina", "evento fotonico");
			entity.persist(evento1);
			entity.getTransaction().commit();
			System.out.println("persona creata con ID: " + evento1.getId());


			// troviamo un evento tramite ID

			long idMuccaAssassina = evento1.getId();
			entity.getTransaction().begin();
			Evento eventoRecuperato = entity.find(Evento.class, idMuccaAssassina);
			entity.getTransaction().commit();

			if (eventoRecuperato != null) {
				System.out.println("Evento trovato: " + eventoRecuperato.getTitolo() + " Tipo di evento: " + eventoRecuperato.getTipoEvento());
			} else {
				System.out.println("Evento con id:" + idMuccaAssassina + "non trovata");
			}

			//Eliminare un evento tramite ID

			entity.getTransaction().begin();
			Evento eventoDaEliminare = entity.find(Evento.class, idMuccaAssassina);
			if(eventoDaEliminare!=null){
				entity.remove(eventoDaEliminare);
				System.out.println("Evento con ID: " + eventoDaEliminare.getId() + " eliminato");
			}else{
				System.out.println("evento con id:" + eventoDaEliminare.getId());
			}
			entity.getTransaction().commit();

		} catch (Exception e) {
			System.out.println("errore ");
			if(entity.getTransaction().isActive()){
				entity.getTransaction().rollback();
			}
			e.printStackTrace();
		} finally {
			entity.close();
		}

	}
}