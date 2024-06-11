package com.mexpedition.mapper;

import com.mexpedition.config.GlobalMapperConfig;
import com.mexpedition.dto.ExpeditionDTO;
import com.mexpedition.model.Expedition;
import org.mapstruct.Mapper;

@Mapper(config = GlobalMapperConfig.class)
public interface ExpeditionMapper extends ParentMapper<Expedition, ExpeditionDTO> {
}