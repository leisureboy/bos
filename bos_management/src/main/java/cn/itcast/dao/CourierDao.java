package cn.itcast.dao;

import cn.itcast.bos.domain.base.Courier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface CourierDao extends JpaRepository<Courier,Integer>,JpaSpecificationExecutor<Courier> {
    @Modifying
    @Query(value = "update Courier set deltag='1' where id=?1")
    @Transactional
   public void UpdateDelTag(Integer id);
}
