package calculator;
/**
 * Абстрактый класс Calculation
 * В классе хранится значение заработной платы до вычета налога и метод для ее вычисления.
 * Метод calc() переопределяется у наследников.
 * @author Siraev
 * @version 1.2
 */
public abstract class Calculation {
	
	/** заработная плата до вычета налога. */
	public static float netSalary = 0; 
	/**
	 * Абстрактный метод (для наследников) для вычислений.
	 * @return the long
	 */
	public abstract float calc();
	
	/**
	 * Метод, вычисляющий заработную плату до вычета налога.
	 *
	 * @param amount количество деталей
	 * @param cost цена одной детали
	 * @param allowance надбавка
	 */
	public final static void calcNetSalary(long amount, float cost, float allowance) {
		netSalary = amount * cost + allowance;
	}
}