# LFR
```mermaid
flowchart TD
    subgraph Initialization
        Start[Start] --> InitializeOLED[Initialize OLED Display]
        InitializeOLED --> InitializeButtons[Initialize Buttons]
        InitializeButtons --> InitializeQTR[Initialize QTR Sensors]
        InitializeQTR --> InitializeMotors[Initialize Motor Drivers]
        InitializeMotors --> InitializeUltrasonic[Initialize Ultrasonic Sensors]
        InitializeUltrasonic --> MainLoop[Main Loop]
    end

    subgraph mainLoop
        MainLoop --> CheckRunning{Is Running?}
        CheckRunning -->|Yes| ReadButtons[Read Button States]
        ReadButtons --> CheckLineChange[Check for Line Change]
        CheckLineChange --> ReadQTRValues[Read QTR Sensor Values]
        ReadQTRValues --> ConvertToDigital[Convert Analog to Digital]
        ConvertToDigital --> StoreValues[Store Digital Values]
        StoreValues --> CheckStringPath{Is String Path Active?}
        CheckStringPath -->|Yes| StringFollow[String Follow Logic]
        CheckStringPath -->|No| PriorityLogic[Priority Logic]
        StringFollow --> ShortMove[Short Move]
        ShortMove --> RotateBasedOnPath[Rotate Based on Path]
        RotateBasedOnPath --> FollowLinePID[Follow Line Using PID]
        PriorityLogic --> CheckRotationSigns[Check for Rotation Signs]
        CheckRotationSigns --> Rotate[Left Rotate or Right Rotate]
        Rotate --> FollowLinePID
        FollowLinePID --> CheckBox[Check for Box]
        CheckBox --> StopOnBox[Stop if Box Detected<br/>state = run]
        StopOnBox --> CheckCaveEscape[Check for Cave Escape]
        CheckCaveEscape --> EscapeCave[Escape Cave if Needed]
        EscapeCave --> MainLoop
    end

    subgraph DisplayLogic
        CheckRunning -->|No| DisplayMenu[Display Menu]
        DisplayMenu --> CheckState{State?}
        CheckState -->|displayName| DisplayName[Display Name<br/>state = displayName]
        CheckState -->|home| DisplayHome[Display Home Menu<br/>state = home]
        CheckState -->|lfrMenu| DisplayLFR[Display LFR Menu<br/>state = lfrMenu]
        CheckState -->|run| DisplayRun[Display Run Menu<br/>state = run]
        CheckState -->|inputString| DisplayInputString[Display Input String<br/>state = inputString]
        CheckState -->|Speed| DisplaySpeed[Display Speed Menu<br/>state = Speed]
        DisplayName --> MainLoop
        DisplayHome --> MainLoop
        DisplayLFR --> MainLoop
        DisplayRun --> MainLoop
        DisplayInputString --> MainLoop
        DisplaySpeed --> MainLoop
    end
