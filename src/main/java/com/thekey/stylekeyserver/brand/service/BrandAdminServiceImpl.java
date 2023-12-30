package com.thekey.stylekeyserver.brand.service;

import com.thekey.stylekeyserver.brand.domain.Brand;
import com.thekey.stylekeyserver.brand.domain.BrandRepository;
import com.thekey.stylekeyserver.brand.dto.CreateBrandRequestDto;
import com.thekey.stylekeyserver.brand.dto.UpdateBrandRequestDto;
import com.thekey.stylekeyserver.exception.ErrorMessage;
import com.thekey.stylekeyserver.stylepoint.domain.StylePoint;
import com.thekey.stylekeyserver.stylepoint.domain.StylePointRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class BrandAdminServiceImpl implements BrandAdminService {

    private final BrandRepository brandRepository;
    private final StylePointRepository stylePointRepository;

    @Override
    public Brand create(CreateBrandRequestDto requestDto) {
        StylePoint stylePoint = findStylePoint(requestDto.getStylePointId());
        return brandRepository.save(requestDto.toEntity(stylePoint));
    }

    @Override
    public Brand findById(Long id) {
        return brandRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NOT_FOUND_BRAND.get() + id));
    }

    @Override
    public List<Brand> findAll() {
        return brandRepository.findAll();
    }

    @Override
    public Brand update(Long id, UpdateBrandRequestDto requestDto) {
        Brand brand = brandRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NOT_FOUND_BRAND.get() + id));
        StylePoint stylePoint = findStylePoint(requestDto.getStylePointId());

        brand.update(requestDto.getTitle(),
                requestDto.getTitle_eng(),
                requestDto.getDescription(),
                requestDto.getSite_url(),
                requestDto.getImage(),
                requestDto.toEntity(stylePoint).getStylePoint());

        return brand;
    }

    @Override
    public void delete(Long id) {
        brandRepository.deleteById(id);
    }

    private StylePoint findStylePoint(Long id) {
        return stylePointRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        ErrorMessage.NOT_FOUND_STYLEPOINT.get() + id));
    }
}
