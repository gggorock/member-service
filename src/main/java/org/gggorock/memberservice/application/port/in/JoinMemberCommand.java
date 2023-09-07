package org.gggorock.memberservice.application.port.in;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import org.gggorock.memberservice.application.port.out.PasswordEncoderPort;
import org.gggorock.memberservice.domain.Member;
import org.hibernate.validator.constraints.URL;

@Builder
public record JoinMemberCommand(
        @NotBlank(message = "Username cannot be blank")
        @Size(min = 4, max = 30, message = "Username must be between 4 and 50 characters")
        String username,

        @NotBlank(message = "Email cannot be blank")
        @Email(message = "Email should be valid")
        String email,

        @NotBlank(message = "Password cannot be blank")
        @Size(min = 8, max = 128, message = "Password must be between 8 and 128 characters")
        String password,

        @URL(message = "Profile image should be a valid URL")
        String profileImage
) {
        public Member toDomainEntity(PasswordEncoderPort passwordEncoder){
                return Member.create(username, email, passwordEncoder.encode(password), profileImage);
        }
}
