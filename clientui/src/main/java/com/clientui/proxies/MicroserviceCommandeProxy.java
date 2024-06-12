package com.clientui.proxies;

import com.clientui.beans.CommandeBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "zuul-server")
@RibbonClient(name = "microservice-commandes")
public interface MicroserviceCommandeProxy {
    String COMMAND_URI_PREFIX = "/microservice-commandes/commandes";

    @PostMapping(value = COMMAND_URI_PREFIX)
    CommandeBean ajouterCommande(@RequestBody CommandeBean commande);
}
