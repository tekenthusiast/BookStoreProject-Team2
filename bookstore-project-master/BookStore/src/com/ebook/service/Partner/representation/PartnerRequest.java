package com.ebook.service.Partner.representation;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "PartnerRequest")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class PartnerRequest {
	
	private String partnerName;
	private String partnerInfo;
	
	public PartnerRequest(){
		
	}
	
	public String getPartnerName() {
		return partnerName;
	}
	
	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}


	public String getPartnerInfo() {
		return partnerInfo;
	}

	public void setPartnerInfo(String partnerInfo) {
		this.partnerInfo = partnerInfo;
	}

}