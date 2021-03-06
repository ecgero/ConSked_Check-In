package com.emailxl.consked_check_in.internal_db;

/**
 * The worker table data class
 *
 * @author ECG
 */
public class WorkerInt {
    private int idInt;
    private int workerIdExt;
    private String firstName;
    private String lastName;
    private String authrole;
    private int user;

    // Constructors
    public WorkerInt() {
    }

    WorkerInt(int idInt, int workerIdExt, String firstName, String lastName,
              String authrole, int user) {
        this.idInt = idInt;
        this.workerIdExt = workerIdExt;
        this.firstName = firstName;
        this.lastName = lastName;
        this.authrole = authrole;
        this.user = user;
    }

    // idInt functions
    public int getIdInt() {
        return this.idInt;
    }

    public void setIdInt(int idInt) {
        this.idInt = idInt;
    }

    // workerIdExt functions
    public int getWorkerIdExt() {
        return this.workerIdExt;
    }

    public void setWorkerIdExt(int workerIdExt) {
        this.workerIdExt = workerIdExt;
    }

    // firstName functions
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // lastName functions
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // authrole functions
    public String getAuthrole() {
        return this.authrole;
    }

    public void setAuthrole(String authrole) {
        this.authrole = authrole;
    }

    // user functions
    int getUser() {
        return this.user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[" +
                "idInt=" + idInt + ", " +
                "workerIdExt=" + workerIdExt + ", " +
                "firstName=" + firstName + ", " +
                "lastName=" + lastName + ", " +
                "authrole=" + authrole + ", " +
                "user=" + user + "]";
    }
}
