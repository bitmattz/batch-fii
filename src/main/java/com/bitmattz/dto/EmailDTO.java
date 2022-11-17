package com.bitmattz.dto;

import com.bitmattz.models.Fii;
import com.bitmattz.models.User;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class EmailDTO {
    private User user;
    private Fii fii;

    private String to;
    private String message;
}
