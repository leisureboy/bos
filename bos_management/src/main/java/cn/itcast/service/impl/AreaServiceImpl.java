package cn.itcast.service.impl;

import cn.itcast.bos.domain.base.Area;
import cn.itcast.dao.AreaDao;
import cn.itcast.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaDao areaDao;
    @Override
    public void saveBatch(List<Area> areas){
        areaDao.saveAll(areas);
    }
}
