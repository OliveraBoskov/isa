package session;

import entity.User;

public interface UserDaoLocal extends GenericDaoLocal<User, Integer> {
	
	public User findUserWithEmail(String email);
	public User findUserWithEmailAndPassword(String email, String password);
}
