package fr.baraud.codingame.easy.thebridge1;

public class Player {
    private final int position;
    private final int speed;
    private final Gap gap;
    private final Platform platform;

    private Player(int position, int speed, Gap gap, Platform platform){
        this.position = position;
        this.speed = speed;
        this.gap = gap;
        this.platform = platform;
    }

    public Action bestAction(){
        if (notEnoughSpeedToJumpGap()){
            return Action.SPEED_UP;
        } if (tooMuchSpeedToStopOnPlatform()){
            return Action.SLOW_DOWN;
        } if (currentSpeedLeadsToSuccessfulJump()){
            return Action.WAIT;
        }
        return Action.SLOW_DOWN;
    }

    private boolean notEnoughSpeedToJumpGap() {
        return gap.length() > speed;
    }

    private boolean tooMuchSpeedToStopOnPlatform() {
        return minimumDistanceToStopAt(speed)> platform.length();
    }

    private boolean currentSpeedLeadsToSuccessfulJump() {
        return distanceBeforeJumpAt(speed) + gap.length() < speed;
    }

    private int distanceBeforeJumpAt(int speed) {
        return ((gap.position() - this.position) - 1) % speed;
    }

    private int minimumDistanceToStopAt(int speed){
        return (speed * (speed - 1 )) / 2;
    }


    public static class BuildNew {

        private int position = 0;
        private int speed = 0;
        private Gap gap = new Gap.BuildNew().build();
        private Platform platform = new Platform.BuildNew().build();

        public BuildNew drivingAtSpeed(int speed) {
            this.speed = speed;
            return this;
        }

        public BuildNew fromPosition(int position) {
            this.position = position;
            return this;
        }

        public BuildNew withGap(Gap gap) {
            this.gap = gap;
            return this;
        }

        public BuildNew withPlatform(Platform platform) {
            this.platform = platform;
            return this;
        }

        public Player build() {
            return new Player(position, speed, gap, platform);
        }


    }
}
