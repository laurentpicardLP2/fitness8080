package laurent.fitness.services;

import java.util.List;

import laurent.fitness.model.Seance;

public interface SeanceService {
	public List<Seance> getAllSeances();
	public Seance createSeance(int idCommand, String username, float price);
	public Seance updateSeance(Seance seance);
	public void deleteSeance(int idItem);
	public Seance findSeanceById(int idItem);
}
