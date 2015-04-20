package com.arccode.web.controller.api;

import com.alibaba.fastjson.JSON;
import com.arccode.core.entity.ArcResponse;
import com.arccode.web.model.Product;
import com.arccode.web.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * ProductAPI : 商品数据api
 *
 * @author http://arccode.net
 * @since 2015-04-16 10:58
 */
@Controller
@RequestMapping("/api")
public class ProductAPI {

    private final Logger logger = LoggerFactory.getLogger(ProductAPI.class);

    @Resource
    private ProductService productService;


    //////////////////////////////////////////
    //商品api数据接口
    //////////////////////////////////////////

    /**
     * 新增商品
     * @param product
     * @return
     */
    @RequestMapping(value = "/product", method = RequestMethod.POST)
    @ResponseBody
    public ArcResponse<Product> addProduct(@RequestBody Product product) {

        productService.addModel(product);

        // 包装返回的数据
        return new ArcResponse<Product>(HttpStatus.CREATED.value(), "创建成功", product);
    }

    /**
     * 获取单个商品详情
     * @param id
     * @return
     */
    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ArcResponse<Product> product(@PathVariable("id") String id) {

        Product product = productService.getModelById(id);

        return new ArcResponse<Product>(HttpStatus.OK.value(), "查询成功", product);
    }

    /**
     * 编辑产品
     * @param id
     * @param product
     * @return
     */
    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ArcResponse<Product> modifyProduct(@PathVariable("id") String id,
                                              @RequestBody Product product) {

        product.setId(id);
        Product result = productService.modifyModelById(product);

        return new ArcResponse<Product>(HttpStatus.OK.value(), "修改成功", result);
    }

    /**
     * 删除商品
     * @param id
     * @return
     */
    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ArcResponse<Product> removeProduct(@PathVariable("id") String id) {

        productService.removeModelById(id);

        ArcResponse<Product> arc = new ArcResponse<Product>(HttpStatus.NO_CONTENT.value(), "删除成功");

        return arc;
    }

    /**
     * 获取所有商品
     * @return
     */
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    @ResponseBody
    public ArcResponse<List> products() {

        List products = productService.getModels();

        ArcResponse<List> arc = new ArcResponse<List>(HttpStatus.OK.value(), "获取全部商品成功", products);

        return arc;
    }

    //////////////////////////////////////////
    //用户商品关系api数据接口
    //////////////////////////////////////////

    /**
     * 收藏商品, 返回收藏列表
     * @param id
     * @return
     */
    @RequestMapping(value = "/products/{id}/star", method = RequestMethod.PUT)
    @ResponseBody
    public ArcResponse<List> star(@PathVariable("id") String id) {

        List products = productService.starProduct(id);

        ArcResponse<List> arc = new ArcResponse<List>(HttpStatus.OK.value(), "收藏商品[" + id +"]成功", products);

        return arc;
    }

    /**
     * 删除收藏商品, 返回收藏列表
     * @param id
     * @return
     */
    @RequestMapping(value = "/products/{id}/star", method = RequestMethod.DELETE)
    @ResponseBody
    public ArcResponse<List> unStar(@PathVariable("id") String id) {

        List products = productService.unStarProduct(id);

        ArcResponse<List> arc = new ArcResponse<List>(HttpStatus.OK.value(), "删除收藏商品[" + id +"]成功", products);

        return arc;
    }
}
