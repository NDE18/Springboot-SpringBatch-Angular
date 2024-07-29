package com.nde.app.synchro.appSynchronisation;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppSynchronisationApplication implements CommandLineRunner {

	/*@Autowired
	private MysqlUserRepository userRepository;

	@Autowired
	private SqliteUserRepository sqliteUserRepository;*/

	public static void main(String[] args) {
		SpringApplication.run(AppSynchronisationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*if(CheckConnectionAccess.netIsAvailable()) {
			MysqlUserEntity user = new MysqlUserEntity(2, "rodo", "nde", "01/01/89", "email@email.com", "1234");
			userRepository.save(user);
		}
		else {
			SqliteUserEntity sqliteUser = new SqliteUserEntity(2, "rodo", "nde", "01/01/89", "email@email.com", "1234");
			sqliteUserRepository.save(sqliteUser);
		}
		try {
			Optional<SqliteUserEntity> sqliteUserEntity = sqliteUserRepository.findById(1);
			System.err.println(sqliteUserEntity.get().getFirstName());
		} catch (Exception e){
			System.err.print("NO DATA FOUND");
		}*/
	}
}
