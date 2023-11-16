package umc.spring.repository.region;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.region.Region;

public interface RegionRepository extends JpaRepository<Region, Long> {
}
