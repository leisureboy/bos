package cn.itcast.service;

import cn.itcast.bos.domain.base.Courier;
import cn.itcast.bos.domain.base.Standard;

public interface CourierService {
    public void save(Courier courier);

    public void del(Integer[] ids);
}
