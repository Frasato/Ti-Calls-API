package com.frasatodev.ticall.repositories;

import com.frasatodev.ticall.models.EndCall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EndCallRepository extends JpaRepository<EndCall, UUID> {}
