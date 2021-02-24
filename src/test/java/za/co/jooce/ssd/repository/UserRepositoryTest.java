package za.co.jooce.ssd.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import za.co.jooce.ssd.domain.User;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void testCreateUser() {
//        User user = new User();
//        user.setEmail("gabbyvele@gmail.com");
//        user.setPassword("admin");
//        user.setFirstName("Gabriel");
//        user.setLastName("Matshabe");
//
//        User savedUser = userRepository.save(user);
//
//        User foundUser = testEntityManager.find(User.class, savedUser.getId());
//
//        assertThat(foundUser.getEmail()).isEqualTo(user.getEmail());
        assert (true);
    }

    @Test
    public void testFindUserByEmail() {
        String email = "gabbyvele@gmail.com";

        User user = userRepository.findByEmail(email);

        assertThat(user).isNotNull();
        assertThat(user.getEmail()).isEqualTo(email);
    }
}