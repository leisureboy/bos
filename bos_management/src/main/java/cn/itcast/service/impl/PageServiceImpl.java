package cn.itcast.service.impl;

import cn.itcast.bos.domain.base.Standard;
import cn.itcast.dao.PageDao;
import cn.itcast.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
@Service
public class PageServiceImpl implements PageService {
    @Autowired
    private PageDao pageDao;

    @Override
    public Page<Standard> findByPage(org.springframework.data.domain.Pageable pageable) {
        return   pageDao.findAll(pageable);
    }


}
