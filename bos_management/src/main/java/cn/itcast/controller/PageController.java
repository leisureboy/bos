package cn.itcast.controller;

import cn.itcast.bos.domain.base.Standard;
import cn.itcast.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/page")
public class PageController {
    @Autowired
    PageService pageService;
    @RequestMapping("/find")
    public Map findByPage(int page, int rows){
        if (page<1){
            page=1;
        }
        if (rows<1){
            rows=5;
        }
        Pageable pageable= PageRequest.of(page-1,rows);
        Page<Standard> pageDate = pageService.findByPage(pageable);
        Map<String,Object> result=new HashMap<String,Object>();
        result.put("total",pageDate.getTotalElements());
        result.put("rows",pageDate.getContent());
        return result;
    }
}