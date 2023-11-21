package API.obj;

public class ID16Obj {

	private String term;
	private String name;
	private String ename;
	private String sex;
	private String party;
	private String partyGroup;
	private String areaName;
	private String committee;
	private String onboardDate;
	private String degree;
	private String experience;
	private String picUrl;
	private String leaveFlag;
	private String leaveDate;
	private String leaveReason;

	public String getTerm() {
		return term;
	}

	public String getName() {
		return name;
	}

	public String getEname() {
		return ename;
	}

	public String getSex() {
		return sex;
	}

	public String getParty() {
		return party;
	}

	public String getPartyGroup() {
		return partyGroup;
	}

	public String getAreaName() {
		return areaName;
	}

	public String getCommittee() {
		return committee;
	}

	public String getOnboardDate() {
		return onboardDate;
	}

	public String getDegree() {
		return degree;
	}

	public String getExperience() {
		return experience;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public String getLeaveFlag() {
		return leaveFlag;
	}

	public String getLeaveDate() {
		return leaveDate;
	}

	public String getLeaveReason() {
		return leaveReason;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setParty(String party) {
		this.party = party;
	}

	public void setPartyGroup(String partyGroup) {
		this.partyGroup = partyGroup;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public void setCommittee(String committee) {
		this.committee = committee;
	}

	public void setOnboardDate(String onboardDate) {
		this.onboardDate = onboardDate;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public void setLeaveFlag(String leaveFlag) {
		this.leaveFlag = leaveFlag;
	}

	public void setLeaveDate(String leaveDate) {
		this.leaveDate = leaveDate;
	}

	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}

	public ID16Obj() {
		super();
	}

	public ID16Obj(Object term, Object name, Object ename, Object sex, Object party,
		Object partyGroup, Object areaName, Object committee, Object onboardDate, Object degree,
		Object experience, Object picUrl, Object leaveFlag, Object leaveDate,
		Object leaveReason) {

		setTerm(String.valueOf(term));
		setName(String.valueOf(name));
		setEname(String.valueOf(ename));
		setSex(String.valueOf(sex));
		setParty(String.valueOf(party));
		setPartyGroup(String.valueOf(partyGroup));
		setAreaName(String.valueOf(areaName));
		setCommittee(String.valueOf(committee));
		setOnboardDate(String.valueOf(onboardDate));
		setDegree(String.valueOf(degree));
		setExperience(String.valueOf(experience));
		setPicUrl(String.valueOf(picUrl));
		setLeaveFlag(String.valueOf(leaveFlag));
		setLeaveDate(String.valueOf(leaveDate));
		setLeaveReason(String.valueOf(leaveReason));
	}

}
