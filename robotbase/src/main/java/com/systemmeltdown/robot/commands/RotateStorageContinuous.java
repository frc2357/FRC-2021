package com.systemmeltdown.robot.commands;
import com.systemmeltdown.robot.subsystems.StorageSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

/*
* This command will rotate the storage carousel continuously to shoot all cells
*/

public class RotateStorageContinuous extends CommandBase {
    private StorageSubsystem m_storageSubsystem;

    public RotateStorageContinuous(StorageSubsystem storageSubsystem) {
        m_storageSubsystem = storageSubsystem;
        addRequirements(m_storageSubsystem);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}