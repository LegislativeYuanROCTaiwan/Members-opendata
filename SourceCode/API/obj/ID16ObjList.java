package API.obj;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "opendata")
public class ID16ObjList {

	@XmlElement(name = "data")
	private List<ID16Obj> id16ObjLst = new ArrayList<>();

	public List<ID16Obj> getId16ObjLst() {
		return id16ObjLst;
	}

	public void setId16ObjLst(List<ID16Obj> id16ObjLst) {
		this.id16ObjLst = id16ObjLst;
	}

}
