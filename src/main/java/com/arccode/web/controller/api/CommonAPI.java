package com.arccode.web.controller.api;

import com.arccode.web.bean.SelectBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * CommonAPI : 用于地址等数据的下发
 *
 * @author http://arccode.net
 * @since 2015-04-16 11:41
 */
@Controller
@RequestMapping("/api")
public class CommonAPI {


    @RequestMapping(value = "/selects", method = RequestMethod.GET)
    @ResponseBody
    public List selects() {

        List<SelectBean> selectBeans = new ArrayList<SelectBean>();
        SelectBean addBean = new SelectBean("/rest/api/product", "新增商品");
        selectBeans.add(addBean);
        SelectBean getBean = new SelectBean("/rest/api/products/5308e9c2-a4ce-4dca-9373-cc1ffe63d5f9", "获取商品详情");
        selectBeans.add(getBean);
        SelectBean modifyBean = new SelectBean("/rest/api/products/5308e9c2-a4ce-4dca-9373-cc1ffe63d5f9", "修改商品");
        selectBeans.add(modifyBean);
        SelectBean removeBean = new SelectBean("/rest/api/products/5308e9c2-a4ce-4dca-9373-cc1ffe63d5f9", "删除商品");
        selectBeans.add(removeBean);
        SelectBean beans = new SelectBean("/rest/api/products", "获取所有商品");
        selectBeans.add(beans);

        SelectBean starBean = new SelectBean("/rest/api/products/5308e9c2-a4ce-4dca-9373-cc1ffe63d5f9/star", "收藏商品");
        selectBeans.add(starBean);
        SelectBean unStarBean = new SelectBean("/rest/api/products/5308e9c2-a4ce-4dca-9373-cc1ffe63d5f9/star", "删除收藏商品");
        selectBeans.add(unStarBean);

        return selectBeans;
    }
}
