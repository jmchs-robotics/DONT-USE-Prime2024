package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public class Constants {

    public static final class DrivetrainMotorIDs {

        public static final int FRONT_LEFT_DRIVE = 11;
        public static final int FRONT_LEFT_ANGLE = 12;

        public static final int FRONT_RIGHT_DRIVE = 21;
        public static final int FRONT_RIGHT_ANGLE = 22;

        public static final int BACK_LEFT_DRIVE = 31;
        public static final int BACK_LEFT_ANGLE = 32;

        public static final int BACK_RIGHT_DRIVE = 41;
        public static final int BACK_RIGHT_ANGLE = 42;

    }

    public static final class DrivetrainConstants {

        public static final int WIDTH = 29; //in inches
        public static final int LENGTH = 29; //in inches

    }

}

