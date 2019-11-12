import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class BankDepositExercise {
	static DateTimeFormatter formatter=DateTimeFormatter.ofPattern("[dd/MM/yyyy][dd-MM-yyyy]");
	public static String  getMaturityDate(String investmentDate, Period duration){
		LocalDate ld=LocalDate.parse(investmentDate, formatter);
		String result=ld.plus(duration).format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
		return result;	
	}
	public static String getInvestmentPeriod(String investmentDate, String maturityDate){
		LocalDate invd=LocalDate.parse(investmentDate, formatter);
		LocalDate matd=LocalDate.parse(maturityDate, formatter);
		String result=Period.between(invd, matd).getYears()+" year "+Period.between(invd, matd).getMonths()+" months";
		return result;
	}
	public static void main(String[] args) {
		System.out.println("****************************Get Maturity date*************************");
		System.out.println(getMaturityDate("11/01/2018", Period.of(1, 1, 1)));
		System.out.println("****************************Investment Period**************************");
		System.out.println(getInvestmentPeriod("11/10/2019", "12/11/2020"));
	}

}
