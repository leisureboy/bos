package cn.itcast.repository;

import cn.itcast.bos.domain.user.User;

public interface UserRepository extends BaseRepository<User,Long>{
    User findByName(String name);
}