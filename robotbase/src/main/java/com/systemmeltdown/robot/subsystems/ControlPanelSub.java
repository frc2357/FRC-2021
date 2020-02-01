package com.systemmeltdown.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Solenoid;

public class ControlPanelSub extends ClosedLoopSubsystem {
    //color sensor
    //boolean m_useClosedLoop; I could not find any references of this, but VS code was not giving me any warnings, so I'm going to leave that there.

    WPI_TalonSRX m_rotationTalon;
    Solenoid m_extenderSolenoid;
    boolean m_extenderPosition = false;
    private int m_clicksPerRotation;

    public ControlPanelSub(int channel, int rotationTalonID) {
        m_rotationTalon = new WPI_TalonSRX(rotationTalonID);
        m_extenderSolenoid = new Solenoid(channel);
    }

    @Override
    public void periodic() {
        // nothing
    }

    // carbon copy of IntakeSubs changeArmPosition.
    public void changeExtenderPosition() {
        if (m_extenderPosition) {
            m_extenderSolenoid.set(false);
            m_extenderPosition = false;
        } else {
            m_extenderSolenoid.set(true);
            m_extenderPosition = true;
        }
    }

    public void setClicksPerRotation(int clicksPerRotation) {
        m_clicksPerRotation = clicksPerRotation;
    }

    public int getRotations() {
        return  m_clicksPerRotation / m_rotationTalon.getSelectedSensorPosition();
    }

    public void rotateControlPanel(double fullRotationsToDo) {
        m_rotationTalon.set(ControlMode.Position, m_clicksPerRotation * fullRotationsToDo);
    }
}