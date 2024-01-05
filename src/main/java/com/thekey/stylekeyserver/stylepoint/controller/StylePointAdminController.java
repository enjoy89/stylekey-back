package com.thekey.stylekeyserver.stylepoint.controller;

import com.thekey.stylekeyserver.brand.domain.Brand;
import com.thekey.stylekeyserver.stylepoint.domain.StylePoint;
import com.thekey.stylekeyserver.stylepoint.dto.StylePointRequestDto;
import com.thekey.stylekeyserver.stylepoint.service.StylePointAdminService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "StylePoint", description = "StylePoint API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/style-points")
public class StylePointAdminController {

    private final StylePointAdminService stylePointAdminService;

    @GetMapping("/{id}")
    @Operation(summary = "Read One StylePoint", description = "스타일포인트 단건 정보 조회")
    public ResponseEntity<Map<String, Object>> getStylePoint(@PathVariable Long id) {
        Optional<StylePoint> optional = Optional.ofNullable(stylePointAdminService.findById(id));

        return optional.map(stylePoint -> {
            List<Brand> brands = stylePointAdminService.getBrandsByStylePointId(id);

            return ResponseEntity.ok(Map.of(
                    "stylePoint", stylePoint,
                    "brand", brands
            ));
        }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    @Operation(summary = "Read All StylePoint", description = "스타일포인트 전체 정보 조회.")
    public ResponseEntity<List<StylePoint>> getStylePoints() {
        List<StylePoint> stylePoints = stylePointAdminService.findAll();

        return Optional.of(stylePoints)
                .filter(list -> !list.isEmpty())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NO_CONTENT).body(stylePoints));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update StylePoint", description = "스타일포인트 정보 수정")
    public ResponseEntity<StylePoint> update(@PathVariable Long id,
                                             @io.swagger.v3.oas.annotations.parameters.RequestBody(
                                                     content = @Content(
                                                             examples = {
                                                                     @ExampleObject(name = "example", value = """
                                                                                                                      {
                                                                                                                          "id": 1,
                                                                                                                          "title": "Unique2",
                                                                                                                          "description": "변화하는 트렌드를 반영하여 평범하지 않고 개성있는 디테일을 추구하는 스타일",
                                                                                                                          "image": "https://stylekeybucket.s3.ap-northeast-2.amazonaws.com/stylepoint/%E1%84%8B%E1%85%B2%E1%84%82%E1%85%B5%E1%84%8F%E1%85%B3%E1%84%91%E1%85%A9%E1%84%8B%E1%85%B5%E1%86%AB%E1%84%90%E1%85%B3.png"
                                                                                                                      }
                                                                             """)
                                                             }
                                                     )

                                             )
                                             @RequestBody StylePointRequestDto requestDto) {

        if (id == null) {
            return ResponseEntity.badRequest().build();
        }

        Optional<StylePoint> optional = Optional.ofNullable(stylePointAdminService.update(id, requestDto));
        return optional.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
