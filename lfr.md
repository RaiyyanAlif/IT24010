flowchart TD
    Start[Power On] --> InitPins[Initialize Motor & Sensor Pins]
    InitPins --> CalibSensors[Calibrate IR Sensors<br/>Read baseline values]
    CalibSensors --> WaitStart[Wait for Start Button]
    WaitStart --> CheckStart{Start Button Pressed?}
    CheckStart -->|No| WaitStart
    CheckStart -->|Yes| SetPIDGains[Set PID Constants<br/>Kp, Ki, Kd]
    SetPIDGains --> MainLoop[Enter Main Loop]

    subgraph PIDLoop [PID Line Following Loop]
        MainLoop --> ReadIR[Read Left & Right IR Sensors]
        ReadIR --> CalcError[Calculate Error<br/>error = Left - Right]
        CalcError --> PIDCalc[Calculate PID Output<br/>P = Kp * error<br/>I += Ki * error<br/>D = Kd * (error - lastError)]
        PIDCalc --> ComputeMotor[Compute Motor Speeds<br/>baseSpeed = 150<br/>leftSpeed = baseSpeed + PIDoutput<br/>rightSpeed = baseSpeed - PIDoutput]
        ComputeMotor --> Constrain[Constrain Speeds to 0-255]
        Constrain --> DriveMotors[Drive L298N<br/>Left: leftSpeed<br/>Right: rightSpeed]
        DriveMotors --> UpdateError[Update lastError = error]
        UpdateError --> MainLoop
    end
