package com.practice.pickcarprac.emulator.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Emulator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private boolean isRunning;

    public Emulator(String code) {
        this.code = code;
        this.isRunning = false;
    }

    public void turnOn(Emulator emulator) {
        if (emulator.isRunning) {
            throw new IllegalStateException("애뮬레이터가 이미 켜져 있습니다.");
        }
        emulator.isRunning = true;
    }

    public void turnOff(Emulator emulator) {
        if (!emulator.isRunning) {
            throw new IllegalStateException("애뮬레이터가 이미 꺼져 있습니다.");
        }
        emulator.isRunning = false;
    }
}
