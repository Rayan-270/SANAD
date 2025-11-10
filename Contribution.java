package SanadUI;

public class Contribution {
	 String organization;
	 String location ;
	 String contributionType;
	 String phoneNumber;
	 String facebookLink ;
	 
	public Contribution() {}
	public Contribution (String organization , String location , String phoneNumber , String contributionType) {
		this.organization = organization;
		this.location = location;
		this.phoneNumber = phoneNumber ;
		this.contributionType = contributionType;
		
	}
	
	public Contribution (String organization , String location , String phoneNumber , String contributionType , String facebookLink) {
		this.organization = organization;
		this.location = location;
		this.phoneNumber = phoneNumber ;
		this.contributionType = contributionType;
		this.facebookLink = facebookLink;
		
	}
}
