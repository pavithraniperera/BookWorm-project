package lk.ijse.Bo.custom.Boimpl;

import lk.ijse.Bo.custom.UserBo;
import lk.ijse.Dao.custom.UserDao;
import lk.ijse.Dao.custom.daoImpl.UserDaoImpl;
import lk.ijse.dto.UserDto;
import lk.ijse.entity.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserBoImpl implements UserBo {
    private final UserDao userDao = new UserDaoImpl();

    @Override
    public void saveUser(UserDto userDto) throws SQLException {
              userDao.save(new User(userDto.getName(), userDto.getEmail(), userDto.getPassword()));
    }

    @Override
    public List<UserDto> getAllUsers() throws SQLException {
        List<UserDto> dtoList = new ArrayList<>();
        List<User> entities = userDao.loadAll();
        for (User user : entities){
            dtoList.add(new UserDto(user.getName(), user.getEmail(), user.getPassword()));
        }
        return dtoList;
    }

    @Override
    public UserDto getUser(String email) throws SQLException {
        User user = userDao.get(email);
        return  new UserDto(user.getUserId(), user.getName(), user.getEmail(), user.getPassword());
    }

    @Override
    public void updateUser(UserDto dto) throws SQLException {
        userDao.update(new User(dto.getUserId(), dto.getName(), dto.getEmail(), dto.getPassword()));

    }

    @Override
    public UserDto getUserById(int id) throws SQLException {
      User user =  userDao.getbyId(id);
      return new UserDto(user.getName(), user.getEmail(), user.getPassword());
    }

    @Override
    public void deleteUser(int id) throws SQLException {
        userDao.delete(id);

    }
}