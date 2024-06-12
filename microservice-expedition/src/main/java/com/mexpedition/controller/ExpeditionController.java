package com.mexpedition.controller;

import com.mexpedition.dto.ExpeditionDTO;
import com.mexpedition.service.ExpeditionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class ExpeditionController {

    public static final String EXPEDITION_URI_PREFIX = "/expeditions";

    private final ExpeditionService expeditionService;

    public ExpeditionController(ExpeditionService expeditionService) {
        this.expeditionService = expeditionService;
    }

    @GetMapping(EXPEDITION_URI_PREFIX)
    public List<ExpeditionDTO> getExpeditions() {
        return expeditionService.getAllExpeditions();
    }

    @GetMapping(EXPEDITION_URI_PREFIX + "/{id}")
    public ExpeditionDTO getExpeditionById(@PathVariable Long id) {
        return expeditionService.getExpeditionById(id);
    }

    @PostMapping(EXPEDITION_URI_PREFIX)
    public ResponseEntity<ExpeditionDTO> createExpedition(@RequestBody ExpeditionDTO expeditionDTO) {
        ExpeditionDTO createdExpedition = expeditionService.createExpedition(expeditionDTO);
        URI location = URI.create(EXPEDITION_URI_PREFIX + "/" + createdExpedition.getId());
        return ResponseEntity.created(location).body(createdExpedition);
    }

    @PutMapping(EXPEDITION_URI_PREFIX + "/{id}")
    public ExpeditionDTO updateExpedition(@PathVariable Long id, @RequestBody ExpeditionDTO expedition) {
        return expeditionService.updateExpedition(id, expedition);
    }
}
