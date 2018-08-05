package com.wyldkat.expman.controller;

import com.google.common.base.Strings;
import com.wyldkat.expman.dto.BaseDto;
import com.wyldkat.expman.dto.DtoMapper;
import com.wyldkat.expman.dto.IdOnlyDto;
import com.wyldkat.expman.exception.InvalidParameterException;
import com.wyldkat.expman.model.OwnedBaseEntity;
import com.wyldkat.expman.modules.security.JwtTokenUtil;
import com.wyldkat.expman.service.IOwnedEntityService;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

/**
 * Created by Jos&eacute; Batista on 01/11/2016.
 */
public class BaseOwnedEntityController<E extends OwnedBaseEntity, D extends BaseDto, M extends DtoMapper<D, E>, S extends IOwnedEntityService<E>> {

    private final M mapper;
    private final S service;
    private final JwtTokenUtil jwtTokenUtil;

    BaseOwnedEntityController(M mapper, S service, JwtTokenUtil jwtTokenUtil) {
        this.mapper = mapper;
        this.service = service;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @PostMapping()
    public ResponseEntity<BaseDto> createEntityForCurrentUser(HttpServletRequest request, @RequestBody D dto) {

        if (!Strings.isNullOrEmpty(dto.getId())) {
            throw new InvalidParameterException("You should not set the id");
        }

        E baseEntity = mapper.mapDtoToEntity(dto);

        E saved = service.createForUser(baseEntity, jwtTokenUtil.getUsernameFromRequest(request));

        return ResponseEntity.ok(new IdOnlyDto(Long.toString(saved.getId())));
    }

    @PostMapping(value = "remove")
    public ResponseEntity<Void> removeEntityForCurrentUser(HttpServletRequest request, @RequestBody BaseDto dto) {
        Long accountIdLong = Long.valueOf(dto.getId());
        getCurrentUserEntityById(request, accountIdLong);
        service.removeForUser(accountIdLong, jwtTokenUtil.getUsernameFromRequest(request));

        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "edit")
    public ResponseEntity<BaseDto> updateAccountForCurrentUser(HttpServletRequest request, @RequestBody D dto) {
        getCurrentUserEntityById(request, Long.valueOf(dto.getId()));

        service.saveForUser(mapper.mapDtoToEntity(dto), jwtTokenUtil.getUsernameFromRequest(request));

        return ResponseEntity.ok(new BaseDto(dto.getId()));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<D> getCurrentUserEntityById(HttpServletRequest request, @PathVariable Long id) {
        Optional<E> account = service.loadByOwnerAndId(jwtTokenUtil.getUsernameFromRequest(request), id);
        return ResponseEntity.ok(mapper.mapEntityToDto(account.orElseThrow(ResourceNotFoundException::new)));
    }

    @GetMapping()
    public ResponseEntity<List<D>> getCurrentUserEntityList(HttpServletRequest request) {
        String username = jwtTokenUtil.getUsernameFromRequest(request);
        return ResponseEntity.ok(mapper.mapEntityListToDtoList(service.loadAllByOwner(username)));
    }
}
