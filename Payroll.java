abstract class AbstractPerson {
    private String name;
    private String phoneNumber;

    public AbstractPerson(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public abstract boolean login(String phoneNumber);
}

class FitnessTrainer extends AbstractPerson {
    private String specialization;

    public FitnessTrainer(String name, String phoneNumber, String specialization) {
        super(name, phoneNumber);
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void leadTrainingSession(String exercise) {
        // Logic to lead a training session
        System.out.println(getName() + " is leading a training session on " + exercise);
    }

    @Override
    public boolean login(String phoneNumber) {
        // Logic for trainer login
        return true; // Placeholder for actual logic
    }
}

class Client extends AbstractPerson {
    private FitnessCenterProgram program;
    private String currentExercise;

    public Client(String name, String phoneNumber, FitnessCenterProgram program) {
        super(name, phoneNumber);
        this.program = program;
    }

    public FitnessCenterProgram getProgram() {
        return program;
    }

    public void setProgram(FitnessCenterProgram program) {
        this.program = program;
    }

    public String getCurrentExercise() {
        return currentExercise;
    }

    public void setCurrentExercise(String currentExercise) {
        this.currentExercise = currentExercise;
    }

    public void performExercise(String exercise) {
        // Logic to perform exercise
        System.out.println(getName() + " is performing " + exercise);
    }

    public void recordExercise(String exercise) {
        // Logic to record exercise
        System.out.println(getName() + " has recorded exercise: " + exercise);
    }

    public double calculateCaloriesBurned(double duration) {
        // Logic to calculate calories burned
        return duration * 10; // Example calculation
    }

    public void sendProgressToTrainer() {
        // Logic to send progress to trainer
        System.out.println(getName() + " is sending progress to trainer.");
    }

    @Override
    public boolean login(String phoneNumber) {
        // Logic for client login
        return true; // Placeholder for actual logic
    }
}

class FitnessCenter {
    private String location;
    private double membershipFee;

    public FitnessCenter(String location, double membershipFee) {
        this.location = location;
        this.membershipFee = membershipFee;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getMembershipFee() {
        return membershipFee;
    }

    public void setMembershipFee(double membershipFee) {
        this.membershipFee = membershipFee;
    }

    public void requestTrainingSession(FitnessTrainer trainer, String exercise) {
        // Logic to request a training session
        System.out.println("Requesting training session with " + trainer.getName() + " for exercise: " + exercise);
    }
}

class FitnessCenterProgram {
    private String programName;
    private String version;

    public FitnessCenterProgram(String programName, String version) {
        this.programName = programName;
        this.version = version;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void recordExercise(String exercise) {
        // Logic to record exercise
        System.out.println("Recording exercise: " + exercise);
    }

    public double calculateCaloriesBurned(double duration) {
        // Logic to calculate calories burned
        return duration * 10; // Example calculation
    }

    public void sendProgressToTrainer() {
        // Logic to send progress to trainer
        System.out.println("Sending progress to trainer.");
    }
}

public class Payroll {
    public static void main(String[] args) {
        // Example usage
        FitnessCenterProgram program = new FitnessCenterProgram("Weight Loss", "1.0");
        Client client = new Client("John Doe", "123-456-7890", program);
        FitnessTrainer trainer = new FitnessTrainer("Jane Smith", "098-765-4321", "Yoga");

        client.performExercise("Push Ups");
        client.recordExercise("Push Ups");
        client.sendProgressToTrainer();
        trainer.leadTrainingSession("Yoga");

        FitnessCenter fitnessCenter = new FitnessCenter("Main Street Gym", 50.0);
        fitnessCenter.requestTrainingSession(trainer, "Yoga");
    }
}
