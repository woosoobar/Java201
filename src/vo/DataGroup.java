package vo;

import java.util.ArrayList;

public class DataGroup {

	private int index;
	private String name;
	private ArrayList<DataSet> dataSetList;
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<DataSet> getDataSetList() {
		return dataSetList;
	}
	public void setDataSetList(ArrayList<DataSet> dataSetList) {
		this.dataSetList = dataSetList;
	}
	
}
