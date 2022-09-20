package CodeForAdapterDesignPattern;

import java.util.List;

// Data consumer
public class Intranet {
	IPhoneListSource source;
	
	public Intranet(IPhoneListSource source) {
		this.source = source;
	}
	
	public void printPhoneNumbers() {
		List<String> phones = this.source.GetPhoneNumbers();
		System.out.println(phones);
	}
}

 

public interface IPhoneListSource {
	public List<String> GetPhoneNumbers();
}



public class EmployeeToPLAdapter implements IPhoneListSource{
	private EmployeeDetails empDS;
	
	public EmployeeToPLAdapter(EmployeeDetails ds){
		this.empDS = ds;
	}
	
	@Override
	public List<String> GetPhoneNumbers() {
		List<String> emps = this.empDS.GetEmployees();
		List<String> phones = new ArrayList<>();
		
		for(String emp: emps) {
			String[] parts = emp.split("-");
			String phone = parts[3];
			phones.add(phone);
		}
		
		return phones;
	}

}

public class EmployeeDetails {
	public List<String> GetEmployees(){
		List<String> emps = new ArrayList<>();
		
		emps.add("1-ABC-SDE1-9999786543");
		emps.add("2-DEF-SDE2-9876523456");
		emps.add("3-GHI-TL-9321499876");
		emps.add("4-JKL-Architect-9985432121");
		emps.add("5-MNO-HR-9211345667");
		
		return emps;
	}
}

// 

 