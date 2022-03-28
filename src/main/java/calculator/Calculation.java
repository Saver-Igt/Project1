package calculator;
/**
 * Абстрактый класс Calculation<br>
 * В классе хранится значение заработной платы до вычета налога и метод для ее вычисления.<br>
 * Метод calc() переопределяется у наследников.<br>
 * @author Siraev
 * @version 1.0
 */
public abstract class Calculation {
	
	/** заработная плата до вычета налога. */
	public static long netSalary = 0; 
	/**
	 * Абстрактный метод (для наследников) для вычислений.
	 * @return the long
	 */
	public abstract long calc();
	
	/**
	 * Метод, вычисляющий заработную плату до вычета налога.
	 *
	 * @param amount количество деталей
	 * @param cost цена одной детали
	 * @param allowance надбавка
	 */
	public final static void calcNetSalary(long amount, long cost, long allowance) {
		netSalary = amount * cost + allowance;
	}
}