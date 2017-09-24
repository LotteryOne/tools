package com.tappe.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.apache.commons.io.IOUtils;

public class TestYlfl {
	public static void main(String[] args) {

		DataChange da = new DataChange();
		// String receive =
		// "&data=[%7B%22acceptDate%22%3Anull%2C%22acceptNum%22%3A0%2C%22accessories1%22%3A0%2C%22accessories10%22%3A0%2C%22accessories2%22%3A0%2C%22accessories3%22%3A0%2C%22accessories4%22%3A0%2C%22accessories5%22%3A0%2C%22accessories6%22%3A0%2C%22accessories7%22%3A0%2C%22accessories8%22%3A0%2C%22accessories9%22%3A0%2C%22address%22%3A%22%B7%EE%CF%CD%C7%F8%BA%A3%CD%E5%D5%F2%CE%E5%CB%C4%B9%AB%C2%B71558%C5%AA%22%2C%22applyConut%22%3A0%2C%22applypersonAddr%22%3A%22%22%2C%22applypersonBirth%22%3Anull%2C%22applypersonDegree%22%3A0%2C%22applypersonGender%22%3A0%2C%22applypersonIdcard%22%3A%22%22%2C%22applypersonName%22%3A%22%22%2C%22applypersonPolitic%22%3A0%2C%22applypersonTelephone%22%3A%22%22%2C%22applypersonTitle%22%3A%22%22%2C%22applyunitAddress%22%3A%22%22%2C%22applyunitCharacter%22%3A0%2C%22applyunitName%22%3A%22%22%2C%22applyunitPrincipalName%22%3A%22%22%2C%22applyunitProperty%22%3A%22%22%2C%22applyunitProperty2%22%3A%22%22%2C%22applyunitTelephone%22%3A%22%22%2C%22applyunitZip%22%3A%22%22%2C%22areaDate%22%3Anull%2C%22areaGovInvest%22%3A0%2C%22areaId%22%3A%22%22%2C%22areaLeadDate%22%3Anull%2C%22areaLeadId%22%3A%22%22%2C%22areaLeadOpinion%22%3A0%2C%22areaLeadReason%22%3A%22%22%2C%22areaOpinion%22%3A0%2C%22areaReason%22%3A%22%22%2C%22artificerSum%22%3A0%2C%22assistantBusiness%22%3A%22%22%2C%22bedNumber%22%3A182%2C%22buildArea%22%3A7479%2C%22buildCost%22%3A0%2C%22certNum%22%3A0%2C%22character%22%3A0%2C%22cityGovInvest%22%3A0%2C%22costArea%22%3A7479%2C%22courseControl%22%3A%22%22%2C%22district%22%3A0%2C%22establishmentDesc%22%3A%22%22%2C%22examineResult%22%3A0%2C%22executeEndDate%22%3Anull%2C%22executeMethod%22%3A1%2C%22expectBedNumber%22%3A0%2C%22expectBuildStyleIdx%22%3A0%2C%22expectEndDate%22%3Anull%2C%22expectInvestAmt%22%3A0%2C%22fillDate%22%3A%7B%22date%22%3A17%2C%22day%22%3A5%2C%22hours%22%3A13%2C%22minutes%22%3A46%2C%22month%22%3A5%2C%22nanos%22%3A0%2C%22seconds%22%3A12%2C%22time%22%3A1466142372000%2C%22timezoneOffset%22%3A-480%2C%22year%22%3A116%7D%2C%22fitmentCost%22%3A0%2C%22gisAreaId%22%3A%2226%22%2C%22gisHao%22%3A%22%22%2C%22gisLucun%22%3A%22%22%2C%22gisNeighborhoodId%22%3A%2226142%22%2C%22gisNong%22%3A%22%22%2C%22gisShi%22%3A%22%22%2C%22gisZhuang%22%3A%22%22%2C%22glebeCost%22%3A0%2C%22healingArea%22%3A0%2C%22housePropertyIdx%22%3A0%2C%22id%22%3A%22edda491d6eac43a6aaaa0c8c607abdb3%22%2C%22internalHospitalId%22%3A%22%22%2C%22internalNetLevel%22%3A%22%22%2C%22investTotal%22%3A4000%2C%22lastUpdateDate%22%3A%7B%22date%22%3A29%2C%22day%22%3A3%2C%22hours%22%3A16%2C%22minutes%22%3A45%2C%22month%22%3A5%2C%22seconds%22%3A58%2C%22time%22%3A1467189958941%2C%22timezoneOffset%22%3A-480%2C%22year%22%3A116%7D%2C%22legalMan%22%3A%22%CD%F5%BB%DD%BB%AA%22%2C%22mainBusiness%22%3A%22%22%2C%22mechineCost%22%3A0%2C%22medicalSum%22%3A0%2C%22modifyBuild%22%3A0%2C%22numberAdmin%22%3A0%2C%22numberArtificerC%22%3A0%2C%22numberArtificerG%22%3A0%2C%22numberArtificerZ%22%3A0%2C%22numberArtificerZs%22%3A0%2C%22numberBusiness%22%3A0%2C%22numberFinance%22%3A0%2C%22numberLogistics%22%3A0%2C%22numberManagerTotle%22%3A0%2C%22numberMedical%22%3A0%2C%22numberNurse%22%3A0%2C%22numberOthers%22%3A0%2C%22numberRealTotle%22%3A0%2C%22numberSociety%22%3A0%2C%22numberTrain1%22%3A0%2C%22numberTrain2%22%3A0%2C%22operatorCost%22%3A0%2C%22operatorId%22%3A%222641%22%2C%22organGradeId%22%3A%224%22%2C%22organId%22%3A%2226%22%2C%22organName%22%3A%22%C9%CF%BA%A3%B7%EE%CF%CD%C7%F8%BA%A3%CD%E5%D5%F2%BE%B4%C0%CF%D4%BA%22%2C%22othersCost%22%3A0%2C%22overOrgan%22%3A%22%22%2C%22principalName%22%3A%22%22%2C%22projectStartDate%22%3A%7B%22date%22%3A1%2C%22day%22%3A3%2C%22hours%22%3A0%2C%22minutes%22%3A0%2C%22month%22%3A5%2C%22seconds%22%3A0%2C%22time%22%3A1464710400000%2C%22timezoneOffset%22%3A-480%2C%22year%22%3A116%7D%2C%22property%22%3A%2201%22%2C%22property2%22%3A%22%22%2C%22readingroomArea%22%3A0%2C%22refectoryArea%22%3A0%2C%22registerNum%22%3A0%2C%22registerType%22%3A0%2C%22remitteeDate%22%3Anull%2C%22rentBeginDate%22%3Anull%2C%22rentCost%22%3A0%2C%22rentEndDate%22%3Anull%2C%22retiringroomArea%22%3A0%2C%22revert%22%3A0%2C%22runPurpose%22%3A0%2C%22setupEndDate%22%3Anull%2C%22setupId%22%3A%22%22%2C%22sourceGovInvest%22%3A0%2C%22sourceOthers%22%3A0%2C%22sourceSocietyHelp%22%3A0%2C%22sourceUnitInvest%22%3A0%2C%22state%22%3A%224%22%2C%22streetGovInvest%22%3A0%2C%22telephone%22%3A%2218918762922%22%2C%22totleArea%22%3A6083%2C%22validity%22%3A%221%22%2C%22virescenceArea%22%3A2129%2C%22workOnGradeRels%22%3A%22%22%2C%22xAxis%22%3A%22%22%2C%22yAxis%22%3A%22%22%2C%22zip%22%3A%22201422%22%7D]";
		// String
		// receive="{\"acceptDate\":null,\"acceptNum\":0,\"accessories1\":0,\"accessories10\":0,\"accessories2\":0,\"accessories3\":0,\"accessories4\":0,\"accessories5\":0,\"accessories6\":0,\"accessories7\":0,\"accessories8\":0,\"accessories9\":0,\"address\":\"奉贤区海湾镇五四公路1558弄\",\"applyConut\":0,\"applypersonAddr\":\"\",\"applypersonBirth\":null,\"applypersonDegree\":0,\"applypersonGender\":0,\"applypersonIdcard\":\"\",\"applypersonName\":\"\",\"applypersonPolitic\":0,\"applypersonTelephone\":\"\",\"applypersonTitle\":\"\",\"applyunitAddress\":\"\",\"applyunitCharacter\":0,\"applyunitName\":\"\",\"applyunitPrincipalName\":\"\",\"applyunitProperty\":\"\",\"applyunitProperty2\":\"\",\"applyunitTelephone\":\"\",\"applyunitZip\":\"\",\"areaDate\":null,\"areaGovInvest\":0,\"areaId\":\"\",\"areaLeadDate\":null,\"areaLeadId\":\"\",\"areaLeadOpinion\":0,\"areaLeadReason\":\"\",\"areaOpinion\":0,\"areaReason\":\"\",\"artificerSum\":0,\"assistantBusiness\":\"\",\"bedNumber\":182,\"buildArea\":7479,\"buildCost\":0,\"certNum\":0,\"character\":0,\"cityGovInvest\":0,\"costArea\":7479,\"courseControl\":\"\",\"district\":0,\"establishmentDesc\":\"\",\"examineResult\":0,\"executeEndDate\":null,\"executeMethod\":1,\"expectBedNumber\":0,\"expectBuildStyleIdx\":0,\"expectEndDate\":null,\"expectInvestAmt\":0,\"fillDate\":{\"date\":17,\"day\":5,\"hours\":13,\"minutes\":46,\"month\":5,\"nanos\":0,\"seconds\":12,\"time\":1466142372000,\"timezoneOffset\":-480,\"year\":116},\"fitmentCost\":0,\"gisAreaId\":\"26\",\"gisHao\":\"\",\"gisLucun\":\"\",\"gisNeighborhoodId\":\"26142\",\"gisNong\":\"\",\"gisShi\":\"\",\"gisZhuang\":\"\",\"glebeCost\":0,\"healingArea\":0,\"housePropertyIdx\":0,\"id\":\"edda491d6eac43a6aaaa0c8c607abdb3\",\"internalHospitalId\":\"\",\"internalNetLevel\":\"\",\"investTotal\":4000,\"lastUpdateDate\":{\"date\":29,\"day\":3,\"hours\":17,\"minutes\":8,\"month\":5,\"seconds\":47,\"time\":1467191327926,\"timezoneOffset\":-480,\"year\":116},\"legalMan\":\"王惠华\",\"mainBusiness\":\"\",\"mechineCost\":0,\"medicalSum\":0,\"modifyBuild\":0,\"numberAdmin\":0,\"numberArtificerC\":0,\"numberArtificerG\":0,\"numberArtificerZ\":0,\"numberArtificerZs\":0,\"numberBusiness\":0,\"numberFinance\":0,\"numberLogistics\":0,\"numberManagerTotle\":0,\"numberMedical\":0,\"numberNurse\":0,\"numberOthers\":0,\"numberRealTotle\":0,\"numberSociety\":0,\"numberTrain1\":0,\"numberTrain2\":0,\"operatorCost\":0,\"operatorId\":\"2641\",\"organGradeId\":\"4\",\"organId\":\"26\",\"organName\":\"上海奉贤区海湾镇敬老院\",\"othersCost\":0,\"overOrgan\":\"\",\"principalName\":\"\",\"projectStartDate\":{\"date\":1,\"day\":3,\"hours\":0,\"minutes\":0,\"month\":5,\"seconds\":0,\"time\":1464710400000,\"timezoneOffset\":-480,\"year\":116},\"property\":\"01\",\"property2\":\"\",\"readingroomArea\":0,\"refectoryArea\":0,\"registerNum\":0,\"registerType\":0,\"remitteeDate\":null,\"rentBeginDate\":null,\"rentCost\":0,\"rentEndDate\":null,\"retiringroomArea\":0,\"revert\":0,\"runPurpose\":0,\"setupEndDate\":null,\"setupId\":\"\",\"sourceGovInvest\":0,\"sourceOthers\":0,\"sourceSocietyHelp\":0,\"sourceUnitInvest\":0,\"state\":\"4\",\"streetGovInvest\":0,\"telephone\":\"18918762922\",\"totleArea\":6083,\"validity\":\"1\",\"virescenceArea\":2129,\"workOnGradeRels\":\"\",\"xAxis\":\"\",\"yAxis\":\"\",\"zip\":\"201422\"}";
		// System.out.println(receive);
		// try {
		// receive=URLEncoder.encode(receive,"GBK");
		// } catch (UnsupportedEncodingException e1) {
		// }
		// receive="&data=["+receive+"]";
		String receive = "&data=[%7B%22acceptDate%22%3Anull%2C%22acceptNum%22%3A0%2C%22accessories1%22%3A0%2C%22accessories10%22%3A0%2C%22accessories2%22%3A0%2C%22accessories3%22%3A0%2C%22accessories4%22%3A0%2C%22accessories5%22%3A0%2C%22accessories6%22%3A0%2C%22accessories7%22%3A0%2C%22accessories8%22%3A0%2C%22accessories9%22%3A0%2C%22address%22%3A%22%B7%EE%CF%CD%C7%F8%BA%A3%CD%E5%D5%F2%CE%E5%CB%C4%B9%AB%C2%B71558%C5%AA%22%2C%22applyConut%22%3A0%2C%22applypersonAddr%22%3A%22%22%2C%22applypersonBirth%22%3Anull%2C%22applypersonDegree%22%3A0%2C%22applypersonGender%22%3A0%2C%22applypersonIdcard%22%3A%22%22%2C%22applypersonName%22%3A%22%22%2C%22applypersonPolitic%22%3A0%2C%22applypersonTelephone%22%3A%22%22%2C%22applypersonTitle%22%3A%22%22%2C%22applyunitAddress%22%3A%22%22%2C%22applyunitCharacter%22%3A0%2C%22applyunitName%22%3A%22%22%2C%22applyunitPrincipalName%22%3A%22%22%2C%22applyunitProperty%22%3A%22%22%2C%22applyunitProperty2%22%3A%22%22%2C%22applyunitTelephone%22%3A%22%22%2C%22applyunitZip%22%3A%22%22%2C%22areaDate%22%3Anull%2C%22areaGovInvest%22%3A0%2C%22areaId%22%3A%22%22%2C%22areaLeadDate%22%3Anull%2C%22areaLeadId%22%3A%22%22%2C%22areaLeadOpinion%22%3A0%2C%22areaLeadReason%22%3A%22%22%2C%22areaOpinion%22%3A0%2C%22areaReason%22%3A%22%22%2C%22artificerSum%22%3A0%2C%22assistantBusiness%22%3A%22%22%2C%22bedNumber%22%3A182%2C%22buildArea%22%3A7479%2C%22buildCost%22%3A0%2C%22certNum%22%3A0%2C%22character%22%3A0%2C%22cityGovInvest%22%3A0%2C%22costArea%22%3A7479%2C%22courseControl%22%3A%22%22%2C%22district%22%3A0%2C%22establishmentDesc%22%3A%22%22%2C%22examineResult%22%3A0%2C%22executeEndDate%22%3Anull%2C%22executeMethod%22%3A1%2C%22expectBedNumber%22%3A0%2C%22expectBuildStyleIdx%22%3A0%2C%22expectEndDate%22%3Anull%2C%22expectInvestAmt%22%3A0%2C%22fillDate%22%3A%7B%22date%22%3A17%2C%22day%22%3A5%2C%22hours%22%3A13%2C%22minutes%22%3A46%2C%22month%22%3A5%2C%22nanos%22%3A0%2C%22seconds%22%3A12%2C%22time%22%3A1466142372000%2C%22timezoneOffset%22%3A-480%2C%22year%22%3A116%7D%2C%22fitmentCost%22%3A0%2C%22gisAreaId%22%3A%2226%22%2C%22gisHao%22%3A%22%22%2C%22gisLucun%22%3A%22%22%2C%22gisNeighborhoodId%22%3A%2226142%22%2C%22gisNong%22%3A%22%22%2C%22gisShi%22%3A%22%22%2C%22gisZhuang%22%3A%22%22%2C%22glebeCost%22%3A0%2C%22healingArea%22%3A0%2C%22housePropertyIdx%22%3A0%2C%22id%22%3A%22edda491d6eac43a6aaaa0c8c607abdb3%22%2C%22internalHospitalId%22%3A%22%22%2C%22internalNetLevel%22%3A%22%22%2C%22investTotal%22%3A4000%2C%22lastUpdateDate%22%3A%7B%22date%22%3A29%2C%22day%22%3A3%2C%22hours%22%3A17%2C%22minutes%22%3A8%2C%22month%22%3A5%2C%22seconds%22%3A47%2C%22time%22%3A1467191327926%2C%22timezoneOffset%22%3A-480%2C%22year%22%3A116%7D%2C%22legalMan%22%3A%22%CD%F5%BB%DD%BB%AA%22%2C%22mainBusiness%22%3A%22%22%2C%22mechineCost%22%3A0%2C%22medicalSum%22%3A0%2C%22modifyBuild%22%3A0%2C%22numberAdmin%22%3A0%2C%22numberArtificerC%22%3A0%2C%22numberArtificerG%22%3A0%2C%22numberArtificerZ%22%3A0%2C%22numberArtificerZs%22%3A0%2C%22numberBusiness%22%3A0%2C%22numberFinance%22%3A0%2C%22numberLogistics%22%3A0%2C%22numberManagerTotle%22%3A0%2C%22numberMedical%22%3A0%2C%22numberNurse%22%3A0%2C%22numberOthers%22%3A0%2C%22numberRealTotle%22%3A0%2C%22numberSociety%22%3A0%2C%22numberTrain1%22%3A0%2C%22numberTrain2%22%3A0%2C%22operatorCost%22%3A0%2C%22operatorId%22%3A%222641%22%2C%22organGradeId%22%3A%224%22%2C%22organId%22%3A%2226%22%2C%22organName%22%3A%22%C9%CF%BA%A3%B7%EE%CF%CD%C7%F8%BA%A3%CD%E5%D5%F2%BE%B4%C0%CF%D4%BA%22%2C%22othersCost%22%3A0%2C%22overOrgan%22%3A%22%22%2C%22principalName%22%3A%22%22%2C%22projectStartDate%22%3A%7B%22date%22%3A1%2C%22day%22%3A3%2C%22hours%22%3A0%2C%22minutes%22%3A0%2C%22month%22%3A5%2C%22seconds%22%3A0%2C%22time%22%3A1464710400000%2C%22timezoneOffset%22%3A-480%2C%22year%22%3A116%7D%2C%22property%22%3A%2201%22%2C%22property2%22%3A%22%22%2C%22readingroomArea%22%3A0%2C%22refectoryArea%22%3A0%2C%22registerNum%22%3A0%2C%22registerType%22%3A0%2C%22remitteeDate%22%3Anull%2C%22rentBeginDate%22%3Anull%2C%22rentCost%22%3A0%2C%22rentEndDate%22%3Anull%2C%22retiringroomArea%22%3A0%2C%22revert%22%3A0%2C%22runPurpose%22%3A0%2C%22setupEndDate%22%3Anull%2C%22setupId%22%3A%22%22%2C%22sourceGovInvest%22%3A0%2C%22sourceOthers%22%3A0%2C%22sourceSocietyHelp%22%3A0%2C%22sourceUnitInvest%22%3A0%2C%22state%22%3A%224%22%2C%22streetGovInvest%22%3A0%2C%22telephone%22%3A%2218918762922%22%2C%22totleArea%22%3A6083%2C%22validity%22%3A%221%22%2C%22virescenceArea%22%3A2129%2C%22workOnGradeRels%22%3A%22%22%2C%22xAxis%22%3A%22%22%2C%22yAxis%22%3A%22%22%2C%22zip%22%3A%22201422%22%7D]";
		  receive ="&data=[%7B%22acceptDate%22%3Anull]";
		System.out.println(receive.length());
		//String receive="&data=[%7B%22acceptDa%2C%22]";
		String result = sendOrganString(receive);
		System.out.println(result);

		// System.out.println(receive);
		// String result = da.sendOrganString(receive);
		// System.out.println(result);

	}

	private static String receiveHttp(String receive, String urlad)
			throws Exception {
		URL url = null;
		HttpURLConnection conn = null;
		String result = null;
		OutputStream os = null;
		InputStream is = null;
		try {
			url = new URL(urlad);
			conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestProperty("Charset", "GBK");
			conn.setReadTimeout(30000);
			conn.setRequestMethod("POST");
			conn.setUseCaches(false);
			conn.setRequestProperty("Accept-Charset", "GBK");
			conn.connect();
			os = conn.getOutputStream();

			ObjectOutputStream oos = new ObjectOutputStream(os);
			oos.writeObject(receive);

			oos.flush();
			oos.close();
			is = conn.getInputStream();
			result = IOUtils.toString(is, "GBK");
			conn.disconnect();
		} catch (Exception e) {
			throw new Exception();
		} finally {
			try {
				if (os != null) {
					os.close();
				}
				if (is != null) {
					is.close();
				}

			} catch (IOException e) {
			}
		}
		return result;
	}

	public static String sendOrganString(String receive) {
		String urlad = "http://130.2.4.29:9080/ylfl/dataChange.do?method=getOrgan";
//		String urlad="http://10.1.30.16/ylfl/dataChange.do?method=getOrgan";
		String resutl = "";
		try {
			System.out.println(">>>>>url:::::"+urlad);
			resutl = receiveHttp(receive, urlad);
			System.out.println(">>>>>>" + receive);

		} catch (Exception e) {
			System.out.println(">>>>>>>dataChangeConnectionFaile");
			return "error";
		}

		return resutl;
	}

}
