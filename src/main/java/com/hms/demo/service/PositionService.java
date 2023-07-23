package com.hms.demo.service;

import com.hms.demo.model.Position;
import com.hms.demo.web.dto.request.PositionReq;

import java.util.List;

public interface PositionService {
    List<Position> getAllPosition();

    Position getPositionById(Integer id);

    void createPosition(PositionReq positionReq);

    void updatePosition(Integer id, PositionReq positionReq);

    void removePosition(Integer id);
}
