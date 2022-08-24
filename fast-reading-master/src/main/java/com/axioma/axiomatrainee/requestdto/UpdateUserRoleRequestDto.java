package com.axioma.axiomatrainee.requestdto;

import com.axioma.axiomatrainee.model.user.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UpdateUserRoleRequestDto {
    private Long userId;
    private Role role;
}
