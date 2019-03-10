package laurent.fitness.services;

import java.util.List;

import org.springframework.stereotype.Service;

import laurent.fitness.model.Seance;
import laurent.fitness.repository.SeanceRepository;

@Service
public class SeanceServiceImpl implements SeanceService {
	private SeanceRepository seanceRepo;
	
	public SeanceServiceImpl(SeanceRepository seanceRepo) {
		this.seanceRepo = seanceRepo;
	}

	@Override
	public List<Seance> getAllSeances() {
		// TODO Auto-generated method stub
		return this.seanceRepo.findAll();
	}

	@Override
	public Seance saveSeance(Seance seance) {
		// TODO Auto-generated method stub
		return this.seanceRepo.save(seance);
	}

}
