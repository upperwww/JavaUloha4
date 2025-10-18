package sk.ukf.restapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.ukf.restapi.entity.zamestanci;

public interface ZamestanciRepository extends org.springframework.data.jpa.repository.JpaRepository<zamestanci, Integer> {}

