package com.complexivo3.vuelovg1c1.service;

import com.complexivo3.vuelovg1c1.dto.ContactoDto;
import com.complexivo3.vuelovg1c1.dto.ContactoRequest;
import com.complexivo3.vuelovg1c1.mapper.ContactoMapper;
import com.complexivo3.vuelovg1c1.model.Contacto;
import com.complexivo3.vuelovg1c1.repository.IContactoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ContactoService {

    private final IContactoRepository contactoRepository;

    @Transactional
    public void save(ContactoRequest request) {
        Contacto contacto = ContactoMapper.toContacto(request);
        contactoRepository.save(contacto);
    }

    @Transactional(readOnly = true)
    public List<ContactoDto> findAll() {
        return contactoRepository
                .findAll()
                .stream().map(ContactoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public void deleteById(long id) {
        if (contactoRepository.existsById(id))
            contactoRepository.deleteById(id);
    }

}
