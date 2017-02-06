package Database;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import Compound.Information;

public class ToXML {
	
	BufferedWriter bw = null;
	int tabs = 0;
	
	public void addTabs(BufferedWriter bw) throws IOException {
		
		for(int i = 0; i < tabs; i++)
			bw.write("\t");
		
	}
	
	public void writeToXML(Information info) throws IOException{
		
		File file = new File(info.getPersonalInfo().getName() + ".xml");
		FileWriter fw = new FileWriter(file);
		bw = new BufferedWriter(fw);
		addTabs(bw);
		bw.write("<ContactInformation>\n");
		tabs++;
			addTabs(bw);
			bw.write("<PersonalInformation>\n");
			tabs++;
				addTabs(bw);
				bw.write("<Name>" + info.getPersonalInfo().getName() + "</Name>\n");
				addTabs(bw);
				bw.write("<Organization>" + info.getPersonalInfo().getOrganization() + "</Organization>\n");
				addTabs(bw);
				bw.write("<Position>" + info.getPersonalInfo().getPosition() + "</Position>\n");
			tabs--;
			addTabs(bw);
			bw.write("</PersonalInformation>\n");
			addTabs(bw);
			bw.write("<AddressInfoInformation>\n");
			tabs++;
			for(int i = 0; i < info.getAddressInfo().size(); i++) {
				addTabs(bw);
				bw.write("<AddressType>" + info.getAddressInfo().get(i).getAddressType() + "</AddressType>\n");
				addTabs(bw);
				bw.write("<Address>" + info.getAddressInfo().get(i).getAddress() + "</Address>\n");
				addTabs(bw);
				bw.write("<City>" + info.getAddressInfo().get(i).getCity() + "</City>\n");
				addTabs(bw);
				bw.write("<State>" + info.getAddressInfo().get(i).getState() + "</State>\n");
				addTabs(bw);
				bw.write("<ZipCode>" + info.getAddressInfo().get(i).getZipCode() + "</ZipCode>\n");
				addTabs(bw);
				bw.write("<Country>" + info.getAddressInfo().get(i).getCountry() + "</Country>\n");
			}
			tabs--;
			addTabs(bw);
			bw.write("</AddressInfoInformation>\n");
			addTabs(bw);
			bw.write("<ContactInfoInformation>\n");
			tabs++;
			for(int i = 0; i < info.getContactInfo().getVoiceTelephone().size(); i++) {
				addTabs(bw);
				bw.write("<VoiceTelephone>" + info.getContactInfo().getVoiceTelephone().get(i) + "</VoiceTelephone>\n");
			}
			for(int i = 0; i < info.getContactInfo().getTDD_TTYtelephone().size(); i++) {
				addTabs(bw);
				bw.write("<TDD_TTYTelephone>" + info.getContactInfo().getTDD_TTYtelephone().get(i) + "</TDD_TTYTelephone>\n");
			}
			for(int i = 0; i < info.getContactInfo().getFascimileTelephone().size(); i++) {
				addTabs(bw);
				bw.write("<FascimileTelephone>" + info.getContactInfo().getFascimileTelephone().get(i) + "</FascimileTelephone>\n");
			}
			for(int i = 0; i < info.getContactInfo().getEmails().size(); i++) {
				addTabs(bw);
				bw.write("<Emails>" + info.getContactInfo().getEmails().get(i) + "</Emails>\n");
			}
			tabs--;
			addTabs(bw);
			bw.write("</ContactInfoInformation>\n");
			addTabs(bw);
			bw.write("<ServiceInfoInformation>\n");
			tabs++;
				addTabs(bw);
				bw.write("<HrsService>" + info.getServiceInfo().getHrsService() + "</HrsService>\n");
				addTabs(bw);
				bw.write("<Instructions>" + info.getServiceInfo().getInstruction() + "</Instructions>\n");
				tabs--;
			addTabs(bw);
			bw.write("</ServiceInfoInformation>\n");
		tabs--;
		addTabs(bw);
		bw.write("</ContactInformation>");
		bw.close();
	}
}
