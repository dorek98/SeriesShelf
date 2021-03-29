package com.dorek98.service.actor;

import com.dorek98.dto.ActorDetails;
import com.dorek98.mapper.ActorMapper;
import com.dorek98.repository.ActorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
@Transactional(readOnly = true)
public class ActorQueryHandlerImpl implements ActorQueryHandler {

    private final ActorRepository actorRepository;
    private final ActorMapper actorMapper;

    @Override
    public List<ActorDetails> findAll() {
        return actorMapper.listToDetails(actorRepository.findAll());
    }

    @Override
    public ActorDetails findById(long id) {
        return actorMapper.createActorDetails(actorRepository.getOne(id));
    }
}
