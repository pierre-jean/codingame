package fr.baraud.codingame.easy.thebridge1;

public class Player {
    private final int position;
    private final int speed;

    private Player(int position, int speed){
        this.position = position;
        this.speed = speed;
    }

    public Action actionToJump(Bridge bridge){
        if (notEnoughSpeedToJump(bridge)){
            return Action.SPEED_UP;
        }
        return Action.SLOW_DOWN;
    }

    private boolean notEnoughSpeedToJump(Bridge bridge) {
        return bridge.length() > speed;
    }


    public static class BuildNew {

        private int position = 0;
        private int speed = 0;

        public BuildNew drivingAtSpeed(int speed) {
            this.speed = speed;
            return this;
        }

        public BuildNew fromPosition(int position) {
            this.position = position;
            return this;
        }

        public Player build() {
            return new Player(position, speed);
        }
    }
}
