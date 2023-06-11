package gr.upatras.ceid.backend.domain.dto;

public record UserDto(
        String id,
        String username,
        String password,
        String email
) {
}
