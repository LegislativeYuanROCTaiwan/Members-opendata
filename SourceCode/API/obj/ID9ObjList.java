package API.obj;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "opendata")
public class ID9ObjList {
	
	@XmlElement(name = "data")
    private List<ID9Obj> id9ObjLst = new ArrayList<>();
	
	public List<ID9Obj> getId9ObjLst() {
		return id9ObjLst;
	}
	
	public void setId9ObjLst(List<ID9Obj> id9ObjLst) {
		this.id9ObjLst = id9ObjLst;
	}

}
