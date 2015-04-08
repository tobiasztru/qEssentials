package pl.za.xvacuum.qessentials.mysql;

public interface Data {
	
	public boolean wasChanged();
	public void setChanged(boolean changed);
	public void save();

}
