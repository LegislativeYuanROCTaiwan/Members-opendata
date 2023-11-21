package API.obj;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "opendata")
public class ID13ObjList {

	@XmlElement(name = "data")
	private List<ID13Obj> id13ObjLst = new ArrayList<>();

	public List<ID13Obj> getId13ObjLst() {
		return id13ObjLst;
	}

	public void setId13ObjLst(List<ID13Obj> id13ObjLst) {
		this.id13ObjLst = id13ObjLst;
	}

}
