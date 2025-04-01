package com.ibe6.section03.dto;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class CategoryDto {

    public int categoryCode;
    public String categoryName;
    public int refCategoryCode;
}
