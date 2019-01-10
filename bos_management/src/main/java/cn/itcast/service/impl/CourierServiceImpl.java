package cn.itcast.service.impl;

import cn.itcast.bos.domain.base.Courier;
import cn.itcast.dao.CourierDao;
import cn.itcast.service.CourierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourierServiceImpl implements CourierService {

    @Autowired
    private CourierDao courierDao;

    @Override
    public void save(Courier courier) {
        courierDao.save(courier);
    }
}