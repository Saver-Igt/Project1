package calculator;

/**
 * Класс для расчета заработной платы
 * @author Rinat_FN
 * @version 1.0
 */
public final class Salary extends Calculation{

    /** Количество деталей */
    private long amount=0;

    /** Цена за деталь. */
    private long cost=0;

    /** Надбавка. */
    private long allowance=0;

    /** НДФЛ */
    private long cess;

    /** Процент НДФЛ */
    public static int percent=13;

    /**
     * Конструкто класса
     *
     * @param amount передаваемое количество
     * @param cost передаваемаемая цена
     * @param allowance передаемая надбавка
     */
    public Salary(long amount, int cost, long allowance) {
        this.amount = amount;
        this.cost = cost;
        this.allowance = allowance;
    }

    /**
     * Метод расчитывающий зарплату до вычета налогов, НДФЛ, зарплату, которую получит сотрудник
     *
     * @return зарплату, которую получит сотрудник
     */
    @Override
    public long calc() {
        super.calcNetSalary(amount,cost,allowance);
        Tax ndfl = new Tax(percent);
        cess = ndfl.calc();
        return super.netSalary - cess;
    }

    /**
     * Метод, возвращающий вычитаемый налог
     *
     * @return cess вычитаемый налог
     */
    public final long getCess() {
        return cess;
    }
}