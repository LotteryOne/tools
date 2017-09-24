package com.tappe.test;

import java.io.Serializable;
import java.util.Date;

public class OrganExecute   implements Serializable{

	

	// Fields

			private String id;

			private String organId;
			private String overOrgan;
			private String validity;

			private Date lastUpdateDate;

			private String operatorId;

			private String organName;

			private Date fillDate;

			private String telephone;

			private String address;

			private String zip;

			private String principalName;
		//注册类型
			private Long registerType;

			private Date projectStartDate;

			private Date expectEndDate;

			private Long runPurpose;
		//床位数量
			private Long expectBedNumber;

			private Double totleArea;

			private Double buildArea;

			private Double virescenceArea;

			private Double costArea;

			private Date rentBeginDate;

			private Date rentEndDate;

			private Double rentCost;

			private Long housePropertyIdx;

			private Double expectInvestAmt;
			
			private Long modifyBuild;
			
			private Long expectBuildStyleIdx;

			private Double glebeCost;

			private Double mechineCost;

			private Double buildCost;

			private Double operatorCost;

			private Double fitmentCost;

			private Double othersCost;

			private Double sourceGovInvest;

			private Double sourceUnitInvest;

			private Double sourceSocietyHelp;

			private Double sourceOthers;

			private String applyunitName;

			private String applyunitPrincipalName;

			private String applyunitTelephone;

			private String applyunitAddress;

			private String applyunitZip;

			private String applyunitProperty;

			private String applyunitProperty2;

			private Long applyunitCharacter;

			private String applypersonName;

			private Long applypersonGender;

			private Date applypersonBirth;

			private Long applypersonPolitic;

			private Long applypersonDegree;

			private String applypersonTitle;

			private String applypersonTelephone;

			private String applypersonAddr;

			private String applypersonIdcard;

			private String areaId;

			private Long areaOpinion;

			private String areaReason;

			private Date areaDate;
			
			private String areaLeadId;

			private Long areaLeadOpinion;

			private String areaLeadReason;

			private Date areaLeadDate;

			private Date setupEndDate;

			private Date acceptDate;
			private Date remitteeDate;
			private String state;

			private Long revert;

			private String courseControl;

			private Long accessories1;

			private Long accessories2;

			private Long accessories3;

			private Long accessories4;

			private Long accessories5;

			private Long accessories6;

			private Long accessories7;

			private Long accessories8;

			private Long accessories9;

			private Long accessories10;
			private Long acceptNum;
			private Long examineResult;
			/**机构地址X轴 */
			private String xAxis;
			/**机构地址Y轴 */
			private String yAxis;
			/**区县代码*/
			private String gisAreaId;
			/**街道代码*/
			private String gisNeighborhoodId;
			/**路/村*/
			private String gisLucun;
			/**弄*/
			private String gisNong;
			/**号*/
			private String gisHao;
			/**幢*/
			private String gisZhuang;
			/**室*/
			private String gisShi;

			//setup
			
			private String setupId;
			private String legalMan;
			private Double investTotal;
			private String property;
			private String property2;
			private Long character;
			private Long executeMethod;
			private Long certNum;
			private Long registerNum;
			private String mainBusiness;
			private String assistantBusiness;
			private Long bedNumber;
			private Double retiringroomArea;
			private Double refectoryArea;
			private Double readingroomArea;
			private Double healingArea;
			private Long numberRealTotle;
			private Long numberManagerTotle;
			private Long numberAdmin;
			private Long numberFinance;
			private Long numberBusiness;
			private Long numberLogistics;
			private Long medicalSum;
			private Long numberMedical;
			private Long numberNurse;
			private Long artificerSum;
			private Long numberArtificerG;
			private Long numberArtificerC;
			private Long numberArtificerZ;
			private Long numberTrain1;
			private Long numberTrain2;
			private Long numberOthers;
			private Long numberSociety;
			private String establishmentDesc;
			private Date executeEndDate;
			private Long applyConut;
			private Long numberArtificerZs;
//			private Set overOrganExecutes = new HashSet(0);
			private Double streetGovInvest;
			private Double areaGovInvest;
			private Double cityGovInvest;
			private Long district;
			private String internalHospitalId;//内设医疗机构编号
			private String internalNetLevel;//联网情况   1=无
			
			private String organGradeId;
			
			private String workOnGradeRels;
			
			
			public String getId() {
				return id;
			}
			public void setId(String id) {
				this.id = id;
			}
			public String getOrganId() {
				return organId;
			}
			public void setOrganId(String organId) {
				this.organId = organId;
			}
			public String getOverOrgan() {
				return overOrgan;
			}
			public void setOverOrgan(String overOrgan) {
				this.overOrgan = overOrgan;
			}
			public String getValidity() {
				return validity;
			}
			public void setValidity(String validity) {
				this.validity = validity;
			}
			public Date getLastUpdateDate() {
				return lastUpdateDate;
			}
			public void setLastUpdateDate(Date lastUpdateDate) {
				this.lastUpdateDate = lastUpdateDate;
			}
			public String getOperatorId() {
				return operatorId;
			}
			public void setOperatorId(String operatorId) {
				this.operatorId = operatorId;
			}
			public String getOrganName() {
				return organName;
			}
			public void setOrganName(String organName) {
				this.organName = organName;
			}
			public Date getFillDate() {
				return fillDate;
			}
			public void setFillDate(Date fillDate) {
				this.fillDate = fillDate;
			}
			public String getTelephone() {
				return telephone;
			}
			public void setTelephone(String telephone) {
				this.telephone = telephone;
			}
			public String getAddress() {
				return address;
			}
			public void setAddress(String address) {
				this.address = address;
			}
			public String getZip() {
				return zip;
			}
			public void setZip(String zip) {
				this.zip = zip;
			}
			public String getPrincipalName() {
				return principalName;
			}
			public void setPrincipalName(String principalName) {
				this.principalName = principalName;
			}
			public Long getRegisterType() {
				return registerType;
			}
			public void setRegisterType(Long registerType) {
				this.registerType = registerType;
			}
			public Date getProjectStartDate() {
				return projectStartDate;
			}
			public void setProjectStartDate(Date projectStartDate) {
				this.projectStartDate = projectStartDate;
			}
			public Date getExpectEndDate() {
				return expectEndDate;
			}
			public void setExpectEndDate(Date expectEndDate) {
				this.expectEndDate = expectEndDate;
			}
			public Long getRunPurpose() {
				return runPurpose;
			}
			public void setRunPurpose(Long runPurpose) {
				this.runPurpose = runPurpose;
			}
			public Long getExpectBedNumber() {
				return expectBedNumber;
			}
			public void setExpectBedNumber(Long expectBedNumber) {
				this.expectBedNumber = expectBedNumber;
			}
			public Double getTotleArea() {
				return totleArea;
			}
			public void setTotleArea(Double totleArea) {
				this.totleArea = totleArea;
			}
			public Double getBuildArea() {
				return buildArea;
			}
			public void setBuildArea(Double buildArea) {
				this.buildArea = buildArea;
			}
			public Double getVirescenceArea() {
				return virescenceArea;
			}
			public void setVirescenceArea(Double virescenceArea) {
				this.virescenceArea = virescenceArea;
			}
			public Double getCostArea() {
				return costArea;
			}
			public void setCostArea(Double costArea) {
				this.costArea = costArea;
			}
			public Date getRentBeginDate() {
				return rentBeginDate;
			}
			public void setRentBeginDate(Date rentBeginDate) {
				this.rentBeginDate = rentBeginDate;
			}
			public Date getRentEndDate() {
				return rentEndDate;
			}
			public void setRentEndDate(Date rentEndDate) {
				this.rentEndDate = rentEndDate;
			}
			public Double getRentCost() {
				return rentCost;
			}
			public void setRentCost(Double rentCost) {
				this.rentCost = rentCost;
			}
			public Long getHousePropertyIdx() {
				return housePropertyIdx;
			}
			public void setHousePropertyIdx(Long housePropertyIdx) {
				this.housePropertyIdx = housePropertyIdx;
			}
			public Double getExpectInvestAmt() {
				return expectInvestAmt;
			}
			public void setExpectInvestAmt(Double expectInvestAmt) {
				this.expectInvestAmt = expectInvestAmt;
			}
			public Long getModifyBuild() {
				return modifyBuild;
			}
			public void setModifyBuild(Long modifyBuild) {
				this.modifyBuild = modifyBuild;
			}
			public Long getExpectBuildStyleIdx() {
				return expectBuildStyleIdx;
			}
			public void setExpectBuildStyleIdx(Long expectBuildStyleIdx) {
				this.expectBuildStyleIdx = expectBuildStyleIdx;
			}
			public Double getGlebeCost() {
				return glebeCost;
			}
			public void setGlebeCost(Double glebeCost) {
				this.glebeCost = glebeCost;
			}
			public Double getMechineCost() {
				return mechineCost;
			}
			public void setMechineCost(Double mechineCost) {
				this.mechineCost = mechineCost;
			}
			public Double getBuildCost() {
				return buildCost;
			}
			public void setBuildCost(Double buildCost) {
				this.buildCost = buildCost;
			}
			public Double getOperatorCost() {
				return operatorCost;
			}
			public void setOperatorCost(Double operatorCost) {
				this.operatorCost = operatorCost;
			}
			public Double getFitmentCost() {
				return fitmentCost;
			}
			public void setFitmentCost(Double fitmentCost) {
				this.fitmentCost = fitmentCost;
			}
			public Double getOthersCost() {
				return othersCost;
			}
			public void setOthersCost(Double othersCost) {
				this.othersCost = othersCost;
			}
			public Double getSourceGovInvest() {
				return sourceGovInvest;
			}
			public void setSourceGovInvest(Double sourceGovInvest) {
				this.sourceGovInvest = sourceGovInvest;
			}
			public Double getSourceUnitInvest() {
				return sourceUnitInvest;
			}
			public void setSourceUnitInvest(Double sourceUnitInvest) {
				this.sourceUnitInvest = sourceUnitInvest;
			}
			public Double getSourceSocietyHelp() {
				return sourceSocietyHelp;
			}
			public void setSourceSocietyHelp(Double sourceSocietyHelp) {
				this.sourceSocietyHelp = sourceSocietyHelp;
			}
			public Double getSourceOthers() {
				return sourceOthers;
			}
			public void setSourceOthers(Double sourceOthers) {
				this.sourceOthers = sourceOthers;
			}
			public String getApplyunitName() {
				return applyunitName;
			}
			public void setApplyunitName(String applyunitName) {
				this.applyunitName = applyunitName;
			}
			public String getApplyunitPrincipalName() {
				return applyunitPrincipalName;
			}
			public void setApplyunitPrincipalName(String applyunitPrincipalName) {
				this.applyunitPrincipalName = applyunitPrincipalName;
			}
			public String getApplyunitTelephone() {
				return applyunitTelephone;
			}
			public void setApplyunitTelephone(String applyunitTelephone) {
				this.applyunitTelephone = applyunitTelephone;
			}
			public String getApplyunitAddress() {
				return applyunitAddress;
			}
			public void setApplyunitAddress(String applyunitAddress) {
				this.applyunitAddress = applyunitAddress;
			}
			public String getApplyunitZip() {
				return applyunitZip;
			}
			public void setApplyunitZip(String applyunitZip) {
				this.applyunitZip = applyunitZip;
			}
			public String getApplyunitProperty() {
				return applyunitProperty;
			}
			public void setApplyunitProperty(String applyunitProperty) {
				this.applyunitProperty = applyunitProperty;
			}
			public String getApplyunitProperty2() {
				return applyunitProperty2;
			}
			public void setApplyunitProperty2(String applyunitProperty2) {
				this.applyunitProperty2 = applyunitProperty2;
			}
			public Long getApplyunitCharacter() {
				return applyunitCharacter;
			}
			public void setApplyunitCharacter(Long applyunitCharacter) {
				this.applyunitCharacter = applyunitCharacter;
			}
			public String getApplypersonName() {
				return applypersonName;
			}
			public void setApplypersonName(String applypersonName) {
				this.applypersonName = applypersonName;
			}
			public Long getApplypersonGender() {
				return applypersonGender;
			}
			public void setApplypersonGender(Long applypersonGender) {
				this.applypersonGender = applypersonGender;
			}
			public Date getApplypersonBirth() {
				return applypersonBirth;
			}
			public void setApplypersonBirth(Date applypersonBirth) {
				this.applypersonBirth = applypersonBirth;
			}
			public Long getApplypersonPolitic() {
				return applypersonPolitic;
			}
			public void setApplypersonPolitic(Long applypersonPolitic) {
				this.applypersonPolitic = applypersonPolitic;
			}
			public Long getApplypersonDegree() {
				return applypersonDegree;
			}
			public void setApplypersonDegree(Long applypersonDegree) {
				this.applypersonDegree = applypersonDegree;
			}
			public String getApplypersonTitle() {
				return applypersonTitle;
			}
			public void setApplypersonTitle(String applypersonTitle) {
				this.applypersonTitle = applypersonTitle;
			}
			public String getApplypersonTelephone() {
				return applypersonTelephone;
			}
			public void setApplypersonTelephone(String applypersonTelephone) {
				this.applypersonTelephone = applypersonTelephone;
			}
			public String getApplypersonAddr() {
				return applypersonAddr;
			}
			public void setApplypersonAddr(String applypersonAddr) {
				this.applypersonAddr = applypersonAddr;
			}
			public String getApplypersonIdcard() {
				return applypersonIdcard;
			}
			public void setApplypersonIdcard(String applypersonIdcard) {
				this.applypersonIdcard = applypersonIdcard;
			}
			public String getAreaId() {
				return areaId;
			}
			public void setAreaId(String areaId) {
				this.areaId = areaId;
			}
			public Long getAreaOpinion() {
				return areaOpinion;
			}
			public void setAreaOpinion(Long areaOpinion) {
				this.areaOpinion = areaOpinion;
			}
			public String getAreaReason() {
				return areaReason;
			}
			public void setAreaReason(String areaReason) {
				this.areaReason = areaReason;
			}
			public Date getAreaDate() {
				return areaDate;
			}
			public void setAreaDate(Date areaDate) {
				this.areaDate = areaDate;
			}
			public String getAreaLeadId() {
				return areaLeadId;
			}
			public void setAreaLeadId(String areaLeadId) {
				this.areaLeadId = areaLeadId;
			}
			public Long getAreaLeadOpinion() {
				return areaLeadOpinion;
			}
			public void setAreaLeadOpinion(Long areaLeadOpinion) {
				this.areaLeadOpinion = areaLeadOpinion;
			}
			public String getAreaLeadReason() {
				return areaLeadReason;
			}
			public void setAreaLeadReason(String areaLeadReason) {
				this.areaLeadReason = areaLeadReason;
			}
			public Date getAreaLeadDate() {
				return areaLeadDate;
			}
			public void setAreaLeadDate(Date areaLeadDate) {
				this.areaLeadDate = areaLeadDate;
			}
			public Date getSetupEndDate() {
				return setupEndDate;
			}
			public void setSetupEndDate(Date setupEndDate) {
				this.setupEndDate = setupEndDate;
			}
			public Date getAcceptDate() {
				return acceptDate;
			}
			public void setAcceptDate(Date acceptDate) {
				this.acceptDate = acceptDate;
			}
			public Date getRemitteeDate() {
				return remitteeDate;
			}
			public void setRemitteeDate(Date remitteeDate) {
				this.remitteeDate = remitteeDate;
			}
			public String getState() {
				return state;
			}
			public void setState(String state) {
				this.state = state;
			}
			public Long getRevert() {
				return revert;
			}
			public void setRevert(Long revert) {
				this.revert = revert;
			}
			public String getCourseControl() {
				return courseControl;
			}
			public void setCourseControl(String courseControl) {
				this.courseControl = courseControl;
			}
			public Long getAccessories1() {
				return accessories1;
			}
			public void setAccessories1(Long accessories1) {
				this.accessories1 = accessories1;
			}
			public Long getAccessories2() {
				return accessories2;
			}
			public void setAccessories2(Long accessories2) {
				this.accessories2 = accessories2;
			}
			public Long getAccessories3() {
				return accessories3;
			}
			public void setAccessories3(Long accessories3) {
				this.accessories3 = accessories3;
			}
			public Long getAccessories4() {
				return accessories4;
			}
			public void setAccessories4(Long accessories4) {
				this.accessories4 = accessories4;
			}
			public Long getAccessories5() {
				return accessories5;
			}
			public void setAccessories5(Long accessories5) {
				this.accessories5 = accessories5;
			}
			public Long getAccessories6() {
				return accessories6;
			}
			public void setAccessories6(Long accessories6) {
				this.accessories6 = accessories6;
			}
			public Long getAccessories7() {
				return accessories7;
			}
			public void setAccessories7(Long accessories7) {
				this.accessories7 = accessories7;
			}
			public Long getAccessories8() {
				return accessories8;
			}
			public void setAccessories8(Long accessories8) {
				this.accessories8 = accessories8;
			}
			public Long getAccessories9() {
				return accessories9;
			}
			public void setAccessories9(Long accessories9) {
				this.accessories9 = accessories9;
			}
			public Long getAccessories10() {
				return accessories10;
			}
			public void setAccessories10(Long accessories10) {
				this.accessories10 = accessories10;
			}
			public Long getAcceptNum() {
				return acceptNum;
			}
			public void setAcceptNum(Long acceptNum) {
				this.acceptNum = acceptNum;
			}
			public Long getExamineResult() {
				return examineResult;
			}
			public void setExamineResult(Long examineResult) {
				this.examineResult = examineResult;
			}
			public String getxAxis() {
				return xAxis;
			}
			public void setxAxis(String xAxis) {
				this.xAxis = xAxis;
			}
			public String getyAxis() {
				return yAxis;
			}
			public void setyAxis(String yAxis) {
				this.yAxis = yAxis;
			}
			public String getGisAreaId() {
				return gisAreaId;
			}
			public void setGisAreaId(String gisAreaId) {
				this.gisAreaId = gisAreaId;
			}
			public String getGisNeighborhoodId() {
				return gisNeighborhoodId;
			}
			public void setGisNeighborhoodId(String gisNeighborhoodId) {
				this.gisNeighborhoodId = gisNeighborhoodId;
			}
			public String getGisLucun() {
				return gisLucun;
			}
			public void setGisLucun(String gisLucun) {
				this.gisLucun = gisLucun;
			}
			public String getGisNong() {
				return gisNong;
			}
			public void setGisNong(String gisNong) {
				this.gisNong = gisNong;
			}
			public String getGisHao() {
				return gisHao;
			}
			public void setGisHao(String gisHao) {
				this.gisHao = gisHao;
			}
			public String getGisZhuang() {
				return gisZhuang;
			}
			public void setGisZhuang(String gisZhuang) {
				this.gisZhuang = gisZhuang;
			}
			public String getGisShi() {
				return gisShi;
			}
			public void setGisShi(String gisShi) {
				this.gisShi = gisShi;
			}
			public String getSetupId() {
				return setupId;
			}
			public void setSetupId(String setupId) {
				this.setupId = setupId;
			}
			public String getLegalMan() {
				return legalMan;
			}
			public void setLegalMan(String legalMan) {
				this.legalMan = legalMan;
			}
			public Double getInvestTotal() {
				return investTotal;
			}
			public void setInvestTotal(Double investTotal) {
				this.investTotal = investTotal;
			}
			public String getProperty() {
				return property;
			}
			public void setProperty(String property) {
				this.property = property;
			}
			public String getProperty2() {
				return property2;
			}
			public void setProperty2(String property2) {
				this.property2 = property2;
			}
			public Long getCharacter() {
				return character;
			}
			public void setCharacter(Long character) {
				this.character = character;
			}
			public Long getExecuteMethod() {
				return executeMethod;
			}
			public void setExecuteMethod(Long executeMethod) {
				this.executeMethod = executeMethod;
			}
			public Long getCertNum() {
				return certNum;
			}
			public void setCertNum(Long certNum) {
				this.certNum = certNum;
			}
			public Long getRegisterNum() {
				return registerNum;
			}
			public void setRegisterNum(Long registerNum) {
				this.registerNum = registerNum;
			}
			public String getMainBusiness() {
				return mainBusiness;
			}
			public void setMainBusiness(String mainBusiness) {
				this.mainBusiness = mainBusiness;
			}
			public String getAssistantBusiness() {
				return assistantBusiness;
			}
			public void setAssistantBusiness(String assistantBusiness) {
				this.assistantBusiness = assistantBusiness;
			}
			public Long getBedNumber() {
				return bedNumber;
			}
			public void setBedNumber(Long bedNumber) {
				this.bedNumber = bedNumber;
			}
			public Double getRetiringroomArea() {
				return retiringroomArea;
			}
			public void setRetiringroomArea(Double retiringroomArea) {
				this.retiringroomArea = retiringroomArea;
			}
			public Double getRefectoryArea() {
				return refectoryArea;
			}
			public void setRefectoryArea(Double refectoryArea) {
				this.refectoryArea = refectoryArea;
			}
			public Double getReadingroomArea() {
				return readingroomArea;
			}
			public void setReadingroomArea(Double readingroomArea) {
				this.readingroomArea = readingroomArea;
			}
			public Double getHealingArea() {
				return healingArea;
			}
			public void setHealingArea(Double healingArea) {
				this.healingArea = healingArea;
			}
			public Long getNumberRealTotle() {
				return numberRealTotle;
			}
			public void setNumberRealTotle(Long numberRealTotle) {
				this.numberRealTotle = numberRealTotle;
			}
			public Long getNumberManagerTotle() {
				return numberManagerTotle;
			}
			public void setNumberManagerTotle(Long numberManagerTotle) {
				this.numberManagerTotle = numberManagerTotle;
			}
			public Long getNumberAdmin() {
				return numberAdmin;
			}
			public void setNumberAdmin(Long numberAdmin) {
				this.numberAdmin = numberAdmin;
			}
			public Long getNumberFinance() {
				return numberFinance;
			}
			public void setNumberFinance(Long numberFinance) {
				this.numberFinance = numberFinance;
			}
			public Long getNumberBusiness() {
				return numberBusiness;
			}
			public void setNumberBusiness(Long numberBusiness) {
				this.numberBusiness = numberBusiness;
			}
			public Long getNumberLogistics() {
				return numberLogistics;
			}
			public void setNumberLogistics(Long numberLogistics) {
				this.numberLogistics = numberLogistics;
			}
			public Long getMedicalSum() {
				return medicalSum;
			}
			public void setMedicalSum(Long medicalSum) {
				this.medicalSum = medicalSum;
			}
			public Long getNumberMedical() {
				return numberMedical;
			}
			public void setNumberMedical(Long numberMedical) {
				this.numberMedical = numberMedical;
			}
			public Long getNumberNurse() {
				return numberNurse;
			}
			public void setNumberNurse(Long numberNurse) {
				this.numberNurse = numberNurse;
			}
			public Long getArtificerSum() {
				return artificerSum;
			}
			public void setArtificerSum(Long artificerSum) {
				this.artificerSum = artificerSum;
			}
			public Long getNumberArtificerG() {
				return numberArtificerG;
			}
			public void setNumberArtificerG(Long numberArtificerG) {
				this.numberArtificerG = numberArtificerG;
			}
			public Long getNumberArtificerC() {
				return numberArtificerC;
			}
			public void setNumberArtificerC(Long numberArtificerC) {
				this.numberArtificerC = numberArtificerC;
			}
			public Long getNumberArtificerZ() {
				return numberArtificerZ;
			}
			public void setNumberArtificerZ(Long numberArtificerZ) {
				this.numberArtificerZ = numberArtificerZ;
			}
			public Long getNumberTrain1() {
				return numberTrain1;
			}
			public void setNumberTrain1(Long numberTrain1) {
				this.numberTrain1 = numberTrain1;
			}
			public Long getNumberTrain2() {
				return numberTrain2;
			}
			public void setNumberTrain2(Long numberTrain2) {
				this.numberTrain2 = numberTrain2;
			}
			public Long getNumberOthers() {
				return numberOthers;
			}
			public void setNumberOthers(Long numberOthers) {
				this.numberOthers = numberOthers;
			}
			public Long getNumberSociety() {
				return numberSociety;
			}
			public void setNumberSociety(Long numberSociety) {
				this.numberSociety = numberSociety;
			}
			public String getEstablishmentDesc() {
				return establishmentDesc;
			}
			public void setEstablishmentDesc(String establishmentDesc) {
				this.establishmentDesc = establishmentDesc;
			}
			public Date getExecuteEndDate() {
				return executeEndDate;
			}
			public void setExecuteEndDate(Date executeEndDate) {
				this.executeEndDate = executeEndDate;
			}
			public Long getApplyConut() {
				return applyConut;
			}
			public void setApplyConut(Long applyConut) {
				this.applyConut = applyConut;
			}
			public Long getNumberArtificerZs() {
				return numberArtificerZs;
			}
			public void setNumberArtificerZs(Long numberArtificerZs) {
				this.numberArtificerZs = numberArtificerZs;
			}
//			public Set getOverOrganExecutes() {
//				return overOrganExecutes;
//			}
//			public void setOverOrganExecutes(Set overOrganExecutes) {
//				this.overOrganExecutes = overOrganExecutes;
//			}
			public Double getStreetGovInvest() {
				return streetGovInvest;
			}
			public void setStreetGovInvest(Double streetGovInvest) {
				this.streetGovInvest = streetGovInvest;
			}
			public Double getAreaGovInvest() {
				return areaGovInvest;
			}
			public void setAreaGovInvest(Double areaGovInvest) {
				this.areaGovInvest = areaGovInvest;
			}
			public Double getCityGovInvest() {
				return cityGovInvest;
			}
			public void setCityGovInvest(Double cityGovInvest) {
				this.cityGovInvest = cityGovInvest;
			}
			public Long getDistrict() {
				return district;
			}
			public void setDistrict(Long district) {
				this.district = district;
			}
			public String getInternalHospitalId() {
				return internalHospitalId;
			}
			public void setInternalHospitalId(String internalHospitalId) {
				this.internalHospitalId = internalHospitalId;
			}
			public String getInternalNetLevel() {
				return internalNetLevel;
			}
			public void setInternalNetLevel(String internalNetLevel) {
				this.internalNetLevel = internalNetLevel;
			}
			public String getOrganGradeId() {
				return organGradeId;
			}
			public void setOrganGradeId(String organGradeId) {
				this.organGradeId = organGradeId;
			}
			public String getWorkOnGradeRels() {
				return workOnGradeRels;
			}
			public void setWorkOnGradeRels(String workOnGradeRels) {
				this.workOnGradeRels = workOnGradeRels;
			}
			
			
			
			
			
	
}
