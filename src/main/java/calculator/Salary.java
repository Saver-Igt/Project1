package calculator;

/**
 * Класс для расчета заработной платы.
 *
 * @author Rinat_FN
 * @version 1.0
 */
public final class Salary extends Calculation{
    
    /**  НДФЛ. */
    private float ndfl;

    /**
     * Конструктор калсса .
     *
     * @param ndfl процент НДФЛ
     */
    public Salary(float ndfl) {
        this.ndfl = ndfl;
    }

    /**
     * Метод, вычисляющий зп с вычетом налога.
     *
     * @return the зп - ндфл
     */
    @Override
    public float calc() {
        return netSalary - ndfl;
    }

}