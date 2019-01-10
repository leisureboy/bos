package cn.itcast.service;

import cn.itcast.bos.domain.base.Standard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface PageService {


    public Page<Standard> findByPage (Pageable pageable);


}
