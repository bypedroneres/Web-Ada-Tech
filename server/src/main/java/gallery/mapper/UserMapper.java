package gallery.mapper;

import gallery.domain.dto.user.UserPostDTO;
import gallery.domain.dto.user.UserPutDTO;
import gallery.domain.dto.user.UserResponseDTO;
import gallery.domain.entities.User;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponseDTO toResponseDto (User user);

    User postDtoToEntity(UserPostDTO userPostDTO);

    User putDtoToEntity(UserPutDTO userPutDTO);
}
