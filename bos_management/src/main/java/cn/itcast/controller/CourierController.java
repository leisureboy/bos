package cn.itcast.controller;

import cn.itcast.bos.domain.base.Courier;
import cn.itcast.bos.domain.common.ResponseResult;
import cn.itcast.service.CourierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courier")
public class CourierController {
    @Autowired
   private CourierService courierService;
    @RequestMapping("/save")
    public ResponseResult save (Courier courier){
        try {
            courierService.save(courier);
            return ResponseResult.SUCCESS();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseResult.FAIL();
        }

    }

    @RequestMapping("/del")
    public ResponseResult del(Integer[] ids){
        try {
            courierService.del(ids);
            return ResponseResult.SUCCESS();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseResult.FAIL();
        }
    }

}
