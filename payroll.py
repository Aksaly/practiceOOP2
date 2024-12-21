from abc import ABC, abstractmethod


class AbstractPerson(ABC):
    def __init__(self, name: str, phone_number: str):
        self._name = name
        self._phone_number = phone_number

    @property
    def name(self):
        return self._name

    @name.setter
    def name(self, value):
        self._name = value

    @property
    def phone_number(self):
        return self._phone_number

    @phone_number.setter
    def phone_number(self, value):
        self._phone_number = value

    @abstractmethod
    def login(self, phone_number: str) -> bool:
        pass


class FitnessTrainer(AbstractPerson):
    def __init__(self, name: str, phone_number: str, specialization: str):
        super().__init__(name, phone_number)
        self.specialization = specialization

    def lead_training_session(self, exercise: str):
        print(f"{self.name} is leading a training session on {exercise}")

    def login(self, phone_number: str) -> bool:
        # Logic for trainer login
        return True  # Placeholder for actual logic


class FitnessCenterProgram:
    def __init__(self, program_name: str, version: str):
        self.program_name = program_name
        self.version = version

    def record_exercise(self, exercise: str):
        print(f"Recording exercise: {exercise}")

    def calculate_calories_burned(self, duration: float) -> float:
        return duration * 10  # Example calculation

    def send_progress_to_trainer(self):
        print("Sending progress to trainer.")


class Client(AbstractPerson):
    def __init__(self, name: str, phone_number: str, program: FitnessCenterProgram):
        super().__init__(name, phone_number)
        self.program = program
        self.current_exercise = None

    def perform_exercise(self, exercise: str):
        print(f"{self.name} is performing {exercise}")

    def record_exercise(self, exercise: str):
        print(f"{self.name} has recorded exercise: {exercise}")

    def calculate_calories_burned(self, duration: float) -> float:
        return duration * 10  # Example calculation

    def send_progress_to_trainer(self):
        print(f"{self.name} is sending progress to trainer.")

    def login(self, phone_number: str) -> bool:
        # Logic for client login
        return True  # Placeholder for actual logic


class FitnessCenter:
    def __init__(self, location: str, membership_fee: float):
        self.location = location
        self.membership_fee = membership_fee

    def request_training_session(self, trainer: FitnessTrainer, exercise: str):
        print(f"Requesting training session with {trainer.name} for exercise: {exercise}")


# Example usage
if __name__ == "__main__":
    program = FitnessCenterProgram("Weight Loss", "1.0")
    client = Client("John Doe", "123-456-7890", program)
    trainer = FitnessTrainer("Jane Smith", "098-765-4321", "Yoga")

    client.perform_exercise("Push Ups")
    client.record_exercise("Push Ups")
    client.send_progress_to_trainer()
    trainer.lead_training_session("Yoga")

    fitness_center = FitnessCenter("Main Street Gym", 50.0)
    fitness_center.request_training_session(trainer, "Yoga")
