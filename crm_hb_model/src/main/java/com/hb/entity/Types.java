package com.hb.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Types entity. @author MyEclipse Persistence Tools
 */

public class Types implements java.io.Serializable {

	// Fields

	private Integer tid;
	private String tname;
	

	// Constructors

	/** default constructor */
	public Types() {
	}

	/** minimal constructor */
	public Types(String tname) {
		this.tname = tname;
	}

	/** full constructor */
	public Types(String tname, Set wares) {
		this.tname = tname;
		
	}

	// Property accessors

	public Integer getTid() {
		return this.tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public String getTname() {
		return this.tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	

}