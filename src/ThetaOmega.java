import javafx.scene.chart.ScatterChart;

public class ThetaOmega {

    private double tStop;
    private double n;
    private double f;
    private double theta0;
    private double omega0;
    private double c;
    private double A;

    public ThetaOmega(double tStop, double n, double f, double theta0, double omega0, double c, double A) {
        this.tStop = tStop;
        this.n = n;
        this.f = f;
        this.theta0 = theta0;
        this.omega0 = omega0;
        this.c = c;
        this.A = A;
    }

    public ScatterChart.Series getValues() {
        ScatterChart.Series values = new ScatterChart.Series();
        double dt = tStop / (n - 1);
        double t = 0;

        double theta = theta0;
        double omega = omega0;

        for (int i = 1; i < tStop / dt; i++) {
            double tMid = t + dt / 2;
            double thetamid = theta + dt * omega / 2;
            double omegamid = omega + dt * (-Math.sin(theta) - c * omega + A * Math.sin(f * t)) / 2;
            theta = theta + dt * omegamid;
            omega = omega + dt * (-Math.sin(thetamid) - c * omegamid + A * Math.sin(f * tMid));
            t = t + dt;
            values.getData().add(new ScatterChart.Data(theta, omega));
        }
        return values;
    }

}
