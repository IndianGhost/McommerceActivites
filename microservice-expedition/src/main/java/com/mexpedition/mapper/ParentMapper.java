package com.mexpedition.mapper;

public interface ParentMapper<T, D> {
    D fromEntityToDTO(T entity);

    T fromDTOToEntity(D dto);
}
