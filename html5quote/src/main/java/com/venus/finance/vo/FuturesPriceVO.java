package com.venus.finance.vo;

import java.util.ArrayList;
import java.util.List;

public class FuturesPriceVO {
	private String code;
	private List<Long>dateRtnList;
	private List<Double> closePriceList;
	private List<Double> settlePriceList;
	private List<Double> settlePriceCurList;
	private List<Double> closePriceCurList;
	private List<Double> closePriceDeriCurList;
	private List<Double> macd5CurList;
	private List<Double> macd10CurList;
	private List<Double> macd20CurList;
	private List<Double> macd40CurList;
	private List<Double> macd60CurList;
	private List<Double> vdivccList;
	private List<CandleVO> candlePriceList;
	private List<MacdVO> macdList;
	private List<Double> ccVolumeList;
	private List<Double> volumeList;
	public List<Long> getDateRtnList() {
		return dateRtnList;
	}
	public void setDateRtnList(List<Long> dateRtnList) {
		this.dateRtnList = dateRtnList;
	}
	public List<Double> getClosePriceList() {
		return closePriceList;
	}
	public void setClosePriceList(List<Double> closePriceList) {
		this.closePriceList = closePriceList;
	}
	public List<Double> getSettlePriceList() {
		return settlePriceList;
	}
	public void setSettlePriceList(List<Double> settlePriceList) {
		this.settlePriceList = settlePriceList;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public List<Double> getSettlePriceCurList() {
		return settlePriceCurList;
	}
	public void setSettlePriceCurList(List<Double> settlePriceCurList) {
		this.settlePriceCurList = settlePriceCurList;
	}
	public List<CandleVO> getCandlePriceList() {
		return candlePriceList;
	}
	public void setCandlePriceList(List<CandleVO> candlePriceList) {
		this.candlePriceList = candlePriceList;
	}
	public List<MacdVO> getMacdList() {
		return macdList;
	}
	public void setMacdList(List<MacdVO> macdList) {
		this.macdList = macdList;
	}
	public List<Double> getCcVolumeList() {
		return ccVolumeList;
	}
	public void setCcVolumeList(List<Double> ccVolumeList) {
		this.ccVolumeList = ccVolumeList;
	}
	public List<Double> getVolumeList() {
		return volumeList;
	}
	public void setVolumeList(List<Double> volumeList) {
		this.volumeList = volumeList;
	}
	public List<Double> getClosePriceCurList() {
		return closePriceCurList;
	}
	public void setClosePriceCurList(List<Double> closePriceCurList) {
		this.closePriceCurList = closePriceCurList;
	}
	public List<Double> getMacd5CurList() {
		return macd5CurList;
	}
	public void setMacd5CurList(List<Double> macd5CurList) {
		this.macd5CurList = macd5CurList;
	}
	public List<Double> getMacd20CurList() {
		return macd20CurList;
	}
	public void setMacd20CurList(List<Double> macd20CurList) {
		this.macd20CurList = macd20CurList;
	}
	public List<Double> getMacd10CurList() {
		return macd10CurList;
	}
	public void setMacd10CurList(List<Double> macd10CurList) {
		this.macd10CurList = macd10CurList;
	}
	public List<Double> getMacd40CurList() {
		return macd40CurList;
	}
	public void setMacd40CurList(List<Double> macd40CurList) {
		this.macd40CurList = macd40CurList;
	}
	public List<Double> getMacd60CurList() {
		return macd60CurList;
	}
	public void setMacd60CurList(List<Double> macd60CurList) {
		this.macd60CurList = macd60CurList;
	}
	public List<Double> getVdivccList() {
		return vdivccList;
	}
	public void setVdivccList(List<Double> vdivccList) {
		this.vdivccList = vdivccList;
	}
	public List<Double> getClosePriceDeriCurList() {
		return closePriceDeriCurList;
	}
	public void setClosePriceDeriCurList(List<Double> closePriceDeriCurList) {
		this.closePriceDeriCurList = closePriceDeriCurList;
	}
	
}
