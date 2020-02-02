package com.systemmeltdown.robot.commands;

import com.systemmeltdown.robot.subsystems.StorageSubsystem;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class RecountCellsCommand extends CommandBase {
    private final StorageSubsystem m_storageSub;

    public RecountCellsCommand(StorageSubsystem storageSub) {
        m_storageSub = storageSub;
        addRequirements(storageSub);
    }

    @Override
    public void execute() {
        int countOfCells = 0;
        for (int i = 0; i < 5; i++) {
            if (m_storageSub.isFeedSensorBlocked()) {
                countOfCells++;
            }
            new RotateStorageSingleCell(m_storageSub);
            i++;
        }
        m_storageSub.setNumOfCells(countOfCells);
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}