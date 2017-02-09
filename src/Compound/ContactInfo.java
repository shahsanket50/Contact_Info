package Compound;

import java.util.ArrayList;
import java.util.List;

public class ContactInfo {

	private List<String> voiceTelephone = new ArrayList<String>();
	private List<String> TDD_TTYtelephone = new ArrayList<String>();
	private List<String> facsimileTelephone = new ArrayList<String>();
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
	public List<String> getFacsimileTelephone() {
		return facsimileTelephone;
	}
	public void setFacsimileTelephone(List<String> facsimileTelephone) {
		this.facsimileTelephone = facsimileTelephone;
	}
	public List<String> getEmails() {
		return emails;
	}
	public void setEmails(List<String> emails) {
		this.emails = emails;
	}
	
}
