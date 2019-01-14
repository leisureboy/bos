package cn.itcast.service.impl;

import cn.itcast.bos.domain.base.Area;
import cn.itcast.bos.domain.base.Courier;
import cn.itcast.bos.domain.base.Standard;
import cn.itcast.dao.AreaDao;
import cn.itcast.dao.CourierDao;
import cn.itcast.dao.PageDao;
import cn.itcast.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


@Service
public class PageServiceImpl implements PageService {
    @Autowired
    private PageDao pageDao;
    @Autowired
    private CourierDao courierDao;
    @Autowired
    AreaDao areaDao;



    @Override
    public Page<Standard> findByPage(Pageable pageable) {
        return   pageDao.findAll(pageable);
    }
    @Override
  public Page<Courier> pageQuery(Specification<Courier> specification, Pageable pageable){
       return courierDao.findAll(specification,pageable);

    }
    @Override
    public Page<Area> findArea(Pageable pageable) {
        return   areaDao.findAll(pageable);
    }


}
