package com.mexpedition.service;

import com.mexpedition.dto.ExpeditionDTO;
import com.mexpedition.exception.ExpeditionNotFound;
import com.mexpedition.mapper.ExpeditionMapper;
import com.mexpedition.model.Expedition;
import com.mexpedition.repository.ExpeditionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ExpeditionService {
    private final ExpeditionRepository expeditionRepository;
    private final ExpeditionMapper expeditionMapper;

    public ExpeditionService(ExpeditionRepository expeditionRepository, ExpeditionMapper expeditionMapper) {
        this.expeditionRepository = expeditionRepository;
        this.expeditionMapper = expeditionMapper;
    }

    public List<ExpeditionDTO> getAllExpeditions() {
        return expeditionRepository.findAll().stream().map(expeditionMapper::fromEntityToDTO).toList();
    }

    public ExpeditionDTO getExpeditionById(Long id) throws ExpeditionNotFound {
        return expeditionRepository.findById(id)
                .map(expeditionMapper::fromEntityToDTO)
                .orElseThrow(() -> new ExpeditionNotFound("Expedition not found with ID: " + id));
    }

    public ExpeditionDTO getExpeditionByIdCommande(Integer idCommande) throws ExpeditionNotFound {
        return expeditionRepository.findByIdCommande(idCommande)
                .map(expeditionMapper::fromEntityToDTO)
                .orElseThrow(() -> new ExpeditionNotFound("Expedition not found with command ID: " + idCommande));
    }

    @Transactional
    public ExpeditionDTO createExpedition(ExpeditionDTO expeditionDTO) {
        Expedition expedition = expeditionMapper.fromDTOToEntity(expeditionDTO);
        Expedition savedExpedition = expeditionRepository.save(expedition);
        return expeditionMapper.fromEntityToDTO(savedExpedition);
    }

    @Transactional
    public ExpeditionDTO updateExpedition(Long id, ExpeditionDTO expeditionDTO) throws ExpeditionNotFound {
        Expedition existingExpedition = expeditionRepository.findById(id)
                .orElseThrow(() -> new ExpeditionNotFound("Expedition not found with ID: " + id));

        // Update existing expedition entity with data from DTO
        Expedition updatedExpedition = expeditionMapper.fromDTOToEntity(expeditionDTO);
        updatedExpedition.setId(existingExpedition.getId());

        // Save the updated expedition entity
        Expedition savedExpedition = expeditionRepository.save(updatedExpedition);

        // Map the saved entity back to DTO and return
        return expeditionMapper.fromEntityToDTO(savedExpedition);
    }
}
