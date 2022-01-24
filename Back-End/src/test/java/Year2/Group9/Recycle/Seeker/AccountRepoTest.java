package Year2.Group9.Recycle.Seeker;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class AccountRepoTest {

    @Autowired
    private AccountRepo repo;

    @Autowired
    private TestEntityManager entityManager;
    
    @Test
    public void testCreateAccount(){
        Accounts account = new Accounts();
        account.setEmail("Jatinder@gmail.com");
        account.setPassword("password");
        account.setFirstname("Jj");
        account.setSurname("Lewis");

        Accounts savedAccount = repo.save(account);

        Accounts existAccount = entityManager.find(Accounts.class, savedAccount.getId());

        assertThat(existAccount.getEmail()).isEqualTo(account.getEmail());




    }
    
}
