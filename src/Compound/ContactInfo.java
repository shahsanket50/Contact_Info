package Compound;

import java.util.ArrayList;
import java.util.List;

public class ContactInfo {

	private List<String> voiceTelephone = new ArrayList<String>();
	private List<String> TDD_TTYtelephone = new ArrayList<String>();
	private List<String> fascimileTelephone = new ArrayList<String>();
	private List<String> emails = new ArrayList<String>();
	public List<String> getVoiceTelephone() {
		return voiceTelephone;
	}
	public void setVoiceTelephone(List<String> voiceTelephone) {
		this.voiceTelephone = voiceTelephone;
	}
	public List<String> getTDD_TTYtelephone() {
		return TDD_TTYtelephone;
	}
	public void setTDD_TTYtelephone(List<String> tDD_TTYtelephone) {
		TDD_TTYtelephone = tDD_TTYtelephone;
	}
	public List<String> getFascimileTelephone() {
		return fascimileTelephone;
	}
	public void setFascimileTelephone(List<String> fascimileTelephone) {
		this.fascimileTelephone = fascimileTelephone;
	}
	public List<String> getEmails() {
		return emails;
	}
	public void setEmails(List<String> emails) {
		this.emails = emails;
	}
	
}
