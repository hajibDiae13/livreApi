package com.example.RestApi.repos;
import com.example.RestApi.entities.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LivreRepo extends JpaRepository<Livre, Integer> {
	List<Livre> findByOrderByTitleAsc();
}
