package laurent.fitness.services;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import laurent.fitness.model.User;

public interface UserService {
	public List<User> getAllUsers();
	
	public User saveUser(User user);
	
	public void deleteUser(User user);
	
	public int findByUsernameIdMax();
	
	public User findByUsername(String username);

}
