package lk.ijse.Bo.custom;

import lk.ijse.dto.UserDto;

import java.sql.SQLException;
import java.util.List;

public interface UserBo {


    void saveUser(UserDto userDto) throws SQLException;

    List<UserDto> getAllUsers() throws SQLException;

    UserDto getUser(String email) throws SQLException;

    void updateUser(UserDto dto) throws SQLException;

    UserDto getUserById(int id) throws SQLException;

    void deleteUser(int id) throws SQLException;
}
