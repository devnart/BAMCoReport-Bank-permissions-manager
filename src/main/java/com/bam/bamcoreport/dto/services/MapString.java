package com.bam.bamcoreport.dto.services;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MapString<S,E> {

    @Autowired
    private ModelMapper modelMapper;

    public E convertToEntity(S mapString, Class<E> entityClass) {
        if(mapString == null)
            return null;

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT).setPropertyCondition(Conditions.isNotNull());
        return modelMapper.map(mapString, entityClass);
    }
}
