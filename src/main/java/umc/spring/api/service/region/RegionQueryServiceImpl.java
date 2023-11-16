package umc.spring.api.service.region;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.repository.region.RegionRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RegionQueryServiceImpl implements RegionQueryService {

    private final RegionRepository regionRepository;
    @Override
    public boolean existsById(Long id) {
        return regionRepository.existsById(id);
    }
}
