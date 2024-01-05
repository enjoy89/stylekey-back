package com.thekey.stylekeyserver.stylepoint.service;

import com.thekey.stylekeyserver.brand.domain.Brand;
import com.thekey.stylekeyserver.stylepoint.domain.StylePoint;
import com.thekey.stylekeyserver.stylepoint.dto.StylePointRequestDto;
import java.util.List;

public interface StylePointAdminService {

    StylePoint findById(Long id);

    List<StylePoint> findAll();

    StylePoint update(Long id, StylePointRequestDto requestDto);

    List<Brand> getBrandsByStylePointId(Long id);
}
