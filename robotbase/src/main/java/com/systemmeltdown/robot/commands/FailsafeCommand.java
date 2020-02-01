package com.systemmeltdown.robot.commands;

import com.systemmeltdown.robot.subsystems.ClosedLoopSubsystem;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

/**
 * The failsafe: Kill all commands. For Safety ;D
 */
public class FailsafeCommand extends CommandBase {
    private boolean m_failsafeActive;
    private ClosedLoopSubsystem[] m_subsystems;

    /**
     * @param failsafeActive Pass in true if failsafe should be active, false if not.
     * @param subsystems All Subsystems you wish to trigger this failsafe command on.
     */
    public FailsafeCommand(boolean failsafeActive, ClosedLoopSubsystem[] subsystems) {
        m_failsafeActive = failsafeActive;
        m_subsystems = subsystems;
    }

    @Override
    public void initialize() {
        for (int i = 0; i < m_subsystems.length; i++) {
            m_subsystems[i].setClosedLoopEnabled(m_failsafeActive);
        }
        CommandScheduler.getInstance().cancelAll();
    }
  
    @Override
    public boolean isFinished() {
        return true;
    }
  }