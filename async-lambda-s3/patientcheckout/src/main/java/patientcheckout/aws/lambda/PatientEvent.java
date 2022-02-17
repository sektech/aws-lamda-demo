package patientcheckout.aws.lambda;

public class PatientEvent {
    public String firstname;
    public String lastname;
    public String ssn;

    public PatientEvent(){}

    public PatientEvent(String firstname, String lastname, String ssn) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.ssn = ssn;
    }

    @Override
    public String toString() {
        return "patientcheckout.aws.lambda.PatientEvent{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", ssn='" + ssn + '\'' +
                '}';
    }
}
