package com.axioma.axiomatrainee.requestdto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserRatingRequestDto {
    private int ratingIncNumber;
    private Long userId;
}
