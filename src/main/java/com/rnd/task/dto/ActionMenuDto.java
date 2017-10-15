package com.rnd.task.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Skpandey
 *
 */
public class ActionMenuDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("rightClick")
	private String rightClick;
	@JsonProperty("leftClick")
	private String leftClick;

	public String getRightClick() {
		return rightClick;
	}

	public void setRightClick(String rightClick) {
		this.rightClick = rightClick;
	}

	public String getLeftClick() {
		return leftClick;
	}

	public void setLeftClick(String leftClick) {
		this.leftClick = leftClick;
	}

}
