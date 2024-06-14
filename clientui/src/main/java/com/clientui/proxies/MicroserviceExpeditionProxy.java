package com.clientui.proxies;

import com.clientui.beans.ExpeditionBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("zuul-server")
@RibbonClient("microservice-expedition")
public interface MicroserviceExpeditionProxy {
    String EXPEDITION_URI_PREFIX = "/microservice-expedition/expeditions";

    @GetMapping(EXPEDITION_URI_PREFIX)
    List<ExpeditionBean> getExpeditions();

    @GetMapping(EXPEDITION_URI_PREFIX + "/{id}")
    ExpeditionBean getExpeditionById(@PathVariable Long id);

    @GetMapping(EXPEDITION_URI_PREFIX + "/command/{idCommand}")
    ExpeditionBean getExpeditionByIdCommande(@PathVariable Integer idCommand);

    @PostMapping(EXPEDITION_URI_PREFIX)
    ResponseEntity<ExpeditionBean> createExpedition(@RequestBody ExpeditionBean expeditionDTO);

    @PutMapping(EXPEDITION_URI_PREFIX + "/{id}")
    ExpeditionBean updateExpedition(@PathVariable Long id, @RequestBody ExpeditionBean expedition);
}