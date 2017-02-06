package Compound;

import java.util.ArrayList;
import java.util.List;

public class Information {

	private PersonalInfo personalInfo;
	private List<AddressInfo> addressInfo = new ArrayList<AddressInfo>();
	private ContactInfo contactInfo;
	private ServiceInfo serviceInfo;
	public PersonalInfo getPersonalInfo() {
		return personalInfo;
	}
	public void setPersonalInfo(PersonalInfo personalInfo) {
		this.personalInfo = personalInfo;
	}
	public List<AddressInfo> getAddressInfo() {
		return addressInfo;
	}
	public void setAddressInfo(List<AddressInfo> addressInfo) {
		this.addressInfo = addressInfo;
	}
	public ContactInfo getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}
	public ServiceInfo getServiceInfo() {
		return serviceInfo;
	}
	public void setServiceInfo(ServiceInfo serviceInfo) {
		this.serviceInfo = serviceInfo;
	}
	
}
