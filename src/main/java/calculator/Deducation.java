package calculator;

/**
 * Класс для расчета вычетов государтству
 * @author Rinat_FN
 * @version 1.0
 */
public final class Deducation extends Calculation{

    /** Процент вычета */
    private int percent;

    /** Константа */
    private final int constant = 100;

    /**
     * Конструктор класса
     *
     * @param percent передаваемый процент
     */
    public Deducation(int percent) {
        this.percent = percent;
    }

    /**
     * Метод, расчитывающий процент вычета
     *
     * @return вычет 
    */
    @Override
    public long calc() {
        return super.netSalary*percent/constant;
    }

}
