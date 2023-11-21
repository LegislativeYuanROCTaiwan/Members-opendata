package API.obj;

public class ID13Obj {

	private String comtCd;
	private String comtName;
	private String comtDesp;
	private String comtType;

	public String getComtCd() {
		return comtCd;
	}

	public String getComtName() {
		return comtName;
	}

	public String getComtDesp() {
		return comtDesp;
	}

	public String getComtType() {
		return comtType;
	}

	public void setComtCd(String comtCd) {
		this.comtCd = comtCd;
	}

	public void setComtName(String comtName) {
		this.comtName = comtName;
	}

	public void setComtDesp(String comtDesp) {
		this.comtDesp = comtDesp;
	}

	public void setComtType(String comtType) {
		this.comtType = comtType;
	}

	public ID13Obj() {
		super();
	}

	public ID13Obj(Object comtCd, Object comtName, Object comtDesp, Object comtType) {
		setComtCd(String.valueOf(comtCd));
		setComtName(String.valueOf(comtName));
		setComtDesp(String.valueOf(comtDesp));
		setComtType(String.valueOf(comtType));
	}

}
