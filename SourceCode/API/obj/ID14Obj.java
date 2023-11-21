package API.obj;

public class ID14Obj {

	private String committee;
	private String lgno;
	private String name;
	private String term;
	private String sessionPeriod;
	private String isCoChairman;

	public String getCommittee() {
		return committee;
	}

	public String getLgno() {
		return lgno;
	}

	public String getName() {
		return name;
	}

	public String getTerm() {
		return term;
	}

	public String getSessionPeriod() {
		return sessionPeriod;
	}

	public String getIsCoChairman() {
		return isCoChairman;
	}

	public void setCommittee(String committee) {
		this.committee = committee;
	}

	public void setLgno(String lgno) {
		this.lgno = lgno;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public void setSessionPeriod(String sessionPeriod) {
		this.sessionPeriod = sessionPeriod;
	}

	public void setIsCoChairman(String isCoChairman) {
		this.isCoChairman = isCoChairman;
	}
	
	public ID14Obj() {
		super();
	}


	public ID14Obj(Object committee, Object lgno, Object name, Object term, Object sessionPeriod, Object isCoChairman) {
		setCommittee(String.valueOf(committee));
		setLgno(String.valueOf(lgno));
		setName(String.valueOf(name));
		setTerm(String.valueOf(term));
		setSessionPeriod(String.valueOf(sessionPeriod));
		setIsCoChairman(String.valueOf(isCoChairman));
	}
		

}
