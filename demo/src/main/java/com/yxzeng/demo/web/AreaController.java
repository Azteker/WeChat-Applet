package com.yxzeng.demo.web;

import com.yxzeng.demo.entity.Area;
import com.yxzeng.demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/superadmin")
public class AreaController {
    @Autowired
    private AreaService areaService;

    @RequestMapping(value = "/listarea", method = RequestMethod.GET)
    private Map<String, Object> listArea(){
        Map<String, Object> modelMap=new HashMap<>();
        List<Area> list=areaService.getAreaList();
        modelMap.put("areaList",list);
        return modelMap;
    }

    @RequestMapping(value = "/getareabyid", method = RequestMethod.GET)
    private Map<String, Object> getAreaById(int areaId){
        Map<String, Object> modelMap=new HashMap<>();
        Area area=areaService.getAreaById(areaId);
        modelMap.put("area",area);
        return modelMap;
    }

    @PostMapping(value = "/addarea")
    private Map<String, Object> addArea(@RequestBody Area area){
        Map<String, Object> modelMap=new HashMap<>();
        modelMap.put("success",areaService.addArea(area));
        return modelMap;
    }

    @PostMapping(value = "/modifyarea")
    private Map<String, Object> modifyArea(@RequestBody Area area){
        Map<String, Object> modelMap=new HashMap<>();
        modelMap.put("success",areaService.modifyArea(area));
        return modelMap;
    }

    @GetMapping(value = "removearea")
    private Map<String, Object> removeArea(int areaId){
        Map<String, Object> modelMap=new HashMap<>();
        modelMap.put("success",areaService.deleteArea(areaId));
        return modelMap;
    }
}
