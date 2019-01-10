package cn.itcast.service.impl;

import cn.itcast.bos.domain.base.Standard;
import cn.itcast.bos.domain.common.ResponseResult;
import cn.itcast.dao.StandardDao;
import cn.itcast.service.StandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StandardServiceImpl implements StandardService {
    @Autowired
    private StandardDao standardDao;

    @Override
    public void save(Standard standard) {
            standardDao.save(standard);

    }
    @Override
    public void del(Integer[] ids){
        for (Integer id : ids) {
            standardDao.deleteById(id);
        }

    }

}
