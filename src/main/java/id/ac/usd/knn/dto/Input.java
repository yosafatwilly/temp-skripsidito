package id.ac.usd.knn.dto;

public class Input {
    private int maskD;
    private int maskI;
    private int maskS;
    private int maskC;
    private int pressureD;
    private int pressureI;
    private int pressureS;
    private int pressureC;
    private int selfD;
    private int selfI;
    private int selfS;
    private int selfC;

    public Input() {
    }

    public int getMaskD() {
        return maskD;
    }

    public void setMaskD(int maskD) {
        this.maskD = maskD;
    }

    public int getMaskI() {
        return maskI;
    }

    public void setMaskI(int maskI) {
        this.maskI = maskI;
    }

    public int getMaskS() {
        return maskS;
    }

    public void setMaskS(int maskS) {
        this.maskS = maskS;
    }

    public int getMaskC() {
        return maskC;
    }

    public void setMaskC(int maskC) {
        this.maskC = maskC;
    }

    public int getPressureD() {
        return pressureD;
    }

    public void setPressureD(int pressureD) {
        this.pressureD = pressureD;
    }

    public int getPressureI() {
        return pressureI;
    }

    public void setPressureI(int pressureI) {
        this.pressureI = pressureI;
    }

    public int getPressureS() {
        return pressureS;
    }

    public void setPressureS(int pressureS) {
        this.pressureS = pressureS;
    }

    public int getPressureC() {
        return pressureC;
    }

    public void setPressureC(int pressureC) {
        this.pressureC = pressureC;
    }

    public int getSelfD() {
        return selfD;
    }

    public void setSelfD(int selfD) {
        this.selfD = selfD;
    }

    public int getSelfI() {
        return selfI;
    }

    public void setSelfI(int selfI) {
        this.selfI = selfI;
    }

    public int getSelfS() {
        return selfS;
    }

    public void setSelfS(int selfS) {
        this.selfS = selfS;
    }

    public int getSelfC() {
        return selfC;
    }

    public void setSelfC(int selfC) {
        this.selfC = selfC;
    }

    @Override
    public String toString() {
        return "Input{" +
                "maskD=" + maskD +
                ", maskI=" + maskI +
                ", maskS=" + maskS +
                ", maskC=" + maskC +
                ", pressureD=" + pressureD +
                ", pressureI=" + pressureI +
                ", pressureS=" + pressureS +
                ", pressureC=" + pressureC +
                ", selfD=" + selfD +
                ", selfI=" + selfI +
                ", selfS=" + selfS +
                ", selfC=" + selfC +
                '}';
    }
}
