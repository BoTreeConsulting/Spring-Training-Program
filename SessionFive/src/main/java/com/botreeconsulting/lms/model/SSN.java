package com.botreeconsulting.lms.model;

public class SSN {
	private String ssn = "";

	public SSN(String ssn) {
		this.ssn = ssn;
	}

	/**
	 * @return the ssn
	 */
	public String getSsn() {
		return ssn;
	}

	/**
	 * @param ssn the ssn to set
	 */
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SSN [ssn=" + ssn + "]";
	}
	
	
}
