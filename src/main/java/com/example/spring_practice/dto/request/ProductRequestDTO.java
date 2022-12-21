package com.example.spring_practice.dto.request;

import lombok.*;
import javax.validation.constraints.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDTO {

    @NotBlank(message = "상품명은 필수 입력 값입니다.")
    @Size(min = 0, max = 45, message = "상품명은 45자 이하로 입력 가능합니다.")
    private String name;

    @NotNull(message = "상품 상세 설명은 필수 입력 값입니다.")
    @Size(min = 0, max = 100, message = "상품 상세 설명은 100자 이하로 입력 가능합니다.")
    private String info;
}
