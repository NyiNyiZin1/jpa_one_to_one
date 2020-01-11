package com.nnz.onetoone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nnz.onetoone.model.Gender;
import com.nnz.onetoone.model.User;
import com.nnz.onetoone.model.UserProfile;
import com.nnz.onetoone.repository.UserProfileRepository;
import com.nnz.onetoone.repository.UserRepository;

import java.util.Calendar;

@SpringBootApplication
public class JpaOnetooneApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
    private UserProfileRepository userProfileRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaOnetooneApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Clean up database tables
		//userProfileRepository.deleteAllInBatch();
		//userRepository.deleteAllInBatch();

		//=========================================

		// Create a User instance
		User user = new User("nyi", "nyizin", "nyinyi@gmail.com",
				"MY_SUPER_SECRET_PASSWORD");

		Calendar dateOfBirth = Calendar.getInstance();
		dateOfBirth.set(1992, 7, 21);

		// Create a UserProfile instance
		UserProfile userProfile = new UserProfile("09400540427", Gender.MALE, dateOfBirth.getTime(),
				"747", "2nd Cross", "YaDaNar Road, Kodihalli", "Yangon",
				"Yangon", "Myanmar", "560008");


		// Set child reference(userProfile) in parent entity(user)
		user.setUserProfile(userProfile);

		// Set parent reference(user) in child entity(userProfile)
		userProfile.setUser(user);

		// Save Parent Reference (which will save the child as well)
		userRepository.save(user);

		//=========================================
	}


}
