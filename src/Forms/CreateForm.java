package Forms;

import Compound.*;
import Database.ToXML;

import javax.swing.*;
import java.io.IOException;
import java.util.List;

public class CreateForm {
	private static Information info = new Information();
	private static BasicForm basicForm;

	public void initialForm() {
		InitialFrame initialFrame = new InitialFrame();
		initialFrame.generate();
	} 
	
	public void createEmptyForm() {
		basicForm = new BasicForm();
		basicForm.generate(basicForm);
	}

	public BasicForm getBasicForm() {
		return basicForm;
	}


	public boolean submitForm() {
		ContactInfo contactInfo;
		if (info.getContactInfo() == null)	{
			contactInfo = new ContactInfo();
		}
		else {
			contactInfo = info.getContactInfo();
		}
		PersonalInfo personalInfo = new PersonalInfo();
		ServiceInfo serviceInfo = new ServiceInfo();

		personalInfo.setName(basicForm.nameTextField.getText());
		personalInfo.setOrganization(basicForm.organizationNameTextField.getText());
		if (basicForm.positionTextFieldValid) personalInfo.setPosition(basicForm.positionTextField.getText());
		if (basicForm.voiceTelephoneTextFieldValid) contactInfo.getVoiceTelephone().add(basicForm.voiceTelephoneTextField.getText());
		if (basicForm.tDD_TTYTelephoneTextFieldValid) contactInfo.getTDD_TTYtelephone().add(basicForm.tDD_TTYTelephoneTextField.getText());
		if (basicForm.facsimileTelephoneTextFieldValid) contactInfo.getFacsimileTelephone().add(basicForm.facsimileTelephoneTextField.getText());
		if (basicForm.emailTextFieldValid) contactInfo.getEmails().add(basicForm.emailTextField.getText());

		if (basicForm.hoursTextFieldValid) serviceInfo.setHrsService(basicForm.hoursTextField.getText());
		if (basicForm.instructionTextFieldValid) serviceInfo.setInstruction(basicForm.instructionTextField.getText());

		for (int i=1;i<basicForm.voiceTelephoneComboBox.getItemCount();i++) {
			contactInfo.getVoiceTelephone().add(basicForm.voiceTelephoneComboBox.getItemAt(i).toString());
		}
		for (int i=1;i<basicForm.tDDTelephoneComboBox.getItemCount();i++) {
			contactInfo.getVoiceTelephone().add(basicForm.tDDTelephoneComboBox.getItemAt(i).toString());
		}
		for (int i=1;i<basicForm.facsimileTelephoneComboBox.getItemCount();i++) {
			contactInfo.getVoiceTelephone().add(basicForm.facsimileTelephoneComboBox.getItemAt(i).toString());
		}
		for (int i=1;i<basicForm.emailComboBox.getItemCount();i++) {
			contactInfo.getVoiceTelephone().add(basicForm.emailComboBox.getItemAt(i).toString());
		}
		info.setPersonalInfo(personalInfo);
		info.setContactInfo(contactInfo);
		info.setServiceInfo(serviceInfo);

		ToXML toXML = new ToXML();
		try {
			toXML.writeToXML(info);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}

	public void storeAddress(String type, String address, String city, String state, String country, String pincode) {
		List<AddressInfo> addressInfoList = info.getAddressInfo();
		AddressInfo addressInfo = new AddressInfo();
		addressInfo.setAddress(address);
		addressInfo.setCity(city);
		addressInfo.setState(state);
		addressInfo.setCountry(country);
		addressInfo.setZipCode(pincode);
		addressInfo.setAddressType(type);
		addressInfoList.add(addressInfo);
		info.setAddressInfo(addressInfoList);
		basicForm.addressComboBox.addItem(address);
	}

	public void removeAddress(int index){
		info.getAddressInfo().remove(index);
	}

	public static void main(String args[]){
		CreateForm form = new CreateForm();
		form.initialForm();
	}
}
