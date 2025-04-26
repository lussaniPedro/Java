public class workout {
    public static void main(String[] args) {
        calendar.WeeklyCalendar();
        System.out.println();
    }
}

class work {
    private String name;
    private int steps;
    private int reps;
    private float weight;

    /* Getters */
    public String getName() {
        return name;
    }

    public int getSteps() {
        return steps;
    }

    public int getReps() {
        return reps;
    }

    public float getWeight() {
        return weight;
    }

    public float getVolume() {
        return weight * reps * steps;
    }

    /* Setters */
    public void setName(String name) {
        this.name = name;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public void setWeight(float kg) {
        this.weight = kg;
    }
}