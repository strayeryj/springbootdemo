package com.example.demo.repository;

import com.example.demo.repository.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
@Mapper
public interface IUserMapper {
    public abstract UserDto selectUserById(String id);
    public abstract List selectUsers();
    public abstract Integer updateUserById(String name, String id);
    public abstract Integer insertUser(UserDto userDto);
    public abstract Integer deleteUser(String id);
    public abstract Integer insertBatch(List list);
}
