package teamcode.Susbsystems;

public final class ArmConstants {

    public static class ARM_POSITIONS{

        public static class PIVOT{

            public static int HOME_POSITION = 0;
            public static int SCORE_POSITION = 100;
            public static int GRAB_POSITION = -100;
            public static int STACK_GRAB_POSITION = 50;
            public static int HANG_POSITION = 1;
            public static int CATCH_POSITION = 100;
        }

        public static class EXTEND{

            public static int HOME_POSITION = 0;
            public static int SCORE_POSITION = 100;
            public static int GRAB_POSITION = -100;
            public static int STACK_GRAB_POSITION = 50;
            public static int HANG_POSITION = 0;
            public static int CATCH_POSITION = 100;
        }
        public static class GRAB{
            public static double GRAB = 0.40;
            public static double RELEASE = 0.50;

        }

        public static class WRIST{
            public static double GRAB = 1;
            public static double SCORE = 0;
        }

        public static class PLANE{
            public static double SHOOT = 0;
        }
    }

}
