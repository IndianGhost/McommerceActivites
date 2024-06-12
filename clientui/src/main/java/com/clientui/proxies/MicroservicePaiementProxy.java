package com.clientui.proxies;

import com.clientui.beans.PaiementBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "zuul-server")
@RibbonClient(name = "microservice-paiement")
public interface MicroservicePaiementProxy {
    String PAYMENT_URI_PREFIX = "/microservice-paiement/paiement";

    @PostMapping(value = PAYMENT_URI_PREFIX)
    ResponseEntity<PaiementBean> payerUneCommande(@RequestBody PaiementBean paiement);
}
