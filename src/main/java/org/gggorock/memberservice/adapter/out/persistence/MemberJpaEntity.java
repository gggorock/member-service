package org.gggorock.memberservice.adapter.out.persistence;

import jakarta.persistence.*;
import lombok.*;
import org.gggorock.memberservice.domain.Member;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "member")
@ToString
@EqualsAndHashCode
public class MemberJpaEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    @Getter
    private Long id;

    @Column(name = "user_name", nullable = false)
    private String username;

    @Column(name = "emain", nullable = false, unique = true, updatable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    private String profileImage;

    @ElementCollection(targetClass = Member.Authority.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "authority")
    @Column(name = "authority")
    private List<Member.Authority> authorities = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private Member.Status status;

    @Builder
    private MemberJpaEntity(Long id,
                            String username,
                            String email,
                            String password,
                            String profileImage,
                            List<Member.Authority> authorities,
                            Member.Status status) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.profileImage = profileImage;
        this.authorities = authorities;
        this.status = status;
    }

    static MemberJpaEntity from(Member member){
        return MemberJpaEntity.builder()
                .id(member.getId())
                .username(member.getUsername())
                .email(member.getEmail())
                .password(member.getPassword())
                .profileImage(member.getProfileImage())
                .authorities(member.getAuthorities())
                .status(member.getStatus())
                .build();
    }



}
