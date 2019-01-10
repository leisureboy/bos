package cn.itcast.dao;

import cn.itcast.bos.domain.base.Standard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PageDao extends JpaRepository<Standard,Integer> {
}
