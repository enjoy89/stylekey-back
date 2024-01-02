package com.thekey.stylekeyserver.stylepoint.service;

import com.thekey.stylekeyserver.brand.domain.Brand;
import com.thekey.stylekeyserver.brand.repository.BrandRepository;
import com.thekey.stylekeyserver.exception.ErrorMessage;
import com.thekey.stylekeyserver.stylepoint.domain.StylePoint;
import com.thekey.stylekeyserver.stylepoint.dto.UpdateStylePointRequestDto;
import com.thekey.stylekeyserver.stylepoint.repository.StylePointRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class StylePointAdminServiceImpl implements StylePointAdminService {

    private final StylePointRepository stylePointRepository;
    private final BrandRepository brandRepository;

    @Override
    public StylePoint findById(Long id) {
        return stylePointRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NOT_FOUND_STYLEPOINT.get() + id));
    }

    @Override
    public List<StylePoint> findAll() {
        return stylePointRepository.findAll();
    }

    @Override
    public StylePoint update(Long id, UpdateStylePointRequestDto requestDto) {
        StylePoint stylePoint = stylePointRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NOT_FOUND_STYLEPOINT.get() + id));

        stylePoint.update(requestDto.getTitle(),
                requestDto.getDescription(),
                requestDto.getImage());

        return stylePoint;
    }

    @Override
    public List<Brand> getBrandsByStylePointId(Long id) {
        StylePoint stylePoint = stylePointRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NOT_FOUND_STYLEPOINT.get() + id));

        return brandRepository.findBrandByStylePoint(stylePoint);
    }

}
