package kg.megacom.NatvProject.repositories;

import kg.megacom.NatvProject.models.entities.Banner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BannerRepo extends JpaRepository<Banner, Long> {
    List<Banner> findAllByClientEmail(String clientEmail);
}
