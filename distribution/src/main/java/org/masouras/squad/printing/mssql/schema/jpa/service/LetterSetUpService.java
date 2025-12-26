package org.masouras.squad.printing.mssql.schema.jpa.service;

import lombok.RequiredArgsConstructor;
import org.masouras.squad.printing.mssql.schema.jpa.entity.LetterSetUpEntity;
import org.masouras.squad.printing.mssql.schema.jpa.entity.LetterSetUpKey;
import org.masouras.squad.printing.mssql.schema.jpa.repository.LetterSetUpRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LetterSetUpService {
    private final LetterSetUpRepository letterSetUpRepository;

    public LetterSetUpEntity findById(LetterSetUpKey key) {
        return letterSetUpRepository.findById(key).orElse(null);
    }
    public LetterSetUpEntity save(LetterSetUpEntity entity) {
        return letterSetUpRepository.save(entity);
    }
}
