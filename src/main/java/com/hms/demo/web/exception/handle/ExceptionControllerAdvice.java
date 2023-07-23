package com.hms.demo.web.exception.handle;

import com.hms.demo.web.dto.response.utils.ErrorResponse;
import com.hms.demo.web.dto.response.utils.Response;
import com.hms.demo.web.dto.response.utils.ResponseUtils;
import com.hms.demo.web.exception.EntityNotFoundException;
import com.hms.demo.web.exception.ServiceException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class ExceptionControllerAdvice {

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Response> unknownErrorHandler(Exception e) {
        log.error("Unexpected Exception", e);
        String errKey = "err.sys.unexpected-exception";
        String errMsg = "Unknown error";
        return ResponseUtils.internalErr(ErrorResponse.of(errKey, errMsg));
    }

    @ExceptionHandler({ServiceException.class})
    public ResponseEntity<Response> ServiceErrorHandler(ServiceException e) {
        String errKey = e.getMessage();
        String errMsg = e.getErrMsg();
        log.error(errKey, errMsg);
        return ResponseUtils.badRequest(ErrorResponse.of(errKey, errMsg));
    }

    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<Response> EntityNotFoundErrorHandler(EntityNotFoundException e) {
        String errKey = e.getMessage();
        String errMsg = "Can not find " + e.getEntityName() + " with id: " + e.getEntityId();
        log.error(errKey, errMsg);
        return ResponseUtils.badRequest(ErrorResponse.of(errKey, errMsg));
    }

}
