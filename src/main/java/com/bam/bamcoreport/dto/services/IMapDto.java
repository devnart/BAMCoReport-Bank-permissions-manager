package com.bam.bamcoreport.dto.services;

import java.util.Collection;
import java.util.List;

public interface IMapDto <E,D>{
    D convertToDto(E entity, Class<D> dtoClass);

    E convertToEntity(D dto, Class<E> entityClass);

    List<D> convertListToListDto(Collection<E> entityList, Class<D> outCLass);
}
