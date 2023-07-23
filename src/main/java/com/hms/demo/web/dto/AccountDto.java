package com.hms.demo.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AccountDto {
    private Integer id;
    private String username;
    private String email;
    private String authority;
}
