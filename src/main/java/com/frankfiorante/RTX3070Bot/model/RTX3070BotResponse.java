package com.frankfiorante.RTX3070Bot.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RTX3070BotResponse {

    @Builder.Default
    private boolean keyWordFound = false;
}
