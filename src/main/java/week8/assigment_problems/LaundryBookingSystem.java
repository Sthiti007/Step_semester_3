package session8.assignment.p1;

interface WashType {
    String getName();
    int getDurationMinutes();
    double getCharge();
}

class QuickWash implements WashType {
    public String getName() { return "Quick"; }
    public int getDurationMinutes() { return 30; }
    public double getCharge() { return 20.00; }
}

class NormalWash implements WashType {
    public String getName() { return "Normal"; }
    public int getDurationMinutes() { return 45; }
    public double getCharge() { return 30.00; }
}

class HeavyWash implements WashType {
    public String getName() { return "Heavy"; }
    public int getDurationMinutes() { return 60; }
    public double getCharge() { return 45.00; }
}

class WashingMachine {
    private String machineId;
    private boolean isBusy;
    private WashCycle currentCycle;

    public WashingMachine(String machineId) {
        this.machineId = machineId;
        this.isBusy = false;
    }

    public String getMachineId() { return machineId; }
    public boolean isBusy() { return isBusy; }

    public void startWash(String studentName, WashType washType) {
        if (isBusy) {
            System.out.println("Machine " + machineId + " is currently busy.");
            return;
        }
        this.currentCycle = new WashCycle(studentName, this, washType);
        this.isBusy = true;
        System.out.println(washType.getName() + " wash started on " + machineId + " for " + studentName + " (" + washType.getDurationMinutes() + " min). Charge: " + washType.getCharge() + ".");
    }

    public void completeCycle() {
        if (!isBusy) return;
        this.isBusy = false;
        this.currentCycle = null;
        System.out.println(machineId + " cycle completed. " + machineId + " is now free.");
    }
}

class WashCycle {
    private String studentName;
    private WashingMachine machine;
    private WashType washType;

    public WashCycle(String studentName, WashingMachine machine, WashType washType) {
        this.studentName = studentName;
        this.machine = machine;
        this.washType = washType;
    }
}