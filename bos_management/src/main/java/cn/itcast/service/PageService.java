package cn.itcast.service;

import cn.itcast.bos.domain.base.Area;
import cn.itcast.bos.domain.base.Courier;
import cn.itcast.bos.domain.base.Standard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;


public interface PageService {


    public Page<Standard> findByPage (Pageable pageable);


    Page<Courier> pageQuery(Specification<Courier> specification, Pageable pageable);

    public Page<Area> findArea(Pageable pageable);
}
