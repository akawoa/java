package com.codingdojo.phone;

public class Galaxy extends Phone implements Ringable {
    public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }
    @Override
    public String ring() {
		return "Galaxy " + this.getVersionNumber() + " says " + this.getRingTone();
    }
    @Override
    public String unlock() {
		return "Unlocking via fingerprint";
    }
    @Override
    public void displayInfo() {
        System.out.println("Version Number: " + this.getVersionNumber());
        System.out.println("Battery Percentage: " + this.getBatteryPercentage());
        System.out.println("Carrier" + this.getCarrier());         
    }
}