package figueiredoisaac.finsoft.repository;

import figueiredoisaac.finsoft.models.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}
