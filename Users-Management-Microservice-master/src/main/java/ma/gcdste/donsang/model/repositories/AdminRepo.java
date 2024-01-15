package ma.gcdste.donsang.model.repositories;

import ma.gcdste.donsang.model.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<Admin,Long> {
}
