package com.practice.emulator.repository;

import com.practice.emulator.model.entity.Emulator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmulatorRepository extends JpaRepository<Emulator, Long> {
    List<Emulator> findAllByIsRunningTrue();
}
