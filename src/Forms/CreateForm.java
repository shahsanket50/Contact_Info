package Forms;

import Compound.ContactInfo;
import Compound.Information;
import Compound.PersonalInfo;
import Compound.ServiceInfo;
import Database.ToXML;

import javax.swing.*;
import java.io.IOException;

public class CreateForm {
	private static Information info = new Information();
	private static JFrame initialFrame;
	private static JFrame emptyFrame;
	private static BasicForm basicForm;
	public void initialForm() {
		initialFrame = new JFrame("Contact Information");
		initialFrame.setContentPane(new InitialFrame().start);
		initialFrame.setDefaultCloseOperation(initialFrame.EXIT_ON_CLOSE);
		initialFrame.setResizable(false);
		initialFrame.setSize(200, 200);
		initialFrame.setVisible(true);
	} 
	
	public void createEmptyForm() {
		initialFrame.setVisible(false);
		emptyFrame = new JFrame("BasicForm");
		basicForm = new BasicForm();
		emptyFrame.setContentPane(basicForm.form);
		emptyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		emptyFrame.setResizable(false);
		emptyFrame.setSize(600, 600);
		emptyFrame.setVisible(true);
	}

	public JFrame getInitialFrame() {
		return initialFrame;
	}

	public JFrame getEmptyFrame() {
		return emptyFrame;
	}

	public BasicForm getBasicForm() {
		return basicForm;
	}

	public Information getInfo() {
		return info;
	}

	public void updateForm() {

		
	}

	public void submitForm() {
		if (basicForm.nameTextField.getText().isEmpty() || basicForm.organisationNameTextField.getText().isEmpty() ||
				(basicForm.telephoneNoTextField.getText().isEmpty() && info.getContactInfo().getVoiceTelephone().isEmpty()) ||
				info.getAddressInfo().isEmpty()) {
			//JDialog jDialog = new JDialog(emptyFrame, "Empty Fields");
			JOptionPane.showMessageDialog(emptyFrame, "Empty Fields");
			return;
		}
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
		personalInfo.setOrganization(basicForm.organisationNameTextField.getText());
		if (!basicForm.positionTextField.getText().isEmpty()) personalInfo.setPosition(basicForm.positionTextField.getText());
		if (!basicForm.telephoneNoTextField.getText().isEmpty()) contactInfo.getVoiceTelephone().add(basicForm.telephoneNoTextField.getText());
		if (!basicForm.tDDTelephoneNoTextField.getText().isEmpty()) contactInfo.getTDD_TTYtelephone().add(basicForm.tDDTelephoneNoTextField.getText());
		if (!basicForm.fascimileTelephoneNoTextField.getText().isEmpty()) contactInfo.getFascimileTelephone().add(basicForm.fascimileTelephoneNoTextField.getText());
		//if (!basicForm.emailTextField.getText().isEmpty()) contactInfo.getEmails().add(basicForm.emailTextField.getText());

		if (!basicForm.hoursTextField.getText().isEmpty()) serviceInfo.setHrsService(basicForm.hoursTextField.getText());
		if (!basicForm.instructionTextField.getText().isEmpty()) serviceInfo.setInstruction(basicForm.instructionTextField.getText());

		info.setPersonalInfo(personalInfo);
		info.setContactInfo(contactInfo);
		info.setServiceInfo(serviceInfo);

		ToXML toXML = new ToXML();
		try {
			toXML.writeToXML(info);
		} catch (IOException e) {
			e.printStackTrace();
		}
		emptyFrame.dispose();
		initialFrame.setVisible(true);
	}

	public static void main(String args[]){
		CreateForm form = new CreateForm();
		form.initialForm();
	}
}
