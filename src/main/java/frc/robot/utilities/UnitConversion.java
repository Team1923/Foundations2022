package frc.robot.utilities;

public class UnitConversion {
    public static double nativeUnitstoRPM(double nativeUnits) {
      return (nativeUnits * 600) / 2048.0;
    }
  
    public static double RPMtoNativeUnits(double RPM) {
      return (RPM / 600) * 2048.0;
    }
  
    // position, FalconFX.
    public static double positionRotsToNativeUnits(double rots) {
      return rots * 2048;
    }
  
    public static double positionNativeToRots(double nativeUnits) {
      return nativeUnits / 2048;
    }
  
    public static double inchesToMeters(double inches) {
      return inches / 39.37;
    }
  }
  