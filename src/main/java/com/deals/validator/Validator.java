package com.deals.validator;

import com.deals.dto.DealsDto;
import org.springframework.stereotype.Component;

@Component
public interface Validator {

    void validate(DealsDto request);
}
