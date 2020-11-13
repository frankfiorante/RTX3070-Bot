package com.frankfiorante.RTX3070Bot.error;

public class KeywordNotFoundException extends RuntimeException {
    public KeywordNotFoundException(String keyWord) { super(keyWord + " not found"); }
}
