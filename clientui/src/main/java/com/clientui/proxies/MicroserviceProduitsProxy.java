package com.clientui.proxies;

import com.clientui.beans.ProductBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "zuul-server")
@RibbonClient(name = "microservice-produits")
public interface MicroserviceProduitsProxy {
    String PRODUCT_URI_PREFIX = "/microservice-produits/Produits";

    @GetMapping(value = PRODUCT_URI_PREFIX)
    List<ProductBean> listeDesProduits();

    /*
     * Notez ici la notation @PathVariable("id") qui est différente de celle qu'on utlise dans le contrôleur
     **/
    @GetMapping(value = PRODUCT_URI_PREFIX + "/{id}")
    ProductBean recupererUnProduit(@PathVariable("id") int id);


}
