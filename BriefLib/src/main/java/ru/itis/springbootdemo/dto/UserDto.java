package ru.itis.springbootdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.springbootdemo.models.FileInfo;
import ru.itis.springbootdemo.models.User;

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

    public static UserDto from(User user) {
        return UserDto.builder()
                .name(user.getName())
                .email(user.getEmail())
                .id(user.getId())
                .photo(user.getPhoto())
                .build();
    }
    public static List<UserDto> from(List<User> users) {
        return users.stream()
                .map(UserDto::from)
                .collect(Collectors.toList());
    }
}
