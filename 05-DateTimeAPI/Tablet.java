import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Tablet {
	private String tablet_name;
	private String manufacturer;
	private LocalDate manufactureDate;
	private LocalDate expiryDate;
	public Tablet(String tablet_name, String manufacturer, LocalDate manufactureDate, LocalDate expiryDate) {
		super();
		this.tablet_name = tablet_name;
		this.manufacturer = manufacturer;
		this.manufactureDate = manufactureDate;
		this.expiryDate = expiryDate;
	}
	public static List<String> getTablets(Tablet t){
		List<String> tablet=new ArrayList<>();
		tablet.add(t.getTablet_name());
		return tablet;
	}
	public String getTablet_name() {
		return tablet_name;
	}
	public void setTablet_name(String tablet_name) {
		this.tablet_name = tablet_name;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public LocalDate getManufactureDate() {
		return manufactureDate;
	}
	public void setManufactureDate(LocalDate manufactureDate) {
		this.manufactureDate = manufactureDate;
	}
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	@Override
	public String toString() {
		return "Tablet [tablet_name=" + tablet_name + ", manufacturer=" + manufacturer + ", manufactureDate="
				+ manufactureDate + ", expiryDate=" + expiryDate + "]";
	}

	
}
