package com.frasatodev.ticall.repositories;

import com.frasatodev.ticall.models.Call;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CallRepository extends JpaRepository<Call, UUID> {}
