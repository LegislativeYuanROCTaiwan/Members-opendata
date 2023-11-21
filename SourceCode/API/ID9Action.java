package API;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.google.gson.Gson;

import API.obj.ID9Obj;
import API.obj.ID9ObjList;
//
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import javax.servlet.http.HttpServletRequest;

//當屆委員資料
public class ID9Action extends ActionSupport {

	private static final long serialVersionUID = -675680671102295967L;
	private final Logger log = Logger.getLogger(this.getClass());
	private static final HashSet<String> availableFileType = new HashSet<String>(
		Arrays.asList("csv", "json", "xml", "xls", "txt"));

	private String name;
	private String sex;
	private String party;
	private String partyGroup;
	private String areaName;
	private String committee;

	private String importFilePath = "/lyodw/odwsys/ODM_FT/9_CSV/9_CSV.csv";
	private String exportFilePath = "/lyodw/tomcat7/webapps/odw/source/";
	private String exportFileName = String.valueOf(System.currentTimeMillis());

	private String fileType;

	public String execute() throws Exception {
		System.out.println("ID9Action start!!");
		HttpServletRequest request;
		 request = ServletActionContext.getRequest();
		if (StringUtils.isBlank(fileType) || !availableFileType.contains(fileType.toLowerCase())) {
			return SUCCESS;
		}

		try {
			List<ID9Obj> resultList = new ArrayList<>();
			ID9Obj iD9Obj = new ID9Obj();
			ID9ObjList iD9ObjList = new ID9ObjList();
			Path path = Paths.get(importFilePath);
			InputStreamReader isr = new InputStreamReader(new FileInputStream(path.toFile()),
				StandardCharsets.UTF_8);
			BufferedReader br = new BufferedReader(isr);
			
			int row = 1;
			String readLine;
			while ((readLine = br.readLine()) != null) {
				if (row == 1) {
					row++;
					continue;
				}
				// ======== CSV file column
				// term,name,ename,sex,party,partyGroup,areaName,committee,onboardDate,degree,tel,experience,fax,addr,picUrl,leaveFlag,leaveDate,leaveReason
				String[] detail = ((String) readLine).split(",", -1);

				iD9Obj = new ID9Obj(detail[0], detail[1], detail[2], detail[3], detail[4], detail[5], detail[6],
					detail[7], detail[8], detail[9], detail[10], detail[11], detail[12], detail[13], detail[14],
					detail[15], detail[16], detail[17]);

				// generate query result
				if ((StringUtils.isBlank(name) || name.equals(iD9Obj.getName())) &&
					(StringUtils.isBlank(sex) || sex.equals(iD9Obj.getSex())) &&
					(StringUtils.isBlank(party) || party.equals(iD9Obj.getParty())) &&
					(StringUtils.isBlank(partyGroup) || partyGroup.equals(iD9Obj.getPartyGroup())) &&
					(StringUtils.isBlank(areaName) || areaName.equals(iD9Obj.getAreaName())) &&
					(StringUtils.isBlank(committee) || committee.equals(iD9Obj.getCommittee()))) {
					resultList.add(iD9Obj);
					iD9ObjList.getId9ObjLst().addAll(resultList);
				}

			}
			
			br.close();
			isr.close();

			if (fileType.equalsIgnoreCase("csv")) {
				generateCsv(exportFilePath, exportFileName, ".csv", resultList);
			} else if (fileType.equalsIgnoreCase("txt")) {
				generateCsv(exportFilePath, exportFileName, ".txt", resultList);
			} else if (fileType.equalsIgnoreCase("xls")) {
				String csvFilePath = generateCsv(exportFilePath, exportFileName, ".csv", resultList);

				// Opening CSV Files
				Workbook wb = new HSSFWorkbook();
				CreationHelper helper = wb.getCreationHelper();
				Sheet sheet = wb.createSheet("new sheet");

				Path path_xls = Paths.get(csvFilePath);
				InputStreamReader isr_xls = new InputStreamReader(new FileInputStream(path_xls.toFile()),
					StandardCharsets.UTF_8);
				BufferedReader br_xls = new BufferedReader(isr_xls);
				
				String readLine_xls;
				int r = 0;
				while ((readLine_xls = br_xls.readLine()) != null) {
					Row rows = sheet.createRow((short) r++);
					
					String[] line = ((String) readLine_xls).split(",", -1);

					for (int i = 0; i < line.length; i++)
						rows.createCell(i).setCellValue(helper.createRichTextString(line[i]));

				}

				// Write the output to a file
				FileOutputStream fileOut = new FileOutputStream(exportFilePath + exportFileName + ".xls");
				wb.write(fileOut);
				fileOut.close();
				br_xls.close();

			} else if (fileType.equalsIgnoreCase("json")) {
				String finalResult = "{\"dataList\":" + new Gson().toJson(resultList) + "}";
				FileWriter fw = new FileWriter(exportFilePath + exportFileName + ".txt");
				fw.write(finalResult);
				fw.close();
				request.setAttribute("json",finalResult);
			} else if (fileType.equalsIgnoreCase("xml")) {
				// xml
				StringWriter sw = new StringWriter();
				JAXBContext jaxbContext = JAXBContext.newInstance(ID9ObjList.class);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

				// Marshal the employees list in file
				jaxbMarshaller.marshal(iD9ObjList, new File(exportFilePath + exportFileName + ".xml"));
			}
			request.setAttribute("exportFilePath",exportFilePath);
			request.setAttribute("exportFileName",exportFileName);
			request.setAttribute("fileType",fileType);
		} catch (Exception e) {
			e.printStackTrace();
			// errorMsg = e.getMessage();
			return "exception";
		}
		System.out.println("ID9Action SUCCESS!!");
		return SUCCESS;
	}

	public static String generateCsv(String fileLocation, String fileName, String fileSubName, List<ID9Obj> resultList)
		throws Exception {
		String csvFilePath = fileLocation + fileName + fileSubName;
		try {

			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				    new FileOutputStream((csvFilePath)), "UTF-8"));
			bw.write('\ufeff');
			bw.write(
				"term,name,ename,sex,party,partyGroup,areaName,committee,onboardDate,degree,tel,experience,fax,addr,picUrl,leaveFlag,leaveDate,leaveReason");

			for (ID9Obj result : resultList) {
				bw.newLine();
				bw.write(result.getTerm() + "," + result.getName() + "," + result.getEname() + ","
					+ result.getSex() + "," + result.getParty() + "," + result.getPartyGroup() + ","
					+ result.getAreaName() + "," + result.getCommittee() + "," + result.getOnboardDate()
					+ "," + result.getDegree() + "," + result.getTel() + "," + result.getExperience() + ","
					+ result.getFax() + "," + result.getAddr() + "," + result.getPicUrl() + "," + result.getLeaveFlag()
					+ "," + result.getLeaveDate() + "," + result.getLeaveReason());
			}

			bw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return csvFilePath;
	}

	public String getName() {
		return name;
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

	public String getImportFilePath() {
		return importFilePath;
	}

	public String getExportFilePath() {
		return exportFilePath;
	}

	public String getExportFileName() {
		return exportFileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setName(String name) {
		this.name = name;
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

	public void setImportFilePath(String importFilePath) {
		this.importFilePath = importFilePath;
	}

	public void setExportFilePath(String exportFilePath) {
		this.exportFilePath = exportFilePath;
	}

	public void setExportFileName(String exportFileName) {
		this.exportFileName = exportFileName;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

}
