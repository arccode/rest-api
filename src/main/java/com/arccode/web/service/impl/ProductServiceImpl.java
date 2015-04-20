package com.arccode.web.service.impl;

import com.arccode.core.entity.ArcNotFoundException;
import com.arccode.core.util.ApplicationUtils;
import com.arccode.web.model.Product;
import com.arccode.web.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * ProductServiceImpl : 商品业务接口实现
 *
 * @author http://arccode.net
 * @since 2015-04-16 11:00
 */
@Service
public class ProductServiceImpl implements ProductService {

    private final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    // 临时存储商品列表, 模拟db中的表
    private List<Product> products = new ArrayList<Product>();

    // 收藏的商品, 模拟db中关联查出的收藏商品
    private List<Product> stars = new ArrayList<Product>();

    @Override
    public Product addModel(Product product) {

        // 生成id
        String id = "";
        if(products.size() >= 1) {
            id = ApplicationUtils.randomUUID();
        } else {
            id = "5308e9c2-a4ce-4dca-9373-cc1ffe63d5f9";
        }
        product.setId(id);
        products.add(product);

        return product;
    }

    @Override
    public Product getModelById(String id) {

        Product product = null;

        for (Product item: products) {
            if(item.getId().equals(id)) {
                product = item;
                break;
            }
        }

        if(product == null) {
            throw new ArcNotFoundException("指定产品不存在");
        }

        return product;
    }

    @Override
    public Product modifyModelById(Product product) {

        boolean flag = false;

        for (Product item: products) {
            if(item.getId().equals(product.getId())) {
                item.setName(product.getName());
                item.setDescription(product.getDescription());
                product = item;
                flag = true;
            }
        }

        if (!flag) {
            throw new ArcNotFoundException("id为[" + product.getId() +"]的商品不存在");
        }

        return product;
    }

    @Override
    public void removeModelById(String id) {

        Product toBeRemove = null;

        for (Product item: products) {
            if(item.getId().equals(id)) {
                toBeRemove = item;
            }
        }

        if (toBeRemove == null) {
            throw new ArcNotFoundException("id为[" + id +"]的商品不存在");
        }

        products.remove(toBeRemove);

    }

    @Override
    public List<Product> getModels() {
        return products;
    }

    @Override
    public List<Product> starProduct(String id) {

        for(Product item: products) {
            if (id.equals(item.getId())) {
                stars.add(item);
            }
        }
        return stars;
    }

    @Override
    public List<Product> unStarProduct(String id) {

        Product toBeUnStar = null;

        for(Product item: products) {
            if (id.equals(item.getId())) {
                toBeUnStar = item;
            }
        }

        if (toBeUnStar == null) {
            throw new ArcNotFoundException("id为[" + id +"]的商品不存在");
        }

        stars.remove(toBeUnStar);

        return stars;
    }
}
