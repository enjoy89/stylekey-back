package com.thekey.stylekeyserver.brand.service;

import com.thekey.stylekeyserver.brand.domain.Brand;
import com.thekey.stylekeyserver.brand.dto.CreateBrandRequestDto;
import com.thekey.stylekeyserver.brand.dto.UpdateBrandRequestDto;
import java.util.List;

public interface BrandAdminService {

    Brand create(CreateBrandRequestDto requestDto);
    Brand findById(Long id);
    List<Brand> findAll();
    Brand update(Long id, UpdateBrandRequestDto requestDto);
    void delete(Long id);

}
