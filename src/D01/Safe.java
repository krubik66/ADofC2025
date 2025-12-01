package D01;

public class Safe {
    private int position;
    private int password;

    private int lastBigProgress = 0;
    private int lastPosition = 0;

    public Safe(int position) {
        this.position = position;
        this.password = 0;
    }

    public void move(String line) {
        String[] splitted = {line.substring(0, 1),  line.substring(1)};
        boolean isLeft = splitted[0].equals("L");
        if(isLeft) {
            position -= Integer.parseInt(splitted[1]);
        } else {
            position += Integer.parseInt(splitted[1]);
        }
        normalize();
        score();
    }

    public void move0x434C49434B(String line) {
        lastPosition = position;
        String[] splitted = {line.substring(0, 1),  line.substring(1)};
        boolean isLeft = splitted[0].equals("L");
        int full = Math.abs(Integer.parseInt(splitted[1]) / 100);
        password += full;
        int rest = Math.floorMod(Integer.parseInt(splitted[1]), 100);
        if(isLeft) {
            position -= rest;
        } else {
            position += rest;
        }
        normalize0x434C49434B();
        score();
    }

    private void normalize() {
        while(position >= 100) {
            position -= 100;
        }
        while(position < 0) {
            position += 100;
        }
    }

    private void normalize0x434C49434B() {
        int before = password;
        if(position == 100) {
            password--;
        }
        while(position >= 100) {
            position -= 100;
            password++;
        }
        if(lastPosition == 0 && position < 0) {
            password--;
        }
        while(position < 0) {
            position += 100;
            password++;
        }
        lastBigProgress = (password - before);
    }

    private void score() {
        if(position == 0) {
            password++;
            lastBigProgress++;
        }
    }

    public int giveNumbers() {
        return password;
    }

    public String showProgress(String line) {
        if(lastBigProgress >= 0) {
            return lastPosition + " - " + line + "\n" + lastBigProgress + "\n";
        } else {
            return "";
        }
    }
}
