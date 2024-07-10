package com.fumoliteratura.literatura.models;

public enum Idiomas {
    ESPAÑOL("es"),
    INGLES("en"),
    JAPONES("ja"),
    PORTUGUES("pt"),
    FRANCES("fr"),
    FINLANDES("fi"),
    ITALIANO("it"),
    CHINO("zh"),
    COREANO("ko");
    private String idioma;
    Idiomas(String idioma){
        this.idioma=idioma;
    }
    public static Idiomas fromString(String idiomaLibro){
        for (Idiomas idioma : Idiomas.values()){
            if (idioma.idioma.equalsIgnoreCase(idiomaLibro)){
                return idioma;
            }
        }

        throw new IllegalArgumentException("Idioma no encontrado: "+idiomaLibro);
    }

    public String getIdioma() {
        return idioma;
    }
}
