package com.thekey.stylekeyserver.stylepoint.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StylePointRepository extends JpaRepository<StylePoint, Long> {
}
