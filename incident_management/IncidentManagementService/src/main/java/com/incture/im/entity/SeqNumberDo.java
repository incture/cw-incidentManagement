package com.incture.im.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* Comments: Sequence Number Generation,
*/
@Entity
@Table(name="IM_SEQ_NUM")
public class SeqNumberDo implements BaseDo, Serializable {
	public static final long serialVersionUID = 558142837969712138L;

	@Id
	@Column(name="REF_COD", length=255)
	private String referenceCode;

	@Column(name="RUN_NUM")
	private Integer runningNumber;

	

	 public SeqNumberDo(String referenceCode,int runningNumber){
			super();
			this.referenceCode = referenceCode;
			this.runningNumber = runningNumber;
	    }
	public SeqNumberDo() {
		super();
	}

	public String getReferenceCode() {
		return referenceCode;
	}

	public void setReferenceCode(String referenceCode) {
		this.referenceCode = referenceCode;
	}

	public Integer getRunningNumber() {
		return runningNumber;
	}

	public void setRunningNumber(Integer runningNumber) {
		this.runningNumber = runningNumber;
	}

	public Boolean getValidForUsage() {
		return Boolean.TRUE;
	}
	public Object getPrimaryKey() {

		return null;
	}
}