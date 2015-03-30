package pl.za.xvacuum.qessentials.tasks;

import pl.za.xvacuum.qessentials.utils.AutoMessageUtil;

public class AutoMessage implements Runnable{

	@Override
	public void run() {
		AutoMessageUtil.sendRandomMessage();
	}

}
