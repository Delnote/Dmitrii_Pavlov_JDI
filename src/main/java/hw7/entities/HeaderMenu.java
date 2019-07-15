package hw7.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HeaderMenu {

    HEADER_MENU("Home", "Contact form", "Service", "Metals & Colors");

    private final String home;
    private final String contactForm;
    private final String service;
    private final String metalsAndColors;
}
