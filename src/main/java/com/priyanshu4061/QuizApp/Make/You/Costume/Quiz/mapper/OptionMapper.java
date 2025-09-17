package com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.mapper;

import com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.dto.OptionsDto;
import com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.entity.Option;

public class OptionMapper {
    public static Option toEntity(OptionsDto optionsDto){
        Option option = new Option();
        option.setOptionId(optionsDto.getOptionId());
        option.setOptionText(optionsDto.getOptionText());
        option.setCorrect(optionsDto.isCorrect());

        return option;
    }

    public static OptionsDto toDto(Option option){
        OptionsDto optionsDto = new OptionsDto();

        optionsDto.setOptionId(option.getOptionId());
        optionsDto.setOptionText(option.getOptionText());

        return optionsDto;
    }
}
