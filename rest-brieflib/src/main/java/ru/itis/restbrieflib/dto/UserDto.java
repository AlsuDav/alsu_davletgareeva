package ru.itis.restbrieflib.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.restbrieflib.models.FileInfo;
import ru.itis.restbrieflib.models.User;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private String name;
    private Long id;
    private String email;
    private FileInfo photo;
    private String phoneNumber;

    public static UserDto from(User user) {
        return UserDto.builder()
                .name(user.getName())
                .email(user.getEmail())
                .id(user.getId())
                .photo(user.getPhoto())
                .phoneNumber(user.getPhoneNumber())
                .build();
    }
    public static List<UserDto> from(List<User> users) {
        return users.stream()
                .map(UserDto::from)
                .collect(Collectors.toList());
    }
}
