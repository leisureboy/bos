package cn.itcast.controller;

import cn.itcast.bos.domain.base.Area;
import cn.itcast.bos.domain.base.Courier;
import cn.itcast.bos.domain.base.Standard;
import cn.itcast.service.AreaService;
import cn.itcast.service.PageService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.*;
import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/page")
public class PageController {
    @Autowired
   private PageService pageService;
    @Autowired
   private PageService areaService;
    @RequestMapping("/find")
    public Map findByPage(int page, int rows){
        if (page<1){
            page=1;
        }
        if (rows<1){
            rows=5;
        }
        Pageable pageable= new PageRequest(page-1,rows);
        Page<Standard> pageDate = pageService.findByPage(pageable);
        Map<String,Object> result=new HashMap<String,Object>();
        result.put("total",pageDate.getTotalElements());
        result.put("rows",pageDate.getContent());
        return result;
    }

    @RequestMapping("/pageQuery")
    public Map pageQuery(int page, int rows, Courier courier){
        if (page<1){
            page=1;
        }
        if (rows<1){
            rows=5;
        }
        Pageable pageable= new PageRequest(page-1,rows);
    //查询条件
        Specification specification=new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list=new ArrayList<Predicate>();
                if(StringUtils.isNotBlank(courier.getCourierNum())){
                    Predicate p1=criteriaBuilder.equal(root.get("courierNum").as(String.class),courier.getCourierNum());
                        list.add(p1);
                }
                if(StringUtils.isNotBlank(courier.getCompany())){
                    Predicate p2=criteriaBuilder.equal(root.get("company").as(String.class),"%"+courier.getCompany()+"%");
                    list.add(p2);
                } if(StringUtils.isNotBlank(courier.getType())){
                    Predicate p3=criteriaBuilder.equal(root.get("type").as(String.class),courier.getType());
                    list.add(p3);
                }
                Join<Courier,Standard> standardJoin=root.join("standard",JoinType.INNER);
                if(courier.getStandard()!=null&&StringUtils.isNotBlank(courier.getStandard().getName())){
                    Predicate p4=criteriaBuilder.equal(root.get("name").as(String.class),"%"+courier.getStandard().getName()+"%");
                    list.add(p4);
                }


                return criteriaBuilder.and(list.toArray(new Predicate[0]));
            }
        };



        Page<Courier> pageDate = pageService.pageQuery(specification,pageable);
        Map<String,Object> result=new HashMap<String,Object>();
        result.put("total",pageDate.getTotalElements());
        result.put("rows",pageDate.getContent());
        return result;
    }


    @RequestMapping("/area")
    public Map findArea(int page, int rows){
        if (page<1){
            page=1;
        }
        if (rows<1){
            rows=5;
        }
        Pageable pageable= new PageRequest(page-1,rows);;
        Page<Area> pageDate = areaService.findArea(pageable);
        Map<String,Object> result=new HashMap<String,Object>();
        result.put("total",pageDate.getTotalElements());
        result.put("rows",pageDate.getContent());
        return result;
    }
}