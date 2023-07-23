package com.hms.demo.service.impl;

import com.hms.demo.model.Position;
import com.hms.demo.repository.PositionRepository;
import com.hms.demo.service.PositionService;
import com.hms.demo.service.utils.MappingHelper;
import com.hms.demo.web.dto.request.PositionReq;
import com.hms.demo.web.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PositionServiceImpl implements PositionService {
    private final PositionRepository positionRepository;
    private final MappingHelper mappingHelper;

    @Override
    public List<Position> getAllPosition() {
        return positionRepository.findAll();
    }

    @Override
    public Position getPositionById(Integer id) {
        return positionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Position.class.getName()
                        , id.toString()));
    }

    @Override
    public void createPosition(PositionReq positionReq) {
        var res = mappingHelper.map(positionReq, Position.class);
        positionRepository.save(res);
    }

    @Override
    public void updatePosition(Integer id, PositionReq positionReq) {
        var Position = positionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Position.class.getName()
                        , id.toString()));
        mappingHelper.copyProperties(positionReq, Position);
        positionRepository.save(Position);
    }

    @Override
    public void removePosition(Integer id) {
        positionRepository.deleteById(id);
    }
}
