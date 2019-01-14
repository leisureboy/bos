package cn.itcast.dao;

import cn.itcast.bos.domain.base.Area;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AreaDao extends JpaRepository<Area,String> {
}
