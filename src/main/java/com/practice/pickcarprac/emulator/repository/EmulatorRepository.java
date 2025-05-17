package com.practice.pickcarprac.emulator.repository;

import com.practice.pickcarprac.emulator.entity.Emulator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmulatorRepository extends JpaRepository<Emulator, Long> {
}
