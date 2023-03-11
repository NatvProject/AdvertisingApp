package kg.megacom.NatvProject.repositories;

import kg.megacom.NatvProject.models.entities.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdvertisementRepo extends JpaRepository<Advertisement, Long> {
    List<Advertisement> findAllByClientEmail(String clientEmail);
}
