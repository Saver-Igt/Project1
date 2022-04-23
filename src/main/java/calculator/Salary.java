package calculator;

/**
 * Класс для расчета заработной платы
 * @author Rinat_FN
 * @version 1.0
 */
public final class Salary extends Calculation{
    /** НДФЛ */
    private float ndfl;

    public Salary(float ndfl) {
        this.ndfl = ndfl;
    }

    @Override
    public float calc() {
        return netSalary - ndfl;
    }

}