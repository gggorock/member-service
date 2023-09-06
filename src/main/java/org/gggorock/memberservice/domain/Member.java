package org.gggorock.memberservice.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
@EqualsAndHashCode
public class Member {

    private Long id;

    private String username;

    private String email;

    private String password;

    private String profileImage;

    private List<Authority> authorities = new ArrayList<>();

    private Status status;

    @Builder
    private Member(Long id,
                  String username,
                  String email,
                  String password,
                  String profileImage,
                  List<Authority> authorities,
                  Status status) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.profileImage = profileImage;
        this.authorities = authorities;
        this.status = status;
    }

    public static Member create(String username,
                                  String email,
                                  String password,
                                  String profileImage) {
        return Member.builder()
                .username(username)
                .email(email)
                .password(password)
                .profileImage(profileImage)
                .authorities(List.of(Authority.USER))
                .status(Status.ACTIVE)
                .build();
    }

    public static Member load(Long id,
                              String username,
                              String email,
                              String password,
                              String profileImage,
                              List<Authority> authorities,
                              Status status) {
        return Member.builder()
                .id(id)
                .username(username)
                .email(email)
                .password(password)
                .profileImage(profileImage)
                .authorities(authorities)
                .status(status)
                .build();
    }

    public enum Authority {
        ADMIN,
        USER,
    }

    public enum Status {
        ACTIVE,
        INACTIVE,
        BLOCKED,
        DELETED,
    }

}
