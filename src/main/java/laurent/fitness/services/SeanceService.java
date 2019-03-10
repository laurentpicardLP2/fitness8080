package laurent.fitness.services;

import java.util.List;

import laurent.fitness.model.Seance;

public interface SeanceService {
	public List<Seance> getAllSeances();
	public Seance saveSeance(Seance seance);
}
