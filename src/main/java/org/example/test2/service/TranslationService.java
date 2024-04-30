package org.example.test2.service;

import lombok.RequiredArgsConstructor;
import org.example.test2.config.Translator;
import org.springframework.stereotype.Service;

import static org.example.test2.constants.TranslatorCode.GREETINGS;

@Service
@RequiredArgsConstructor
public class TranslationService {

    private final Translator translator;

    public String translate() {
        return translator.toLocale(GREETINGS);
    }
}
