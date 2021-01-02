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
	private List<Double> settlePriceDeriCurList;
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
	//策略一到策略五
	private String strategy1;
	private String strategy2;
	private String strategy3;
	private String strategy4;
	private String strategy5;
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
	public List<Double> getSettlePriceDeriCurList() {
		return settlePriceDeriCurList;
	}
	public void setSettlePriceDeriCurList(List<Double> settlePriceDeriCurList) {
		this.settlePriceDeriCurList = settlePriceDeriCurList;
	}
	public String getStrategy1() {
		return strategy1;
	}
	public void setStrategy1(String strategy1) {
		this.strategy1 = strategy1;
	}
	public String getStrategy2() {
		return strategy2;
	}
	public void setStrategy2(String strategy2) {
		this.strategy2 = strategy2;
	}
	public String getStrategy3() {
		return strategy3;
	}
	public void setStrategy3(String strategy3) {
		this.strategy3 = strategy3;
	}
	public String getStrategy4() {
		return strategy4;
	}
	public void setStrategy4(String strategy4) {
		this.strategy4 = strategy4;
	}
	public String getStrategy5() {
		return strategy5;
	}
	public void setStrategy5(String strategy5) {
		this.strategy5 = strategy5;
	}
}
