package sk.ukf.restapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sk.ukf.restapi.dao.ZamestanciRepository;
import sk.ukf.restapi.entity.zamestanci;
import sk.ukf.restapi.exception.EmailAlreadyExistsException;
import sk.ukf.restapi.exception.ObjectNotFoundException;

import java.util.List;

@Service
public class ZamestanciServiceImpl implements zamestanciService {
    private ZamestanciRepository zamestanciRepository;

    @Autowired
    public ZamestanciServiceImpl(ZamestanciRepository zamestanciRepository) {
        this.zamestanciRepository = zamestanciRepository;
    }

    @Override
    public List<zamestanci> findAll() {
        return zamestanciRepository.findAll();
    }

    @Override
    public zamestanci findById(int id) {
        return zamestanciRepository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public zamestanci save(zamestanci zamestanci) {
        if (zamestanciRepository.existsByEmail(zamestanci.getEmail())) {
            throw new EmailAlreadyExistsException(zamestanci.getEmail());
        }
        return zamestanciRepository.save(zamestanci);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        zamestanciRepository.deleteById(id);
    }
}
