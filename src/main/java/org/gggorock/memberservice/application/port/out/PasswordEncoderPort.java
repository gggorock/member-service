package org.gggorock.memberservice.application.port.out;

public interface PasswordEncoderPort {

    String encode(String password);
}
