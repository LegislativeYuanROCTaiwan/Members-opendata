package API.obj;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "opendata")
public class ID14ObjList {

	@XmlElement(name = "data")
	private List<ID14Obj> id14ObjLst = new ArrayList<>();

	public List<ID14Obj> getId14ObjLst() {
		return id14ObjLst;
	}

	public void setId14ObjLst(List<ID14Obj> id14ObjLst) {
		this.id14ObjLst = id14ObjLst;
	}

}
